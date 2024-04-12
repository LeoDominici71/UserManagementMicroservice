package com.fiap.clientRegistry.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fiap.clientRegistry.entities.dto.UpdateUserDTO;
import com.fiap.clientRegistry.entities.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String cpf;
	private String email;
	private Integer idade;
	private String cep;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;

	public User() {
		super();
	}

	public User UserUpdate(User userAtual, User userAntigo) {
		userAtual.setCep(userAntigo.getCep());
		userAtual.setCidade(userAntigo.getCidade());
		userAtual.setBairro(userAntigo.getBairro());
		userAtual.setRua(userAntigo.getRua());
		userAtual.setNumero(userAntigo.getNumero());
		userAtual.setComplemento(userAntigo.getComplemento());

		return userAtual;

	}

	public User(UserDTO userDto) {
		this.nome = userDto.getNome();
		this.cpf = userDto.getCpf();
		this.email = userDto.getEmail();
		this.idade = userDto.getIdade();
		this.cep = userDto.getCep();
		this.cidade = userDto.getCidade();
		this.bairro = userDto.getBairro();
		this.rua = userDto.getRua();
		this.numero = userDto.getNumero();
		this.complemento = userDto.getComplemento();
	}

	public User(UpdateUserDTO userDto) {
		this.cep = userDto.getCep();
		this.cidade = userDto.getCidade();
		this.bairro = userDto.getBairro();
		this.rua = userDto.getRua();
		this.numero = userDto.getNumero();
		this.complemento = userDto.getComplemento();
	}

	public User(Long id, String nome, String cpf, String email,Integer idade, String cep, String cidade, String bairro, String rua,
			String numero, String complemento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.idade = idade;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", idade=" + idade + ", cep="
				+ cep + ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero
				+ ", complemento=" + complemento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
