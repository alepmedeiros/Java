package model;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="O nome deve ser informado")
	@Length(max=40, message="O nome não pode ser maior que {max}")
	private String nome;
	
	@NotEmpty(message="A senha deve ser informada")
	@Length(min=6, max=10, message="A senha deve ter entre {min} e {max} caracteres")
	private String senha;
	
	@NotEmpty(message="O CPF deve ser informado")
	@CPF(message="Informe um cpf valido")
	private String cpf;
	
	@NotNull(message="A renda deve ser informada")
	@Digits(fraction=2,integer=10)
	private Double renda;
	
	@NotEmpty(message = "O email deve ser informado")
	@Email(message = "O email não é valido")
	private String email;
	
	@NotEmpty(message = "Sua pagina deve ser informada")
	@URL(protocol = "http",message = "Informe um endereco valido")
	private String pagina;
	
	public Usuario() {
		this.nome = "";
		this.senha = "";
		this.cpf = "";
		this.renda = null;
		this.email = "";
		this.pagina = "";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getRenda() {
		return renda;
	}
	public void setRenda(Double renda) {
		this.renda = renda;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	
	
	
}
