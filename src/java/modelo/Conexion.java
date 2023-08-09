package modelo;

import java.io.BufferedWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Conexion { 
    private static Conexion sConexion;
    private Properties credenciales;
    Connection conexion =  null;
    private Conexion() throws IOException {
        
        String bd = "ucc";
        String url = String.format(
                "jdbc:mysql://localhost:3306/%s"
                , bd
        );
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            System.out.println(url);
            Logger.getLogger(Conexion.class.getName()).log(Level.INFO, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConexion(){
        if (sConexion==null) try {
            sConexion = new Conexion();
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sConexion.conexion;
    }
}
