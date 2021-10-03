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
public class DetailBarangEntity_19552011024 {
    private static String kode_barang;
    private static String nama_barang;
    private static String kategori_barang;
    private static int harga_barang;
    private static int stok_barang;
    private static String tanggal;
    
    //Kode Barang
    public String getkode_barang() {
        return kode_barang;
    }
    public void setkode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }
    //Nama Barang
    public String getnama_barang() {
        return nama_barang;
    }
    public void setnama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }
    //Kategori Barang
    public String getkategori_barang() {
        return kategori_barang;
    }
    public void setkategori_barang(String kategori_barang) {
        this.kategori_barang = kategori_barang;
    }
    //Harga Barang
    public int getharga_barang() {
        return harga_barang;
    }
    public void setharga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
    }
    //Stok Barang
    public int getstok_barang() {
        return stok_barang;
    }
    public void setstok_barang(int stok_barang) {
        this.stok_barang = stok_barang;
    }
    //Tanggal
    public String gettanggal() {
        return tanggal;
    }
    public void settanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
