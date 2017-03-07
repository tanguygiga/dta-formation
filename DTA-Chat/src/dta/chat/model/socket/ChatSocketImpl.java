package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket {

	@Override
	public void close() throws Exception {
		clientSocket.close();

	}

	ClientSocket clientSocket;

	public ChatSocketImpl(String host, int port) throws ChatClientException {
		super();
		try {
			clientSocket = new ClientSocket(host, port);
		} catch (IOException e) {
			throw new ChatClientException("Problème lors de la création de la connection", e);
		}
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			clientSocket.sendObject(msg);
		} catch (IOException e) {
			throw new ChatClientException("Problème lors de l'envoi du message", e);
		}

	}

	@Override
	public ChatMessage readMessage() throws ChatClientException, IOException {
		try {
			return (ChatMessage) clientSocket.readObject();
		} catch (ClassNotFoundException e) {
			throw new ChatClientException("Problème lors de la lecture du message", e);

		}

	}
}
