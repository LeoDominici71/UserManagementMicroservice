package com.fiap.clientRegistry.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.clientRegistry.entities.User;
import com.fiap.clientRegistry.entities.dto.UpdateUserDTO;
import com.fiap.clientRegistry.entities.dto.UserDTO;
import com.fiap.clientRegistry.service.UserService;
import com.fiap.clientRegistry.service.impl.UserServiceImpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {
	
	public final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> listUsers(){
		List<User> userList = service.findAll();
		List<UserDTO> userDtoList = userList.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());	
		UserController.log.info("OUT - FindUserList");
		return ResponseEntity.ok().body(userDtoList);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
		User user = service.findById(id);
		UserController.log.info("OUT - FindUserById");
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> registerUser( @Valid @RequestBody UserDTO userDto){
		User user = service.save(new User(userDto));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		UserController.log.info("OUT - UserRegistry");
		return ResponseEntity.created(uri).body(new UserDTO(user));
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<UpdateUserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserDTO userDto){
		User user = service.update(id, new User(userDto));
		UserController.log.info("OUT - UpdateUserById");
		return ResponseEntity.ok().body(new UpdateUserDTO(user));
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		service.delete(id);
		UserController.log.info("OUT - DeleteUserById");
		return ResponseEntity.noContent().build();
	}

}
