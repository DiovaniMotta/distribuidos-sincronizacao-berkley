package br.com.furb.distribuidos.berkley.message;

public class Message {

	public static String SEND = new String("#SEND:");
	public static String RECEIVE = new String("#RECEIVE:");
	
	public void process(String process){
		if(process == null)
			return;
		if(process.isEmpty())
			return;
		String aux = process.startsWith(SEND) ? process.replace(SEND,"") : process.replace(RECEIVE,"");		
	}
}
