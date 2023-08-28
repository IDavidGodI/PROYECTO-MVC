
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesorDAO {
    Connection con = null;
    PreparedStatement ps;
    public ProfesorDAO(){
        con = Conexion.getConexion();
    }
    
    public Profesor getProfesor(String correo) throws SQLException{
        Profesor p = null;
        String consulta = "SELECT * FROM Profesor WHERE correo=?";
        
        ps = con.prepareStatement(consulta);
        ps.setString(1,correo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            String rCC = rs.getString(1);
            String rNombre = rs.getString(2);
            String rCorreo = rs.getString(3);
            
            p = new Profesor(rCC, rNombre, rCorreo);
        }
        return p;
    }
}
