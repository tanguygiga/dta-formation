package dta.chat.controller;

import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ViewComposite;

public class ChatLoginStrategy implements ChatAuthController {

	private ViewComposite view;
	private ChatConversationModel model;

	public ChatLoginStrategy(ViewComposite view, ChatConversationModel model) {
		this.setView(view);
		this.model = model;
	}

	@Override
	public void authenticate(String login) {
		model.setLogin(login);
	}

	public ViewComposite getView() {
		return view;
	}

	public void setView(ViewComposite view) {
		this.view = view;
	}

}
