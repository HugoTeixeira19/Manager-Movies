package com.development.personal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JScrollPane;
import java.awt.Color;

//import control.conexao2;
import com.development.personal.controller.FilmesController;


public class telaCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtAtorprincipal;
	private JTextField txtFoto;
	private JTextArea txtSinopse;
	private JFileChooser foto;
	private JLabel labelFoto;
	private ImageIcon icone = null, iconePadrao;
	private JTextField txtDuracao;
	private FilmesController ocontroleFilmes;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					telaCadastro frame = new telaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telaCadastro() {
		super("Cadastro de Filmes");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 372);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ocontroleFilmes = new FilmesController();
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCodigo.setBounds(39, 24, 45, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNome.setBounds(39, 49, 45, 14);
		contentPane.add(lblNome);
		
		JLabel lblGenero = new JLabel("G\u00EAnero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGenero.setBounds(39, 74, 45, 14);
		contentPane.add(lblGenero);
		
		JLabel lblAtorPrincipal = new JLabel("Ator Principal");
		lblAtorPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAtorPrincipal.setBounds(23, 99, 61, 14);
		contentPane.add(lblAtorPrincipal);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSinopse.setBounds(32, 124, 43, 14);
		contentPane.add(lblSinopse);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFoto.setBounds(51, 257, 33, 14);
		contentPane.add(lblFoto);
		
		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o");
		lblDuracao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDuracao.setBounds(29, 223, 55, 14);
		contentPane.add(lblDuracao);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(86, 21, 121, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(86, 46, 121, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(86, 71, 121, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtAtorprincipal = new JTextField();
		txtAtorprincipal.setBounds(86, 96, 121, 20);
		contentPane.add(txtAtorprincipal);
		txtAtorprincipal.setColumns(10);
		
		txtFoto = new JTextField();
		txtFoto.setEditable(false);
		txtFoto.setBounds(86, 254, 160, 20);
		contentPane.add(txtFoto);
		txtFoto.setColumns(10);
		
		JButton btnSeleArquivo = new JButton("Selecionar arquivo");
		btnSeleArquivo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSeleArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // janela de escolha de capa				
				foto = new JFileChooser(".png");
				foto.setDialogTitle("Carregando capa do filme");
				foto.setFileFilter(new FileNameExtensionFilter("Apenas PNG", "png"));
				foto.setAcceptAllFileFilterUsed(false);
				foto.showOpenDialog(null);
				ocontroleFilmes.escolhaFoto(txtFoto, icone, labelFoto, foto);
			}
		}); // fim da escolha
		
		txtDuracao = new JTextField();
		txtDuracao.setBounds(86, 220, 86, 20);
		contentPane.add(txtDuracao);
		txtDuracao.setColumns(10);
		btnSeleArquivo.setBounds(256, 253, 121, 23);
		contentPane.add(btnSeleArquivo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 124, 216, 81);
		contentPane.add(scrollPane);
		
		txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//ocontroleFilmes.inserirFilme(txtNome.getText(), txtGenero.getText(), txtAtorprincipal.getText(), txtDuracao.getText(), txtSinopse.getText(), ocontroleFilmes.getCaminho());
					limparCampos();
					ocontroleFilmes.copiaArquivo(ocontroleFilmes.getArquivo(), ocontroleFilmes.getDestino());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Campo c�digo deve ser n�mero");
				}
			}
		});
		btnSalvar.setBounds(145, 299, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(323, 299, 89, 23);
		contentPane.add(btnCancelar);
		
		JPanel panelFoto = new JPanel();
		panelFoto.setBackground(Color.GRAY);
		panelFoto.setBounds(353, 11, 176, 160);
		contentPane.add(panelFoto);
		panelFoto.setLayout(null);
		
		labelFoto = new JLabel("");
		labelFoto.setBackground(Color.WHITE);
		labelFoto.setBounds(10, 0, 156, 160);
		panelFoto.add(labelFoto);
		iconePadrao = new ImageIcon(ocontroleFilmes.getPadrao().toString());
		Image imag = iconePadrao.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT);
		labelFoto.setIcon(new ImageIcon(imag));
	}
	
	private void limparCampos() {
		Integer.parseInt(txtCodigo.getText() + 1);
		txtNome.setText("");
		txtFoto.setText("");
		txtGenero.setText("");
		txtDuracao.setText("");
		txtSinopse.setText("");
		txtAtorprincipal.setText("");
		Image imag = iconePadrao.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT);
		labelFoto.setIcon(new ImageIcon(imag));
	}
}
