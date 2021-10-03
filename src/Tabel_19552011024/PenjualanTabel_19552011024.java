/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel_19552011024;

import Entity_19552011024.PenjualanEntity_19552011024;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

//Pembuat
//Nama = Muhammad Ikhwan Fathulloh
//NPM = 19552011024
//Jurusan = Teknik Informatika
//Kampus = Sekolah Tinggi Teknologi Bandung

//Media Sosial
//Youtube = Muhammad Ikhwan Fathulloh
//Blog = muhammadikhwanfathulloh.blogspot.com
//Gmail = muhammadikhwanfathulloh17@gmail.com
/**
 *
 * @author User
 */
public class PenjualanTabel_19552011024 extends AbstractTableModel {
    private List<PenjualanEntity_19552011024> list = new ArrayList<>();
    
    public void insert(PenjualanEntity_19552011024 penjualanEntity) {
        list.add(penjualanEntity);
        fireTableDataChanged();
    }

    public void update(int row, PenjualanEntity_19552011024 penjualanEntity) {
        list.set(row, penjualanEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public PenjualanEntity_19552011024 get(int row) {
        return list.get(row);
    }

    public void setList(List<PenjualanEntity_19552011024> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getkode_order();
            case 1:
                return list.get(rowIndex).getkode_barang();
            case 2:
                return list.get(rowIndex).getnama_barang();
            case 3:
                return list.get(rowIndex).getharga_barang();
            case 4:
                return list.get(rowIndex).getjumlah_barang();
            case 5:
                return list.get(rowIndex).gettotal();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Order";
            case 1:
                return "Kode Barang";
            case 2:
                return "Nama Barang";
            case 3:
                return "Harga Barang";
            case 4:
                return "Jumlah Barang";
            case 5:
                return "Total";
            default:
                return null;
        }
    }
}
