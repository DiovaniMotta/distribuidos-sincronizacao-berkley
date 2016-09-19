package br.com.furb.distribuidos.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import br.com.furb.distribuidos.berkley.time.TimeControl;

public class ServerBerkley {

	public static int TIMEOUT = 60000;
	public static final int PORT = 9000;
	private static Date DATA_SERVIDOR;
	private static List<String> horarios = new ArrayList<String>();
	public static Timer timer;

	static {
		timer = new Timer();
		timer.scheduleAtFixedRate(new Executa(), 0, 100);
	}

	public static void main(String[] args) {
		encerrar();
	}

	private static void encerrar() {
		try {
			Thread.sleep(60000);
			timer.cancel();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private static class Executa extends TimerTask {

		@Override
		public void run() {
			try {
				ServerSocket servidor = new ServerSocket(PORT);
				System.out
						.println("Servidor de Sincronização de Relógio Ativo.");
				DATA_SERVIDOR = TimeControl.getNow();
				System.out.println("Data Atual: "
						+ TimeControl.getFormat(DATA_SERVIDOR));
				while (true) {
					Socket socket = servidor.accept();
					horarios.clear();
					String host = socket.getInetAddress().getHostName();
					System.out.println("Cliente conectou: " + host);
					try {
						PrintStream escrita = new PrintStream(
								socket.getOutputStream());
						Scanner leitura = new Scanner(socket.getInputStream());
						String texto = new String(); 
						/*if(leitura.hasNext())
							texto = leitura.nextLine();*/
						if (texto.startsWith("#DATE_")) {
							horarios.add(texto.replace("#DATE_", ""));
						}
						Random random = new Random();
						boolean sinc = random.nextBoolean();
						if (sinc) {
							escrita.println("#SYNC_");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
