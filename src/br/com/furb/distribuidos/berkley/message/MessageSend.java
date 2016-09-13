package br.com.furb.distribuidos.berkley.message;

public class MessageSend extends Message {

	@Override
	public String message() {
		return SEND + data;
	}
}
