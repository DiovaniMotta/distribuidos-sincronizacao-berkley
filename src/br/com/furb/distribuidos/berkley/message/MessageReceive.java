package br.com.furb.distribuidos.berkley.message;

public class MessageReceive extends Message {

	@Override
	public String message() {
		return RECEIVE + data;
	}
	
	@Override
	public String split(String scanner) {
		if(scanner == null)
			return new String();
		if(scanner.isEmpty())
			return scanner;
		String[] aux = scanner.split(RECEIVE);
		if(aux.length > 0)
			return aux[0];
		return new String();
	}
}
