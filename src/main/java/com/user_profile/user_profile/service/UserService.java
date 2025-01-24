package com.user_profile.user_profile.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.user_profile.user_profile.dto.UpdatePasswordRequest;
import com.user_profile.user_profile.dto.UserDTO;
import com.user_profile.user_profile.entity.User;
import com.user_profile.user_profile.exception.UserAlreadyExistsException;
import com.user_profile.user_profile.exception.UserNotFoundException;
import com.user_profile.user_profile.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository repo;
	private final ModelMapper modelMapper;

	public User addUser(UserDTO dto) {
		User user = modelMapper.map(dto, User.class);
		Optional<User> optionalUser = repo.findByEmailAndIsDeletedFalse(dto.getEmail());
		if (optionalUser.isEmpty()) {
			return repo.save(user);
		} else
			throw new UserAlreadyExistsException("User already exist with email : " + dto.getEmail());
	}

	public User deleteUser(Integer id) {
		Optional<User> optionalUser = repo.findByIdAndIsDeletedFalse(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setDeleted(true);
			return repo.save(user);
		} else
			throw new UserNotFoundException("No user found with id " + id);
	}
	
	public List<User> allUsers() {
		Optional<List<User>> optionalUsers = repo.findByIsDeletedFalse();
		if(optionalUsers.get().isEmpty()){
			throw new UserNotFoundException("No user found ............. ");
		}else {
			return optionalUsers.get();
		}
	}
	
	public User update(Integer id,UserDTO dto) {
		Optional<User> optionalUser = repo.findByIdAndIsDeletedFalse(id);
		if(optionalUser.isPresent()) {
			User user = modelMapper.map(dto, User.class);
			user.setId(id);
			return repo.save(user);
		}else throw new UserNotFoundException("No user found with id " + id); 
	}
	
	public User login(String email,String password) {
		Optional<User> optionalUser = repo.findByEmailAndPasswordAndIsDeletedFalse(email, password);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else throw new UserNotFoundException("Login failed, No user found : "+email);
	}
	
	public User updatePassword(UpdatePasswordRequest request) {
		Optional<User> optionalUser = repo.findByIdAndIsDeletedFalse(request.getId());
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setPassword(request.getPassword());
			return repo.save(user);
		}else throw new UserNotFoundException("No user found with the ID : "+request.getId());
	}
}













