package com.project.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.User;
import com.project.store.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long Id) {
		Optional<User> user = userRepository.findById(Id);
		return user.get();
	}
	
	public User registerUser(User newUser){
		return userRepository.save(newUser);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(Long id, User userUpdated) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, userUpdated);
		return userRepository.save(entity);
	}
	
	private void updateData(User oldUser, User newUser) {
		oldUser.setName(newUser.getName());
		oldUser.setEmail(newUser.getEmail());
		oldUser.setNumber(newUser.getNumber());
	}
	
}
