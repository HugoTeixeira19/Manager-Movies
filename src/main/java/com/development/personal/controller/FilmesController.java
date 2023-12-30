package com.development.personal.controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.development.personal.dao.FilmeDAO;
import com.development.personal.model.Filme;

public class FilmesController {
	private File arquivo, destino, padrao;
	private String link, caminho;
	private Filme oFilme;
	private FilmeDAO oDaoFilme;

	public FilmesController() {
		padrao = new File("./imagens/semfoto.png");
	}

	public void escolhaFoto(JTextField txtFoto, ImageIcon icone, JLabel labelFoto, JFileChooser foto) {
		arquivo = foto.getSelectedFile();
		if (arquivo != null) {
			link = arquivo.getName();
			String pathString = "./imagens/";
			Path path = Paths.get(pathString);
			try {
				Files.createDirectories(path);
				destino = new File("./imagens/" + link);
				caminho = destino.toString();
				
				if (destino.exists()) {
					JOptionPane.showMessageDialog(null, "Arquivo com esse nome já existe.");
				}
				
				txtFoto.setText(foto.getSelectedFile().getName());
				System.out.println(foto.getSelectedFile().toString());
				System.out.println(destino.toString());
				try {
					icone = new ImageIcon(arquivo.toString());
					Image imag = icone.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(),
							Image.SCALE_DEFAULT);
					labelFoto.setIcon(new ImageIcon(imag));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Erro na tentativa de criação do diretório.");
			}
		}
	}

	public void copiarArquivo(File fonte, File destino) {
		FileChannel in = null;
		FileChannel out = null;
		try {
			in = new FileInputStream(fonte).getChannel();
			out = new FileOutputStream(destino).getChannel();
			in.transferTo(0, in.size(), out);

			in.close();
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void inserirFilme(String nome, String genero, String capa) {
		oFilme = new Filme(nome, genero, capa);
		oDaoFilme = new FilmeDAO();
		oDaoFilme.inserir(oFilme);
	}

	public void excluirFilme(Long codigo) {
		oFilme = new Filme();
		oFilme.setCodigo(codigo);
		oDaoFilme.excluir(oFilme);
	}

	public void copiaArquivo(File fonte, File destino) {
		FileChannel entrada = null;
		FileChannel saida = null;
		try {
			entrada = new FileInputStream(fonte).getChannel();
			saida = new FileOutputStream(destino).getChannel();
			entrada.transferTo(0, entrada.size(), saida);

			entrada.close();
			saida.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public List<Filme> getLista() {
		oDaoFilme = new FilmeDAO();
		return oDaoFilme.listarDados();
	}
	
	public Filme GetByCode(int codigo) {
		oDaoFilme = new FilmeDAO();
		return oDaoFilme.GetByCode(codigo);
	}
	
	public String[] GetColumnsName() {
		return new String[] { "Código", "Nome", "Gênero" };
	}
	
	public ArrayList<Object[]> ListarRegistro() {
		oDaoFilme = new FilmeDAO();
		return oDaoFilme.ListarRegistro();
	}

	public File getPadrao() {
		return padrao;
	}

	public File getArquivo() {
		return arquivo;
	}

	public File getDestino() {
		return destino;
	}

	public String getCaminho() {
		return caminho;
	}
}
