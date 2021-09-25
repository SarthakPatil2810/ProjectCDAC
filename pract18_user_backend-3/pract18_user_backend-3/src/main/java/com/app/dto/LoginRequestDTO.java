package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequestDTO {
	
	@NotBlank(message = "email id is required")
	private String email;
	@NotBlank(message = "password is required")
	private String password;
}