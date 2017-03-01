package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.model.observer.ChatObservable;

public class ChatConsoleLoginView extends ViewComposite {

	private Scanner sc;

	public ChatConsoleLoginView(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void print() {
		System.out.println("= Login =");
		System.out.println("Veuillez saisir votre login : ");
		String login = sc.next();
		this.authController.authenticate(login);
	}

	@Override
	public void update(ChatObservable observable, Object obj) {
		// TODO Auto-generated method stub

	}

}
