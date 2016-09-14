package br.com.furb.distribuidos.berkley.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.Scanner;

import br.com.furb.distribuidos.berkley.message.Message;
import br.com.furb.distribuidos.berkley.message.factory.MessageFactory;
import br.com.furb.distribuidos.berkley.message.factory.MessageFactory.TypeMessage;
import br.com.furb.distribuidos.berkley.queue.Client;
import br.com.furb.distribuidos.berkley.queue.QueueClient;

public class ServerBerkleySocket extends AbstractBerkleySocket {

	protected QueueClient queueClient;
	
	public ServerBerkleySocket(Configuration configuration) {
		super(configuration);
		queueClient = new QueueClient();
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
	public void send() {
	
	}

	@Override
	public void receive() {
		try {
			if(configuration.getTimeOut() > 0) {
				socket = server.accept();
				Client client = new Client(socket.getInetAddress().getHostName(),true);
				queueClient.add(client);
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
}
