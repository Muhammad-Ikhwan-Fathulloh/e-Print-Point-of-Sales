/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel_19552011024;

import Entity_19552011024.UserEntity_19552011024;
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
public class UserTabel_19552011024 extends AbstractTableModel {
    private List<UserEntity_19552011024> list = new ArrayList<>();
    
    public void insert(UserEntity_19552011024 userEntity) {
        list.add(userEntity);
        fireTableDataChanged();
    }

    public void update(int row, UserEntity_19552011024 userEntity) {
        list.set(row, userEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public UserEntity_19552011024 get(int row) {
        return list.get(row);
    }

    public void setList(List<UserEntity_19552011024> list) {
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
                return  list.get(rowIndex).getfullname();
            case 1:
                return list.get(rowIndex).getusername();
            case 2:
                return list.get(rowIndex).getalamat();
            case 3:
                return list.get(rowIndex).getnohp();
            case 4:
                return list.get(rowIndex).getpassword();
            case 5:
                return list.get(rowIndex).getakses();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Fullname";
            case 1:
                return "Username";
            case 2:
                return "Alamat";
            case 3:
                return "No HP";
            case 4:
                return "Password";
            case 5:
                return "Akses";
            default:
                return null;
        }
    }
}
