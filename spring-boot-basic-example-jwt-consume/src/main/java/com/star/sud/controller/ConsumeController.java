package com.star.sud.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.sud.dto.RegistrationUser;
import com.star.sud.dto.ResponseToken;
import com.star.sud.dto.User;

@RestController
public class ConsumeController {

	private static final Logger log = LogManager.getLogger(ConsumeController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${REGISTRATION_URL}")
	private String regUrl;

	@Value("${AUTHENTICATION_URL}")
	private String authUrl;

	@Value("${HELLO_URL}")
	private String hellUrl;

	@RequestMapping(value = "/getResponse", method = RequestMethod.GET)
	public String getResponse() throws JsonProcessingException {

		try {

			HttpHeaders registrationHeaders = getHeaders();
			HttpEntity<String> registrationEntity = new HttpEntity<String>(getBody(getRegistrationUser()),
					registrationHeaders);

			// Register User
			ResponseEntity<String> registrationResponse = restTemplate.exchange(this.regUrl, HttpMethod.POST,
					registrationEntity, String.class);
			// if the registration is successful
			if (!registrationResponse.getStatusCode().equals(HttpStatus.OK))
				throw new Exception("failed to register the user from backend server");

			// create user authentication object
			User authenticationUser = getAuthenticationUser();
			// convert the user authentication object to JSON
			String authenticationBody = getBody(authenticationUser);
			// create headers specifying that it is JSON request
			HttpHeaders authenticationHeaders = getHeaders();
			HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody, authenticationHeaders);

			// Authenticate User and get JWT
			ResponseEntity<ResponseToken> authenticationResponse = restTemplate.exchange(this.authUrl, HttpMethod.POST,
					authenticationEntity, ResponseToken.class);

			// if the authentication is successful
			if (!authenticationResponse.getStatusCode().equals(HttpStatus.OK))
				throw new Exception("Authentication Exception");

			String token = "Bearer " + authenticationResponse.getBody().getToken();
			HttpHeaders headers = getHeaders();
			headers.set("Authorization", token);
			HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
			// Use Token to get Response
			ResponseEntity<String> helloResponse = restTemplate.exchange(this.hellUrl, HttpMethod.GET, jwtEntity,
					String.class);
			if (!helloResponse.getStatusCode().equals(HttpStatus.OK))
				throw new Exception("Failed to get the response from the server");

			return helloResponse.getBody();

		} catch (Exception ex) {
			log.error("getResponse", ex);
		}
		return null;
	}

	private RegistrationUser getRegistrationUser() {
		RegistrationUser user = new RegistrationUser();
		user.setUsername("user01");
		user.setPassword("password");
		user.setRole("ROLE_ADMIN");
		return user;
	}

	private User getAuthenticationUser() {
		User user = new User();
		user.setUsername("user01");
		user.setPassword("password");
		return user;
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}

	private String getBody(final User user) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(user);
	}

}