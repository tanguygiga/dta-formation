package dta.chat.view.console;

import dta.chat.model.observer.ChatObservable;

public class ChatConsoleTitleView extends ViewComposite {

	public ChatConsoleTitleView() {
	}

	@Override
	public void print() {
		System.out.println("== CHAT == ");
	}

	@Override
	public void update(ChatObservable observable, Object obj) {
		// TODO Auto-generated method stub

	}

}
