/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel_19552011024;

import Entity_19552011024.KategoriEntity_19552011024;
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
public class KategoriTabel_19552011024 extends AbstractTableModel {
    private List<KategoriEntity_19552011024> list = new ArrayList<>();
    
    public void insert(KategoriEntity_19552011024 kategoriEntity) {
        list.add(kategoriEntity);
        fireTableDataChanged();
    }

    public void update(int row, KategoriEntity_19552011024 kategoriEntity) {
        list.set(row, kategoriEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public KategoriEntity_19552011024 get(int row) {
        return list.get(row);
    }

    public void setList(List<KategoriEntity_19552011024> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return  list.get(rowIndex).getkategori_kode();
            case 1:
                return list.get(rowIndex).getkategori_barang();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kategori Kode";
            case 1:
                return "Kategori Barang";
            default:
                return null;
        }
    }
}
