package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.model.observer.ChatObservable;

public class ChatConsoleView extends ViewComposite {

	public ChatConsoleView(Scanner sc) {
		this.add(new ChatConsoleTitleView());
		this.add(new ChatConsoleLoginView(sc));
		this.add(new ChatConsoleConversationView());
	}

	@Override
	public void update(ChatObservable observable, Object obj) {
		// TODO Auto-generated method stub

	}
}
