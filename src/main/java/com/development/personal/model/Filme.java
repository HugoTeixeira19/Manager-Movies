package com.development.personal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "filme", uniqueConstraints = @UniqueConstraint(columnNames = { "codigo" }))
public class Filme implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 100)
	private String nome;
	
	@Column(length = 100)
	private String genero;
	
	@Column(length = 125)
	private String capa;
	
	public Filme() {
		
	}
	
	public Filme(String nome, String genero, String capa) {
		this.nome = nome;
		this.genero = genero;
		this.capa = capa;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public String getGenero() {
		return genero;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}
	
	@Override
	public String toString() {
		return "Filme [codigo=" + codigo + ", nome=" + nome + ", genero=" + genero
				+ ", capa=" + capa + "]";
	}
	
}
