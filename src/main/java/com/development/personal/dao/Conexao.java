package com.development.personal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class Conexao {
	private static String url = "jdbc:mysql://localhost:3306/managermovies";
	private static String login = "root";
	private static String password = "Jkhy92ug@";
	private static Connection con = null;
	
	
	private static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("managermovies-jpa");
	
	public static EntityManager getConexao() {
		return entityFactory.createEntityManager();
	}
	
	public static Connection getConexaoBd() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, login, password);
				JOptionPane.showMessageDialog(null, "Conectou teste");
			} catch(ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Driver n�o encontrado!");
				return null;
			} catch(SQLException x) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar conectar: " + x);
				return null;
			}
		}
		return con;
	}
}
