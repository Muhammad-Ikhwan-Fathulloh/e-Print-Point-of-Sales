/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;
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
import List_19552011024.BarangList_19552011024;
import Entity_19552011024.BarangEntity_19552011024;
import Entity_19552011024.JumlahEntity_19552011024;
import List_19552011024.JumlahdataList_19552011024;
import Tabel_19552011024.BarangTabel_19552011024;
import View_19552011024.BarangView_19552011024;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BarangController_19552011024 {
    private static String className = "BarangController";
    public static BarangTabel_19552011024 barangTabel = new BarangTabel_19552011024();
    public static BarangList_19552011024 barangList = new BarangList_19552011024();
    public static JumlahdataList_19552011024 jumlahList = new JumlahdataList_19552011024();
    
    public void maximazieWindowsBarang(BarangView_19552011024 barangView) {
        try {
            barangView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
    
    public void setTableModel(BarangView_19552011024 barangView) {
        try {
            BarangView_19552011024.Barang.setModel(barangTabel);
        } catch (Exception e) {
            
        }
    }
    
    
    
    public void loadData(BarangView_19552011024 barangView) {
        try {
            List<BarangEntity_19552011024> list = barangList.getListData();
            barangTabel.setList(list);
        } catch (Exception e) {
           
        }
    }
    
    
    
    public void buttonSimpanAction(BarangView_19552011024 barangView) {
        try {
            BarangEntity_19552011024 barangEntity = new BarangEntity_19552011024();
            barangEntity.setkode_barang(BarangView_19552011024.kode_barang.getText());
            barangEntity.setnama_barang(BarangView_19552011024.nama_barang.getText());
            barangEntity.setkategori_barang((String) BarangView_19552011024.kategori_barang.getSelectedItem());
            barangEntity.setharga_barang(Integer.valueOf(BarangView_19552011024.harga_barang.getText()));
            barangEntity.setstok_barang(Integer.valueOf(BarangView_19552011024.stok_barang.getText()));
            barangEntity.settanggal(BarangView_19552011024.tanggal.getText());
                
            String condition = barangView.Status.getText();
            if (condition.equals("INSERT")) {
                String message = barangList.insertData(barangEntity);
                JOptionPane.showMessageDialog(barangView, message);
            } else if (condition.equals("UPDATE")) {
                String message = barangList.updateData(barangEntity);
                JOptionPane.showMessageDialog(barangView, message);
            } else{
                JOptionPane.showMessageDialog(barangView, "gagal");
            }
            refresh(barangView);
        } catch (Exception e) {
            
        }
    }
    
    public void buttonBaruAction(BarangView_19552011024 barangView) {
        try {

           BarangView_19552011024.Status.setText("INSERT");
            
        } catch (Exception e) {
            
        }
    }
    
    public void buttonHapusAction(BarangView_19552011024 barangView) {
        try {
            int rowSelected = BarangView_19552011024.Barang.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(barangView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                String kode_barang = barangTabel.get(rowSelected).getkode_barang();
                String nama_barang = barangTabel.get(rowSelected).getnama_barang();

                int confirm = JOptionPane.showConfirmDialog(barangView, "Apakah anda yakin menghapus data "
                        + nama_barang + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = barangList.deleteData(kode_barang);
                    JOptionPane.showMessageDialog(barangView, message);
                }
                
            }
            refresh(barangView);
        } catch (Exception e) {
            
        }
    }
    
    public void buttonUbahAction(BarangView_19552011024 barangView) {
        try {
            int rowSelected = BarangView_19552011024.Barang.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(barangView, "Silahkan seleksi data yang ingin diubah");
            } else {
                BarangView_19552011024.Status.setText("UPDATE");

              
            }
        } catch (Exception e) {
            
        }
    }
    
    public void tableDataAction(BarangView_19552011024 barangView) {
        BarangView_19552011024.Barang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = BarangView_19552011024.Barang.getSelectedRow();
                if (row != -1) {
                    BarangEntity_19552011024 barangEntity = barangTabel.get(row);
                    
                    BarangView_19552011024.kode_barang.setText(barangEntity.getkode_barang());
                    BarangView_19552011024.nama_barang.setText(barangEntity.getnama_barang());
                    BarangView_19552011024.kategori_barang.setSelectedItem(barangEntity.getkategori_barang());
                    BarangView_19552011024.harga_barang.setText(Integer.toString(barangEntity.getharga_barang()));
                    BarangView_19552011024.stok_barang.setText(Integer.toString(barangEntity.getstok_barang()));
                    BarangView_19552011024.tanggal.setText(barangEntity.gettanggal());
                }
            }
        });
    }
    
    
    
    public void refresh(BarangView_19552011024 barangView) {
        try {
            BarangView_19552011024.Status.setText("");
            //BarangView_19552011024.kode_barang.setText("");
            BarangView_19552011024.nama_barang.setText("");
            BarangView_19552011024.kategori_barang.setSelectedIndex(0);
            BarangView_19552011024.harga_barang.setText("");
            BarangView_19552011024.stok_barang.setText("");
            BarangView_19552011024.tanggal.setText("");
            BarangView_19552011024.Barang.clearSelection();

            loadData(barangView);
            kode(barangView);
            jumlahbarang(barangView);
        } catch (Exception error) {
            
        }
    }
    
    public void kategori(BarangView_19552011024 barangView){
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from kategori";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
              
            while(resultSet.next()){
                BarangView_19552011024.kategori_barang.addItem(resultSet.getString("kategori_barang"));
            }
          
        }catch (Exception error) {
            
        }
    }
    
    public void cari(BarangView_19552011024 barangView){
        try{
            String searchParameter = BarangView_19552011024.cari.getText();
            List<BarangEntity_19552011024> list = barangList.getListDataByParameter(searchParameter);
            barangTabel.setList(list);
        }catch (Exception e){
            
        }
    }
    
    public void kode(BarangView_19552011024 barangView){
       Statement statement = null;
       ResultSet resultSet = null;
       try{
           String faktur = "select MAX(kode_barang) from barang";
           statement = Database_19552011024.configDB().createStatement();
           resultSet = statement.executeQuery(faktur);
           resultSet.next();
           resultSet.getString("MAX(kode_barang)");
           if(resultSet.getString("MAX(kode_barang)")==null){
               BarangView_19552011024.kode_barang.setText("B-0000001");
           }else{
               long id = Long.parseLong(resultSet.getString("MAX(kode_barang)").substring(2,resultSet.getString("MAX(kode_barang)").length()));
               id++;
               BarangView_19552011024.kode_barang.setText("B-" + String.format("%07d", id));
           }
       } catch (Exception e){
           
       }
    }
    
    public void jumlahbarang(BarangView_19552011024 barangView){
        try{
            JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
            jumlahEntity.setJumlahbarang(""+BarangView_19552011024.Barang.getRowCount());
            BarangView_19552011024.jumlah.setText(""+BarangView_19552011024.Barang.getRowCount());
            jumlahList.updateBarang(jumlahEntity);
            
        }catch (Exception e){
            
        }
    }
    
    
}
