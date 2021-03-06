package com.kainos.training.jersey.client;

import javax.ws.rs.WebApplicationException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginClientTest{
	
	private LoginClient loginClient;
	private static final String CORRECT_USERNAME = "admin";
	private static final String CORRECT_PASSWORD = "password";
	private static final String INCORRECT_USERNAME = "not admin";
	private static final String INCORRECT_PASSWORD = "not password";
	
	@Before
	public void setup() {
		loginClient = new LoginClient();
	}

	@Test
    public void shouldSuccessfullyLoginWithRightCredentials() {
		assertThat(loginClient.getLogin(CORRECT_USERNAME, CORRECT_PASSWORD), is(true));
	}
	
	@Test
	public void shouldFailLoginWithIncorrectCredentials() {
		try {
			loginClient.getLogin(INCORRECT_USERNAME, INCORRECT_PASSWORD);
		} catch (WebApplicationException e) {
			assertThat(e.getResponse().getStatus(), is(500));
		}
	}
}
