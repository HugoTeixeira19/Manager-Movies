package com.development.personal.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.development.personal.dao.Conexao;
import com.development.personal.dao.FilmeDAO;
import com.development.personal.model.Filme;

public class TesteConnection {
	public static void main(String[] args) {
		/*var filme1 = new Filme("1h", "Vingadores", "Ação", "teste", "Doctor Strange", "/foto.png");
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("managermovies-jpa");
		EntityManager entityManager = entityFactory.createEntityManager();*/
		
		
		
		/*
		entityManager.getTransaction().begin();
		entityManager.persist(filme1);
		entityManager.getTransaction().commit();
		*/
		
		var con = Conexao.getConexaoBd();
	}
}
