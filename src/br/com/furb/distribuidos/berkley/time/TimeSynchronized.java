package br.com.furb.distribuidos.berkley.time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeSynchronized {

	public static long ajust(String ajust,Date date){
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDate client = LocalDate.parse(ajust, formatador);
		LocalDate now = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ChronoUnit.DAYS.between(now, client);
	}
}
