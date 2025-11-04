package dao;

import config.DatabaseConnection;
import model.DetailTransaksi;
import model.Transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Transaksidao {

    /**
     * Logika utama KASIR.
     * Menggunakan TRANSACTION untuk 3 langkah:
     * 1. INSERT ke data_transaksi
     * 2. INSERT semua barang ke detail_transaksi
     * 3. UPDATE (kurangi) stok di tabel produk
     */
    public boolean tambahTransaksi(Transaksi transaksi) {
        String sqlTransaksi = "INSERT INTO data_transaksi (id_user, id_umkm, tanggal_transaksi, total_transaksi) VALUES (?, ?, ?, ?)";
        String sqlDetail = "INSERT INTO detail_transaksi (id_produk, id_transaksi, jumlah, subtotal, id_umkm) VALUES (?, ?, ?, ?, ?)";
        String sqlUpdateStok = "UPDATE produk SET stok = stok - ? WHERE id_produk = ? AND id_umkm = ?";
        
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Mulai TRANSACTION
            
            int id_transaksi_baru = -1;

            // --- Langkah 1: Insert ke data_transaksi ---
            try (PreparedStatement pstTransaksi = conn.prepareStatement(sqlTransaksi, Statement.RETURN_GENERATED_KEYS)) {
                pstTransaksi.setInt(1, transaksi.getId_user());
                pstTransaksi.setInt(2, transaksi.getId_umkm());
                pstTransaksi.setDate(3, new java.sql.Date(transaksi.getTanggal_transaksi().getTime()));
                pstTransaksi.setDouble(4, transaksi.getTotal_transaksi());
                pstTransaksi.executeUpdate();
                
                try (ResultSet rsKeys = pstTransaksi.getGeneratedKeys()) {
                    if (rsKeys.next()) {
                        id_transaksi_baru = rsKeys.getInt(1);
                    }
                }
            }

            if (id_transaksi_baru == -1) {
                conn.rollback(); // Batalkan jika gagal dapat ID
                return false;
            }

            // --- Langkah 2: Insert semua barang ke detail_transaksi ---
            try (PreparedStatement pstDetail = conn.prepareStatement(sqlDetail)) {
                for (DetailTransaksi item : transaksi.getDetailItems()) {
                    pstDetail.setInt(1, item.getId_produk());
                    pstDetail.setInt(2, id_transaksi_baru);
                    pstDetail.setInt(3, item.getJumlah());
                    pstDetail.setDouble(4, item.getSubtotal());
                    pstDetail.setInt(5, transaksi.getId_umkm());
                    pstDetail.addBatch(); // Tambahkan ke batch
                }
                pstDetail.executeBatch(); // Eksekusi semua sekaligus
            }

            // --- Langkah 3: Update (kurangi) stok di tabel produk ---
            // Sesuai flowchart "Mengurangi stok"
            try (PreparedStatement pstUpdateStok = conn.prepareStatement(sqlUpdateStok)) {
                for (DetailTransaksi item : transaksi.getDetailItems()) {
                    pstUpdateStok.setInt(1, item.getJumlah()); // Jumlah yang dibeli
                    pstUpdateStok.setInt(2, item.getId_produk());
                    pstUpdateStok.setInt(3, transaksi.getId_umkm());
                    pstUpdateStok.addBatch();
                }
                pstUpdateStok.executeBatch();
            }

            conn.commit(); // Selesaikan TRANSACTION jika semua berhasil
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            // Jika ada 1 langkah saja yang gagal, batalkan semua
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true); // Kembalikan ke mode normal
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Menampilkan semua riwayat transaksi untuk satu UMKM.
     */
    public List<Transaksi> tampilkanTransaksi(int id_umkm) {
        List<Transaksi> daftarTransaksi = new ArrayList<>();
        String sql = "SELECT * FROM data_transaksi WHERE id_umkm = ? ORDER BY tanggal_transaksi DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id_umkm);
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Transaksi trx = new Transaksi();
                    trx.setId_transaksi(rs.getInt("id_transaksi"));
                    trx.setId_user(rs.getInt("id_user"));
                    trx.setId_umkm(rs.getInt("id_umkm"));
                    trx.setTanggal_transaksi(rs.getDate("tanggal_transaksi"));
                    trx.setTotal_transaksi(rs.getDouble("total_transaksi"));
                    daftarTransaksi.add(trx);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarTransaksi;
    }
}