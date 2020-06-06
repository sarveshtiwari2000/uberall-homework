package com.uberall.map;

import java.io.IOException;
import java.net.Proxy;

import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Authenticator implements com.squareup.okhttp.Authenticator {

	private String proxyUser;

	private String proxyPassword;

	private String hostUser;

	private String hostPassword;

	public Authenticator(String user, String password) {
		this.proxyUser = user;
		this.proxyPassword = password;
	}

	@Override
	public Request authenticate(Proxy proxy, Response response) throws IOException {
		String credential = Credentials.basic("username", "password");
		return response.request().newBuilder().header("Proxy-Authorization", credential).build();
	}

	@Override
	public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
		String credential = Credentials.basic(this.proxyUser, this.proxyPassword);
		return response.request().newBuilder().header("Proxy-Authorization", credential).build();
	}

}
