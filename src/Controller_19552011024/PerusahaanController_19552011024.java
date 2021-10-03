/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;

import View_19552011024.PerusahaanView_19552011024;
import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 *
 * @author User
 */
//Pembuat
//Nama = Muhammad Ikhwan Fathulloh
//NPM = 19552011024
//Jurusan = Teknik Informatika
//Kampus = Sekolah Tinggi Teknologi Bandung

//Media Sosial
//Youtube = Muhammad Ikhwan Fathulloh
//Blog = muhammadikhwanfathulloh.blogspot.com
//Gmail = muhammadikhwanfathulloh17@gmail.com
public class PerusahaanController_19552011024 {
    private static String className = "KeuanganController";
    public void maximazieWindowsHome(PerusahaanView_19552011024 perusahaanView) {
        try {
            perusahaanView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
}
