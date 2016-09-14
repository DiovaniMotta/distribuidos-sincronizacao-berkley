package br.com.furb.distribuidos.berkley.message;

public class MessageSend extends Message {

	@Override
	public String message() {
		return SEND + data;
	}
	
	@Override
	public String split(String scanner) {
		if(scanner == null)
			return new String();
		if(scanner.isEmpty())
			return scanner;
		String[] aux = scanner.split(SEND);
		if(aux.length > 0)
			return aux[0];
		return new String();
	}
}

