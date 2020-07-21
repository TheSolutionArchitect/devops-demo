package com.awstechguide.webservices.restfulwebservices.configuration;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix="config")
@Validated
public class AppConfig {

	private String host;
	private int port;
	private String database;
	private String username;
	private String password;
	
	@Value("${jdbc.j_host}")
	private String j_host;
	
	
	@NotBlank
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Min(8000)
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@NotBlank
	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	@NotBlank
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotBlank
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotBlank
	public String getJ_host() {
		return j_host;
	}

	public void setJ_host(String j_host) {
		this.j_host = j_host;
	}

	
}
