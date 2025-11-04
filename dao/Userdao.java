package dao;

import config.DatabaseConnection;
import model.User;
import model.Umkm; // Import model Umkm yang baru
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Userdao {

    /**
     * Logika login utama.
     * Mengembalikan User object jika berhasil, null jika gagal.
     */
    public User loginUser(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM user_umkm WHERE username = ? AND password = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, username);
            pst.setString(2, password);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setId_user(rs.getInt("id_user"));
                    user.setId_umkm(rs.getInt("id_umkm"));
                    user.setNama(rs.getString("nama"));
                    user.setUsername(rs.getString("username"));
                    user.setKontak(rs.getString("kontak"));
                    
                    // Setelah user ditemukan, cek perannya (Admin atau Pegawai)
                    String role = getRole(conn, user.getId_user());
                    user.setRole(role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Helper method untuk mengecek peran user.
     */
    private String getRole(Connection conn, int id_user) throws SQLException {
        // Cek apakah dia Pemilik/Admin
        String sqlPemilik = "SELECT * FROM pemilik WHERE id_user = ?";
        try (PreparedStatement pst = conn.prepareStatement(sqlPemilik)) {
            pst.setInt(1, id_user);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return "admin"; // Jika ada di tabel pemilik, dia admin
                }
            }
        }
        
        // Jika bukan pemilik, cek apakah dia Pegawai
        String sqlPegawai = "SELECT * FROM pegawai WHERE id_user = ?";
        try (PreparedStatement pst = conn.prepareStatement(sqlPegawai)) {
            pst.setInt(1, id_user);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return "pegawai"; // Jika ada di tabel pegawai, dia pegawai
                }
            }
        }
        
        return null; // Jika tidak keduanya (seharusnya tidak terjadi)
    }

    /**
     * Logika utama SIGN UP.
     * Mendaftarkan UMKM baru dan Owner-nya dalam satu Transaction.
     */
    public boolean registerOwnerAndUmkm(User owner, Umkm umkm) {
        String sqlUmkm = "INSERT INTO umkm (nama_usaha, alamat_usaha) VALUES (?, ?)";
        String sqlUser = "INSERT INTO user_umkm (id_umkm, nama, username, password, kontak) VALUES (?, ?, ?, ?, ?)";
        String sqlPemilik = "INSERT INTO pemilik (id_user) VALUES (?)";
        
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Mulai TRANSACTION

            int id_umkm_baru = -1;
            int id_user_baru = -1;

            // --- Langkah 1: Insert ke tabel umkm ---
            try (PreparedStatement pstUmkm = conn.prepareStatement(sqlUmkm, Statement.RETURN_GENERATED_KEYS)) {
                pstUmkm.setString(1, umkm.getNama_usaha());
                pstUmkm.setString(2, umkm.getAlamat_usaha());
                pstUmkm.executeUpdate();
                
                try (ResultSet rsKeys = pstUmkm.getGeneratedKeys()) {
                    if (rsKeys.next()) {
                        id_umkm_baru = rsKeys.getInt(1);
                    }
                }
            }
            
            if (id_umkm_baru == -1) {
                conn.rollback();
                return false;
            }

            // --- Langkah 2: Insert ke tabel user_umkm ---
            try (PreparedStatement pstUser = conn.prepareStatement(sqlUser, Statement.RETURN_GENERATED_KEYS)) {
                pstUser.setInt(1, id_umkm_baru); // Pakai ID UMKM dari langkah 1
                pstUser.setString(2, owner.getNama());
                pstUser.setString(3, owner.getUsername());
                pstUser.setString(4, owner.getPassword());
                pstUser.setString(5, owner.getKontak());
                pstUser.executeUpdate();
                
                try (ResultSet rsKeys = pstUser.getGeneratedKeys()) {
                    if (rsKeys.next()) {
                        id_user_baru = rsKeys.getInt(1);
                    }
                }
            }
            
            if (id_user_baru == -1) {
                conn.rollback();
                return false;
            }

            // --- Langkah 3: Insert ke tabel pemilik (untuk menandai sebagai Admin) ---
            try (PreparedStatement pstPemilik = conn.prepareStatement(sqlPemilik)) {
                pstPemilik.setInt(1, id_user_baru); // Pakai ID User dari langkah 2
                pstPemilik.executeUpdate();
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

    // --- FUNGSI KELOLA PEGAWAI (UNTUK ADMIN) ---

    public boolean tambahPegawai(User pegawai) {
        String sqlUser = "INSERT INTO user_umkm (id_umkm, nama, username, password, kontak) VALUES (?, ?, ?, ?, ?)";
        String sqlPegawai = "INSERT INTO pegawai (id_user, posisi) VALUES (?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false); // Mulai transaction
            
            int id_user_baru = -1;
            
            // 1. Insert ke user_umkm
            try (PreparedStatement pstUser = conn.prepareStatement(sqlUser, Statement.RETURN_GENERATED_KEYS)) {
                pstUser.setInt(1, pegawai.getId_umkm());
                pstUser.setString(2, pegawai.getNama());
                pstUser.setString(3, pegawai.getUsername());
                pstUser.setString(4, pegawai.getPassword());
                pstUser.setString(5, pegawai.getKontak());
                pstUser.executeUpdate();
                
                try (ResultSet rsKeys = pstUser.getGeneratedKeys()) {
                    if (rsKeys.next()) {
                        id_user_baru = rsKeys.getInt(1);
                    }
                }
            }
            
            if (id_user_baru == -1) {
                conn.rollback();
                return false;
            }

            // 2. Insert ke pegawai
            try (PreparedStatement pstPegawai = conn.prepareStatement(sqlPegawai)) {
                pstPegawai.setInt(1, id_user_baru);
                pstPegawai.setString(2, "Pegawai"); // Sesuai flowchart, tambahkan posisi
                pstPegawai.executeUpdate();
            }
            
            conn.commit(); // Selesaikan transaction
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection conn = DatabaseConnection.getConnection()) {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public List<User> tampilkanPegawai(int id_umkm) {
        List<User> daftarPegawai = new ArrayList<>();
        // Kita JOIN untuk mengambil data user sekaligus posisinya
        String sql = "SELECT u.*, p.posisi FROM user_umkm u " +
                     "JOIN pegawai p ON u.id_user = p.id_user " +
                     "WHERE u.id_umkm = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id_umkm);
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId_user(rs.getInt("id_user"));
                    user.setId_umkm(rs.getInt("id_umkm"));
                    user.setNama(rs.getString("nama"));
                    user.setUsername(rs.getString("username"));
                    user.setKontak(rs.getString("kontak"));
                    // Anda bisa tambahkan 'posisi' di model User jika perlu
                    // user.setPosisi(rs.getString("posisi")); 
                    daftarPegawai.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarPegawai;
    }

    public boolean updatePegawai(User pegawai) {
        String sql = "UPDATE user_umkm SET nama = ?, username = ?, password = ?, kontak = ? WHERE id_user = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, pegawai.getNama());
            pst.setString(2, pegawai.getUsername());
            pst.setString(3, pegawai.getPassword());
            pst.setString(4, pegawai.getKontak());
            pst.setInt(5, pegawai.getId_user());
            
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hapusPegawai(int id_user) {
        String sqlPegawai = "DELETE FROM pegawai WHERE id_user = ?";
        String sqlUser = "DELETE FROM user_umkm WHERE id_user = ?";
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false); // Mulai transaction
            
            // 1. Hapus dari tabel 'pegawai' dulu (karena ada foreign key)
            try (PreparedStatement pstPegawai = conn.prepareStatement(sqlPegawai)) {
                pstPegawai.setInt(1, id_user);
                pstPegawai.executeUpdate();
            }
            
            // 2. Hapus dari tabel 'user_umkm'
            try (PreparedStatement pstUser = conn.prepareStatement(sqlUser)) {
                pstUser.setInt(1, id_user);
                pstUser.executeUpdate();
            }
            
            conn.commit(); // Selesaikan transaction
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection conn = DatabaseConnection.getConnection()) {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    // --- FUNGSI PENGATURAN TOKO (UNTUK ADMIN) ---

    /**
     * Mengambil detail UMKM berdasarkan ID.
     */
    public Umkm getUmkmById(int id_umkm) {
        Umkm umkm = null;
        String sql = "SELECT * FROM umkm WHERE id_umkm = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id_umkm);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    umkm = new Umkm();
                    umkm.setId_umkm(rs.getInt("id_umkm"));
                    umkm.setNama_usaha(rs.getString("nama_usaha"));
                    umkm.setAlamat_usaha(rs.getString("alamat_usaha"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return umkm;
    }

    /**
     * Meng-update detail UMKM.
     */
    public boolean updateUmkm(Umkm umkm) {
        String sql = "UPDATE umkm SET nama_usaha = ?, alamat_usaha = ? WHERE id_umkm = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, umkm.getNama_usaha());
            pst.setString(2, umkm.getAlamat_usaha());
            pst.setInt(3, umkm.getId_umkm());
            
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}