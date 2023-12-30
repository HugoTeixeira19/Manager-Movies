package com.development.personal.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.development.personal.controller.FilmesController;
import com.development.personal.model.Filme;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Color;

public class telaConsulta extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FilmesController ocontrolFilmes;
	private static Filme filme;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtDuracao;
	private JTextArea txtSinopse;
	private JTextField txtAtorPrincipal;
	private ImageIcon teste;
	private JLabel labelFoto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            // select Look and Feel
		            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		            telaConsulta frame = new telaConsulta(4);
					frame.setVisible(true);
		            // start application
			    } catch (ClassNotFoundException ex) {
			    	ex.printStackTrace();
			    } catch (InstantiationException ex) {
			    	ex.printStackTrace();
			    } catch (IllegalAccessException ex) {
			    	ex.printStackTrace();
			    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
			    	ex.printStackTrace();
			    }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telaConsulta(int codigo) {
		super("Consulta de Filmes");
		ocontrolFilmes = new FilmesController();
		//filme = ocontrolFilmes.GetById(codigo);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(57, 43, 57, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(57, 71, 52, 14);
		contentPane.add(lblNome);
		
		JLabel lblGenero = new JLabel("G\u00EAnero");
		lblGenero.setBounds(57, 96, 53, 14);
		contentPane.add(lblGenero);
		
		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o");
		lblDuracao.setBounds(56, 122, 55, 14);
		contentPane.add(lblDuracao);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(57, 175, 55, 14);
		contentPane.add(lblSinopse);
		
		JLabel lblAtorPrincipal = new JLabel("Ator principal");
		lblAtorPrincipal.setBounds(32, 150, 81, 14);
		contentPane.add(lblAtorPrincipal);
		
		//txtCodigo = new JTextField(filme.getCodigo());
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(114, 40, 126, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField(filme.getNome());
		txtNome.setBounds(114, 68, 126, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtGenero = new JTextField(filme.getGenero());
		txtGenero.setBounds(114, 93, 126, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		//txtDuracao = new JTextField(filme.getDuracao());
		txtDuracao.setBounds(113, 119, 126, 20);
		contentPane.add(txtDuracao);
		txtDuracao.setColumns(10);
		
		//txtAtorPrincipal = new JTextField(filme.getAtorprincipal());
		txtAtorPrincipal.setBounds(113, 147, 126, 20);
		contentPane.add(txtAtorPrincipal);
		txtAtorPrincipal.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 175, 281, 88);
		contentPane.add(scrollPane);
		
		//txtSinopse = new JTextArea(filme.getSinopse());
		scrollPane.setViewportView(txtSinopse);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(326, 7, 176, 160);
		contentPane.add(panel);
		panel.setLayout(null);
		
		labelFoto = new JLabel("");
		labelFoto.setBounds(10, 0, 156, 160);
		panel.add(labelFoto);
		
		PreencherCampos(filme);
	}
	
	private void PreencherCampos(Filme filme) {
		//txtCodigo.setText(Integer.toString(filme.getCodigo()));
		txtNome.setText(filme.getNome());
		txtGenero.setText(filme.getGenero());
		//txtDuracao.setText(filme.getDuracao());
		//txtSinopse.setText(filme.getSinopse());
		//txtAtorPrincipal.setText(filme.getAtorprincipal());
		atualizarFoto(filme);
	}
	
	private void atualizarFoto(Filme filme) {
		try {
			//teste = new ImageIcon(filme.getFoto());
			Image imag = teste.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT);
			labelFoto.setIcon(new ImageIcon(imag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
