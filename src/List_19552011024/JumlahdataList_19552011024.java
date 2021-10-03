/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List_19552011024;

import Database_19552011024.Database_19552011024;
import Entity_19552011024.BarangEntity_19552011024;
import Entity_19552011024.JumlahEntity_19552011024;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class JumlahdataList_19552011024 {
    private String className = "JumlahList";

    public List<JumlahEntity_19552011024> getListData() {
        List<JumlahEntity_19552011024> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from jumlahdata";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
                jumlahEntity.setJumlahbarang(resultSet.getString("jumlah_barang"));
                jumlahEntity.setJumlahuser(resultSet.getString("jumlah_user"));
                jumlahEntity.setJumlahkategori(resultSet.getString("jumlah_kategori"));
                jumlahEntity.setJumlahtoko(resultSet.getString("jumlah_toko"));
                jumlahEntity.setJumlahpenjualan(resultSet.getString("jumlah_penjualan"));
                
                list.add(jumlahEntity);
            }
            statement.close();
            resultSet.close();
        }catch (Exception e){
            
        }
        return list;   
    }  
    
    public String updateBarang(JumlahEntity_19552011024 jumlahEntity) {
        String message = "";
        int id = 1;
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE jumlahdata SET jumlah_barang = ? WHERE id = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, jumlahEntity.getJumlahbarang());
            preparedStatement.setInt(2, id);
            
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
    
    public String updateUser(JumlahEntity_19552011024 jumlahEntity) {
        String message = "";
        int id = 1;
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE jumlahdata SET jumlah_user = ? WHERE id = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, jumlahEntity.getJumlahuser());
            preparedStatement.setInt(2, id);
            
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
    
    public String updateKategori(JumlahEntity_19552011024 jumlahEntity) {
        String message = "";
        int id = 1;
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE jumlahdata SET jumlah_kategori = ? WHERE id = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, jumlahEntity.getJumlahkategori());
            preparedStatement.setInt(2, id);
            
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
    
    public String updateToko(JumlahEntity_19552011024 jumlahEntity) {
        String message = "";
        int id = 1;
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE jumlahdata SET jumlah_toko = ? WHERE id = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, jumlahEntity.getJumlahtoko());
            preparedStatement.setInt(2, id);
            
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
    
    public String updatePenjualan(JumlahEntity_19552011024 jumlahEntity) {
        String message = "";
        int id = 1;
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE jumlahdata SET jumlah_penjualan = ? WHERE id = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, jumlahEntity.getJumlahpenjualan());
            preparedStatement.setInt(2, id);
            
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
    
    public String no_faktur(JumlahEntity_19552011024 jumlahEntity) {
        String message = "";
        int id = 1;
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE jumlahdata SET no_faktur = ? WHERE id = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, jumlahEntity.getNo_faktur());
           
            preparedStatement.setInt(2, id);
            
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
    
    public String nama_toko(JumlahEntity_19552011024 jumlahEntity) {
        String message = "";
        int id = 1;
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE jumlahdata SET nama_toko = ? WHERE id = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, jumlahEntity.getNama_toko());
            preparedStatement.setInt(2, id);
            
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
    
    public String sales(JumlahEntity_19552011024 jumlahEntity) {
        String message = "";
        int id = 1;
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE jumlahdata SET sales = ? WHERE id = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, jumlahEntity.getSales());
            preparedStatement.setInt(2, id);
            
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
    
    public String admin(JumlahEntity_19552011024 jumlahEntity) {
        String message = "";
        int id = 1;
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE jumlahdata SET admin = ? WHERE id = ?";

            preparedStatement = Database_19552011024.configDB().prepareStatement(sqlUpdate);
            
            preparedStatement.setString(1, jumlahEntity.getAdmin());
            preparedStatement.setInt(2, id);
            
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
}
