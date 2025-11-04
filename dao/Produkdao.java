package dao;

import config.DatabaseConnection;
import model.Produk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Produkdao {

    // Sesuai flowchart: Bisa diakses Admin & Pegawai
    public boolean tambahProduk(Produk produk) {
        String sql = "INSERT INTO produk (id_user, id_umkm, nama_produk, kategori, harga, stok, deskripsi) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, produk.getId_user());
            pst.setInt(2, produk.getId_umkm());
            pst.setString(3, produk.getNama_produk());
            pst.setString(4, produk.getKategori());
            pst.setInt(5, produk.getHarga());
            pst.setInt(6, produk.getStok());
            pst.setString(7, produk.getDeskripsi());
            
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Sesuai flowchart: Bisa diakses Admin & Pegawai
    public List<Produk> tampilkanProduk(int id_umkm) {
        List<Produk> daftarProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk WHERE id_umkm = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id_umkm);
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Produk produk = new Produk();
                    produk.setId_produk(rs.getInt("id_produk"));
                    produk.setId_umkm(rs.getInt("id_umkm"));
                    produk.setNama_produk(rs.getString("nama_produk"));
                    produk.setKategori(rs.getString("kategori"));
                    produk.setHarga(rs.getInt("harga"));
                    produk.setStok(rs.getInt("stok"));
                    produk.setDeskripsi(rs.getString("deskripsi"));
                    daftarProduk.add(produk);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarProduk;
    }

    // Sesuai flowchart: HANYA UNTUK ADMIN
    public boolean updateProdukAdmin(Produk produk) {
        String sql = "UPDATE produk SET nama_produk = ?, kategori = ?, harga = ?, stok = ?, deskripsi = ? WHERE id_produk = ? AND id_umkm = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, produk.getNama_produk());
            pst.setString(2, produk.getKategori());
            pst.setInt(3, produk.getHarga());
            pst.setInt(4, produk.getStok());
            pst.setString(5, produk.getDeskripsi());
            pst.setInt(6, produk.getId_produk());
            pst.setInt(7, produk.getId_umkm()); // Keamanan ekstra
            
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Sesuai flowchart: HANYA UNTUK PEGAWAI (Update Stok)
    public boolean updateStokPegawai(int id_produk, int stokBaru, int id_umkm) {
        String sql = "UPDATE produk SET stok = ? WHERE id_produk = ? AND id_umkm = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, stokBaru);
            pst.setInt(2, id_produk);
            pst.setInt(3, id_umkm);
            
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Sesuai flowchart: HANYA UNTUK ADMIN
    public boolean hapusProduk(int id_produk, int id_umkm) {
        String sql = "DELETE FROM produk WHERE id_produk = ? AND id_umkm = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id_produk);
            pst.setInt(2, id_umkm);
            
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}