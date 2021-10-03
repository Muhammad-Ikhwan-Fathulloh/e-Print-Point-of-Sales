/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report_19552011024;

import Database_19552011024.Database_19552011024;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;
import View_19552011024.KeuanganView_19552011024;
import java.io.File;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
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
public class ReportController_19552011024 {
    
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    
    Map<String, Object> parameter = new HashMap<String, Object>();
    
    public void cetakDataBarang()throws JRException, SQLException{
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("DataBarang.jasper"), null, Database_19552011024.configDB());
        JasperViewer.viewReport(jp, false);
    }
    public void cetakDataUser()throws JRException, SQLException{
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("DataUser.jasper"), null, Database_19552011024.configDB());
        JasperViewer.viewReport(jp, false);
    }
    public void cetakDataToko()throws JRException, SQLException{
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("DataToko.jasper"), null, Database_19552011024.configDB());
        JasperViewer.viewReport(jp, false);
    }
    
    public void cetakDataKeuangan(KeuanganView_19552011024 keuanganView)throws JRException, SQLException{
        try{
            parameter.put("tgldari", keuanganView.tglFrom);
            parameter.put("tglsampai", keuanganView.tglUntil);
            File file = new File("src/Report_19552011024/DataKeuangan.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameter,Database_19552011024.configDB());
            JasperViewer.viewReport(jasperPrint, false);
        }catch(Exception e) {
            
        } 
    }
    public void cetakDataPenjualan()throws JRException, SQLException{
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("DataPenjualan.jasper"), null, Database_19552011024.configDB());
        JasperViewer.viewReport(jp, false);
    }
}
