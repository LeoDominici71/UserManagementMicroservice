package com.fiap.clientRegistry.entities.dto;

import org.hibernate.validator.constraints.br.CPF;

import com.fiap.clientRegistry.entities.User;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
	
	
    private Long id;
	@NotNull
	private String nome;
	@CPF
	private String cpf;
	private String email;
	private Integer idade;
	@NotNull
	private String cep;
	private String cidade;
	private String bairro;
	private String rua;
	@NotNull
	private String numero;
	private String complemento;

	public UserDTO(User user) {
		setId(user.getId());
		setNome(user.getNome());
		setCpf(user.getCpf());
		setEmail(user.getEmail());
		setIdade(user.getIdade());
		setCep(user.getCep());
		setCidade(user.getCidade());
		setBairro(user.getBairro());
		setRua(user.getRua());
		setNumero(user.getNumero());
		setComplemento(user.getComplemento());

	}

}
