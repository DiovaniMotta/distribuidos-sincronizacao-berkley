package br.com.furb.distribuidos.berkley.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.Scanner;

import br.com.furb.distribuidos.berkley.message.Message;
import br.com.furb.distribuidos.berkley.message.factory.MessageFactory;
import br.com.furb.distribuidos.berkley.message.factory.MessageFactory.TypeMessage;

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
			if(configuration.getTimeOut() > 0) {
				socket = server.accept();
				System.out.println("Server Connected: "+ socket.getInetAddress().getHostName());
				PrintStream escrita = new PrintStream(socket.getOutputStream());
				Scanner leitura = new Scanner(socket.getInputStream());
				while (leitura.hasNext()) {
					Message message = MessageFactory.getFactory(TypeMessage.SEND).getMessage();
					String retorno = message.split(leitura.nextLine());
					
					message.addTime(current);
					escrita.print(message.message());
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
