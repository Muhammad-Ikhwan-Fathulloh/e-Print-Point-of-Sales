/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;
//
import Database_19552011024.Database_19552011024;
import Entity_19552011024.BarangEntity_19552011024;
import Entity_19552011024.LoginEntity_19552011024;
import Entity_19552011024.TokoEntity_19552011024;
import List_19552011024.BarangList_19552011024;
import List_19552011024.TokoList_19552011024;
import Tabel_19552011024.BarangTabel_19552011024;
import Tabel_19552011024.TokoTabel_19552011024;
import View_19552011024.TokoView_19552011024;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class TokoController_19552011024 {
    private static String className = "TokoController";
    public static TokoTabel_19552011024 tokoTabel = new TokoTabel_19552011024();
    public static TokoList_19552011024 tokoList = new TokoList_19552011024();
    public static BarangTabel_19552011024 barangTabel = new BarangTabel_19552011024();
    public static BarangList_19552011024 barangList = new BarangList_19552011024();
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void maximazieWindowsToko(TokoView_19552011024 tokoView) {
        try {
            tokoView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
    
    public void setTableModel(TokoView_19552011024 tokoView) {
        try {
            TokoView_19552011024.Toko.setModel(tokoTabel);
        } catch (Exception e) {
            
        }
    }
    
    public void setTableModelToko(TokoView_19552011024 tokoView) {
        try {
            TokoView_19552011024.Barang.setModel(barangTabel);
        } catch (Exception e) {
            
        }
    }
    
    public void loadData(TokoView_19552011024 tokoView) {
        try {
            List<TokoEntity_19552011024> list = tokoList.getListData();
            tokoTabel.setList(list);
        } catch (Exception e) {
           
        }
    }
    
    public void loadDataToko(TokoView_19552011024 tokoView) {
        try {
            List<BarangEntity_19552011024> list = barangList.getListData();
            barangTabel.setList(list);
        } catch (Exception e) {
           
        }
    }
    
    public void buttonBaruAction(TokoView_19552011024 tokoView) {
        try {

           TokoView_19552011024.Status.setText("INSERT");
            
        } catch (Exception e) {
            
        }
    }
    
    public void tableDataToko(TokoView_19552011024 tokoView) {
        TokoView_19552011024.Barang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TokoView_19552011024.Barang.getSelectedRow();
                if (row != -1) {
                    BarangEntity_19552011024 barangEntity = barangTabel.get(row);
                    
                    TokoView_19552011024.kode_barang.setText(barangEntity.getkode_barang());
                    TokoView_19552011024.nama_barang.setText(barangEntity.getnama_barang());
                    //BarangView_19552011024.kategori_barang.setSelectedItem(barangEntity.getkategori_barang());
                    TokoView_19552011024.harga_barang.setText(Integer.toString(barangEntity.getharga_barang()));
                    //BarangView_19552011024.stok_barang.setText(Integer.toString(barangEntity.getstok_barang()));
                    //BarangView_19552011024.tanggal.setText(barangEntity.gettanggal());
                }
            }
        });
    }
    
    public void buttonSimpanAction(TokoView_19552011024 tokoView) {
        try {
            TokoEntity_19552011024 tokoEntity = new TokoEntity_19552011024();
            tokoEntity.setkode_order(TokoView_19552011024.kode_order.getText());
            tokoEntity.setnama_toko((String) TokoView_19552011024.nama_toko.getSelectedItem());
            tokoEntity.setalamat(TokoView_19552011024.alamat.getText());
            tokoEntity.setkode_barang(TokoView_19552011024.kode_barang.getText());
            tokoEntity.setnama_barang(TokoView_19552011024.nama_barang.getText());
            tokoEntity.setharga_barang(Integer.valueOf(TokoView_19552011024.harga_barang.getText()));
            tokoEntity.setjumlah_barang(Integer.valueOf(TokoView_19552011024.jumlah_barang.getText()));
            tokoEntity.settanggal(TokoView_19552011024.tanggal.getText());
            tokoEntity.setsales(TokoView_19552011024.sales.getText());
            
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
    
    public void buttonHapusAction(TokoView_19552011024 tokoView) {
        try {
            int rowSelected = TokoView_19552011024.Toko.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(tokoView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                String kode_order = tokoTabel.get(rowSelected).getkode_order();
                String nama_toko = tokoTabel.get(rowSelected).getnama_toko();

                int confirm = JOptionPane.showConfirmDialog(tokoView, "Apakah anda yakin menghapus data "
                        + nama_toko + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = tokoList.deleteData(kode_order);
                    JOptionPane.showMessageDialog(tokoView, message);
                }
                
            }
            refresh(tokoView);
        } catch (Exception e) {
            
        }
    }
    
    public void buttonUbahAction(TokoView_19552011024 tokoView) {
        try {
            int rowSelected = TokoView_19552011024.Toko.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(tokoView, "Silahkan seleksi data yang ingin diubah");
            } else {
                TokoView_19552011024.Status.setText("UPDATE");

              
            }
        } catch (Exception e) {
            
        }
    }
    
    public void tableDataAction(TokoView_19552011024 tokoView) {
        TokoView_19552011024.Toko.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TokoView_19552011024.Toko.getSelectedRow();
                if (row != -1) {
                    TokoEntity_19552011024 tokoEntity = tokoTabel.get(row);
                    
                    TokoView_19552011024.kode_order.setText(tokoEntity.getkode_order());
                    TokoView_19552011024.nama_toko.setSelectedItem(tokoEntity.getnama_toko());
                    TokoView_19552011024.alamat.setText(tokoEntity.getalamat());
                    TokoView_19552011024.kode_barang.setText(tokoEntity.getkode_barang());
                    TokoView_19552011024.nama_barang.setText(tokoEntity.getnama_barang());
                    TokoView_19552011024.harga_barang.setText(Integer.toString(tokoEntity.getharga_barang()));
                    TokoView_19552011024.jumlah_barang.setText(Integer.toString(tokoEntity.getjumlah_barang()));
                    TokoView_19552011024.tanggal.setText(tokoEntity.gettanggal());
                    //TokoView_19552011024.sales.setText(tokoEntity.getsales());
                }
            }
        });
    }
    
    
    
    public void refresh(TokoView_19552011024 tokoView) {
        try {
            TokoView_19552011024.Status.setText("");
            //TokoView_19552011024.kode_order.setText("");
            TokoView_19552011024.nama_toko.setSelectedIndex(0);
            TokoView_19552011024.alamat.setText("");
            TokoView_19552011024.kode_barang.setText("");
            TokoView_19552011024.nama_barang.setText("");
            TokoView_19552011024.harga_barang.setText("");
            TokoView_19552011024.jumlah_barang.setText("");
            TokoView_19552011024.tanggal.setText("");
            //TokoView_19552011024.sales.setText("");
            TokoView_19552011024.Toko.clearSelection();
            TokoView_19552011024.Barang.clearSelection();

            loadData(tokoView);
            kode(tokoView);
        } catch (Exception error) {
            
        }
    }
    
    public void toko(TokoView_19552011024 tokoView){
        Statement statement = null;
        ResultSet resultSet = null;
        
        
        try{
            String sqlSelect = "select * from datatoko";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while(resultSet.next()){
                TokoView_19552011024.nama_toko.addItem(resultSet.getString("nama_toko"));
            }
            
        }catch (Exception error) {
            
        }
    }
    public void sales(TokoView_19552011024 tokoView){
        try{
            LoginEntity_19552011024 loginEntity = new LoginEntity_19552011024();
            String aksesku = loginEntity.getfullname();
            
        }catch (Exception e){
            
        }
    }
    
    public void cari(TokoView_19552011024 tokoView){
        try{
            String searchParameter = TokoView_19552011024.caritoko.getText();
            List<TokoEntity_19552011024> list = tokoList.getListDataByParameter(searchParameter);
            tokoTabel.setList(list);
        }catch (Exception e){
            
        }
    }
    
    public void caribarang(TokoView_19552011024 tokoView){
        try{
            String searchParameter = TokoView_19552011024.cari.getText();
            List<BarangEntity_19552011024> list = barangList.getListDataByParameter(searchParameter);
            barangTabel.setList(list);
        }catch (Exception e){
            
        }
    }
    public void kode(TokoView_19552011024 tokoView){
       Statement statement = null;
       ResultSet resultSet = null;
       try{
           String faktur = "select MAX(kode_order) from toko";
           statement = Database_19552011024.configDB().createStatement();
           resultSet = statement.executeQuery(faktur);
           resultSet.next();
           resultSet.getString("MAX(kode_order)");
           if(resultSet.getString("MAX(kode_order)")==null){
               TokoView_19552011024.kode_order.setText("O-0000001");
           }else{
               long id = Long.parseLong(resultSet.getString("MAX(kode_order)").substring(2,resultSet.getString("MAX(kode_order)").length()));
               id++;
               TokoView_19552011024.kode_order.setText("O-" + String.format("%07d", id));
           }
       } catch (Exception e){
           
       }
    }
}
