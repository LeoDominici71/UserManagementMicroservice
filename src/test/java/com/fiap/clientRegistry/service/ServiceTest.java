package com.fiap.clientRegistry.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fiap.clientRegistry.entities.User;
import com.fiap.clientRegistry.factory.Factory;
import com.fiap.clientRegistry.repositories.UserRepository;
import com.fiap.clientRegistry.service.impl.UserServiceImpl;

@ExtendWith(SpringExtension.class)
public class ServiceTest {

	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private UserRepository repository;

	@Test
	public void testServiceFindUserById() {
		// Arrange
		User user = Factory.createUser();

		// Act
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		User result = service.findById(1L);

		// Assert
		assertNotNull(result);
		assertEquals(user.getNome(), result.getNome());
		verify(repository, Mockito.times(1)).findById(1L);

	}

	@Test
	public void testServiceRegisterUser() {
		// Arrange
		User user = Factory.createUser();

		// Act
		Mockito.when(repository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
		User result = service.save(user);
		// Assert
		assertNotNull(result);
		assertEquals(user.getNome(), result.getNome());
		verify(repository, Mockito.times(1)).save(user);

	}

	@Test
	public void testUpdateUser() {
		// Arrange
		User user = Factory.createUser();

		// Act
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(user);

		User result = service.update(1L, user);
		
		//Assert
		assertNotNull(result);
		assertEquals(user.getBairro(), result.getBairro());
		verify(repository, Mockito.times(1)).findById(1L);
		verify(repository, Mockito.times(1)).save(user);

	}
	
	@Test
	public void testServiceFindAllUser() {
		// Arrange
		User user = Factory.createUser();
        User user2 = Factory.createUser2();
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

		
		// Act
		when(repository.findAll()).thenReturn(users);
		List<User> results = service.findAll();

		// Assert
		assertNotNull(results);
		assertEquals(user.getNome(), results.get(0).getNome());
		assertEquals(user2.getNome(), results.get(1).getNome());
		verify(repository, Mockito.times(1)).findAll();

	}
	
	@Test
	public void testDeleteUser() {
		//Arrange
		User user = Factory.createUser();

		//Act
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		Assertions.assertDoesNotThrow(() -> {
			repository.delete(user);
		});
		
		//Assert
		Mockito.verify(repository, times(1)).delete(user);

		

	}

}
