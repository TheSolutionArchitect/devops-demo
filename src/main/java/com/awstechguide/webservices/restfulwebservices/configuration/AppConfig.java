package com.awstechguide.webservices.restfulwebservices.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="config")
public class AppConfig {

	private String host;
	private String port;
	private String database;
	private String username;
	private String password;
	
	@Value("${jdbc.j_host}")
	private String j_host;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJ_host() {
		return j_host;
	}

	public void setJ_host(String j_host) {
		this.j_host = j_host;
	}
	
	
	
}
