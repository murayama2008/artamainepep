/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class user extends koneksi {
    public user(){
        super.setKoneksi();
    }
    public DefaultTableModel model = new DefaultTableModel();
    
    public void simpan(String id,String user,String pass,String nama,String nohp) throws SQLException{
        // Kolom harus disebut jelas, biar urutannya gak bikin error
        String sql = "INSERT INTO users (id, username, password, nama, nohp) " +
                     "VALUES ('"+id+"','"+user+"','"+pass+"','"+nama+"','"+nohp+"')";
        st.executeUpdate(sql);
    }

    public void edit(String id,String user,String pass,String nama,String nohp) throws SQLException{
        String sql = "UPDATE users SET username = '"+user+"', password = '"+pass+
                     "', nama = '"+nama+"', nohp = '"+nohp+"' WHERE id = '"+id+"'";
        st.executeUpdate(sql);
    }

    public void hapus(String id) throws SQLException{
        String sql = "DELETE FROM users WHERE id = '"+id+"'";
        st.executeUpdate(sql);
    }

    public void tampil(){
        String sql = "SELECT * FROM users ORDER BY id";
        String[] kolom = {"ID","Username","Password","Nama","No Hp"};
       
        try {
            rs = st.executeQuery(sql);
            model.setColumnIdentifiers(kolom);
            model.setRowCount(0); // reset isi tabel biar gak double
            
            while(rs.next()){
                Object[] data = new Object[5];
                data[0] = rs.getString("id");
                data[1] = rs.getString("username");
                data[2] = rs.getString("password");
                data[3] = rs.getString("nama");
                data[4] = rs.getString("nohp");
                
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
