/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;
//
import Database_19552011024.Database_19552011024;
import Entity_19552011024.LoginEntity_19552011024;
import View_19552011024.HomeView_19552011024;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class HomeController_19552011024 {
    private static String className = "HomeController";
    public void maximazieWindowsHome(HomeView_19552011024 homeView) {
        try {
            homeView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
    
    public void tanggalwaktu(HomeView_19552011024 homeView){
        Thread p = new Thread(){
            public void run(){
                for(;;){
                    Calendar cal = new GregorianCalendar();
                    int hari = cal.get(Calendar.DAY_OF_MONTH);
                    int bulan = cal.get(Calendar.MONTH);
                    int tahun = cal.get(Calendar.YEAR);
                    homeView.tanggal.setText(hari+"/"+(bulan+1)+"/"+tahun);
                    
                    int jam = cal.get(Calendar.HOUR);
                    int menit = cal.get(Calendar.MINUTE);
                    int detik = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    
                    String day_night = "";
                    if(AM_PM == 1){
                        day_night = "PM";
                    }else{
                        day_night = "AM";
                    }
                    String waktuu = jam + ":" + menit + ":" + detik + day_night;
                    homeView.waktu.setText(waktuu);
                    
                    try{
                        sleep(1000);
                    }catch (InterruptedException ex){
                        //Logger.getLogger(homeView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        p.start();
    }
    
    public void akses(HomeView_19552011024 homeView){
        try{
            LoginEntity_19552011024 loginEntity = new LoginEntity_19552011024();
            String aksesku = loginEntity.getakses();
            if(aksesku.equals("Admin Master")){
                homeView.barang.setEnabled(true);
                homeView.user.setEnabled(true);
                homeView.toko.setEnabled(true);
                homeView.penjualan.setEnabled(true);
                homeView.keuangan.setEnabled(true);
            }else if(aksesku.equals("Petugas Penjualan")){
                homeView.barang.setEnabled(true);
                homeView.user.setEnabled(false);
                homeView.userp.setVisible(false);
                homeView.toko.setEnabled(true);
                homeView.penjualan.setEnabled(true);
                homeView.keuangan.setEnabled(false);
                homeView.keuanganp.setVisible(false);
            }else if(aksesku.equals("Petugas Gudang")){
                homeView.barang.setEnabled(true);
                homeView.user.setEnabled(false);
                homeView.userp.setVisible(false);
                homeView.toko.setEnabled(false);
                homeView.tokop.setVisible(false);
                homeView.penjualan.setEnabled(false);
                homeView.penjualanp.setVisible(false);
                homeView.keuangan.setEnabled(false);
                homeView.keuanganp.setVisible(false);
            }else if(aksesku.equals("Sales")){
                homeView.barang.setEnabled(false);
                homeView.barangp.setVisible(false);
                homeView.user.setEnabled(false);
                homeView.userp.setVisible(false);
                homeView.toko.setEnabled(true);
                homeView.penjualan.setEnabled(false);
                homeView.penjualanp.setVisible(false);
                homeView.keuangan.setEnabled(false);
                homeView.keuanganp.setVisible(false);
            }
        }catch (Exception e){
            
        }
    }
    
    public void jumlahdata(HomeView_19552011024 homeView){
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sqlSelect = "select * from jumlahdata";
            statement = Database_19552011024.configDB().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
              
            while(resultSet.next()){
                HomeView_19552011024.jumlahbarang.setText(resultSet.getString("jumlah_barang"));
                HomeView_19552011024.jumlahuser.setText(resultSet.getString("jumlah_user"));
                HomeView_19552011024.jumlahkategori.setText(resultSet.getString("jumlah_kategori"));
                HomeView_19552011024.jumlahtoko.setText(resultSet.getString("jumlah_toko"));
                HomeView_19552011024.jumlahpenjualan.setText(resultSet.getString("jumlah_penjualan"));
            }
        }catch (Exception e){
            
        }
    }
}
