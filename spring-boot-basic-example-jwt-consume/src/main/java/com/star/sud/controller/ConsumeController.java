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

	@Value("${REFRESH_TOKEN}")
	private String refreshToken;

	private String token;

	@RequestMapping(value = "/getResponse", method = RequestMethod.GET)
	public String getResponse() throws JsonProcessingException {

		log.info("getResponse starts");

		String response = null;
		// create user registration object
		RegistrationUser registrationUser = getRegistrationUser();
		// convert the user registration object to JSON
		String registrationBody = getBody(registrationUser);
		// create headers specifying that it is JSON request
		HttpHeaders registrationHeaders = getHeaders();
		HttpEntity<String> registrationEntity = new HttpEntity<String>(registrationBody, registrationHeaders);

		try {
			// Register User
			ResponseEntity<String> registrationResponse = restTemplate.exchange(regUrl, HttpMethod.POST,
					registrationEntity, String.class);
			log.info("registrationResponse : {}", registrationResponse);
			// if the registration is successful
			if (registrationResponse.getStatusCode().equals(HttpStatus.OK)) {

				// create user authentication object
				User authenticationUser = getAuthenticationUser();
				// convert the user authentication object to JSON
				String authenticationBody = getBody(authenticationUser);
				// create headers specifying that it is JSON request
				HttpHeaders authenticationHeaders = getHeaders();
				HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody,
						authenticationHeaders);

				// Authenticate User and get JWT
				ResponseEntity<ResponseToken> authenticationResponse = restTemplate.exchange(authUrl, HttpMethod.POST,
						authenticationEntity, ResponseToken.class);

				log.info("authenticationResponse: {}", authenticationResponse);

				// if the authentication is successful
				if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {
					token = "Bearer " + authenticationResponse.getBody().getToken();
					response = getData();

				}
			}
		} catch (Exception ex) {
			// check if exception is due to ExpiredJwtException
			if (ex.getMessage().contains("io.jsonwebtoken.ExpiredJwtException")) {
				// Refresh Token
				refreshToken();
				// try again with refresh token
				response = getData();
			} else {
				System.out.println(ex);
			}
		}
		log.info("getResponse end");
		return response;

	}

	private String getData() {
		String response = null;

		HttpHeaders headers = getHeaders();
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<String> helloResponse = restTemplate.exchange(hellUrl, HttpMethod.GET, jwtEntity, String.class);
		if (helloResponse.getStatusCode().equals(HttpStatus.OK)) {
			response = helloResponse.getBody();
		}
		return response;

	}

	private void refreshToken() {
		HttpHeaders headers = getHeaders();
		headers.set("Authorization", token);
		headers.set("isRefreshToken", "true");
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseToken> refreshTokenResponse = restTemplate.exchange(refreshToken, HttpMethod.GET,
				jwtEntity, ResponseToken.class);
		if (refreshTokenResponse.getStatusCode().equals(HttpStatus.OK)) {
			token = "Bearer " + refreshTokenResponse.getBody().getToken();
		}

	}

	private RegistrationUser getRegistrationUser() {
		RegistrationUser user = new RegistrationUser();
		user.setUsername("javainuse");
		user.setPassword("javainuse");
		user.setRole("ROLE_ADMIN");
		return user;
	}

	private User getAuthenticationUser() {
		User user = new User();
		user.setUsername("javainuse");
		user.setPassword("javainuse");
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