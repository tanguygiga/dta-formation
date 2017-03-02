package dta.chat.model;

import java.io.IOException;

import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatClientException;
import dta.chat.model.socket.ChatSocketImpl;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	ChatSocketImpl chatSocketImpl;

	public ChatConversationModel(ChatSocketImpl impl) {
		super();
		this.chatSocketImpl = impl;

	}

	String login;

	public void setLogin(String login) {
		this.login = login;

		ChatMessage message = new ChatMessage();

		message.setLogin("Vous vous êtes identifié sous le pseudo");
		message.setText(login);

		notifyObservers(message);
	}

	public void sendMessage(String msg) {

		ChatMessage message = new ChatMessage();
		message.setLogin(login);
		message.setText(msg);
		try {
			chatSocketImpl.sendMessage(message);
		} catch (ChatClientException e) {
			throw new ChatClientException("Problème lors de l'envoi du message", e);
		}

		notifyObservers(message);
	}

	public void readMessage() {
		new Thread(() -> {
			while (true) {
				try {
					ChatMessage message = chatSocketImpl.readMessage();
					notifyObservers(message);

				} catch (ChatClientException | IOException e) {
					throw new ChatClientException("Problème lors de la lecture du message", e);

				}
			}
		}).start();

	}
}
