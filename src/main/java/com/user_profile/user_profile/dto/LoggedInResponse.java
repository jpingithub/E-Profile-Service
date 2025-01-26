package com.user_profile.user_profile.dto;

import lombok.Data;

@Data
public class LoggedInResponse {
    private Integer userId;
    private String token;
}
