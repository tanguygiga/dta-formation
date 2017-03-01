package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

public class ChatConsoleView extends ViewComposite implements ChatObserver<ChatMessage> {

	private Scanner read;

	public ChatConsoleView(Scanner read) {

		this.setRead(read);

		this.add(new ChatConsoleTitleView());
		this.add(new ChatConsoleLoginView(read));
		this.add(new ChatConsoleConversationView());
	}

	@Override
	protected void printThisBefore() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void printThisAfter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage message) {

		System.out.println(message.getLogin() + " : " + message.getText());

	}

	public Scanner getRead() {
		return read;
	}

	public void setRead(Scanner read) {
		this.read = read;
	}

}
