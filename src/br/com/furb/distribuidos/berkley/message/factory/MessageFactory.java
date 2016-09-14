package br.com.furb.distribuidos.berkley.message.factory;

import br.com.furb.distribuidos.berkley.message.Message;

public abstract class MessageFactory {

	public enum TypeMessage {
		RECEIVE, SEND
	}

	public static MessageFactory getFactory(TypeMessage index) {
		if (index == TypeMessage.RECEIVE)
			return new MessageFactoryReceive();
		return new MessageFactorySend();
	}

	public abstract Message getMessage();
}
