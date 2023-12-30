package com.development.personal.dao;

import com.development.personal.model.*;

import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
	public void inserir(Filme filme) {
		var entityManager = Conexao.getConexao();
		entityManager.getTransaction().begin();
		entityManager.persist(filme);
		entityManager.getTransaction().commit();
	}
	
	public void excluir(Filme filme) {
		var entityManager = Conexao.getConexao();
		entityManager.getTransaction().begin();
		entityManager.remove(filme);
		entityManager.getTransaction().commit();
	}
	
	public List<Filme> listarDados() {
		var entityManager = Conexao.getConexao();
		var query = entityManager.createQuery("SELECT a FROM Filme a", Filme.class);
		return (List<Filme>) query.getResultList();
	}
	
	public ArrayList<Object[]> ListarRegistro() {
		var entityManager = Conexao.getConexao();
		var query = entityManager.createQuery("SELECT a FROM Filme a", Filme.class);
		var listFilmes = query.getResultList();
		
		var listRegistros = new ArrayList<Object[]>();
		for (var filme : listFilmes) {
			listRegistros.add(new Object[] { filme.getCodigo(), filme.getNome(), filme.getGenero()});
		}
		
		return listRegistros;
	}
	
	public Filme GetByCode(int codigo) {
		var entityManager = Conexao.getConexao();
		var query = entityManager.createQuery("Select a FROM Filme a Where codigo = :id", Filme.class);
		query.setParameter("id", codigo);
		return (Filme) query.getSingleResult();
	}
}