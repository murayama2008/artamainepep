/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class koneksi {
    Connection con;
    Statement st;
    ResultSet rs;
    
    public Connection getKoneksi(){
        return con;
    }
    
    public void setKoneksi(){
        try {
            // Ganti driver PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // URL koneksi PostgreSQL
            // Format: jdbc:postgresql://host:port/nama_database
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/sistemkasir", 
                "postgres",   // username postgres lo
                "12345"       // password postgres lo
            );
            
            st = con.createStatement();
            System.out.println("KONEKSI BERHASIL KE POSTGRESQL");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        koneksi k = new koneksi();
        k.setKoneksi();
    }
}
