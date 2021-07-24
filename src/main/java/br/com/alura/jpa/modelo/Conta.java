package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// indica para o JPA mapeie a classe como uma entidade e uma tabela
@Entity
public class Conta {
    // Esta anotação indica qual atributo representa a chave primária 	
	@Id   
	// Esta anotação indica o que queremos usar chaves sequenciais no banco(auto-increment)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titular;
	private Integer agencia;
	private Integer numero;
	private Double saldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}