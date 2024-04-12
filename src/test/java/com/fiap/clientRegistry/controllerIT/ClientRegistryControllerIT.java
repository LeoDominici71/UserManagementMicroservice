package com.fiap.clientRegistry.controllerIT;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.clientRegistry.entities.dto.UpdateUserDTO;
import com.fiap.clientRegistry.entities.dto.UserDTO;
import com.fiap.clientRegistry.factory.Factory;
import com.fiap.clientRegistry.repositories.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ClientRegistryControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserRepository userRepository;

	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveRegistrarUmCliente() throws Exception {
		// Arrange
		UserDTO request = Factory.createUserDTO();
		String jsonBody = objectMapper.writeValueAsString(request);

		// Act
		ResultActions response = mockMvc
				.perform(post("/api/user").content(jsonBody).contentType(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isCreated());
		response.andExpect(jsonPath("$.nome").exists());
		response.andExpect(jsonPath("$.cpf").exists());
		response.andExpect(jsonPath("$.email").exists());
		response.andExpect(jsonPath("$.idade").exists());
		response.andExpect(jsonPath("$.cep").exists());
		response.andExpect(jsonPath("$.cidade").exists());
		response.andExpect(jsonPath("$.bairro").exists());
		response.andExpect(jsonPath("$.rua").exists());
		response.andExpect(jsonPath("$.numero").exists());
		response.andExpect(jsonPath("$.complemento").exists());

	}

	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void naoDeveRegistrarUmClienteComVariaveisNula() throws Exception {
		// Arrange
		UserDTO userDTO = Factory.createUserDTOWithNullAddress();
		String jsonBody = objectMapper.writeValueAsString(userDTO);

		// Act
		ResultActions response = mockMvc
				.perform(post("/api/user").content(jsonBody).contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isBadRequest());
	}

	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void naoDeveRegistrarUmClienteComIdadeMenorDe18() throws Exception {
		// Arrange
		UserDTO userDTO = Factory.createUserDTOUnderAge();
		String jsonBody = objectMapper.writeValueAsString(userDTO);

		// Act
		ResultActions response = mockMvc
				.perform(post("/api/user").content(jsonBody).contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isUnprocessableEntity());
	}

	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveBuscarClientePorId() throws Exception {

		// Arrange
		userRepository.save(Factory.createUser());

		// Act
		ResultActions response = mockMvc.perform(get("/api/user/{Id}", 1L).accept(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isOk());
		response.andExpect(jsonPath("$.nome").exists());
		response.andExpect(jsonPath("$.cpf").exists());
		response.andExpect(jsonPath("$.email").exists());
		response.andExpect(jsonPath("$.idade").exists());
		response.andExpect(jsonPath("$.cep").exists());
		response.andExpect(jsonPath("$.cidade").exists());
		response.andExpect(jsonPath("$.bairro").exists());
		response.andExpect(jsonPath("$.rua").exists());
		response.andExpect(jsonPath("$.numero").exists());
		response.andExpect(jsonPath("$.complemento").exists());

	}

	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void naoDeveBuscarClientePorIdQuandoOIdNaoExiste() throws Exception {

		// Act
		ResultActions response = mockMvc.perform(get("/api/user/{Id}", 1L).accept(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isUnprocessableEntity());

	}

	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveRetornarListaDeClientes() throws Exception {
		// Arrange
		userRepository.save(Factory.createUser());
		userRepository.save(Factory.createUser2());
		// Act
		ResultActions response = mockMvc.perform(get("/api/user").accept(MediaType.APPLICATION_JSON));

		//Assert
		response.andExpect(status().isOk());
		response.andExpect(jsonPath("$[0].nome").exists());
		response.andExpect(jsonPath("$[0].cpf").exists());
		response.andExpect(jsonPath("$[0].email").exists());
		response.andExpect(jsonPath("$[0].idade").exists());
		response.andExpect(jsonPath("$[0].cep").exists());
		response.andExpect(jsonPath("$[0].cidade").exists());
		response.andExpect(jsonPath("$[0].bairro").exists());
		response.andExpect(jsonPath("$[0].rua").exists());
		response.andExpect(jsonPath("$[0].numero").exists());
		response.andExpect(jsonPath("$[0].complemento").exists());

	}
	
	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveAtualizarUmCliente() throws Exception {
		// Arrange
		userRepository.save(Factory.createUser());
		UpdateUserDTO request = Factory.createUserDTOToUpdate();
		String jsonBody = objectMapper.writeValueAsString(request);

		// Act
		ResultActions response = mockMvc
				.perform(put("/api/user/update/{id}", 1L).content(jsonBody).contentType(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isOk());
		response.andExpect(jsonPath("$.cep").exists());
		response.andExpect(jsonPath("$.cidade").exists());
		response.andExpect(jsonPath("$.bairro").exists());
		response.andExpect(jsonPath("$.rua").exists());
		response.andExpect(jsonPath("$.numero").exists());
		response.andExpect(jsonPath("$.complemento").exists());

	}
	
	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void naoDeveAtualizarUmClienteQuandoIdNaoExiste() throws Exception {
		// Arrange
		userRepository.save(Factory.createUser());
		UpdateUserDTO request = Factory.createUserDTOToUpdate();
		String jsonBody = objectMapper.writeValueAsString(request);

		// Act
		ResultActions response = mockMvc
				.perform(put("/api/user/update/{id}", 2L).content(jsonBody).contentType(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isUnprocessableEntity());

	}
	
	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveDeletarClientePorId() throws Exception {

		// Arrange
		userRepository.save(Factory.createUser());

		// Act
		ResultActions response = mockMvc.perform(delete("/api/user/delete/{id}", 1L).accept(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isNoContent());
		

	}
	
	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void naoDeveDeletarClientePorIdQuandoIdNaoExiste() throws Exception {

		// Act
		ResultActions response = mockMvc.perform(delete("/api/user/delete/{id}", 10L).accept(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isUnprocessableEntity());
		

	}

}
