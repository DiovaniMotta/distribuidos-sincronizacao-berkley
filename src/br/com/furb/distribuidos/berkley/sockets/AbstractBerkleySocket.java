package br.com.furb.distribuidos.berkley.sockets;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public abstract class AbstractBerkleySocket {

	protected Date current;
	protected Socket socket;
	protected ServerSocket server;
	protected Configuration configuration;
	
    public AbstractBerkleySocket(Configuration configuration) {
		super();
		this.configuration = configuration;
	}

	public abstract void now();
	
	public abstract void connect();
    
    public abstract void send();
    
    public abstract void receive();
    
}
