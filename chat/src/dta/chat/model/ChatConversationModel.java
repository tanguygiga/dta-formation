package dta.chat.model;

import dta.chat.model.observer.ChatObservable;

public class ChatConversationModel<T> extends ChatObservable<T> {

	public void setLogin(String login) {
		// notifie tous les observateurs
	}

	public void sendMessages(String msg) {
		// notifie tous les observateurs

	}
}
