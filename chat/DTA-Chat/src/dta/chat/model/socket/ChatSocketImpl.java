package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket {

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

	ClientSocket clientSocket;

	public ChatSocketImpl() {
		super();
		try {
			clientSocket = new ClientSocket("localhost", 1800);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			clientSocket.sendObject(msg.getLogin());
			clientSocket.sendObject(msg.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		// TODO Auto-generated method stub
		return null;
	}

}
