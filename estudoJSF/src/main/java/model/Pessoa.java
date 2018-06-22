package model;

import java.io.Serializable;

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 8867975063218842092L;
	
	private Integer id;
	private String nome;
	private String telefone;
	private Boolean editando;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer id, String nome, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}
}
