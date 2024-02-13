package com.project.store.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){ 
		User userTeste = new User(1L,"Larissa","é","muito","gostosa");
	
		return ResponseEntity.ok().body(userTeste);
	}
	
}
