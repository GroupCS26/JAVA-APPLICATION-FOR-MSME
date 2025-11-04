package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn;

    // Ganti sesuai setting MySQL kamu
    private static final String URL = "jdbc:mysql://localhost:3306/UA";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Koneksi ke database berhasil!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Gagal koneksi: " + e.getMessage());
        }
        return conn;
    }
}
