package br.com.furb.distribuidos.berkley.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import br.com.furb.distribuidos.berkley.message.Message;
import br.com.furb.distribuidos.berkley.message.factory.MessageFactory;
import br.com.furb.distribuidos.berkley.message.factory.MessageFactory.TypeMessage;
import br.com.furb.distribuidos.berkley.time.RandomTime;

public class ClientBerkleySocket extends AbstractBerkleySocket {

	public ClientBerkleySocket(Configuration configuration) {
		super(configuration);
	}
	
	@Override
	public void now() {
		RandomTime randomTime = new RandomTime();
		LocalDateTime ldt = LocalDateTime.of(randomTime.year(),randomTime.month(),randomTime.day(),randomTime.hour(),randomTime.minute(),randomTime.second());
		current = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
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
		/*Scanner leitura = new Scanner(cliente.getInputStream());
		while(teclado.hasNext()) {
			String texto = teclado.nextLine();
			if (texto.equals("0")) {
				break;
			}
			escrita.println(texto);
			if (leitura.hasNext())
				System.err.println(leitura.nextLine());
		}*/
	}

	@Override
	public void receive() {
		try {
			PrintStream escrita = new PrintStream(socket.getOutputStream());
			Message message =  MessageFactory.getFactory(TypeMessage.RECEIVE).getMessage(); 
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
