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
public class TokoEntity_19552011024 {
    private String kode_order;
    private String nama_toko;
    private String alamat;
    private String kode_barang;
    private String nama_barang;
    private int harga_barang;
    private int jumlah_barang;
    private int total;
    private String tanggal;
    private String sales;
    
    //Kode Order
    public String getkode_order() {
        return kode_order;
    }
    public void setkode_order(String kode_order) {
        this.kode_order = kode_order;
    }
    //Nama Toko
    public String getnama_toko() {
        return nama_toko;
    }
    public void setnama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }
    //Alamat
    public String getalamat() {
        return alamat;
    }
    public void setalamat(String alamat) {
        this.alamat = alamat;
    }
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
    //Harga Barang
    public int getharga_barang() {
        return harga_barang;
    }
    public void setharga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
    }
    //Jumlah Barang
    public int getjumlah_barang() {
        return jumlah_barang;
    }
    public void setjumlah_barang(int jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }
    //Tanggal
    public String gettanggal() {
        return tanggal;
    }
    public void settanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    //Sales
    public String getsales() {
        return sales;
    }
    public void setsales(String sales) {
        this.sales = sales;
    }
}
