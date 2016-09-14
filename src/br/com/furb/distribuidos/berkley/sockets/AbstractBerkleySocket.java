package br.com.furb.distribuidos.berkley.sockets;

import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import br.com.furb.distribuidos.berkley.time.RandomTime;

public abstract class AbstractBerkleySocket {

	protected Date current;
	protected Socket socket;
	protected ServerSocket server;
	protected Configuration configuration;

	public AbstractBerkleySocket(Configuration configuration) {
		super();
		this.configuration = configuration;
	}

	public void now() {
		RandomTime randomTime = new RandomTime();
		LocalDateTime ldt = LocalDateTime.of(randomTime.year(),
				randomTime.month(), randomTime.day(), randomTime.hour(),
				randomTime.minute(), randomTime.second());
		current = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
	}

	public abstract void connect();

	public abstract void send();

	public abstract void receive();

}
