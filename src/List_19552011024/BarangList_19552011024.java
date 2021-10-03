/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List_19552011024;
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

import Database_19552011024.Database_19552011024;
import Entity_19552011024.BarangEntity_19552011024;
import Entity_19552011024.StokEntity_19552011024;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BarangList_19552011024 {
    private String className = "BarangList";

    public List<BarangEntity_19552011024> getListData() {
        List<BarangEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from barang";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                BarangEntity_19552011024 barangEntity = new BarangEntity_19552011024();
                barangEntity.setkode_barang(resultSet.getString("kode_barang"));
                barangEntity.setnama_barang(resultSet.getString("nama_barang"));
                barangEntity.setkategori_barang(resultSet.getString("kategori_barang"));
                barangEntity.setharga_barang(resultSet.getInt("harga_barang"));
                barangEntity.setstok_barang(resultSet.getInt("stok_barang"));
                barangEntity.settanggal(resultSet.getString("tanggal"));
                
                
                list.add(barangEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    }   
    
    public List<BarangEntity_19552011024> getListDataByParameter(String searchParameter) {
        List<BarangEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from barang WHERE kategori_barang LIKE '%"+searchParameter+"%'";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                BarangEntity_19552011024 barangEntity = new BarangEntity_19552011024();
                barangEntity.setkode_barang(resultSet.getString("kode_barang"));
                barangEntity.setnama_barang(resultSet.getString("nama_barang"));
                barangEntity.setkategori_barang(resultSet.getString("kategori_barang"));
                barangEntity.setharga_barang(resultSet.getInt("harga_barang"));
                barangEntity.setstok_barang(resultSet.getInt("stok_barang"));
                barangEntity.settanggal(resultSet.getString("tanggal"));
                
                
                list.add(barangEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    }   
    
    public String insertData(BarangEntity_19552011024 barangEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO barang VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlInsert);
            preparedStatement.setString(1, barangEntity.getkode_barang());
            preparedStatement.setString(2, barangEntity.getnama_barang());
            preparedStatement.setString(3, barangEntity.getkategori_barang());
            preparedStatement.setInt(4, barangEntity.getharga_barang());
            preparedStatement.setInt(5, barangEntity.getstok_barang());
            preparedStatement.setString(6, barangEntity.gettanggal());
            
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data Berhasil ditambah";
            } else {
                message = "Data gagal ditambah";
            }
            preparedStatement.close();
        } catch (Exception e) {
            
        }
        return message;
    }
    
    public String updateData(BarangEntity_19552011024 barangEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE barang SET nama_barang = ?, kategori_barang = ?,harga_barang = ?,stok_barang = ?,tanggal = ? WHERE kode_barang = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, barangEntity.getnama_barang());
            preparedStatement.setString(2, barangEntity.getkategori_barang());
            preparedStatement.setInt(3, barangEntity.getharga_barang());
            preparedStatement.setInt(4, barangEntity.getstok_barang());
            preparedStatement.setString(5, barangEntity.gettanggal());
            preparedStatement.setString(6, barangEntity.getkode_barang());
            
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data Berhasil diubah";
            } else {
                message = "Data gagal diubah";
            }
            preparedStatement.close();
        } catch (Exception e) {
            
        }
        return message;
    }
    
    public String updateStok(StokEntity_19552011024 stokEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE barang SET stok_barang = ? WHERE kode_barang = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setInt(1, stokEntity.getstok_barang());
            preparedStatement.setString(2, stokEntity.getkode_barang());
            
            int isSuccess = preparedStatement.executeUpdate();

//            if (isSuccess == 1) {
//                message = "Data Berhasil diubah";
//            } else {
//                message = "Data gagal diubah";
//            }
            preparedStatement.close();
        } catch (Exception e) {
            
        }
        return message;
    }
    
    public String deleteData(String kode_barang) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM barang WHERE kode_barang = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlDelete);
            preparedStatement.setString(1, kode_barang);
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data berhasil dihapus";
            } else {
                message = "Data gagal dihapus";
            }
            preparedStatement.close();
        } catch (Exception e) {
            
        }
        return message;
    }

}
