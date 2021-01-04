package com.star.sud.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.star.sud.resource.UserResource;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(UserResource.class);
	}
}