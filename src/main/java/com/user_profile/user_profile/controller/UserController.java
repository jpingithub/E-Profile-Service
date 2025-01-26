package com.user_profile.user_profile.controller;

import java.util.List;

import com.user_profile.user_profile.dto.LoggedInResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_profile.user_profile.dto.LoginRequest;
import com.user_profile.user_profile.dto.UpdatePasswordRequest;
import com.user_profile.user_profile.dto.UserDTO;
import com.user_profile.user_profile.entity.User;
import com.user_profile.user_profile.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;

	@PostMapping
	ResponseEntity<User>  register(@RequestBody UserDTO dto) {
		return ResponseEntity.ok(service.addUser(dto));
	}

	@DeleteMapping("/{id}")
	ResponseEntity<User> delete(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(service.deleteUser(id));
	}

	@GetMapping
	ResponseEntity<List<User>> allUsers() {
		return ResponseEntity.ok(service.allUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> userDetails(@PathVariable("id") Integer id){
		return ResponseEntity.ok(service.getUserDetailsById(id));
	}

	@PutMapping("/{id}")
	ResponseEntity<User> update(@PathVariable("id") Integer id ,@RequestBody UserDTO dto) {
		return ResponseEntity.ok(service.update(id, dto));
	}
	
	@PostMapping("/login")
	ResponseEntity<LoggedInResponse> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(service.login(request.getEmail(), request.getPassword()));
	}
	
	@PatchMapping("/password-reset")
	ResponseEntity<User> updatePassword(@RequestBody UpdatePasswordRequest request) {
		return ResponseEntity.ok(service.updatePassword(request));
	}


	
}











