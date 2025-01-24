package com.user_profile.user_profile.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
