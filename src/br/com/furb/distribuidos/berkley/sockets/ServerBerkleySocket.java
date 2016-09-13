package br.com.furb.distribuidos.berkley.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerBerkleySocket extends AbstractBerkleySocket {

	public ServerBerkleySocket(Configuration configuration) {
		super(configuration);
	}

	@Override
	public void connect() {
		try {
			server = new ServerSocket(configuration.getPort());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	@SuppressWarnings("resource")
	public void send() {
		try {
			while (configuration.getTimeOut() > 0) {
				System.out.println("Server Connected: "+ socket.getInetAddress().getHostName());
				PrintStream escrita = new PrintStream(socket.getOutputStream());
				Scanner leitura = new Scanner(socket.getInputStream());
				while (leitura.hasNext()) {
				
				}
				configuration.dec();
			}
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void receive() {

	}
}
