package com.fiap.clientRegistry.service;

import java.util.List;
import java.util.Optional;

import com.fiap.clientRegistry.entities.User;

public interface UserService {

	public User save(User user);
	
	public List<User> findAll();
	
	public User findById(Long id);
	
	public User update(Long id , User user);
	
	public void delete(Long id);

}
