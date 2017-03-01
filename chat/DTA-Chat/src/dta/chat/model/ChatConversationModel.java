package dta.chat.model;

import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatClientException;
import dta.chat.model.socket.ChatSocketImpl;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	String login;

	public void setLogin(String login) {
		this.login = login;

		ChatMessage message = new ChatMessage();

		message.setLogin("Vous vous êtes identifié sous le pseudo : ");
		message.setText(login);

		notifyObservers(message);
	}

	ChatSocketImpl impl = new ChatSocketImpl();

	public void sendMessage(String msg) {

		ChatMessage message = new ChatMessage();
		message.setLogin(login);
		message.setText(msg);
		try {
			impl.sendMessage(message);
		} catch (ChatClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		notifyObservers(message);
	}
}
