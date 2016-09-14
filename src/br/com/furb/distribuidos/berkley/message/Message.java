package br.com.furb.distribuidos.berkley.message;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Message {

	protected String data;
	public static String SEND = new String("#SEND:");
	public static String RECEIVE = new String("#RECEIVE:");
	protected static String AJUST = new String("_AJUST");
	protected static String SYNCHRONIZED = new String("_SYNCHRONIZED");
	
	public void addTime(Date date){
		DateTimeFormatter formatador = 
				  DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		data = localDate.format(formatador);

	}
	
	public abstract String message();
	
	public abstract String split(String scanner);
}
