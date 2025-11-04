-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 04, 2025 at 03:12 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ua`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_transaksi`
--

CREATE TABLE `data_transaksi` (
  `id_transaksi` int NOT NULL,
  `id_user` int DEFAULT NULL,
  `tanggal_transaksi` date NOT NULL,
  `total_transaksi` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `id_umkm` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_transaksi`
--

INSERT INTO `data_transaksi` (`id_transaksi`, `id_user`, `tanggal_transaksi`, `total_transaksi`, `id_umkm`) VALUES
(1, 2, '2025-10-01', '66000', 3),
(2, 2, '2025-10-01', '52000', 3),
(3, 2, '2025-10-02', '67000', 3),
(4, 1, '2025-10-02', '84000', 3),
(5, 2, '2025-10-03', '71000', 3),
(6, 2, '2025-10-03', '49000', 3),
(7, 2, '2025-10-04', '61000', 3),
(8, 2, '2025-10-04', '60000', 3),
(9, 1, '2025-10-04', '65000', 3),
(10, 2, '2025-10-05', '55000', 3),
(11, 2, '2025-10-05', '47000', 3),
(12, 1, '2025-10-06', '88000', 3),
(13, 2, '2025-10-06', '61000', 3),
(14, 2, '2025-10-06', '47000', 3),
(15, 2, '2025-10-07', '54500', 3),
(16, 2, '2025-10-07', '61500', 3),
(17, 1, '2025-10-07', '68500', 3),
(18, 2, '2025-10-08', '55500', 3),
(19, 2, '2025-10-08', '49000', 3),
(20, 2, '2025-10-08', '55000', 3),
(21, 1, '2025-10-09', '70000', 3),
(22, 2, '2025-10-09', '50000', 3),
(23, 2, '2025-10-09', '71000', 3),
(24, 2, '2025-10-10', '61500', 3),
(25, 2, '2025-10-10', '50000', 3),
(26, 1, '2025-10-10', '90000', 3),
(27, 2, '2025-10-11', '62000', 3),
(28, 2, '2025-10-11', '53000', 3),
(29, 2, '2025-10-11', '61500', 3),
(30, 2, '2025-10-12', '53500', 3),
(31, 2, '2025-10-12', '48000', 3),
(32, 1, '2025-10-12', '80500', 3),
(33, 2, '2025-10-13', '56000', 3),
(34, 2, '2025-10-13', '75000', 3),
(35, 2, '2025-10-13', '53000', 3),
(36, 2, '2025-10-14', '80500', 3),
(37, 2, '2025-10-14', '44000', 3),
(53, 31, '2025-11-04', '115000.0', 3);

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detail` int NOT NULL,
  `id_produk` int DEFAULT NULL,
  `id_transaksi` int DEFAULT NULL,
  `jumlah` int NOT NULL,
  `subtotal` int NOT NULL,
  `id_umkm` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_detail`, `id_produk`, `id_transaksi`, `jumlah`, `subtotal`, `id_umkm`) VALUES
(1, 1, 1, 10, 60000, 3),
(2, 2, 1, 3, 36000, 3),
(3, 3, 2, 6, 24000, 3),
(4, 4, 2, 4, 28000, 3),
(5, 5, 3, 5, 35000, 3),
(6, 8, 3, 4, 32000, 3),
(7, 6, 4, 3, 24000, 3),
(8, 7, 4, 4, 36000, 3),
(9, 2, 4, 2, 24000, 3),
(10, 1, 5, 6, 36000, 3),
(11, 5, 5, 5, 35000, 3),
(12, 6, 6, 3, 24000, 3),
(13, 9, 6, 5, 25000, 3),
(14, 10, 7, 5, 35000, 3),
(15, 11, 7, 4, 26000, 3),
(16, 12, 8, 6, 39000, 3),
(17, 13, 8, 3, 21000, 3),
(20, 4, 10, 4, 28000, 3),
(21, 3, 10, 6, 27000, 3),
(22, 13, 11, 3, 21000, 3),
(23, 1, 11, 4, 26000, 3),
(24, 2, 12, 5, 60000, 3),
(25, 4, 12, 4, 28000, 3),
(26, 5, 13, 5, 35000, 3),
(27, 7, 13, 4, 26000, 3),
(28, 6, 14, 4, 32000, 3),
(29, 9, 14, 3, 15000, 3),
(30, 10, 15, 5, 35000, 3),
(31, 3, 15, 3, 19500, 3),
(32, 12, 16, 6, 42000, 3),
(33, 1, 16, 3, 19500, 3),
(34, 2, 17, 3, 36000, 3),
(35, 13, 17, 5, 32500, 3),
(38, 9, 19, 5, 25000, 3),
(39, 8, 19, 4, 24000, 3),
(40, 3, 20, 3, 22500, 3),
(41, 5, 20, 5, 32500, 3),
(42, 11, 21, 6, 42000, 3),
(43, 7, 21, 4, 28000, 3),
(44, 9, 22, 3, 18000, 3),
(45, 6, 22, 4, 32000, 3),
(46, 5, 23, 5, 35000, 3),
(47, 4, 23, 4, 36000, 3),
(49, 11, 24, 6, 42000, 3),
(50, 9, 25, 3, 18000, 3),
(51, 7, 25, 4, 32000, 3),
(52, 2, 26, 6, 72000, 3),
(53, 9, 26, 3, 18000, 3),
(55, 6, 27, 4, 32000, 3),
(56, 10, 28, 5, 35000, 3),
(57, 8, 28, 3, 18000, 3),
(58, 3, 29, 3, 19500, 3),
(59, 12, 29, 6, 42000, 3),
(60, 13, 30, 3, 21000, 3),
(63, 9, 31, 3, 18000, 3),
(64, 2, 32, 4, 48000, 3),
(65, 5, 32, 5, 32500, 3),
(66, 7, 33, 5, 32500, 3),
(67, 1, 33, 5, 30000, 3),
(68, 2, 34, 5, 60000, 3),
(69, 9, 34, 3, 15000, 3),
(70, 6, 35, 10, 80000, 3),
(71, 13, 35, 3, 21000, 3),
(72, 2, 36, 4, 48000, 3),
(73, 5, 36, 5, 32500, 3),
(74, 9, 37, 3, 18000, 3),
(75, 4, 37, 4, 26000, 3),
(95, 5, 53, 10, 70000, 3),
(96, 7, 53, 5, 45000, 3);

-- --------------------------------------------------------

--
-- Table structure for table `laporan`
--

CREATE TABLE `laporan` (
  `id_laporan` int NOT NULL,
  `id_user` int DEFAULT NULL,
  `periode` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `tanggal_awal` date NOT NULL,
  `tanggal_akhir` date NOT NULL,
  `total_penjualan` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `total_keuntungan` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `catatan` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_umkm` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `laporan`
--

INSERT INTO `laporan` (`id_laporan`, `id_user`, `periode`, `tanggal_awal`, `tanggal_akhir`, `total_penjualan`, `total_keuntungan`, `catatan`, `id_umkm`) VALUES
(1, 1, 'Mingguan', '2025-10-01', '2025-10-07', '925000', '240000', 'Penjualan minggu pertama meningkat karena promo roti sobek.', NULL),
(2, 1, 'Mingguan', '2025-10-08', '2025-10-14', '870000', '210000', 'Penjualan stabil, produk paling laris roti keju dan donat gula.', NULL),
(3, 1, 'Mingguan', '2025-10-15', '2025-10-21', '950000', '260000', 'Peningkatan penjualan saat akhir pekan dan pesanan acara.', NULL),
(4, 1, 'Bulanan', '2025-10-01', '2025-10-31', '3750000', '940000', 'Kenaikan omzet 12% dibanding bulan September.', NULL),
(5, 1, 'Bulanan', '2025-09-01', '2025-09-30', '3320000', '865000', 'Penjualan menurun di awal bulan karena cuaca hujan.', NULL),
(6, 1, 'Tahunan', '2025-01-01', '2025-12-31', '42800000', '10100000', 'Tahun 2025 mencatat penjualan tinggi berkat promosi digital dan pelanggan loyal.', NULL),
(7, 1, 'Tahunan', '2024-01-01', '2024-12-31', '38900000', '9400000', 'Penjualan stabil sepanjang tahun 2024, roti keju tetap favorit.', NULL),
(8, 1, 'Tahunan', '2023-01-01', '2023-12-31', '36200000', '8850000', 'Penjualan meningkat dibanding 2022 karena ekspansi toko baru.', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_user` int DEFAULT NULL,
  `posisi` varchar(50) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_user`, `posisi`) VALUES
(2, 'Kasir'),
(3, 'Bagian Produksi'),
(31, 'Kasir');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int NOT NULL,
  `nama_pelanggan` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `alamat` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `no_hp` char(13) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pemilik`
--

CREATE TABLE `pemilik` (
  `id_user` int DEFAULT NULL,
  `masa_jabatan` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemilik`
--

INSERT INTO `pemilik` (`id_user`, `masa_jabatan`) VALUES
(1, NULL),
(21, '5');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id_produk` int NOT NULL,
  `id_user` int DEFAULT NULL,
  `nama_produk` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `kategori` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `harga` int NOT NULL,
  `stok` int NOT NULL,
  `deskripsi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_umkm` int DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id_produk`, `id_user`, `nama_produk`, `kategori`, `harga`, `stok`, `deskripsi`, `id_umkm`, `is_active`) VALUES
(1, 1, 'baju', 'Pakaian', 6000, 38, 'Roti lembut isi coklat, dibuat setiap pagi.', 3, 1),
(2, 1, 'Roti Tawar Gandum', 'Roti Tawar', 12000, 23, 'Roti sehat berbahan gandum utuh, tanpa pengawet.', 3, 1),
(3, 3, 'Donat Gula', 'Snack Tradisional', 4000, 62, 'Donat klasik tabur gula halus, favorit pelanggan.', 3, 1),
(4, 1, 'Roti Keju Susu', 'Roti Manis', 7000, 45, 'Roti isi keju dan susu dengan tekstur lembut.', 3, 1),
(5, 3, 'Roti Pisang Coklat', 'Roti Manis', 7000, 50, 'Roti isi pisang dan coklat, cocok untuk anak-anak.', 3, 1),
(6, 3, 'Roti Sosis Mayo', 'Roti Gurih', 8000, 27, 'Roti berisi sosis dan saus mayo, laris untuk sarapan.', 3, 1),
(7, 3, 'Roti Abon Pedas', 'Roti Gurih', 9000, 16, 'Roti lembut dengan abon sapi pedas khas toko.', 3, 1),
(8, 1, 'Kue Lapis Pelangi', 'Snack Tradisional', 5000, 59, 'Kue lapis berwarna-warni dengan rasa manis legit.', 3, 1),
(9, 3, 'Kue Klepon', 'Snack Tradisional', 3000, 60, 'Klepon isi gula merah, kenyal dan gurih.', 3, 1),
(10, 3, 'Kue Dadar Gulung', 'Snack Tradisional', 4000, 60, 'Kulit hijau pandan berisi kelapa parut manis.', 3, 1),
(11, 1, 'Roti Coklat Kacang', 'Roti Manis', 7500, 40, 'Roti isi coklat kacang dengan topping wijen.', 3, 1),
(12, 3, 'Brownies Kukus', 'Kue Basah', 10000, -90, 'Brownies kukus lembut dan coklat pekat.', 3, 1),
(13, 3, 'Roti Pandan Keju', 'Roti Manis', 6500, 40, 'Roti aroma pandan isi keju parut.', 3, 1),
(27, 21, 'Baju Batman', 'Pakaian', 10000, 10, 'Bagus', 3, 1),
(28, 31, 'BajuBagus', 'Pakaian', 100000, 10, 'Mantap', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `umkm`
--

CREATE TABLE `umkm` (
  `id_umkm` int NOT NULL,
  `nama_usaha` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `alamat_usaha` varchar(100) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `umkm`
--

INSERT INTO `umkm` (`id_umkm`, `nama_usaha`, `alamat_usaha`) VALUES
(1, 'Roti Manis Mulia', 'Jl. Pahlawan No. 12, Samarinda, Kalimantan Timur'),
(2, 'Toko Berkah Inoa', 'Perum PKL Blok D Rt 5'),
(3, 'FarisToko', 'PulauPanjang'),
(4, 'Samarindaumkm', 'Perjuangan'),
(5, 'FarisStore', 'PulauPanjang');

-- --------------------------------------------------------

--
-- Table structure for table `user_umkm`
--

CREATE TABLE `user_umkm` (
  `id_user` int NOT NULL,
  `id_umkm` int DEFAULT NULL,
  `nama` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password` char(20) COLLATE utf8mb4_general_ci NOT NULL,
  `kontak` char(20) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_umkm`
--

INSERT INTO `user_umkm` (`id_user`, `id_umkm`, `nama`, `username`, `password`, `kontak`) VALUES
(1, 1, 'Rina Anggraini', 'rinaowner', 'owner123', '081234567890'),
(2, 1, 'Siti Mariani', 'sitipegawai', 'pegawai123', '081298765432'),
(3, 1, 'Dewi Rahma', 'dewipegawai', 'pegawai321', '081356789012'),
(20, 2, 'Mohamad', 'rissysaputra', 'zxuan123', '082223427594'),
(21, 3, 'Abdurah', 'Abdurrahman1', '123', '085828237918'),
(31, 3, 'Vielys', 'Viely43210', '123', '0838832828');

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_riwayat_penjualan`
-- (See below for the actual view)
--
CREATE TABLE `view_riwayat_penjualan` (
`id_transaksi` int
,`tanggal_transaksi` date
,`total_transaksi` varchar(50)
,`NAMA_PEGAWAI` varchar(100)
,`NAMA_UMKM` varchar(100)
);

-- --------------------------------------------------------

--
-- Structure for view `view_riwayat_penjualan`
--
DROP TABLE IF EXISTS `view_riwayat_penjualan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_riwayat_penjualan`  AS SELECT `dt`.`id_transaksi` AS `id_transaksi`, `dt`.`tanggal_transaksi` AS `tanggal_transaksi`, `dt`.`total_transaksi` AS `total_transaksi`, `u`.`nama` AS `NAMA_PEGAWAI`, `um`.`nama_usaha` AS `NAMA_UMKM` FROM ((`data_transaksi` `dt` join `user_umkm` `u` on((`dt`.`id_user` = `u`.`id_user`))) join `umkm` `um` on((`dt`.`id_umkm` = `um`.`id_umkm`))) ORDER BY `dt`.`tanggal_transaksi` AS `DESCdesc` ASC  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_transaksi`
--
ALTER TABLE `data_transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_transaksi_user` (`id_user`),
  ADD KEY `fk_data_transaksi_umkm` (`id_umkm`);

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `fk_detail_produk` (`id_produk`),
  ADD KEY `fk_detail_transaksi` (`id_transaksi`),
  ADD KEY `fk_detail_transaksi_umkm` (`id_umkm`);

--
-- Indexes for table `laporan`
--
ALTER TABLE `laporan`
  ADD PRIMARY KEY (`id_laporan`),
  ADD KEY `fk_laporan_user` (`id_user`),
  ADD KEY `fk_laporan_umkm` (`id_umkm`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD KEY `fk_posisi_user` (`id_user`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `pemilik`
--
ALTER TABLE `pemilik`
  ADD KEY `fk_masajabatan_user` (`id_user`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_produk`),
  ADD KEY `fk_produk_user` (`id_user`),
  ADD KEY `fk_produk_umkm` (`id_umkm`);

--
-- Indexes for table `umkm`
--
ALTER TABLE `umkm`
  ADD PRIMARY KEY (`id_umkm`);

--
-- Indexes for table `user_umkm`
--
ALTER TABLE `user_umkm`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `fk_user_umkm` (`id_umkm`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_transaksi`
--
ALTER TABLE `data_transaksi`
  MODIFY `id_transaksi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id_detail` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `id_produk` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `umkm`
--
ALTER TABLE `umkm`
  MODIFY `id_umkm` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_umkm`
--
ALTER TABLE `user_umkm`
  MODIFY `id_user` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_transaksi`
--
ALTER TABLE `data_transaksi`
  ADD CONSTRAINT `fk_data_transaksi_umkm` FOREIGN KEY (`id_umkm`) REFERENCES `umkm` (`id_umkm`),
  ADD CONSTRAINT `fk_transaksi_user` FOREIGN KEY (`id_user`) REFERENCES `user_umkm` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `fk_detail_produk` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_detail_transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `data_transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_detail_transaksi_umkm` FOREIGN KEY (`id_umkm`) REFERENCES `umkm` (`id_umkm`);

--
-- Constraints for table `laporan`
--
ALTER TABLE `laporan`
  ADD CONSTRAINT `fk_laporan_umkm` FOREIGN KEY (`id_umkm`) REFERENCES `umkm` (`id_umkm`),
  ADD CONSTRAINT `fk_laporan_user` FOREIGN KEY (`id_user`) REFERENCES `user_umkm` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `fk_posisi_user` FOREIGN KEY (`id_user`) REFERENCES `user_umkm` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `pemilik`
--
ALTER TABLE `pemilik`
  ADD CONSTRAINT `fk_masajabatan_user` FOREIGN KEY (`id_user`) REFERENCES `user_umkm` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `produk`
--
ALTER TABLE `produk`
  ADD CONSTRAINT `fk_produk_umkm` FOREIGN KEY (`id_umkm`) REFERENCES `umkm` (`id_umkm`),
  ADD CONSTRAINT `fk_produk_user` FOREIGN KEY (`id_user`) REFERENCES `user_umkm` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `user_umkm`
--
ALTER TABLE `user_umkm`
  ADD CONSTRAINT `fk_user_umkm` FOREIGN KEY (`id_umkm`) REFERENCES `umkm` (`id_umkm`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
