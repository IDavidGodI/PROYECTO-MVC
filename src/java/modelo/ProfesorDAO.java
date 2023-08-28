
package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfesorDAO {
    Connection con = null;
    PreparedStatement ps;
    public ProfesorDAO(){
        con = Conexion.getConexion();
    }
    private String encriptarClave(String clave){
        MessageDigest md;
        byte[] hash = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            hash = md.digest(clave.getBytes());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        String hashHexadecimal = sb.toString();
        return hashHexadecimal;

    }
    private PreparedStatement crearStatementProfesor(String consulta, String correo, String clave) throws SQLException {
        PreparedStatement auxps = con.prepareStatement(consulta);
        String hashClave = encriptarClave(clave);
        auxps.setString(1,correo);
        auxps.setString(2,hashClave);
        return auxps;
    }
    
    public Profesor getProfesor(int ID) throws SQLException{
        Profesor p = null;
        String consulta = "SELECT * FROM profesor p WHERE ID_PROFESOR=?";
        
        ps = con.prepareStatement(consulta);
        ps.setInt(1,ID);
        resetPs();
        p = getProfesor();
        return p;
    }
    public Profesor getProfesor(String correo) throws SQLException{
        Profesor p = null;
        String consulta = "SELECT * FROM profesor p WHERE correo=?";
        
        ps = con.prepareStatement(consulta);
        ps.setString(1,correo);
        resetPs();
        p = getProfesor();
        return p;
    }
    private void resetPs(){
        ps=null;
    }
    private Profesor getProfesor()throws SQLException{
        if (ps!=null);
        Profesor p = null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            int rID = rs.getInt(1);
            String rNombre = rs.getString(2);
            String rCorreo = rs.getString(3);
            
            p = new Profesor(rID, rNombre, rCorreo);
        }
        return p;
    }
    
    public boolean correoDuplicado(String correo) throws SQLException{
        String consulta = "SELECT * FROM profesor WHERE correo=?";
        ps = con.prepareStatement(consulta);
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();
        resetPs();
        return rs.next();
    }
    public boolean validarProfesor(String correo, String clave) throws SQLException{
        String consulta = "SELECT * FROM usuario WHERE correo=? AND clave=?";
        ps = crearStatementProfesor(consulta, correo, clave);
        ResultSet rs = ps.executeQuery();
        resetPs();
        return rs.next();
    }
    
    public boolean registrarProfesor(String correo, String clave, String nombre){
        int filasAfectadas = 0;
        String consulta = "INSERT INTO profesor (correo,clave,nombre) VALUES (?,?,?)";
        String hashClave = encriptarClave(clave);
        System.out.println(hashClave);
        try {
            ps = crearStatementProfesor(consulta, correo, clave);
            ps.setString(3,nombre);
            filasAfectadas = ps.executeUpdate();
            resetPs();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas > 0;
    }
}

