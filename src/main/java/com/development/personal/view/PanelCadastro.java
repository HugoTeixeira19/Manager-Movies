package com.development.personal.view;

import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.development.personal.controller.FilmesController;
import com.development.personal.model.Filme;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class PanelCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JLabel lblFoto;
	private JLabel lblFotoField;
	private JFileChooser foto;
	public JTextField txtFoto;
	private FilmesController ocontroleFilmes;
	private ImageIcon iconDefault, icone;
	private JButton btnSalvar;
	private JButton btnNovo;
	private List<Filme> lista = new ArrayList<Filme>();

	/**
	 * Create the panel.
	 */
	public PanelCadastro() {
		setLayout(null);
		
		ocontroleFilmes = new FilmesController();
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCodigo.setBounds(350, 589, 73, 31);
		add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(433, 589, 68, 31);
		add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(355, 644, 68, 31);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNome.setBounds(433, 641, 240, 39);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblGenero = new JLabel("Gênero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setBounds(343, 700, 80, 31);
		add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtGenero.setColumns(10);
		txtGenero.setBounds(433, 696, 240, 39);
		add(txtGenero);
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(292, 11, 564, 504);
		
		iconDefault = new ImageIcon("./imagens/semfoto.png");
		Image image = iconDefault.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
				Image.SCALE_DEFAULT);
		
		lblFotoField = new JLabel("Foto");
		lblFotoField.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFotoField.setBounds(343, 755, 80, 35);
		add(lblFotoField);
		lblFoto.setIcon(new ImageIcon(image));
		add(lblFoto);
		
		txtFoto = new JTextField();
		txtFoto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtFoto.setColumns(10);
		txtFoto.setBounds(433, 753, 323, 39);
		txtFoto.setEditable(false);
		add(txtFoto);
		
		JButton btnFoto = new JButton("Selecionar Arquivo");
		btnFoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFoto.setBounds(766, 755, 182, 35);
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // janela de escolha de capa				
				foto = new JFileChooser(".png");
				foto.setDialogTitle("Carregando capa do filme");
				foto.setFileFilter(new FileNameExtensionFilter("Apenas PNG", "png"));
				foto.setAcceptAllFileFilterUsed(false);
				foto.showOpenDialog(null);
				ocontroleFilmes.escolhaFoto(txtFoto, icone, lblFoto, foto);
			}
		}); // fim da escolha
		add(btnFoto);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(Color.BLUE);
		btnSalvar.setForeground(Color.RED);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalvar.setBounds(368, 906, 267, 48);
		add(btnSalvar);
		
		btnNovo = new JButton("Novo");
		btnNovo.setForeground(Color.RED);
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNovo.setBackground(Color.BLUE);
		btnNovo.setBounds(656, 906, 267, 48);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		add(btnNovo);

	}
	
	public JTextField getTxtCodigo() {
		return txtCodigo;
	}
	
	public JTextField getTxtNome() {
		return txtNome;
	}
	
	public JTextField getTxtGenero() {
		return txtGenero;
	}
	
	public JLabel getLabelFoto() {
		return lblFoto;
	}
	
	public FilmesController GetController() {
		return ocontroleFilmes;
	}
	
	public ImageIcon getImageIconDefault() {
		return iconDefault;
	}
	
	public void limparCampos() {
		txtCodigo.setText("");
		txtNome.setText("");
		txtFoto.setText("");
		txtGenero.setText("");
		Image imag = iconDefault.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
		lblFoto.setIcon(new ImageIcon(imag));
	}
	
	public JButton getButtonSalvar() {
		return btnSalvar;
	}
}
