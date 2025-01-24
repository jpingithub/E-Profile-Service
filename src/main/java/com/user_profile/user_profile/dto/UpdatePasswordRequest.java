package com.user_profile.user_profile.dto;

import lombok.Data;

@Data
public class UpdatePasswordRequest {
	private Integer id;
	private String password;
}
