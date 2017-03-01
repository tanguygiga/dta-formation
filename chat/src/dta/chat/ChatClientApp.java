package dta.chat;

import java.util.Scanner;

import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			ChatConversationModel model = new ChatConversationModel();
			final ChatConsoleView view = new ChatConsoleView(sc);
			view.setAuthController((login) -> {
				view.setLogin(login);
			});

			model.addObserver(view);

			view.print();

			model.sendMessages("Bonjour");
			model.sendMessages("C'est moi");
		}

	}

}
