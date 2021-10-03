/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;

import Database_19552011024.Database_19552011024;
import Entity_19552011024.LoginEntity_19552011024;
import View_19552011024.HomeView_19552011024;
import View_19552011024.UserLoginView_19552011024;
//import static java.lang.Thread.sleep;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
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
public class LoginController_19552011024 {
    public void login(UserLoginView_19552011024 userLoginView){
        PreparedStatement st;
        ResultSet rs;
        String username = UserLoginView_19552011024.username.getText();
        String password = UserLoginView_19552011024.password.getText();
        
        String query = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";
         
        if(username.trim().equals("username"))
        {
                JOptionPane.showMessageDialog(null, "Masukkan Username", "Empty Username", 2);
        }
        else if(password.trim().equals("password"))
        {
                JOptionPane.showMessageDialog(null, "Masukkan Password", "Empty Password", 2);
        }
        else{
           try {
               st = Database_19552011024.configDB().prepareStatement(query);
               st.setString(1, username);
               st.setString(2, password);
               rs = st.executeQuery();
               
               if(rs.next()){
                   LoginEntity_19552011024 loginEntity = new LoginEntity_19552011024();
                   loginEntity.setfullname(rs.getString("fullname"));
                   loginEntity.setusername(rs.getString("username"));
                   loginEntity.setalamat(rs.getString("alamat"));
                   loginEntity.setnohp(rs.getString("nohp"));
                   loginEntity.setpassword(rs.getString("password"));
                   loginEntity.setakses(rs.getString("akses"));
                   HomeView_19552011024 form = new HomeView_19552011024();
                   form.setVisible(true);
                   form.pack();
                   form.setLocationRelativeTo(null);
                   userLoginView.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "Belum Terdaftar","Login Error",2);
               }
              
            } catch (SQLException ex) {
            
            } 
        }
        
    }
    public void batal(UserLoginView_19552011024 userLoginView){
        try{
            UserLoginView_19552011024.username.setText("");
            UserLoginView_19552011024.password.setText("");
        }catch (Exception e){
            
        }
    }
    
    public void tanggalwaktu(UserLoginView_19552011024 userLoginView){
        Thread p = new Thread(){
            public void run(){
                for(;;){
                    Calendar cal = new GregorianCalendar();
                    int hari = cal.get(Calendar.DAY_OF_MONTH);
                    int bulan = cal.get(Calendar.MONTH);
                    int tahun = cal.get(Calendar.YEAR);
                    userLoginView.tanggal.setText(hari+"/"+(bulan+1)+"/"+tahun);
                    
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
                    userLoginView.waktu.setText(waktuu);
                    
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
        
}
