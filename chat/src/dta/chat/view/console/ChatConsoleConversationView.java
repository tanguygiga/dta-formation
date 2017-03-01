package dta.chat.view.console;

import dta.chat.model.observer.ChatObservable;

public class ChatConsoleConversationView extends ViewComposite {

	@Override
	public void print() {
		System.out.println("= Conversation =");
		System.out.println("Salut à toi " + user + " !");
	}

	@Override
	public void update(ChatObservable observable, Object obj) {
		// TODO Auto-generated method stub

	}

}
