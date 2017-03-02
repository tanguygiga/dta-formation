package dta.chat.model.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket extends Socket {

	private ObjectInputStream serverInput;
	private ObjectOutputStream serverOuput;

	public ClientSocket(String host, Integer port) throws IOException {
		super(host, port);
		this.serverInput = new ObjectInputStream(this.getInputStream());
		this.serverOuput = new ObjectOutputStream(this.getOutputStream());
	}

	public Object readObject() throws ClassNotFoundException, IOException {
		return this.serverInput.readObject();
	}

	public void sendObject(Object obj) throws IOException {
		this.serverOuput.writeObject(obj);
	}

	// Pour d�mo
	public static void main(String[] args) throws IOException {
		ClientSocket client = new ClientSocket("localhost", 1800);
		client.sendObject("Test de message");
		client.close();
		// client.readObject();
		// pour recevoir un message du serveur

	}

}
