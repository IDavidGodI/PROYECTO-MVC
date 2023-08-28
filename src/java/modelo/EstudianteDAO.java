package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EstudianteDAO {
    Connection con = null;
    PreparedStatement ps;
    public EstudianteDAO(){
        con = Conexion.getConexion();
    }
    
    public ArrayList<Estudiante> getEstudiantes(int cm)throws SQLException{
        ArrayList<Estudiante> estudiantes = null;
        
        String consulta = "SELECT * FROM estudiante WHERE cod_curso=?";
        
        ps = con.prepareStatement(consulta);
        ps.setInt(1,cm);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()){
            Estudiante e = new Estudiante(
                rs.getString(1),
                rs.getString(3),
                rs.getString(2),
                rs.getFloat(4)
            );
            if (estudiantes==null)  estudiantes = new ArrayList<>();
            
            estudiantes.add(e);
        }
        return estudiantes;
    }
    
    public void editarNota(String cc, float nota, int cod_curso)throws SQLException{
        String consulta = "UPDATE ESTUDIANTE SET NOTA=? WHERE CC_ESTUDIANTE=? AND COD_CURSO = ?";
        ps = con.prepareStatement(consulta);
        ps.setFloat(1,nota);
        ps.setString(2, cc);
        ps.setInt(3, cod_curso);
        
        System.out.println(ps.toString());
        ps.executeUpdate();
    }
    public boolean ValidarEstudiante(String cc)throws SQLException{
        String consulta = "SELECT * FROM ESTUDIANTE WHERE CC_ESTUDIANTE = ?";
        Integer resultado = null;
        ps = con.prepareStatement(consulta);
        ps.setString(1, cc);
        
        ResultSet rs = ps.executeQuery();
        
        return rs.next();
    }
    public Integer GetMateriaInscrita(String cc)throws SQLException{
        String consulta = "SELECT COD_CURSO FROM ESTUDIANTE WHERE CC_ESTUDIANTE = ?";
        Integer resultado = null;
        ps = con.prepareStatement(consulta);
        ps.setString(1, cc);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            resultado = rs.getInt(1);
        }
        
        return resultado;
    }
    
    public void eliminarEstudiante(String cc)throws SQLException{
        String consulta = "UPDATE ESTUDIANTE SET COD_CURSO=NULL WHERE CC_ESTUDIANTE=?";
        ps = con.prepareStatement(consulta);
        ps.setString(1, cc);
        ps.executeUpdate();
    }
}
