package com.development.personal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;

import com.development.personal.controller.FilmesController;
import com.development.personal.model.Filme;
import com.development.personal.model.ModelTable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ListaFilmes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private FilmesController ocontroleFilmes;
	private List<Filme> lista = new ArrayList<Filme>();
	private ImageIcon imgIcon;
	private ImageIcon imgIconDefault;
	private JLabel lblFoto;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtFoto;
	private JTextField txtPesquisa;
	private JButton btnSalvar;
	private TableRowSorter<TableModel> sorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
					ListaFilmes frame = new ListaFilmes();
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
	public ListaFilmes() {
		setResizable(false);
		setTitle("Listagem de Filmes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 900, 900);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 89, 680, 972);
		panel.setLayout(new BorderLayout());
		contentPane.add(panel);
		
		PanelCadastro panelRegistro = new PanelCadastro();
		panelRegistro.setBounds(690, 11, 1226, 1038);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		ocontroleFilmes = panelRegistro.GetController();

		lista = ocontroleFilmes.getLista();
		txtCodigo = panelRegistro.getTxtCodigo();
		txtNome = panelRegistro.getTxtNome();
		txtGenero = panelRegistro.getTxtGenero();
		lblFoto = panelRegistro.getLabelFoto();
		txtFoto = panelRegistro.txtFoto;
		btnSalvar = panelRegistro.getButtonSalvar();
		
		txtPesquisa = new JTextField();
		txtPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtPesquisa.setBounds(53, 21, 356, 40);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnFiltrar = new JButton("Pesquisar");
		btnFiltrar.setForeground(Color.RED);
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnFiltrar.setBounds(419, 21, 150, 40);
		contentPane.add(btnFiltrar);
		imgIconDefault = panelRegistro.getImageIconDefault();
		
		
		var listFilmes = ocontroleFilmes.ListarRegistro();
		String[] columns = ocontroleFilmes.GetColumnsName();
			
		ModelTable model = new ModelTable(listFilmes, columns);
			
		table = new JTable(model);
		
		sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		table.setDefaultEditor(Object.class, null);
		
		table.setFillsViewportHeight(true);
		table.setBounds(0, 124, 643, 344);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		var scrollBar = new JScrollPane(table);
		scrollBar.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollBar.setBounds(0, 124, 643, 344);
		panel.add(scrollBar);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				var row = table.getSelectedRow();
				if (row > -1) {
					String value = table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(row), 0).toString();
					
					var filme = ocontroleFilmes.GetByCode(Integer.parseInt(value));
					
					txtCodigo.setText(String.valueOf(filme.getCodigo()));
					txtGenero.setText(filme.getGenero());
					txtNome.setText(filme.getNome());
					
					File file = new File(filme.getCapa());
					panelRegistro.txtFoto.setText(file.getName());
					
					atualizarFoto(filme);
				}
			}
		});
		
		btnFiltrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sorter.setRowFilter(RowFilter.regexFilter(txtPesquisa.getText()));
				table.setRowSorter(sorter);
			}
			
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ocontroleFilmes.inserirFilme(txtNome.getText(), txtGenero.getText(), ocontroleFilmes.getCaminho());
					panelRegistro.limparCampos();
					if (!ocontroleFilmes.getArquivo().exists()) {
						ocontroleFilmes.copiaArquivo(ocontroleFilmes.getArquivo(), ocontroleFilmes.getDestino());
					}
					
					AtualizarLista();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Campo c�digo deve ser n�mero");
				}
			}
		});
	}
	
	private void atualizarFoto(Filme filme) {
		try {
			imgIcon = new ImageIcon(filme.getCapa());
			Image imag = imgIcon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
			lblFoto.setIcon(new ImageIcon(imag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void AtualizarLista() {
		var listFilmes = ocontroleFilmes.ListarRegistro();
		
		if (listFilmes.size() > 0) {
			String[] columns = ocontroleFilmes.GetColumnsName();
			ModelTable modelAux = new ModelTable(listFilmes, columns);
			
			table.setModel(modelAux);
			sorter.setModel(modelAux);
			table.setRowSorter(sorter);
		} else {
			String[] columns = ocontroleFilmes.GetColumnsName();
			ModelTable modelAux = new ModelTable(columns);
			table = new JTable(modelAux);
		}
	}
}
