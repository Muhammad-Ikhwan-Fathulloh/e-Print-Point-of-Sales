/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List_19552011024;

import Database_19552011024.Database_19552011024;
import Entity_19552011024.DatatokoEntity_19552011024;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DatatokoList_19552011024 {
    private String className = "DataTokoList";
    
    public List<DatatokoEntity_19552011024> getListData() {
        List<DatatokoEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from datatoko";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                DatatokoEntity_19552011024 tokoEntity = new DatatokoEntity_19552011024();
                tokoEntity.setKode_Toko(resultSet.getString("kode_toko"));
                tokoEntity.setNama_Toko(resultSet.getString("nama_toko"));
                tokoEntity.setAlamat(resultSet.getString("alamat"));
                tokoEntity.setNohp(resultSet.getString("nohp"));
                
                list.add(tokoEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    } 
    
    public List<DatatokoEntity_19552011024> getListDataByParameter(String searchParameter) {
        List<DatatokoEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from datatoko WHERE nama_toko LIKE '%"+searchParameter+"%'";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                DatatokoEntity_19552011024 tokoEntity = new DatatokoEntity_19552011024();
                tokoEntity.setKode_Toko(resultSet.getString("kode_toko"));
                tokoEntity.setNama_Toko(resultSet.getString("nama_toko"));
                tokoEntity.setAlamat(resultSet.getString("alamat"));
                tokoEntity.setNohp(resultSet.getString("nohp"));
                
                list.add(tokoEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    } 
    
    public String insertData(DatatokoEntity_19552011024 tokoEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO datatoko VALUES (?, ?, ?, ?)";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlInsert);
            preparedStatement.setString(1, tokoEntity.getKode_Toko());
            preparedStatement.setString(2, tokoEntity.getNama_Toko());
            preparedStatement.setString(3, tokoEntity.getAlamat());
            preparedStatement.setString(4, tokoEntity.getNohp());
            
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
    
    public String updateData(DatatokoEntity_19552011024 tokoEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE datatoko SET nama_toko = ?,alamat = ?,nohp = ? WHERE kode_toko = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, tokoEntity.getNama_Toko());
            preparedStatement.setString(2, tokoEntity.getAlamat());
            preparedStatement.setString(3, tokoEntity.getNohp());
            preparedStatement.setString(4, tokoEntity.getKode_Toko());
            
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
    
    public String deleteData(String kode_toko) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM datatoko WHERE kode_toko = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlDelete);
            preparedStatement.setString(1, kode_toko);
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
