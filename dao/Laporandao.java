package dao;

import config.DatabaseConnection;
import model.AnalisisProduk;
import model.RingkasanOmzet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Laporandao {

    /**
     * Sesuai flowchart: Analisis Produk Terlaris/Tidak Laris
     * Mengambil data penjualan produk berdasarkan periode.
     * order: "DESC" untuk terlaris, "ASC" untuk tidak laris.
     */
    public List<AnalisisProduk> getAnalisisProduk(int id_umkm, Date tanggalAwal, Date tanggalAkhir, String order) {
        List<AnalisisProduk> hasilAnalisis = new ArrayList<>();
        
        String sql = "SELECT p.nama_produk, SUM(dt.jumlah) as total_terjual " +
                     "FROM detail_transaksi dt " +
                     "JOIN data_transaksi t ON dt.id_transaksi = t.id_transaksi " +
                     "JOIN produk p ON dt.id_produk = p.id_produk " +
                     "WHERE t.id_umkm = ? AND t.tanggal_transaksi BETWEEN ? AND ? " +
                     "GROUP BY p.nama_produk " +
                     "ORDER BY total_terjual " + (order.equalsIgnoreCase("ASC") ? "ASC" : "DESC");
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id_umkm);
            pst.setDate(2, new java.sql.Date(tanggalAwal.getTime()));
            pst.setDate(3, new java.sql.Date(tanggalAkhir.getTime()));
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    AnalisisProduk analisis = new AnalisisProduk();
                    analisis.setNamaProduk(rs.getString("nama_produk"));
                    analisis.setTotalTerjual(rs.getInt("total_terjual"));
                    hasilAnalisis.add(analisis);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasilAnalisis;
    }

    /**
     * Sesuai flowchart: Ringkasan Omzet
     * Menghitung total omzet dan jumlah transaksi berdasarkan periode.
     */
    public RingkasanOmzet getRingkasanOmzet(int id_umkm, Date tanggalAwal, Date tanggalAkhir) {
        RingkasanOmzet omzet = new RingkasanOmzet();
        String sql = "SELECT SUM(total_transaksi) as total_omzet, COUNT(id_transaksi) as jumlah_transaksi " +
                     "FROM data_transaksi " +
                     "WHERE id_umkm = ? AND tanggal_transaksi BETWEEN ? AND ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id_umkm);
            pst.setDate(2, new java.sql.Date(tanggalAwal.getTime()));
            pst.setDate(3, new java.sql.Date(tanggalAkhir.getTime()));
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    omzet.setTotalOmzet(rs.getDouble("total_omzet"));
                    omzet.setJumlahTransaksi(rs.getInt("jumlah_transaksi"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return omzet;
    }
    
    // Note: Anda bisa tambahkan method untuk menyimpan laporan ke tabel 'laporan' di sini
    // jika Anda ingin admin bisa menyimpan hasil analisis ini.
}