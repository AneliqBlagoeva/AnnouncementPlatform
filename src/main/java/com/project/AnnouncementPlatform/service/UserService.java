package com.project.AnnouncementPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.AnnouncementPlatform.domain.User;
import com.project.AnnouncementPlatform.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public Optional<User> findById(String email) {
        return userRepository.findById(email);
    }
    
    public void deleteById(String email) {
    	userRepository.deleteById(email);
    }
    
    public User save(User user) {
        return userRepository.save(user);
    }
    
    public User update(User user) {
    	if (!userRepository.findById(user.getEmail()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return userRepository.save(user);
    }
}
