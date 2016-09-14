package br.com.furb.distribuidos.berkley.queue;

public class Client {

	private String id;
	private Boolean connect;
	
	public Client() {
		super();
	
	}

	public Client(String id, Boolean connect) {
		super();
		this.id = id;
		this.connect = connect;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getConnect() {
		return connect;
	}

	public void setConnect(Boolean connect) {
		this.connect = connect;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", connect=" + connect + "]";
	}
}
