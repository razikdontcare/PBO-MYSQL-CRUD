/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksidatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Razik
 */
public class Koneksi {
    static Connection koneksi;
    
    public static Connection getKoneksi(){
        try {
            String url = "jdbc:mysql://localhost/perpustakaan";
            String user = "root";
            String password = "password";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Gagal membuat koneksi");
        }
        return koneksi;
    }
    
    public static boolean insert(String query, Object... params) {
        try (PreparedStatement statement = getKoneksi().prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal melakukan insert: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean update(String query, Object... params) {
        try (PreparedStatement statement = getKoneksi().prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal melakukan update: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean delete(String query, Object... params) {
        try (PreparedStatement statement = getKoneksi().prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal melakukan delete: " + e.getMessage());
            return false;
        }
    }
}
