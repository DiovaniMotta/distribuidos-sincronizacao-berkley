package br.com.furb.distribuidos.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import br.com.furb.distribuidos.berkley.time.TimeControl;

public class ClientBerkley {

	public static final int PORT = 9000;
	public static int TIMEOUT = 60000;
	public static final String SERVER = "127.0.0.1";
	public static Date DATA_SERVIDOR;
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
				Socket cliente = new Socket(SERVER, PORT);
				DATA_SERVIDOR = TimeControl.getNow();
				try {
					while (true) {
						PrintStream escrita = new PrintStream(
								cliente.getOutputStream());
						@SuppressWarnings("resource")
						Scanner leitura = new Scanner(cliente.getInputStream());
						while (leitura.hasNext()) {
							String texto = leitura.nextLine();
							if (texto.equals("#SYNC_")) {
								escrita.println("#DATE_"
										+ TimeControl.getFormat(DATA_SERVIDOR));
							} else {
								DATA_SERVIDOR = TimeControl.getNow();
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
