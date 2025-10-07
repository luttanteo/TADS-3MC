package br.senac.sp.sus.tablemodel;

import br.senac.sp.sus.model.BancoSangue;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BancoSangueTableModel extends AbstractTableModel {
    private List<BancoSangue> lista;
    private String[] cabecalho = {"ID", "Nome", "Telefone"};

    public BancoSangueTableModel(List<BancoSangue> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BancoSangue b = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return b.getId();
            case 1:
                return b.getNome();
            default:
                return b.getTelefone();
        }
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }

    public void setLista(List<BancoSangue> lista) {
        this.lista = lista;
    }

    public List<BancoSangue> getLista() {
        return lista;
    }
}