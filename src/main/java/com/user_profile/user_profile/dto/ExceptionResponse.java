package com.user_profile.user_profile.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
	private Instant timestamp;
    private String message;
    private String path;
    private Integer status;
}
