/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;
//
import Database_19552011024.Database_19552011024;
import Entity_19552011024.JumlahEntity_19552011024;
import Entity_19552011024.KeuanganEntity_19552011024;
import Entity_19552011024.PenjualanEntity_19552011024;
import Entity_19552011024.StokEntity_19552011024;
import Entity_19552011024.TokoEntity_19552011024;
import List_19552011024.BarangList_19552011024;
import List_19552011024.JumlahdataList_19552011024;
import List_19552011024.KeuanganList_19552011024;
import List_19552011024.PenjualanList_19552011024;
import List_19552011024.TokoList_19552011024;
import Tabel_19552011024.BarangTabel_19552011024;
import Tabel_19552011024.PenjualanTabel_19552011024;
import Tabel_19552011024.TokoTabel_19552011024;
import View_19552011024.PenjualanView_19552011024;
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
public class PenjualanController_19552011024 {
    private static String className = "PenjualanController";
    public static PenjualanTabel_19552011024 penjualanTabel = new PenjualanTabel_19552011024();
    public static PenjualanList_19552011024 penjualanList = new PenjualanList_19552011024();
    public static KeuanganList_19552011024 keuangannList = new KeuanganList_19552011024();
    public static JumlahdataList_19552011024 jumlahList = new JumlahdataList_19552011024();
    
    public static TokoTabel_19552011024 tokoTabel = new TokoTabel_19552011024();
    public static TokoList_19552011024 tokoList = new TokoList_19552011024();
    
    public static BarangTabel_19552011024 barangTabel = new BarangTabel_19552011024();
    public static BarangList_19552011024 barangList = new BarangList_19552011024();
    
    public void maximazieWindowsPenjualan(PenjualanView_19552011024 penjualanView) {
        try {
            penjualanView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
    
    public void setTableModel(PenjualanView_19552011024 penjualanView) {
        try {
            PenjualanView_19552011024.Penjualan.setModel(penjualanTabel);
        } catch (Exception e) {
            
        }
    }
    
    public void setTableModelPenjualan(PenjualanView_19552011024 penjualanView) {
        try {
            PenjualanView_19552011024.Toko.setModel(tokoTabel);
        } catch (Exception e) {
            
        }
    }
    
    public void loadDataPenjualan(PenjualanView_19552011024 penjualanView) {
        try {
            List<TokoEntity_19552011024> list = tokoList.getListData();
            tokoTabel.setList(list);
        } catch (Exception e) {
           
        }
    }
    
    public void loadData(PenjualanView_19552011024 penjualanView) {
        try {
            List<PenjualanEntity_19552011024> list = penjualanList.getListData();
            penjualanTabel.setList(list);
        } catch (Exception e) {
           
        }
        jumlahdata(penjualanView);
    }
    
    public void jumlahdata(PenjualanView_19552011024 penjualanView){
        try {
            int total = 0;
            for (int i =0; i< PenjualanView_19552011024.Penjualan.getRowCount(); i++){
                total = total + Integer.parseInt(PenjualanView_19552011024.Penjualan.getValueAt(i, 5).toString());
                
            }
            PenjualanView_19552011024.subtotal.setText(Integer.toString(total));
        } catch (Exception e) {
           
        }
    }
    
    public void tableDataActionPenjualan(PenjualanView_19552011024 penjualanView) {
        PenjualanView_19552011024.Toko.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = PenjualanView_19552011024.Toko.getSelectedRow();
                if (row != -1) {
                    TokoEntity_19552011024 tokoEntity = tokoTabel.get(row);
                    
                    PenjualanView_19552011024.kode_order.setText(tokoEntity.getkode_order());
                    PenjualanView_19552011024.nama_toko.setText(tokoEntity.getnama_toko());
                    //PenjualanView_19552011024.alamat.setText(tokoEntity.getalamat());
                    PenjualanView_19552011024.kode_barang.setText(tokoEntity.getkode_barang());
                    PenjualanView_19552011024.nama_barang.setText(tokoEntity.getnama_barang());
                    PenjualanView_19552011024.harga_barang.setText(Integer.toString(tokoEntity.getharga_barang()));
                    //PenjualanView_19552011024.stok_barang.setText(Integer.toString(tokoEntity.getstok_barang()));
                    PenjualanView_19552011024.jumlah_barang.setText(Integer.toString(tokoEntity.getjumlah_barang()));
                    //PenjualanView_19552011024.tanggal.setText(tokoEntity.gettanggal());
                    PenjualanView_19552011024.sales.setText(tokoEntity.getsales());
                }
            }
        });
    }
    
    public void toko(PenjualanView_19552011024 penjualanView){
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from toko";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
              
            while(resultSet.next()){
                //PenjualanView_19552011024.nama_toko1.addItem(resultSet.getString("nama_toko"));
            }
          
        }catch (Exception error) {
            
        }
    }
    
    
    public void hitung(PenjualanView_19552011024 penjualanView){
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from barang where kode_barang ='"+PenjualanView_19552011024.kode_barang.getText()+"'";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while(resultSet.next()){
                PenjualanView_19552011024.stok_barang.setText(resultSet.getString("stok_barang"));
            }
            
            int total;
            int a = Integer.parseInt(PenjualanView_19552011024.harga_barang.getText());
            int b = Integer.parseInt(PenjualanView_19552011024.jumlah_barang.getText());
            total = a*b;
            PenjualanView_19552011024.total.setText(""+total);
            tokoku(penjualanView);
            sales(penjualanView);
            
        }catch (Exception e){
            
        }
    }
    
    public void cek(PenjualanView_19552011024 penjualanView){
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            //String sqlSelect = "select * from toko where nama_toko ='"+PenjualanView_19552011024.nama_toko1.getSelectedItem()+"'";
            statement = Database_19552011024.configDB().createStatement();
            //resultSet = statement.executeQuery(sqlSelect);
            
            while(resultSet.next()){
                PenjualanView_19552011024.caritoko.setText(resultSet.getString("nama_toko"));
            }
            
        }catch (Exception e){
            
        }
    }
    public void nofaktur(PenjualanView_19552011024 penjualanView){
       Statement statement = null;
       ResultSet resultSet = null;
       try{
           String faktur = "select MAX(no_faktur) from keuangan";
           statement = Database_19552011024.configDB().createStatement();
           resultSet = statement.executeQuery(faktur);
           resultSet.next();
           resultSet.getString("MAX(no_faktur)");
           if(resultSet.getString("MAX(no_faktur)")==null){
               PenjualanView_19552011024.no_faktur.setText("F-0000001");
           }else{
               long id = Long.parseLong(resultSet.getString("MAX(no_faktur)").substring(2,resultSet.getString("MAX(no_faktur)").length()));
               id++;
               PenjualanView_19552011024.no_faktur.setText("F-" + String.format("%07d", id));
           }
       } catch (Exception e){
           
       }
       
    }
    
    public void tambahDetail(PenjualanView_19552011024 penjualanView){
       try{
           PenjualanView_19552011024.Status.setText("Tambah");
       } catch (Exception e){
           
       }
    }
    
    public void batalt(PenjualanView_19552011024 penjualanView) {
        try {
            int rowSelected = PenjualanView_19552011024.Penjualan.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(penjualanView, "Silahkan seleksi data");
            } else {
                PenjualanView_19552011024.Status.setText("Batal");

              
            }
        } catch (Exception e) {
            
        }
    }
    
    
    public void simpan(PenjualanView_19552011024 penjualanView){
       try{
           PenjualanEntity_19552011024 penjualanEntity = new PenjualanEntity_19552011024();
           
           //penjualanEntity.setno_faktur(PenjualanView_19552011024.no_faktur.getText());
           penjualanEntity.setkode_order(PenjualanView_19552011024.kode_order.getText());
           penjualanEntity.setkode_barang(PenjualanView_19552011024.kode_barang.getText());
           penjualanEntity.setnama_barang(PenjualanView_19552011024.nama_barang.getText());
           penjualanEntity.setharga_barang(Integer.valueOf(PenjualanView_19552011024.harga_barang.getText()));
           penjualanEntity.setjumlah_barang(Integer.valueOf(PenjualanView_19552011024.jumlah_barang.getText()));
           penjualanEntity.settotal(Integer.valueOf(PenjualanView_19552011024.total.getText()));
//           penjualanEntity.settanggal(PenjualanView_19552011024.tanggal.getText());
//           penjualanEntity.setsales(PenjualanView_19552011024.sales.getText());
//           penjualanEntity.setadmin(PenjualanView_19552011024.admin.getText());
           
           String condition = penjualanView.Status.getText();
           if (condition.equals("Tambah")) {
               String message = penjualanList.insertData(penjualanEntity);
               JOptionPane.showMessageDialog(penjualanView, message);
               nofaktur(penjualanView);
               loadDataPenjualan(penjualanView);
               loadData(penjualanView);
               
           }else{
               JOptionPane.showMessageDialog(penjualanView, "gagal");
           }
             
       } catch (Exception e){
           
       }
       
    }
    public void batal(PenjualanView_19552011024 penjualanView){
        int x, y, z;
        x = Integer.parseInt(PenjualanView_19552011024.stok_barang.getText());
        y = Integer.parseInt(PenjualanView_19552011024.jumlah_barang.getText());
        z = x + y;
            
        String id = PenjualanView_19552011024.kode_barang.getText();   
        try{
            StokEntity_19552011024 stokEntity = new StokEntity_19552011024();
            stokEntity.setkode_barang(id);
            stokEntity.setstok_barang(z);
            String condition = penjualanView.Status.getText();
            if (condition.equals("Batal")) {
                String message = barangList.updateStok(stokEntity);
                //JOptionPane.showMessageDialog(penjualanView, message);
            }else{
                JOptionPane.showMessageDialog(penjualanView, "gagal");
            }
        }catch (Exception e){
            
        }
    }
    
    public void stok(PenjualanView_19552011024 penjualanView){
        int x, y, z;
        x = Integer.parseInt(PenjualanView_19552011024.stok_barang.getText());
        y = Integer.parseInt(PenjualanView_19552011024.jumlah_barang.getText());
        z = x - y;
            
        String id = PenjualanView_19552011024.kode_barang.getText();
        try{
            StokEntity_19552011024 stokEntity = new StokEntity_19552011024();
            stokEntity.setkode_barang(id);
            stokEntity.setstok_barang(z);
            String condition = penjualanView.Status.getText();
            if (condition.equals("Tambah")) {
                String message = barangList.updateStok(stokEntity);
                //JOptionPane.showMessageDialog(penjualanView, message);
            }else{
                JOptionPane.showMessageDialog(penjualanView, "gagal");
            }
            
        }catch (Exception e){
            
        }
    }
    
    public void cari(PenjualanView_19552011024 penjualanView){
        try{
            String searchParameter = PenjualanView_19552011024.caritoko.getText();
            List<TokoEntity_19552011024> list = tokoList.getListDataByParameter(searchParameter);
            tokoTabel.setList(list);
        }catch (Exception e){
            
        }
    }
    
    public void tableDataAction(PenjualanView_19552011024 penjualanView) {
        PenjualanView_19552011024.Penjualan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = PenjualanView_19552011024.Penjualan.getSelectedRow();
                if (row != -1) {
                    PenjualanEntity_19552011024 penjualanEntity = penjualanTabel.get(row);
                    
//                    PenjualanView_19552011024.no_faktur.setText(penjualanEntity.getno_faktur());
//                    PenjualanView_19552011024.kode_order.setText(penjualanEntity.getkode_order());
//                    PenjualanView_19552011024.nama_toko.setText(penjualanEntity.getnama_toko());
//                    PenjualanView_19552011024.kode_barang.setText(penjualanEntity.getkode_barang());
//                    PenjualanView_19552011024.total.setText(Integer.toString(penjualanEntity.gettotal()));
//                    PenjualanView_19552011024.jumlah_barang.setText(Integer.toString(penjualanEntity.getjumlah_barang()));
//                    PenjualanView_19552011024.tanggal.setText(penjualanEntity.gettanggal());
//                    PenjualanView_19552011024.sales.setText(penjualanEntity.getsales());
//                    PenjualanView_19552011024.admin.setText(penjualanEntity.getadmin());
                }
            }
        });
    }
    
    public void buttonHapusAction(PenjualanView_19552011024 penjualanView) {
        try {
            int rowSelected = PenjualanView_19552011024.Penjualan.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(penjualanView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                String kode_order = penjualanTabel.get(rowSelected).getkode_order();
                String kode_barang = penjualanTabel.get(rowSelected).getkode_barang();

                int confirm = JOptionPane.showConfirmDialog(penjualanView, "Apakah anda yakin menghapus data "
                        + kode_barang + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = penjualanList.deleteData(kode_order);
                    JOptionPane.showMessageDialog(penjualanView, message);
                }
                
            }
        } catch (Exception e) {
            
        }
    }
    
    public void buttonHapusToko(PenjualanView_19552011024 penjualanView) {
        try {
            int rowSelected = PenjualanView_19552011024.Toko.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(penjualanView, "Silahkan seleksi data");
            } else {
                String kode_order = tokoTabel.get(rowSelected).getkode_order();
                String nama_toko = tokoTabel.get(rowSelected).getnama_toko();

                int confirm = JOptionPane.showConfirmDialog(penjualanView, "Apakah anda yakin data yang dipilih "
                        + nama_toko + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = tokoList.deleteData(kode_order);
                    JOptionPane.showMessageDialog(penjualanView, message);
                }
                
            }
            
        } catch (Exception e) {
            
        }
    }
    
    public void simpankeuangan(PenjualanView_19552011024 penjualanView){
        try{
            KeuanganEntity_19552011024 keuanganEntity = new KeuanganEntity_19552011024();
            keuanganEntity.setno_faktur(PenjualanView_19552011024.no_faktur.getText());
            keuanganEntity.setnama_toko(PenjualanView_19552011024.nama_toko.getText());
            keuanganEntity.settotal(Integer.valueOf(PenjualanView_19552011024.total.getText()));
            keuanganEntity.settanggal(PenjualanView_19552011024.tanggal.getText());
            keuanganEntity.setsales(PenjualanView_19552011024.sales.getText());
            keuanganEntity.setadmin(PenjualanView_19552011024.admin.getText());
            keuangannList.insertData(keuanganEntity);
            PenjualanEntity_19552011024 penjualanEntity = new PenjualanEntity_19552011024();
            penjualanList.Kosong(penjualanEntity);
            nofaktur(penjualanView);
            updatefaktur(penjualanView);
            loadData(penjualanView);
            
        }catch (Exception e){
            
        }
       
   }
   
    public void updatefaktur(PenjualanView_19552011024 penjualanView){
        try{
            JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
            jumlahEntity.setNo_faktur(PenjualanView_19552011024.no_faktur.getText());
            //jumlahEntity.setNama_toko(PenjualanView_19552011024.nama_toko.getText());
            
            jumlahList.no_faktur(jumlahEntity);
            //jumlahList.nama_toko(jumlahEntity);
            
        }catch (Exception e){
            
        }
    }
    public void tokoku(PenjualanView_19552011024 penjualanView){
        try{
            JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
            
            jumlahEntity.setNama_toko(PenjualanView_19552011024.nama_toko.getText());
            
            jumlahList.nama_toko(jumlahEntity);
            
        }catch (Exception e){
            
        }
    }
    public void sales(PenjualanView_19552011024 penjualanView){
        try{
            JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
            
            jumlahEntity.setSales(PenjualanView_19552011024.sales.getText());
            
            jumlahList.sales(jumlahEntity);
            
        }catch (Exception e){
            
        }
    }
    public void admin(PenjualanView_19552011024 penjualanView){
        try{
            JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
            
            jumlahEntity.setAdmin(PenjualanView_19552011024.admin.getText());
            
            jumlahList.admin(jumlahEntity);
        }catch (Exception e){
            
        }
    }
    
}
