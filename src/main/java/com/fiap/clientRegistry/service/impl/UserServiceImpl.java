package com.fiap.clientRegistry.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiap.clientRegistry.controller.exception.GeneralClientSystemException;
import com.fiap.clientRegistry.entities.User;
import com.fiap.clientRegistry.repositories.UserRepository;
import com.fiap.clientRegistry.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	public static final Integer AGE = 18;

	private final UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;

	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		try {
			UserServiceImpl.log.info("IN - UserRegistry");
			if (user.getIdade() < AGE) {
				throw new Exception("Customers should be over 18 years old to register");
			}
			return repository.save(user);
		} catch (Exception e) {
			UserServiceImpl.log.error("IN - UserRegistry exception", e);
			throw new GeneralClientSystemException(e.getMessage());
		}
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		UserServiceImpl.log.info("IN - FindUserList");
		return repository.findAll();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		try {
			UserServiceImpl.log.info("IN - FindUserById");

			Optional<User> optionalUser = repository.findById(id);
			User user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found"));
			return user;
		} catch (Exception e) {
			throw new GeneralClientSystemException(e.getMessage());

		}
	}

	@Override
	public User update(Long id, User user) {
		// TODO Auto-generated method stub
		try {
			UserServiceImpl.log.info("IN - UpdateUserById");

			Optional<User> currentUser = repository.findById(id);
			User userCurrent = currentUser.orElseThrow(() -> new EntityNotFoundException("User not found"));
			User updated = userCurrent.UserUpdate(userCurrent, user);
			repository.save(updated);

			return updated;
		} catch (Exception e) {
			throw new GeneralClientSystemException(e.getMessage());

		}
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		try {
			UserServiceImpl.log.info("IN - DeleteUserById");

			Optional<User> optionalUser = repository.findById(id);
			User user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found"));
			repository.delete(user);
		} catch (Exception e) {
			throw new GeneralClientSystemException(e.getMessage());

		}

	}

}
