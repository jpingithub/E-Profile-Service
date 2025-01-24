package com.user_profile.user_profile.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String userName;
	private String email;
	private String password;
	private Long phoneNumber;
	private String profileImage;
}
