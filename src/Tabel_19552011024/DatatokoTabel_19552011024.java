/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel_19552011024;

import Entity_19552011024.DatatokoEntity_19552011024;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class DatatokoTabel_19552011024 extends AbstractTableModel {
    private List<DatatokoEntity_19552011024> list = new ArrayList<>();
    
    public void insert(DatatokoEntity_19552011024 tokoEntity) {
        list.add(tokoEntity);
        fireTableDataChanged();
    }

    public void update(int row, DatatokoEntity_19552011024 tokoEntity) {
        list.set(row, tokoEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public DatatokoEntity_19552011024 get(int row) {
        return list.get(row);
    }

    public void setList(List<DatatokoEntity_19552011024> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return  list.get(rowIndex).getKode_Toko();
            case 1:
                return list.get(rowIndex).getNama_Toko();
            case 2:
                return list.get(rowIndex).getAlamat();
            case 3:
                return list.get(rowIndex).getNohp();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Toko";
            case 1:
                return "Nama Toko";
            case 2:
                return "Alamat";
            case 3:
                return "No HP Toko";
            default:
                return null;
        }
    }
}
