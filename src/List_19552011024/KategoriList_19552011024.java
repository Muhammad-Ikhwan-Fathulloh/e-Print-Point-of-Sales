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
import Entity_19552011024.KategoriEntity_19552011024;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KategoriList_19552011024 {
    private String className = "KategoriList";

    public List<KategoriEntity_19552011024> getListData() {
        List<KategoriEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from kategori";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                KategoriEntity_19552011024 kategoriEntity = new KategoriEntity_19552011024();
                kategoriEntity.setkategori_kode(resultSet.getString("kategori_kode"));
                kategoriEntity.setkategori_barang(resultSet.getString("kategori_barang"));
                
                list.add(kategoriEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    }   
    
    public List<KategoriEntity_19552011024> getListDataByParameter(String searchParameter) {
        List<KategoriEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from kategori WHERE kategori_barang LIKE '%"+searchParameter+"%'";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                KategoriEntity_19552011024 kategoriEntity = new KategoriEntity_19552011024();
                kategoriEntity.setkategori_kode(resultSet.getString("kategori_kode"));
                kategoriEntity.setkategori_barang(resultSet.getString("kategori_barang"));
                
                list.add(kategoriEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    }   
    
    public String insertData(KategoriEntity_19552011024 kategoriEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO kategori VALUES (?, ?)";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlInsert);
            preparedStatement.setString(1, kategoriEntity.getkategori_kode());
            preparedStatement.setString(2, kategoriEntity.getkategori_barang());
            
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
    
    public String updateData(KategoriEntity_19552011024 kategoriEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE kategori SET kategori_barang = ? WHERE kategori_kode = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
           
            preparedStatement.setString(1, kategoriEntity.getkategori_barang());
            preparedStatement.setString(2, kategoriEntity.getkategori_kode());
            
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
    
    public String deleteData(String kategori_kode) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM kategori WHERE kategori_kode = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlDelete);
            preparedStatement.setString(1, kategori_kode);
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
