package br.com.furb.distribuidos.berkley.sockets;

public class Configuration {

	private Boolean isServer;
	private String server;
	private int timeOut;
	private int port;
	
	public Configuration() {
		super();
	}

	public Configuration(String server, int port) {
		super();
		this.server = server;
		this.port = port;
	}
	
	public Configuration(Boolean isServer, String server, int port) {
		super();
		this.isServer = isServer;
		this.server = server;
		this.port = port;
	}
	
	public Configuration(Boolean isServer, int port) {
		super();
		this.isServer = isServer;
		this.port = port;
	}

	public void dec() throws InterruptedException{
		Thread.sleep(1000);
		timeOut--;
	}
	
	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Boolean getIsServer() {
		return isServer;
	}

	public void setIsServer(Boolean isServer) {
		this.isServer = isServer;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((isServer == null) ? 0 : isServer.hashCode());
		result = prime * result + port;
		result = prime * result + ((server == null) ? 0 : server.hashCode());
		result = prime * result + timeOut;
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
		Configuration other = (Configuration) obj;
		if (isServer == null) {
			if (other.isServer != null)
				return false;
		} else if (!isServer.equals(other.isServer))
			return false;
		if (port != other.port)
			return false;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		if (timeOut != other.timeOut)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Configuration [isServer=" + isServer + ", server=" + server
				+ ", timeOut=" + timeOut + ", port=" + port + "]";
	}
}
