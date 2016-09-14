package br.com.furb.distribuidos.berkley.message.factory;

import br.com.furb.distribuidos.berkley.message.Message;
import br.com.furb.distribuidos.berkley.message.MessageSend;

public class MessageFactorySend extends MessageFactory {

	@Override
	public Message getMessage() {
		return new MessageSend();
	}

}
