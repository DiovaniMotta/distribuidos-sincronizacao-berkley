package br.com.furb.distribuidos.berkley.message;

public class MessageReceive extends Message {

	@Override
	public String message() {
		return RECEIVE + data;
	}
}
