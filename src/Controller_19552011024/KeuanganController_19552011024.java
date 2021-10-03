/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;

import Entity_19552011024.JumlahEntity_19552011024;
import Entity_19552011024.KeuanganEntity_19552011024;
import List_19552011024.JumlahdataList_19552011024;
import List_19552011024.KeuanganList_19552011024;
import Tabel_19552011024.KeuanganTabel_19552011024;
import View_19552011024.KeuanganView_19552011024;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.List;

/**
 *
 * @author User
 */
public class KeuanganController_19552011024 {
    private static String className = "KeuanganController";
    public static KeuanganTabel_19552011024 keuanganTabel = new KeuanganTabel_19552011024();
    public static KeuanganList_19552011024 keuanganList = new KeuanganList_19552011024();
    public static JumlahdataList_19552011024 jumlahList = new JumlahdataList_19552011024();
    
    public void maximazieWindowsKeuangan(KeuanganView_19552011024 keuanganView) {
        try {
            keuanganView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
    
    public void setTableModel(KeuanganView_19552011024 keuanganView) {
        try {
            KeuanganView_19552011024.Keuangan.setModel(keuanganTabel);
        } catch (Exception e) {
            
        }
    }
    
    public void loadData(KeuanganView_19552011024 keuanganView) {
        try {
            List<KeuanganEntity_19552011024> list = keuanganList.getListData();
            keuanganTabel.setList(list);
        } catch (Exception e) {
           
        }
        jumlahdata(keuanganView);
    }
    
    public void jumlahdata(KeuanganView_19552011024 keuanganView){
        try {
            int total = 0;
            for (int i =0; i< KeuanganView_19552011024.Keuangan.getRowCount(); i++){
                total = total + Integer.parseInt(KeuanganView_19552011024.Keuangan.getValueAt(i, 2).toString());
            }
            KeuanganView_19552011024.datakeuangan.setText(Integer.toString(total));
        } catch (Exception e) {
           
        }
    }
    
    public void jumlahpenjualan(KeuanganView_19552011024 keuanganView){
        try{
            JumlahEntity_19552011024 jumlahEntity = new JumlahEntity_19552011024();
            jumlahEntity.setJumlahpenjualan(""+KeuanganView_19552011024.Keuangan.getRowCount());
            KeuanganView_19552011024.jumlah.setText(""+KeuanganView_19552011024.Keuangan.getRowCount());
            jumlahList.updatePenjualan(jumlahEntity);
            
        }catch (Exception e){
            
        }
    }
}
