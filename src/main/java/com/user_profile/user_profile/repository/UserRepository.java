package com.user_profile.user_profile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user_profile.user_profile.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public Optional<User> findByEmailAndIsDeletedFalse(String email);
	public Optional<User> findByIdAndIsDeletedFalse(Integer id);
	public Optional<List<User> > findByIsDeletedFalse();
	public Optional<User> findByEmailAndPasswordAndIsDeletedFalse(String email,String password);
}
