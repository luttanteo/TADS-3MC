package br.senac.sp.sus.model;

import jakarta.persistence.*;

@Entity // marcando essa classe como entidade (pro FactoryEM gerenciar)
@Table(name = "banco_sangue") // marca o nome da tabela
public class BancoSangue {

	@Id // marcando a primeira linha como id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremeto no BD
	private int id;

	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String nome;

	@Column(columnDefinition = "TEXT")
	private String endereco;

	@Column(unique = true, columnDefinition = "VARCHAR(20)")
	private String cnpj;

	private String telefone;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
