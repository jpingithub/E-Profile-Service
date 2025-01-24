package com.user_profile.user_profile.dto;

import lombok.Data;

@Data
public class LoginRequest {
	private String email;
	private String password;
}
