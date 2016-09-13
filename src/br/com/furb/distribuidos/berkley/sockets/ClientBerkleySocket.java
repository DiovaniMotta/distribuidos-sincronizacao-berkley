package br.com.furb.distribuidos.berkley.sockets;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientBerkleySocket extends AbstractBerkleySocket {

	public ClientBerkleySocket(Configuration configuration) {
		super(configuration);
	}
	
	@Override
	public void connect() {
		try {
			socket = new Socket(configuration.getServer(),configuration.getPort());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void send() {
	}

	@Override
	public void receive() {
	
	}

}
