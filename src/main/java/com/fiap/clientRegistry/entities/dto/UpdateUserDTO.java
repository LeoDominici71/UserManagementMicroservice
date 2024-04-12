package com.fiap.clientRegistry.entities.dto;

import com.fiap.clientRegistry.entities.User;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateUserDTO {
	
	@NotNull
	private String cep;
	private String cidade;
	private String bairro;
	private String rua;
	@NotNull
	private String numero;
	private String complemento;
	
	public UpdateUserDTO(User user) {
		setCep(user.getCep());
		setCidade(user.getCidade());
		setBairro(user.getBairro());
		setRua(user.getRua());
		setNumero(user.getNumero());
		setComplemento(user .getComplemento());

	}

}
