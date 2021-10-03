-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 11, 2021 at 07:18 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perusahaan_eprint`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(100) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `kategori_barang` varchar(100) NOT NULL,
  `harga_barang` int(100) NOT NULL,
  `stok_barang` int(100) NOT NULL,
  `tanggal` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama_barang`, `kategori_barang`, `harga_barang`, `stok_barang`, `tanggal`) VALUES
('B-0000001', 'Bulk Ink L Series 80 ml', 'Tinta', 34200, 80, '2/4/21'),
('B-0000002', 'Bulk Ink HP GT Series', 'Tinta', 31350, 80, '2/6/21'),
('B-0000003', 'Bulk Ink Reguler 100 ml', 'Tinta', 28025, 90, '2/4/21'),
('B-0000004', 'Bulk Ink Reguler 200 ml', 'Tinta', 48355, 80, '2/4/21'),
('B-0000005', 'Bulk Ink Art Paper', 'Tinta', 90250, 80, '2/4/21'),
('B-0000006', 'Bulk Ink Reguler 1 Kg', 'Tinta', 149625, 80, '2/4/21'),
('B-0000007', 'Super Black Pigment', 'Tinta', 30923, 80, '2/4/21'),
('B-0000008', 'Sublimation Ink', 'Tinta', 59850, 80, '2/4/21'),
('B-0000009', 'Tabung CISS Reguler', 'Tinta', 54863, 70, '2/6/21'),
('B-0000010', 'Refill Kit Blister', 'Tinta', 19760, 100, '2/11/21'),
('B-0000011', 'Refill Kit Gold', 'Tinta', 23940, 100, '2/4/21'),
('B-0000012', 'Toner Cartridge HP-CE285A', 'Toner', 342000, 100, '2/4/21'),
('B-0000013', 'Toner Cartridge HP-CE278A', 'Toner', 342000, 90, '2/4/21'),
('B-0000014', 'Toner Cartridge HP-CE435A', 'Toner', 342000, 100, '2/4/21'),
('B-0000015', 'Toner Cartridge HP-CE436A', 'Toner', 342000, 90, '2/4/21'),
('B-0000016', 'Toner Cartridge HP-CC388A', 'Toner', 342000, 100, '2/4/21'),
('B-0000017', 'Toner Cartridge HP-CF283A', 'Toner', 361000, 100, '2/4/21'),
('B-0000018', 'Toner Cartridge HP-CE505A', 'Toner', 361000, 90, '2/4/21'),
('B-0000019', 'Toner Cartridge HP-CF280A', 'Toner', 361000, 100, '2/4/21'),
('B-0000020', 'Refill Toner Premium 100 gram', 'Toner', 27550, 100, '2/4/21'),
('B-0000021', 'Refill Toner Premium 500 gram', 'Toner', 67450, 100, '2/4/21'),
('B-0000022', 'Refill Toner Premium 1 Kg', 'Toner', 122645, 100, '2/4/21'),
('B-0000023', 'Cartridge Ribbon CR 2170 LL', 'Ribbon', 67450, 100, '2/4/21'),
('B-0000024', 'Cartridge Ribbon CR 2170 I', 'Ribbon', 49590, 100, '2/4/21'),
('B-0000025', 'Cartridge Ribbon CR 8750 LL', 'Ribbon', 16910, 100, '2/4/21'),
('B-0000026', 'Cartridge Ribbon CR 8750 I', 'Ribbon', 12730, 100, '2/4/21'),
('B-0000027', 'Cartridge Ribbon CR FX2190 LL', 'Ribbon', 57000, 100, '2/4/21'),
('B-0000028', 'Cartridge Ribbon CR PLQ-20 LL', 'Ribbon', 75525, 80, '2/4/21'),
('B-0000029', 'Refill Ribbon RR 2170 LL', 'Ribbon', 22657, 100, '2/4/21'),
('B-0000030', 'Refill Ribbon RR 2170 I', 'Ribbon', 16055, 100, '2/4/21'),
('B-0000031', 'Refill Ribbon RR 7755 LL', 'Ribbon', 7410, 100, '2/4/21'),
('B-0000032', 'Refill Ribbon RR 7755 I', 'Ribbon', 5320, 100, '2/4/21'),
('B-0000033', 'Refill Ribbon RR 8758 LL', 'Ribbon', 7410, 100, '2/4/21'),
('B-0000034', 'Refill Ribbon RR 8758 I', 'Ribbon', 5700, 100, '2/4/21'),
('B-0000035', 'Cartridge ERC 30/34/38', 'Ribbon', 18335, 90, '2/4/21'),
('B-0000036', 'Cartridge LX-310', 'Ribbon', 25650, 100, '2/4/21'),
('B-0000037', 'Refill ERC 30/34/38', 'Ribbon', 3325, 100, '2/4/21'),
('B-0000038', 'Cartridge LQ-310', 'Ribbon', 25650, 100, '2/4/21'),
('B-0000039', 'Glossy Paper Blue A4 200 gsm', 'Photo Paper', 24700, 100, '2/4/21'),
('B-0000040', 'Glossy Black & White A4 200 gsm', 'Photo Paper', 20045, 90, '2/4/21'),
('B-0000041', 'Double Side Glossy A4 150 gsm', 'Photo Paper', 24178, 100, '2/4/21'),
('B-0000042', 'Sticker Glossy Paper A4 135 gsm', 'Photo Paper', 26503, 100, '2/4/21'),
('B-0000043', 'Glossy Photo Paper A4 120 gsm', 'Photo Paper', 59280, 80, '2/4/21'),
('B-0000044', 'Glossy Photo Paper A4 120 gsm', 'Photo Paper', 31160, 80, '2/4/21'),
('B-0000045', 'Glossy Paper Aluminium Pack A4 180 gsm', 'Photo Paper', 15723, 80, '2/4/21'),
('B-0000046', 'Glossy Paper Aluminium Pack A4 200 gsm', 'Photo Paper', 17575, 100, '2/4/21'),
('B-0000047', 'Glossy Paper Aluminium Pack A4 230 gsm', 'Photo Paper', 18763, 80, '2/4/21'),
('B-0000048', 'Glossy Paper A4 210 gsm', 'Photo Paper', 17290, 100, '2/4/21'),
('B-0000049', 'Double Side High Glossy A4 230 gsm', 'Photo Paper', 33393, 100, '2/4/21'),
('B-0000050', 'Glossy Photo Paper A4 230 gsm', 'Photo Paper', 31445, 100, '2/6/21'),
('B-0000051', 'Super Glossy Paper Yellow A4 230 gsm', 'Photo Paper', 24748, 100, '2/5/21'),
('B-0000052', '4R Glossy Paper 200 gsm', 'Photo Paper', 7505, 100, '2/5/21'),
('B-0000053', 'Super Glossy Folio F4 230 gsm', 'Photo Paper', 28453, 100, '2/5/21'),
('B-0000054', 'Double Side Glossy Folio F4 230 gsm', 'Photo Paper', 40518, 100, '2/5/21'),
('B-0000055', 'Glossy Photo Paper A3 260 gsm', 'Photo Paper', 55623, 80, '2/5/21'),
('B-0000056', 'Glossy Photo Paper A4 260 gsm', 'Photo Paper', 19950, 100, '2/5/21'),
('B-0000057', 'Sticker Matte A4 100 gsm', 'Photo Paper', 26458, 100, '2/5/21'),
('B-0000058', 'Inkjet Paper A4 108 gsm', 'Photo Paper', 35055, 100, '2/5/21'),
('B-0000059', 'Double Side Matte A4 220 gsm', 'Photo Paper', 37525, 100, '2/5/21'),
('B-0000060', 'Double Side Matte A4 220 gsm', 'Photo Paper', 19333, 90, '2/5/21'),
('B-0000061', 'Inkjet Paper Folio F4 108 gsm', 'Photo Paper', 32063, 80, '2/5/21'),
('B-0000062', 'Matte Inkjet Folio F4 128 gsm', 'Photo Paper', 34580, 80, '2/5/21'),
('B-0000063', 'Double Side Matte Folio F4 220 gsm', 'Photo Paper', 43558, 100, '2/5/21'),
('B-0000064', 'Matte Inkjet A3 130 gsm', 'Photo Paper', 38000, 70, '2/5/21'),
('B-0000065', 'Matte Inkjet A4 200 gsm', 'Photo Paper', 80465, 80, '2/5/21'),
('B-0000066', 'Silky Gold Photo Paper A4 260 gsm', 'Photo Paper', 49543, 100, '2/5/21'),
('B-0000067', '4R Silky 260 gsm', 'Photo Paper', 10735, 100, '2/5/21'),
('B-0000068', 'RC Satin A4 260 gsm', 'Photo Paper', 39758, 90, '2/5/21'),
('B-0000069', 'Transparent Sticker A4 150 gsm', 'Photo Paper', 30732, 100, '2/5/21'),
('B-0000070', 'Art Paper A4 150 gsm', 'Photo Paper', 21280, 100, '2/5/21'),
('B-0000071', 'Light T-Shirt Transfer Paper A4 150 gsm', 'Photo Paper', 36290, 90, '2/5/21'),
('B-0000072', 'Dark T-Shirt Transfer Paper A4 ', 'Photo Paper', 60705, 100, '2/5/21'),
('B-0000073', 'Fine Art Paper A4 210 gsm', 'Photo Paper', 41135, 80, '2/5/21'),
('B-0000074', 'Microporous Paper A4 260 gsm', 'Photo Paper', 43985, 90, '2/5/21'),
('B-0000075', 'Laminating Film A4+', 'Photo Paper', 33440, 90, '2/5/21'),
('B-0000076', 'PVC Card Laminating 200mm x 300mm', 'Photo Paper', 36955, 100, '2/5/21'),
('B-0000077', 'Laminating Pouch A4 ', 'Laminating Film', 79350, 90, '2/5/21'),
('B-0000078', 'Laminating Pouch F4', 'Laminating Film', 80500, 90, '2/5/21'),
('B-0000079', 'Laminating Pouch A3', 'Laminating Film', 183873, 100, '2/5/21'),
('B-0000080', 'Laminating Glossy Roll 330mm x 150mm', 'Laminating Film', 124973, 100, '2/5/21'),
('B-0000081', 'Laminating Doff Roll 330mm x 150mm', 'Laminating Film', 130198, 90, '2/5/21'),
('B-0000082', 'Laminating Pouch KTP 100 mic', 'Laminating Film', 10692, 100, '2/5/21'),
('B-0000083', 'Laminating Pouch KTP 250 mic', 'Laminating Film', 21384, 90, '2/5/21'),
('B-0000084', 'Laminating Pouch A4S 100 mic', 'Laminating Film', 80300, 90, '2/5/21'),
('B-0000085', 'Full Hijau 210mm x 30m', 'Themper', 22140, 80, '2/5/21'),
('B-0000086', 'Full Hijau 216mm x 30m', 'Themper', 22140, 90, '2/5/21'),
('B-0000087', 'Standar Merah 210mm x 30m', 'Themper', 12600, 80, '2/5/21'),
('B-0000088', 'Standar Merah 216mm x 30m', 'Themper', 12600, 100, '2/5/21'),
('B-0000089', 'Standar Merah E-FAX 210mm x 30m', 'Themper', 9840, 90, '2/5/21'),
('B-0000090', 'Cash Register 57mm x 30mm', 'Themper', 4140, 100, '2/5/21'),
('B-0000091', 'Cash Register 57mm x 50mm', 'Themper', 5900, 90, '2/5/21'),
('B-0000092', 'Cash Register 80mm x 50mm', 'Themper', 7740, 100, '2/5/21'),
('B-0000093', 'Cash Register 80mm x 80mm', 'Themper', 17700, 100, '2/5/21'),
('B-0000094', 'Cash Register EDC', 'Themper', 3660, 100, '2/5/21'),
('B-0000095', 'Cash Register 80mm x 140mm', 'Themper', 73740, 100, '2/5/21'),
('B-0000096', 'Cash Register 80mm x 160mm', 'Themper', 82700, 90, '2/5/21'),
('B-0000097', 'Cash Register 80mm x 180mm', 'Themper', 94620, 90, '2/5/21'),
('B-0000098', 'Cash Register 57mm x 50mm C 22 m', 'Themper', 4850, 90, '2/5/21'),
('B-0000099', 'Cash Register 80mm x 80mm C 63 m', 'Themper', 14850, 90, '2/5/21'),
('B-0000100', 'Papercraft Level 1', 'Papercraft', 14464, 90, '2/5/21'),
('B-0000101', 'Papercraft Level 2', 'Papercraft', 14464, 90, '2/5/21'),
('B-0000102', 'Papercraft Level 3', 'Papercraft', 14464, 90, '2/5/21'),
('B-0000103', 'Photo Album', 'Lain-lain', 48878, 90, '2/5/21'),
('B-0000104', 'Head Cleaner', 'Lain-lain', 31421, 100, '2/5/21'),
('B-0000105', 'Papercraft Level 4', 'Papercraft', 17000, 100, '2/11/21');

-- --------------------------------------------------------

--
-- Table structure for table `datatoko`
--

CREATE TABLE `datatoko` (
  `kode_toko` varchar(100) NOT NULL,
  `nama_toko` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `nohp` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datatoko`
--

INSERT INTO `datatoko` (`kode_toko`, `nama_toko`, `alamat`, `nohp`) VALUES
('T-0000001', 'Merauke', 'Kota Bandung', '0858'),
('T-0000002', 'Serbaneka', 'Kota Bandung', '0858'),
('T-0000003', 'Toko Sejahtera', 'Kota Bandung', '0858'),
('T-0000004', 'Anwar Toko', 'Kota Bandung', '0858'),
('T-0000005', 'Toko ATK', 'Kota Bandung', '0858'),
('T-0000006', 'Megacomp', 'Kota Bandung', '0858'),
('T-0000007', 'Ameera Computer', 'Kota Bandung', '0858'),
('T-0000008', 'Berkah Utama CV', 'Kota Bandung', '0858'),
('T-0000009', 'Jaya FC', 'Kota Bandung', '0858'),
('T-0000010', 'Asia FC', 'Kota Bandung', '0858'),
('T-0000011', 'Garuda Comp', 'Kota Bandung', '0858'),
('T-0000012', 'Rajawali FC', 'Kota Bandung', '0858'),
('T-0000013', 'Elang FC', 'Kota Bandung', '0858'),
('T-0000014', 'Sriwijaya FC', 'Kota Bandung', '0858');

-- --------------------------------------------------------

--
-- Table structure for table `detail_penjualan`
--

CREATE TABLE `detail_penjualan` (
  `kode_order` varchar(100) NOT NULL,
  `kode_barang` varchar(100) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `harga_barang` int(100) NOT NULL,
  `jumlah_barang` int(100) NOT NULL,
  `total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jumlahdata`
--

CREATE TABLE `jumlahdata` (
  `id` int(100) NOT NULL,
  `jumlah_barang` int(100) NOT NULL,
  `jumlah_user` int(100) NOT NULL,
  `jumlah_kategori` int(100) NOT NULL,
  `jumlah_toko` int(100) NOT NULL,
  `jumlah_penjualan` int(100) NOT NULL,
  `no_faktur` varchar(100) NOT NULL,
  `nama_toko` varchar(100) NOT NULL,
  `sales` varchar(100) NOT NULL,
  `admin` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jumlahdata`
--

INSERT INTO `jumlahdata` (`id`, `jumlah_barang`, `jumlah_user`, `jumlah_kategori`, `jumlah_toko`, `jumlah_penjualan`, `no_faktur`, `nama_toko`, `sales`, `admin`) VALUES
(1, 105, 10, 9, 14, 12, 'F-0000012', 'Sriwijaya FC', 'Kusuma Priatna', 'Farah Nurul Aini');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `kategori_kode` varchar(100) NOT NULL,
  `kategori_barang` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`kategori_kode`, `kategori_barang`) VALUES
('K-0000001', 'Photo Paper'),
('K-0000002', 'Tinta'),
('K-0000003', 'Toner'),
('K-0000004', 'Themper'),
('K-0000005', 'Laminating Film'),
('K-0000006', 'Ribbon'),
('K-0000007', 'Papercraft'),
('K-0000008', 'Lain-lain'),
('K-0000009', 'Printing');

-- --------------------------------------------------------

--
-- Table structure for table `keuangan`
--

CREATE TABLE `keuangan` (
  `no_faktur` varchar(100) NOT NULL,
  `nama_toko` varchar(100) NOT NULL,
  `total` int(100) NOT NULL,
  `tanggal` date NOT NULL,
  `sales` varchar(100) NOT NULL,
  `admin` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `keuangan`
--

INSERT INTO `keuangan` (`no_faktur`, `nama_toko`, `total`, `tanggal`, `sales`, `admin`) VALUES
('F-0000001', 'Serbaneka', 221400, '2021-02-08', 'Muhammad Ikhwan Fathulloh', 'Muhammad Ikhwan Fathulloh'),
('F-0000002', 'Merauke', 221400, '2021-02-01', 'Muhammad Ikhwan Fathulloh', 'Muhammad Ikhwan Fathulloh'),
('F-0000003', 'Merauke', 221400, '2021-02-20', 'Muhammad Ikhwan Fathulloh', 'Muhammad Ikhwan Fathulloh'),
('F-0000004', 'Merauke', 48500, '2021-02-09', 'Farah Nurul Aini', 'Farah Nurul Aini'),
('F-0000005', 'Megacomp', 3610000, '2021-02-10', 'Muhammad Ikhwan Fathulloh', 'Muhammad Ikhwan Fathulloh'),
('F-0000006', 'Berkah Utama CV', 1097260, '2021-02-10', 'Muhammad Ikhwan Fathulloh', 'Muhammad Ikhwan Fathulloh'),
('F-0000007', 'Anwar Toko', 1185600, '2021-02-10', 'Muhammad Ikhwan Fathulloh', 'Muhammad Ikhwan Fathulloh'),
('F-0000008', 'Merauke', 641260, '2021-02-11', 'Kusuma Priatna', 'Farah Nurul Aini'),
('F-0000009', 'Garuda Comp', 691600, '2021-02-11', 'Kusuma Priatna', 'Farah Nurul Aini'),
('F-0000010', 'Toko', 623200, '2021-02-11', 'Kusuma Priatna', 'Farah Nurul Aini'),
('F-0000011', 'Elang FC', 375260, '2021-02-11', 'Kusuma Priatna', 'Farah Nurul Aini'),
('F-0000012', 'Sriwijaya FC', 1112460, '2021-02-11', 'Kusuma Priatna', 'Farah Nurul Aini');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `no_faktur` varchar(100) NOT NULL,
  `kode_order` varchar(100) NOT NULL,
  `nama_toko` varchar(100) NOT NULL,
  `kode_barang` varchar(100) NOT NULL,
  `jumlah_barang` int(100) NOT NULL,
  `total` int(100) NOT NULL,
  `tanggal` varchar(100) NOT NULL,
  `sales` varchar(100) NOT NULL,
  `admin` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `toko`
--

CREATE TABLE `toko` (
  `kode_order` varchar(100) NOT NULL,
  `nama_toko` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `kode_barang` varchar(100) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `harga_barang` int(100) NOT NULL,
  `jumlah_barang` int(100) NOT NULL,
  `tanggal` varchar(100) NOT NULL,
  `sales` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `fullname` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `nohp` int(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `akses` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`fullname`, `username`, `alamat`, `nohp`, `password`, `akses`) VALUES
('Ahmad Muslih', 'Ahmad', 'Kota Bandung', 858, '1234', 'Admin Master'),
('Argo Priawan', 'Argo', 'Kota Bogor', 858, '1234', 'Sales'),
('Budiman', 'Budiman', 'Kota Bandung', 858, '1234', 'Petugas Penjualan'),
('Cahaya Abadi', 'Cahaya', 'Kota Bandung', 858, '1234', 'Petugas Gudang'),
('Farah Nurul Aini', 'Farah', 'Kota Bandung', 858, '1234', 'Petugas Penjualan'),
('Gatot Subroto', 'Gatot', 'Kota Bekasi', 858, '1234', 'Petugas Penjualan'),
('Muhammad Ikhwan Fathulloh', 'Ikhwan', 'Kota Jakarta', 858, '1234', 'Admin Master'),
('Kusuma Priatna', 'Kusuma', 'Kota Bandung', 858, '1234', 'Sales'),
('Farah Quin', 'Quin', 'Kota Bandung', 858, '1234', 'Petugas Penjualan'),
('Radi Hendrawan', 'Radi', 'Kota Bekasi', 858, '1234', 'Sales');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indexes for table `datatoko`
--
ALTER TABLE `datatoko`
  ADD PRIMARY KEY (`kode_toko`);

--
-- Indexes for table `jumlahdata`
--
ALTER TABLE `jumlahdata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`kategori_kode`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`no_faktur`);

--
-- Indexes for table `toko`
--
ALTER TABLE `toko`
  ADD PRIMARY KEY (`kode_order`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jumlahdata`
--
ALTER TABLE `jumlahdata`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
