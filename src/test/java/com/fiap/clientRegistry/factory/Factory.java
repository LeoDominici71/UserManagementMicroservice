package com.fiap.clientRegistry.factory;

import com.fiap.clientRegistry.entities.User;
import com.fiap.clientRegistry.entities.dto.UpdateUserDTO;
import com.fiap.clientRegistry.entities.dto.UserDTO;

public class Factory {
	
	public static UserDTO createUserDTO() {
		UserDTO usuario = new UserDTO();
		usuario.setNome("Leonardo");
		usuario.setCpf("48374255854");
		usuario.setEmail("leonardo_requena@outlook.com");
		usuario.setIdade(18);
		usuario.setCep("11701620");
		usuario.setCidade("Praia Grande");
		usuario.setBairro("Vila Guilhermina");
		usuario.setRua("Rua Itarare");
		usuario.setNumero("252");
		usuario.setComplemento("apartamento 65");
		return usuario;
	}
	
	public static UpdateUserDTO createUserDTOToUpdate() {
		UpdateUserDTO usuario = new UpdateUserDTO();
		usuario.setCep("11701621");
		usuario.setCidade("Praia Grande");
		usuario.setBairro("Vila Guilhermina");
		usuario.setRua("Rua Itarare");
		usuario.setNumero("252");
		usuario.setComplemento("apartamento 65");
		return usuario;
	}
	
	public static UserDTO createUserDTOWithNullAddress() {
		UserDTO usuario = new UserDTO();
		usuario.setNome("Leonardo");
		usuario.setCpf("48374255854");
		usuario.setEmail("leonardo_requena@outlook.com");
		usuario.setIdade(18);
		usuario.setCidade("Praia Grande");
		usuario.setBairro("Vila Guilhermina");
		usuario.setRua("Rua Itarare");
		usuario.setNumero("252");
		usuario.setComplemento("apartamento 65");
		return usuario;
	}
	
	public static UserDTO createUserDTOUnderAge() {
		UserDTO usuario = new UserDTO();
		usuario.setNome("Leonardo");
		usuario.setCpf("48374255854");
		usuario.setEmail("leonardo_requena@outlook.com");
		usuario.setIdade(17);
		usuario.setCep("11701620");
		usuario.setCidade("Praia Grande");
		usuario.setBairro("Vila Guilhermina");
		usuario.setRua("Rua Itarare");
		usuario.setNumero("252");
		usuario.setComplemento("apartamento 65");
		return usuario;
	}
	
	public static User createUser() {
		User usuario = new User();
		usuario.setNome("Leonardo");
		usuario.setCpf("48374255854");
		usuario.setEmail("leonardo_requena@outlook.com");
		usuario.setIdade(18);
		usuario.setCep("11701620");
		usuario.setCidade("Praia Grande");
		usuario.setBairro("Vila Guilhermina");
		usuario.setRua("Rua Itarare");
		usuario.setNumero("252");
		usuario.setComplemento("apartamento 65");
		return usuario;
	}
	
	public static User createUser3() {
		User usuario = new User();
		usuario.setNome("Leonardo");
		usuario.setCpf("76632355099");
		usuario.setEmail("leonardo_requena@outlook.com");
		usuario.setIdade(18);
		usuario.setCep("11701620");
		usuario.setCidade("Praia Grande");
		usuario.setBairro("Vila Guilhermina");
		usuario.setRua("Rua Itarare");
		usuario.setNumero("252");
		usuario.setComplemento("apartamento 65");
		return usuario;
	}
	
	public static User createUser2() {
		User usuario = new User();
		usuario.setNome("Igor");
		usuario.setCpf("70409951820");
		usuario.setEmail("leonardo_requena@outlook.com");
		usuario.setIdade(19);
		usuario.setCep("11701620");
		usuario.setCidade("Praia Grande");
		usuario.setBairro("Vila Guilhermina");
		usuario.setRua("Rua Itarare");
		usuario.setNumero("252");
		usuario.setComplemento("apartamento 65");
		return usuario;
	}

}
