/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity_19552011024;
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
public class KategoriEntity_19552011024 {
    private String kategori_kode;
    private String kategori_barang;
    
    //Kategori Kode
    public String getkategori_kode() {
        return kategori_kode;
    }
    public void setkategori_kode(String kategori_kode) {
        this.kategori_kode = kategori_kode;
    }
    //Kategori Barang
    public String getkategori_barang() {
        return kategori_barang;
    }
    public void setkategori_barang(String kategori_barang) {
        this.kategori_barang = kategori_barang;
    }
}
