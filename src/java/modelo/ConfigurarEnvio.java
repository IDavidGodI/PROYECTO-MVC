

package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class ConfigurarEnvio {
    public static void setCredenciales(File archivoConf,String correo, String clave) throws IOException{
        Properties propiedades = new Properties();
        if (!archivoConf.exists()){
            File carpeta = new File(Info.DIR_CREDENCIALES);
            carpeta.mkdir();
            archivoConf.createNewFile();
        }

        FileWriter wArchivo = new FileWriter(archivoConf);
        BufferedWriter bArchivo = new BufferedWriter(wArchivo);
        propiedades.put(Info.P_CORREO_SMTP, correo);
        propiedades.put(Info.P_CLAVE_SMTP, clave);
        
        
        propiedades.store(bArchivo,"Credenciales de la direccion de correo que enviara los emails");
        System.out.println("Archivo de credenciales creado");
    }
    public static void setCredenciales(File archivoConf) throws IOException{
        
        String correo = JOptionPane.showInputDialog("Correo de envios");
        String clave; 
        JPasswordField campoClave = new JPasswordField();
        int ok = JOptionPane.showConfirmDialog(null, campoClave, "Ingresar contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        // atswrmsjrhmrfrag

        if (ok == JOptionPane.OK_OPTION) {
          clave = new String(campoClave.getPassword());
            try {
              setCredenciales(archivoConf, correo, clave);
          } catch (IOException ex) {
              Logger.getLogger(ConfigurarEnvio.class.getName()).log(Level.SEVERE, null, ex);
          }
            return;
        }
        throw new IOException();
    }
}