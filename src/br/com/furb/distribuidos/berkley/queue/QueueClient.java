package br.com.furb.distribuidos.berkley.queue;

import java.util.HashSet;
import java.util.Set;

public class QueueClient {

	private Set<Client> clients = new HashSet<Client>();
	
	public void add(Client client){
		clients.add(client);
	}
	
	public void remove(Client client){
		clients.remove(client);
	}
	
	public Client get(int index){
		for(int x =0; x< clients.size();x++){
			Client client = (Client) clients.toArray()[x];
			if(x == index)
				return client;
		}
		return null;
	}
	
	public Client get(Client client){
		for(Client c : clients)
			if(c.equals(client))
				return c;
		return null;
	}
}
