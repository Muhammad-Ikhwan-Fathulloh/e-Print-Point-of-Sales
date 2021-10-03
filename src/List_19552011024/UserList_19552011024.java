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
import Entity_19552011024.UserEntity_19552011024;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserList_19552011024 {
    private String className = "UserList";
    
    public List<UserEntity_19552011024> getListData() {
        List<UserEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from user";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                UserEntity_19552011024 userEntity = new UserEntity_19552011024();
                userEntity.setfullname(resultSet.getString("fullname"));
                userEntity.setusername(resultSet.getString("username"));
                userEntity.setalamat(resultSet.getString("alamat"));
                userEntity.setnohp(resultSet.getString("nohp"));
                userEntity.setpassword(resultSet.getString("password"));
                userEntity.setakses(resultSet.getString("akses"));
                
                
                list.add(userEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    }  
    
    public List<UserEntity_19552011024> getListDataByParameter(String searchParameter) {
        List<UserEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from user WHERE username LIKE '%"+searchParameter+"%'";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                UserEntity_19552011024 userEntity = new UserEntity_19552011024();
                userEntity.setfullname(resultSet.getString("fullname"));
                userEntity.setusername(resultSet.getString("username"));
                userEntity.setalamat(resultSet.getString("alamat"));
                userEntity.setnohp(resultSet.getString("nohp"));
                userEntity.setpassword(resultSet.getString("password"));
                userEntity.setakses(resultSet.getString("akses"));
                
                
                list.add(userEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;  
    }
    
    public String insertData(UserEntity_19552011024 userEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlInsert);
            preparedStatement.setString(1, userEntity.getfullname());
            preparedStatement.setString(2, userEntity.getusername());
            preparedStatement.setString(3, userEntity.getalamat());
            preparedStatement.setString(4, userEntity.getnohp());
            preparedStatement.setString(5, userEntity.getpassword());
            preparedStatement.setString(6, userEntity.getakses());
            
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
    
    public String updateData(UserEntity_19552011024 userEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE user SET fullname = ?,alamat = ?,nohp = ?,password = ?,akses = ? WHERE username = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, userEntity.getfullname());
            preparedStatement.setString(2, userEntity.getalamat());
            preparedStatement.setString(3, userEntity.getnohp());
            preparedStatement.setString(4, userEntity.getpassword());
            preparedStatement.setString(5, userEntity.getakses());
            preparedStatement.setString(6, userEntity.getusername());
            
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
    
    public String deleteData(String username) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM user WHERE username = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlDelete);
            preparedStatement.setString(1, username);
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
