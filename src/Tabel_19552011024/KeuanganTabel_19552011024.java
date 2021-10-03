/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel_19552011024;

import Entity_19552011024.KeuanganEntity_19552011024;
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
public class KeuanganTabel_19552011024 extends AbstractTableModel {
    private List<KeuanganEntity_19552011024> list = new ArrayList<>();
    
    public void insert(KeuanganEntity_19552011024 keuanganEntity) {
        list.add(keuanganEntity);
        fireTableDataChanged();
    }

    public void update(int row, KeuanganEntity_19552011024 keuanganEntity) {
        list.set(row, keuanganEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public KeuanganEntity_19552011024 get(int row) {
        return list.get(row);
    }

    public void setList(List<KeuanganEntity_19552011024> list) {
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
                return  list.get(rowIndex).getno_faktur();
            case 1:
                return list.get(rowIndex).getnama_toko();
            case 2:
                return list.get(rowIndex).gettotal();
            case 3:
                return list.get(rowIndex).gettanggal();
            case 4:
                return list.get(rowIndex).getsales();
            case 5:
                return list.get(rowIndex).getadmin();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No Faktur";
            case 1:
                return "Nama Toko";
            case 2:
                return "Total";
            case 3:
                return "Tanggal";
            case 4:
                return "Sales";
            case 5:
                return "Admin";
            default:
                return null;
        }
    }
}
