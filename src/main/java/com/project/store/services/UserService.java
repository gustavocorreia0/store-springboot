package com.project.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.store.entities.User;
import com.project.store.repositories.UserRepository;
import com.project.store.services.exceptions.DatabaseException;
import com.project.store.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User registerUser(User newUser) {
		return userRepository.save(newUser);
	}

	public void deleteUser(Long id) {
		try {
			if (userRepository.existsById(id)) {
				userRepository.deleteById(id);
			} else {
				throw new ResourceNotFoundException(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User updateUser(Long id, User userUpdated) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity, userUpdated);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User oldUser, User newUser) {
		oldUser.setName(newUser.getName());
		oldUser.setEmail(newUser.getEmail());
		oldUser.setNumber(newUser.getNumber());
	}

}
