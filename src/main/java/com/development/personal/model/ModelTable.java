package com.development.personal.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModelTable extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Object[]> linhas;
	private String[] colunas;
	
	public ModelTable(ArrayList<Object[]> linhas, String[] colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
	}
	
	public ModelTable(String[] colunas) {
		this.colunas = colunas;
		this.linhas = new ArrayList<Object[]>();
		
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object[] dadosLinhas = (Object[])linhas.get(rowIndex);
        return dadosLinhas[columnIndex];
	}

}
