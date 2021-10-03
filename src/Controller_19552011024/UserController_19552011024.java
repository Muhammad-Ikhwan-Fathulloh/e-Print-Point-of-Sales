/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;

import Entity_19552011024.JumlahEntity_19552011024;
import Entity_19552011024.UserEntity_19552011024;
import List_19552011024.JumlahdataList_19552011024;
import List_19552011024.UserList_19552011024;
import Tabel_19552011024.UserTabel_19552011024;
import View_19552011024.UserRegisterView_19552011024;
import static java.awt.Frame.MAXIMIZED_BOTH;
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
public class UserController_19552011024{
    private static String className = "UserController";
    public static UserTabel_19552011024 userTabel = new UserTabel_19552011024();
    public static UserList_19552011024 userList = new UserList_19552011024();
    public static JumlahdataList_19552011024 jumlahList = new JumlahdataList_19552011024();
    
    public void maximazieWindows(UserRegisterView_19552011024 userRegisterView) {
        try {
            userRegisterView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
    
    public void setTableModel(UserRegisterView_19552011024 userRegisterView) {
        try {
            UserRegisterView_19552011024.Register.setModel(userTabel);
        } catch (Exception e) {
            
        }
    }
    
    public void loadData(UserRegisterView_19552011024 userRegisterView) {
        try {
            List<UserEntity_19552011024> list = userList.getListData();
            userTabel.setList(list);
        } catch (Exception e) {
           
        }
    }
    
    public void buttonBaruAction(UserRegisterView_19552011024 userRegisterView) {
        try {

           UserRegisterView_19552011024.Status.setText("INSERT");
            
        } catch (Exception e) {
            
        }
    }
    
    public void buttonSimpanAction(UserRegisterView_19552011024 userRegisterView) {
        try {
            UserEntity_19552011024 userEntity = new UserEntity_19552011024();
            userEntity.setfullname(UserRegisterView_19552011024.fullname.getText());
            userEntity.setusername(UserRegisterView_19552011024.username.getText());
            userEntity.setalamat(UserRegisterView_19552011024.alamat.getText());
            userEntity.setnohp(UserRegisterView_19552011024.nohp.getText());
            userEntity.setpassword(UserRegisterView_19552011024.password.getText());
            userEntity.setakses((String) UserRegisterView_19552011024.akses.getSelectedItem());
                
            String condition = userRegisterView.Status.getText();
            if (condition.equals("INSERT")) {
                String message = userList.insertData(userEntity);
                JOptionPane.showMessageDialog(userRegisterView, message);
            } else if (condition.equals("UPDATE")) {
                String message = userList.updateData(userEntity);
                JOptionPane.showMessageDialog(userRegisterView, message);
            } else{
                JOptionPane.showMessageDialog(userRegisterView, "gagal");
            }
            refresh(userRegisterView);
        } catch (Exception e) {
            
        }
    }
    
    public void buttonHapusAction(UserRegisterView_19552011024 userRegisterView) {
        try {
            int rowSelected = UserRegisterView_19552011024.Register.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(userRegisterView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                String username = userTabel.get(rowSelected).getusername();
                String fullname = userTabel.get(rowSelected).getfullname();

                int confirm = JOptionPane.showConfirmDialog(userRegisterView, "Apakah anda yakin menghapus data "
                        + fullname + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = userList.deleteData(username);
                    JOptionPane.showMessageDialog(userRegisterView, message);
                }
                
            }
            refresh(userRegisterView);
        } catch (Exception e) {
            
        }
    }
    
    public void buttonUbahAction(UserRegisterView_19552011024 userRegisterView) {
        try {
            int rowSelected = UserRegisterView_19552011024.Register.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(userRegisterView, "Silahkan seleksi data yang ingin diubah");
            } else {
                UserRegisterView_19552011024.Status.setText("UPDATE");

              
            }
        } catch (Exception e) {
            
        }
    }
    
    public void tableDataAction(UserRegisterView_19552011024 userRegisterView) {
        UserRegisterView_19552011024.Register.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = UserRegisterView_19552011024.Register.getSelectedRow();
                if (row != -1) {
                    UserEntity_19552011024 userEntity = userTabel.get(row);
                    
                    UserRegisterView_19552011024.fullname.setText(userEntity.getfullname());
                    UserRegisterView_19552011024.username.setText(userEntity.getusername());
                    UserRegisterView_19552011024.alamat.setText(userEntity.getalamat());
                    UserRegisterView_19552011024.nohp.setText(userEntity.getnohp());
                    UserRegisterView_19552011024.password.setText(userEntity.getpassword());
                    UserRegisterView_19552011024.akses.setSelectedItem(userEntity.getakses());
                }
            }
        });
    }
    
    public void refresh(UserRegisterView_19552011024 userRegisterView) {
        try {
            UserRegisterView_19552011024.Status.setText("");
            UserRegisterView_19552011024.fullname.setText("");
            UserRegisterView_19552011024.username.setText("");
            UserRegisterView_19552011024.alamat.setText("");
            UserRegisterView_19552011024.nohp.setText("");
            UserRegisterView_19552011024.password.setText("");
            UserRegisterView_19552011024.akses.setSelectedIndex(0);
            UserRegisterView_19552011024.Register.clearSelection();

            loadData(userRegisterView);
            jumlahuser(userRegisterView);
        } catch (Exception error) {
            
        }
    }
    
    public void cari(UserRegisterView_19552011024 userRegisterView){
        try {
            String searchParameter = UserRegisterView_19552011024.cari.getText();
            List<UserEntity_19552011024> list = userList.getListDataByParameter(searchParameter);
            userTabel.setList(list);
            
        } catch (Exception error) {
            
        }
    }
    
    public void jumlahuser(UserRegisterView_19552011024 userRegisterView){
        try{
            JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
            jumlahEntity.setJumlahuser(""+UserRegisterView_19552011024.Register.getRowCount());
            UserRegisterView_19552011024.jumlah.setText(""+UserRegisterView_19552011024.Register.getRowCount());
            jumlahList.updateUser(jumlahEntity);
        }catch (Exception e){
            
        }
    }
    
}
