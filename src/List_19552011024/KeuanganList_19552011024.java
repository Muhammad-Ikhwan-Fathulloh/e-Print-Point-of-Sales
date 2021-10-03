/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List_19552011024;

import Database_19552011024.Database_19552011024;
import Entity_19552011024.KeuanganEntity_19552011024;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class KeuanganList_19552011024 {
    private String className = "KeuanganList";

    public List<KeuanganEntity_19552011024> getListData() {
        List<KeuanganEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from keuangan";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                KeuanganEntity_19552011024 keuanganEntity = new KeuanganEntity_19552011024();
                keuanganEntity.setno_faktur(resultSet.getString("no_faktur"));
                //keuanganEntity.setkode_order(resultSet.getString("kode_order"));
                keuanganEntity.setnama_toko(resultSet.getString("nama_toko"));
                //keuanganEntity.setkode_barang(resultSet.getString("kode_barang"));
                //keuanganEntity.setjumlah_barang(resultSet.getInt("jumlah_barang"));
                keuanganEntity.settotal(resultSet.getInt("total"));
                keuanganEntity.settanggal(resultSet.getString("tanggal"));
                keuanganEntity.setsales(resultSet.getString("sales"));
                keuanganEntity.setadmin(resultSet.getString("admin"));
                
                list.add(keuanganEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    } 
    
    public List<KeuanganEntity_19552011024> getListDataByParameter(String searchParameter) {
        List<KeuanganEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from keuangan WHERE no_faktur LIKE '%"+searchParameter+"%'";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                KeuanganEntity_19552011024 keuanganEntity = new KeuanganEntity_19552011024();
                keuanganEntity.setno_faktur(resultSet.getString("no_faktur"));
                //keuanganEntity.setkode_order(resultSet.getString("kode_order"));
                keuanganEntity.setnama_toko(resultSet.getString("nama_toko"));
                //keuanganEntity.setkode_barang(resultSet.getString("kode_barang"));
                //keuanganEntity.setjumlah_barang(resultSet.getInt("jumlah_barang"));
                keuanganEntity.settotal(resultSet.getInt("total"));
                keuanganEntity.settanggal(resultSet.getString("tanggal"));
                keuanganEntity.setsales(resultSet.getString("sales"));
                keuanganEntity.setadmin(resultSet.getString("admin"));
                
                list.add(keuanganEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    }   
    
    public String insertData(KeuanganEntity_19552011024 keuanganEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO keuangan VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlInsert);
            preparedStatement.setString(1, keuanganEntity.getno_faktur());
            //preparedStatement.setString(2, keuanganEntity.getkode_order());
            preparedStatement.setString(2, keuanganEntity.getnama_toko());
            //preparedStatement.setString(4, keuanganEntity.getkode_barang());
            //preparedStatement.setInt(5, keuanganEntity.getjumlah_barang());
            preparedStatement.setInt(3, keuanganEntity.gettotal());
            preparedStatement.setString(4, keuanganEntity.gettanggal());
            preparedStatement.setString(5, keuanganEntity.getsales());
            preparedStatement.setString(6, keuanganEntity.getadmin());
            
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
    
    public String updateData(KeuanganEntity_19552011024 keuanganEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE keuangan SET kode_order = ?, nama_toko = ?,kode_barang = ?,jumlah_barang = ?,total = ?,tanggal = ?,sales = ?,admin = ? WHERE no_faktur = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            //preparedStatement.setString(1, keuanganEntity.getkode_order());
            preparedStatement.setString(2, keuanganEntity.getnama_toko());
            //preparedStatement.setString(3, keuanganEntity.getkode_barang());
            //preparedStatement.setInt(4, keuanganEntity.getjumlah_barang());
            preparedStatement.setInt(5, keuanganEntity.gettotal());
            preparedStatement.setString(6, keuanganEntity.gettanggal());
            preparedStatement.setString(7, keuanganEntity.getsales());
            preparedStatement.setString(8, keuanganEntity.getadmin());
            preparedStatement.setString(9, keuanganEntity.getno_faktur());
            
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
    
    public String deleteData(String no_faktur) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM keuangan WHERE no_faktur = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlDelete);
            preparedStatement.setString(1, no_faktur);
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
