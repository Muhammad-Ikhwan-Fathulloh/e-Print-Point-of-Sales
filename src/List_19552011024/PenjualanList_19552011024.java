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
import Entity_19552011024.PenjualanEntity_19552011024;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PenjualanList_19552011024 {
    private String className = "PenjualanList";

    public List<PenjualanEntity_19552011024> getListData() {
        List<PenjualanEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from detail_penjualan";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                PenjualanEntity_19552011024 penjualanEntity = new PenjualanEntity_19552011024();
                //penjualanEntity.setno_faktur(resultSet.getString("no_faktur"));
                penjualanEntity.setkode_order(resultSet.getString("kode_order"));
                //penjualanEntity.setnama_toko(resultSet.getString("nama_toko"));
                penjualanEntity.setkode_barang(resultSet.getString("kode_barang"));
                penjualanEntity.setnama_barang(resultSet.getString("nama_barang"));
                penjualanEntity.setharga_barang(resultSet.getInt("harga_barang"));
                penjualanEntity.setjumlah_barang(resultSet.getInt("jumlah_barang"));
                penjualanEntity.settotal(resultSet.getInt("total"));
                //penjualanEntity.settanggal(resultSet.getString("tanggal"));
                //penjualanEntity.setsales(resultSet.getString("sales"));
                //penjualanEntity.setadmin(resultSet.getString("admin"));
                
                list.add(penjualanEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    }   
    
    public List<PenjualanEntity_19552011024> getListDataByParameter(String searchParameter) {
        List<PenjualanEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from detail_penjualan WHERE no_faktur LIKE '%"+searchParameter+"%'";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                PenjualanEntity_19552011024 penjualanEntity = new PenjualanEntity_19552011024();
                //penjualanEntity.setno_faktur(resultSet.getString("no_faktur"));
                penjualanEntity.setkode_order(resultSet.getString("kode_order"));
                //penjualanEntity.setnama_toko(resultSet.getString("nama_toko"));
                penjualanEntity.setkode_barang(resultSet.getString("kode_barang"));
                penjualanEntity.setnama_barang(resultSet.getString("nama_barang"));
                penjualanEntity.setharga_barang(resultSet.getInt("harga_barang"));
                penjualanEntity.setjumlah_barang(resultSet.getInt("jumlah_barang"));
                penjualanEntity.settotal(resultSet.getInt("total"));
                //penjualanEntity.settanggal(resultSet.getString("tanggal"));
                //penjualanEntity.setsales(resultSet.getString("sales"));
                //penjualanEntity.setadmin(resultSet.getString("admin"));
                
                list.add(penjualanEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    }   
    
    public String insertData(PenjualanEntity_19552011024 penjualanEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO detail_penjualan VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlInsert);
            //preparedStatement.setString(1, penjualanEntity.getno_faktur());
            preparedStatement.setString(1, penjualanEntity.getkode_order());
            //preparedStatement.setString(3, penjualanEntity.getnama_toko());
            preparedStatement.setString(2, penjualanEntity.getkode_barang());
            preparedStatement.setString(3, penjualanEntity.getnama_barang());
            preparedStatement.setInt(4, penjualanEntity.getharga_barang());
            preparedStatement.setInt(5, penjualanEntity.getjumlah_barang());
            preparedStatement.setInt(6, penjualanEntity.gettotal());
            //preparedStatement.setString(7, penjualanEntity.gettanggal());
            //preparedStatement.setString(8, penjualanEntity.getsales());
            //preparedStatement.setString(9, penjualanEntity.getadmin());
            
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
    
    public String updateData(PenjualanEntity_19552011024 penjualanEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE penjualan SET kode_barang = ?, nama_barang = ?,jumlah_barang = ?,total = ? WHERE kode_order = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            
            //preparedStatement.setString(2, penjualanEntity.getnama_toko());
            
            preparedStatement.setString(1, penjualanEntity.getkode_barang());
            preparedStatement.setString(2, penjualanEntity.getnama_barang());
            preparedStatement.setInt(3, penjualanEntity.getjumlah_barang());
            preparedStatement.setInt(4, penjualanEntity.gettotal());
            //preparedStatement.setString(6, penjualanEntity.gettanggal());
            //preparedStatement.setString(7, penjualanEntity.getsales());
            //preparedStatement.setString(8, penjualanEntity.getadmin());
            //preparedStatement.setString(9, penjualanEntity.getno_faktur());
            preparedStatement.setString(5, penjualanEntity.getkode_order());
            
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
            String sqlDelete = "DELETE FROM detail_penjualan WHERE kode_order = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlDelete);
            preparedStatement.setString(1, kode_order);
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
    
    public String Kosong(PenjualanEntity_19552011024 penjualanEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM detail_penjualan";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlDelete);
            int isSuccess = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (Exception e) {
            
        }
        return message;
    }
}
