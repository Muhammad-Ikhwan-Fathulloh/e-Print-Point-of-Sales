/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;

import Database_19552011024.Database_19552011024;
import Entity_19552011024.DatatokoEntity_19552011024;
import Entity_19552011024.JumlahEntity_19552011024;
import List_19552011024.DatatokoList_19552011024;
import List_19552011024.JumlahdataList_19552011024;
import Tabel_19552011024.DatatokoTabel_19552011024;
import View_19552011024.DatatokoView_19552011024;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author User
 */
public class DatatokoController_19552011024 {
    private static String className = "TokoController";
    public static DatatokoTabel_19552011024 tokoTabel = new DatatokoTabel_19552011024();
    public static DatatokoList_19552011024 tokoList = new DatatokoList_19552011024();
    public static JumlahdataList_19552011024 jumlahList = new JumlahdataList_19552011024();
    
    
    public void maximazieWindows(DatatokoView_19552011024 tokoView) {
        try {
            tokoView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
    
    public void setTableModel(DatatokoView_19552011024 tokoView) {
        try {
            DatatokoView_19552011024.toko.setModel(tokoTabel);
        } catch (Exception e) {
            
        }
    }
    
    public void loadData(DatatokoView_19552011024 tokoView) {
        try {
            List<DatatokoEntity_19552011024> list = tokoList.getListData();
            tokoTabel.setList(list);
        } catch (Exception e) {
           
        }
    }
    
    public void buttonSimpanAction(DatatokoView_19552011024 tokoView) {
        try {
            DatatokoEntity_19552011024 tokoEntity = new DatatokoEntity_19552011024();
            tokoEntity.setKode_Toko(DatatokoView_19552011024.kode_toko.getText());
            tokoEntity.setNama_Toko(DatatokoView_19552011024.nama_toko.getText());
            tokoEntity.setAlamat(DatatokoView_19552011024.alamat.getText());
            tokoEntity.setNohp(DatatokoView_19552011024.nohp.getText());
                
            String condition = tokoView.Status.getText();
            if (condition.equals("INSERT")) {
                String message = tokoList.insertData(tokoEntity);
                JOptionPane.showMessageDialog(tokoView, message);
            } else if (condition.equals("UPDATE")) {
                String message = tokoList.updateData(tokoEntity);
                JOptionPane.showMessageDialog(tokoView, message);
            } else{
                JOptionPane.showMessageDialog(tokoView, "gagal");
            }
            refresh(tokoView);
        } catch (Exception e) {
            
        }
    }
    
    public void buttonBaruAction(DatatokoView_19552011024 tokoView) {
        try {

           DatatokoView_19552011024.Status.setText("INSERT");
            
        } catch (Exception e) {
            
        }
    }
    
    public void buttonHapusAction(DatatokoView_19552011024 tokoView) {
        try {
            int rowSelected = DatatokoView_19552011024.toko.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(tokoView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                String kode_toko = tokoTabel.get(rowSelected).getKode_Toko();
                String nama_toko = tokoTabel.get(rowSelected).getNama_Toko();

                int confirm = JOptionPane.showConfirmDialog(tokoView, "Apakah anda yakin menghapus data "
                        + nama_toko + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = tokoList.deleteData(kode_toko);
                    JOptionPane.showMessageDialog(tokoView, message);
                }
                
            }
            refresh(tokoView);
        } catch (Exception e) {
            
        }
    }
    
    public void buttonUbahAction(DatatokoView_19552011024 tokoView) {
        try {
            int rowSelected = DatatokoView_19552011024.toko.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(tokoView, "Silahkan seleksi data yang ingin diubah");
            } else {
                DatatokoView_19552011024.Status.setText("UPDATE");

              
            }
        } catch (Exception e) {
            
        }
    }
    
    public void tableDataAction(DatatokoView_19552011024 tokoView) {
        DatatokoView_19552011024.toko.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = DatatokoView_19552011024.toko.getSelectedRow();
                if (row != -1) {
                    DatatokoEntity_19552011024 tokoEntity = tokoTabel.get(row);
                    
                    DatatokoView_19552011024.kode_toko.setText(tokoEntity.getKode_Toko());
                    DatatokoView_19552011024.nama_toko.setText(tokoEntity.getNama_Toko());
                    DatatokoView_19552011024.alamat.setText(tokoEntity.getAlamat());
                    DatatokoView_19552011024.nohp.setText(tokoEntity.getNohp());
                }
            }
        });
    }
    
    
    
    public void refresh(DatatokoView_19552011024 tokoView) {
        try {
            DatatokoView_19552011024.Status.setText("");
            
            DatatokoView_19552011024.nama_toko.setText("");
            
            DatatokoView_19552011024.alamat.setText("");
            DatatokoView_19552011024.nohp.setText("");
            
            DatatokoView_19552011024.toko.clearSelection();

            loadData(tokoView);
            kode(tokoView);
            jumlahtoko(tokoView);
        } catch (Exception error) {
            
        }
    }
    
    public void cari(DatatokoView_19552011024 tokoView){
        try{
            String searchParameter = DatatokoView_19552011024.caritoko.getText();
            List<DatatokoEntity_19552011024> list = tokoList.getListDataByParameter(searchParameter);
            tokoTabel.setList(list);
        }catch (Exception e){
            
        }
    }
    
    public void kode(DatatokoView_19552011024 tokoView){
       Statement statement = null;
       ResultSet resultSet = null;
       try{
           String faktur = "select MAX(kode_toko) from datatoko";
           statement = Database_19552011024.configDB().createStatement();
           resultSet = statement.executeQuery(faktur);
           resultSet.next();
           resultSet.getString("MAX(kode_toko)");
           if(resultSet.getString("MAX(kode_toko)")==null){
               DatatokoView_19552011024.kode_toko.setText("T-0000001");
           }else{
               long id = Long.parseLong(resultSet.getString("MAX(kode_toko)").substring(2,resultSet.getString("MAX(kode_toko)").length()));
               id++;
               DatatokoView_19552011024.kode_toko.setText("T-" + String.format("%07d", id));
           }
       } catch (Exception e){
           
       }
    }
    
    public void jumlahtoko(DatatokoView_19552011024 tokoView){
        try{
            JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
            jumlahEntity.setJumlahtoko(""+DatatokoView_19552011024.toko.getRowCount());
            DatatokoView_19552011024.jumlah.setText(""+DatatokoView_19552011024.toko.getRowCount());
            jumlahList.updateToko(jumlahEntity);
            
        }catch (Exception e){
            
        }
    }
    
}
