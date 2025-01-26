package com.user_profile.user_profile.service;

import com.user_profile.user_profile.config.AuthenticatedUser;
import com.user_profile.user_profile.entity.User;
import com.user_profile.user_profile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AuthenticatedUser(userRepository.findByEmailAndIsDeletedFalse(username).orElseThrow());
    }
}
