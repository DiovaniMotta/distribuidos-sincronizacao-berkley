package br.com.furb.distribuidos.berkley.message;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Message {

	public static String SEND = new String("#SEND:");
	public static String RECEIVE = new String("#RECEIVE:");
	protected String data;
	
	public void addTime(Date date){
		DateTimeFormatter formatador = 
				  DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		data = localDate.format(formatador);

	}
	
	public abstract String message();
}
