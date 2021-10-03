/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List_19552011024;

import Database_19552011024.Database_19552011024;
import Entity_19552011024.TokoEntity_19552011024;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

public class TokoList_19552011024 {
    private String className = "TokoList";
    
    public List<TokoEntity_19552011024> getListData() {
        List<TokoEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from toko";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                TokoEntity_19552011024 tokoEntity = new TokoEntity_19552011024();
                tokoEntity.setkode_order(resultSet.getString("kode_order"));
                tokoEntity.setnama_toko(resultSet.getString("nama_toko"));
                tokoEntity.setalamat(resultSet.getString("alamat"));
                tokoEntity.setkode_barang(resultSet.getString("kode_barang"));
                tokoEntity.setnama_barang(resultSet.getString("nama_barang"));
                tokoEntity.setharga_barang(resultSet.getInt("harga_barang"));
                tokoEntity.setjumlah_barang(resultSet.getInt("jumlah_barang"));
                tokoEntity.settanggal(resultSet.getString("tanggal"));
                tokoEntity.setsales(resultSet.getString("sales"));
                
                list.add(tokoEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    } 
    
    public List<TokoEntity_19552011024> getListDataByParameter(String searchParameter) {
        List<TokoEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from toko WHERE nama_toko LIKE'%"+searchParameter+"%'";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                TokoEntity_19552011024 tokoEntity = new TokoEntity_19552011024();
                tokoEntity.setkode_order(resultSet.getString("kode_order"));
                tokoEntity.setnama_toko(resultSet.getString("nama_toko"));
                tokoEntity.setalamat(resultSet.getString("alamat"));
                tokoEntity.setkode_barang(resultSet.getString("kode_barang"));
                tokoEntity.setnama_barang(resultSet.getString("nama_barang"));
                tokoEntity.setharga_barang(resultSet.getInt("harga_barang"));
                tokoEntity.setjumlah_barang(resultSet.getInt("jumlah_barang"));
                tokoEntity.settanggal(resultSet.getString("tanggal"));
                tokoEntity.setsales(resultSet.getString("sales"));
                
                list.add(tokoEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    } 
    
    public String insertData(TokoEntity_19552011024 tokoEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO toko VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlInsert);
            preparedStatement.setString(1, tokoEntity.getkode_order());
            preparedStatement.setString(2, tokoEntity.getnama_toko());
            preparedStatement.setString(3, tokoEntity.getalamat());
            preparedStatement.setString(4, tokoEntity.getkode_barang());
            preparedStatement.setString(5, tokoEntity.getnama_barang());
            preparedStatement.setInt(6, tokoEntity.getharga_barang());
            preparedStatement.setInt(7, tokoEntity.getjumlah_barang());
            preparedStatement.setString(8, tokoEntity.gettanggal());
            preparedStatement.setString(9, tokoEntity.getsales());
            
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
    
    public String updateData(TokoEntity_19552011024 tokoEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE toko SET nama_toko = ?,alamat = ?,kode_barang = ?,nama_barang = ?,harga_barang = ?,jumlah_barang = ?,tanggal = ?,sales = ? WHERE kode_order = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, tokoEntity.getnama_toko());
            preparedStatement.setString(2, tokoEntity.getalamat());
            preparedStatement.setString(3, tokoEntity.getkode_barang());
            preparedStatement.setString(4, tokoEntity.getnama_barang());
            preparedStatement.setInt(5, tokoEntity.getharga_barang());
            preparedStatement.setInt(6, tokoEntity.getjumlah_barang());
            preparedStatement.setString(7, tokoEntity.gettanggal());
            preparedStatement.setString(8, tokoEntity.getsales());
            preparedStatement.setString(9, tokoEntity.getkode_order());
            
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
    
    public String deleteData(String kode_order) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM toko WHERE kode_order = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlDelete);
            preparedStatement.setString(1, kode_order);
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data Berhasil dihapus";
            } else {
                message = "Data gagal dihapus";
            }
            preparedStatement.close();
        } catch (Exception e) {
            
        }
        return message;
    }
}
