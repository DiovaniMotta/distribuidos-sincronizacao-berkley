package br.com.furb.distribuidos.berkley.message.factory;

import br.com.furb.distribuidos.berkley.message.Message;
import br.com.furb.distribuidos.berkley.message.MessageReceive;

public class MessageFactoryReceive extends MessageFactory {

	@Override
	public Message getMessage() {
		return new MessageReceive();
	}

}
