/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;

import Database_19552011024.Database_19552011024;
import Entity_19552011024.JumlahEntity_19552011024;
import Entity_19552011024.KategoriEntity_19552011024;
import List_19552011024.JumlahdataList_19552011024;
import List_19552011024.KategoriList_19552011024;
import Tabel_19552011024.KategoriTabel_19552011024;
import View_19552011024.KategoriView_19552011024;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
public class KategoriController_19552011024{
    private static String className = "KategoriController";
    public static KategoriTabel_19552011024 kategoriTabel = new KategoriTabel_19552011024();
    public static KategoriList_19552011024 kategoriList = new KategoriList_19552011024();
    public static JumlahdataList_19552011024 jumlahList = new JumlahdataList_19552011024();
    
    public void maximazieWindows(KategoriView_19552011024 kategoriView) {
        try {
            kategoriView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
    
    public void setTableModel(KategoriView_19552011024 kategoriView) {
        try {
            KategoriView_19552011024.Kategori.setModel(kategoriTabel);
        } catch (Exception e) {
            
        }
    }
    
    public void loadData(KategoriView_19552011024 kategoriView) {
        try {
            List<KategoriEntity_19552011024> list = kategoriList.getListData();
            kategoriTabel.setList(list);
        } catch (Exception e) {
           
        }
    }
    
    public void buttonSimpanAction(KategoriView_19552011024 kategoriView) {
        try {
            KategoriEntity_19552011024 kategoriEntity = new KategoriEntity_19552011024();
            kategoriEntity.setkategori_kode(KategoriView_19552011024.kategori_kode.getText());
            kategoriEntity.setkategori_barang(KategoriView_19552011024.kategori_barang.getText());
                
            String condition = kategoriView.Status.getText();
            if (condition.equals("INSERT")) {
                String message = kategoriList.insertData(kategoriEntity);
                JOptionPane.showMessageDialog(kategoriView, message);
            } else if (condition.equals("UPDATE")) {
                String message = kategoriList.updateData(kategoriEntity);
                JOptionPane.showMessageDialog(kategoriView, message);
            } else{
                JOptionPane.showMessageDialog(kategoriView, "gagal");
            }
            refresh(kategoriView);
        } catch (Exception e) {
            
        }
    }
    
    public void buttonBaruAction(KategoriView_19552011024 kategoriView) {
        try {

           KategoriView_19552011024.Status.setText("INSERT");
            
        } catch (Exception e) {
            
        }
    }
    
    public void buttonHapusAction(KategoriView_19552011024 kategoriView) {
        try {
            int rowSelected = kategoriView.Kategori.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(kategoriView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                String kategori_kode = kategoriTabel.get(rowSelected).getkategori_kode();
                String kategori_barang = kategoriTabel.get(rowSelected).getkategori_barang();

                int confirm = JOptionPane.showConfirmDialog(kategoriView, "Apakah anda yakin menghapus data "
                        + kategori_barang + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = kategoriList.deleteData(kategori_kode);
                    JOptionPane.showMessageDialog(kategoriView, message);
                }
                
            }
            refresh(kategoriView);
        } catch (Exception e) {
            
        }
    }
    
    public void buttonUbahAction(KategoriView_19552011024 kategoriView) {
        try {
            int rowSelected = KategoriView_19552011024.Kategori.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(kategoriView, "Silahkan seleksi data yang ingin diubah");
            } else {
                KategoriView_19552011024.Status.setText("UPDATE");

              
            }
        } catch (Exception e) {
            
        }
    }
    
    public void tableDataAction(KategoriView_19552011024 kategoriView) {
        KategoriView_19552011024.Kategori.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = KategoriView_19552011024.Kategori.getSelectedRow();
                if (row != -1) {
                    KategoriEntity_19552011024 kategoriEntity = kategoriTabel.get(row);
                    
                    KategoriView_19552011024.kategori_kode.setText(kategoriEntity.getkategori_kode());
                    KategoriView_19552011024.kategori_barang.setText(kategoriEntity.getkategori_barang());
                }
            }
        });
    }
    
    public void refresh(KategoriView_19552011024 kategoriEntity) {
        try {
            KategoriView_19552011024.Status.setText("");
            //KategoriView_19552011024.kategori_kode.setText("");
            KategoriView_19552011024.kategori_barang.setText("");
            KategoriView_19552011024.Kategori.clearSelection();

            loadData(kategoriEntity);
            kode(kategoriEntity);
            jumlahkategori(kategoriEntity);
        } catch (Exception error) {
            
        }
    }
    
    public void cari(KategoriView_19552011024 kategoriEntity){
        try{
            String searchParameter = KategoriView_19552011024.cari.getText();
            List<KategoriEntity_19552011024> list = kategoriList.getListDataByParameter(searchParameter);
            kategoriTabel.setList(list);
        }catch (Exception e){
            
        }
    }
    
    public void kode(KategoriView_19552011024 kategoriEntity){
       Statement statement = null;
       ResultSet resultSet = null;
       try{
           String faktur = "select MAX(kategori_kode) from kategori";
           statement = Database_19552011024.configDB().createStatement();
           resultSet = statement.executeQuery(faktur);
           resultSet.next();
           resultSet.getString("MAX(kategori_kode)");
           if(resultSet.getString("MAX(kategori_kode)")==null){
               KategoriView_19552011024.kategori_kode.setText("K-0000001");
           }else{
               long id = Long.parseLong(resultSet.getString("MAX(kategori_kode)").substring(2,resultSet.getString("MAX(kategori_kode)").length()));
               id++;
               KategoriView_19552011024.kategori_kode.setText("K-" + String.format("%07d", id));
           }
       } catch (Exception e){
           
       }
    }
    
    public void jumlahkategori(KategoriView_19552011024 kategoriEntity){
        try{
            JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
            jumlahEntity.setJumlahkategori(""+KategoriView_19552011024.Kategori.getRowCount());
            KategoriView_19552011024.jumlah.setText(""+KategoriView_19552011024.Kategori.getRowCount());
            jumlahList.updateKategori(jumlahEntity);
        }catch (Exception e){
            
        }
    }
}
