package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class CursoDAO {
    Connection con = null;
    PreparedStatement ps;
    public CursoDAO(){
        con = Conexion.getConexion();
    }
    
    
    
    public ArrayList<Curso> getCursos(Integer ID)throws SQLException{
        ArrayList<Curso> cursos = null;
        
        String consulta;
        consulta = "SELECT COD_CURSO, NOMBRE_CURSO, ID_PROFESOR, HORA_INICIO, HORA_FIN FROM curso WHERE id_profesor IS NULL";
        
        
        ps = con.prepareStatement(consulta);
        if (ID!=null) {
            consulta = "SELECT COD_CURSO, NOMBRE_CURSO, ID_PROFESOR, HORA_INICIO, HORA_FIN FROM curso WHERE id_profesor=?";
            ps = con.prepareStatement(consulta);
            ps.setInt(1,ID);
        }
        ResultSet rs = ps.executeQuery();
        System.out.println("Consulta: "+ps.toString());
                
        while (rs.next()){
            Curso c = new Curso(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            if (cursos==null)  cursos = new ArrayList<>();
            
            cursos.add(c);
        }
        return cursos;
    }
    private void eliminarEstudiantes(String cod_curso) throws SQLException{
        String consulta = "DELETE FROM INSCRIPCION_CURSO WHERE COD_CURSO=?";
        ps = con.prepareStatement(consulta);
        ps.setString(1, cod_curso);
        ps.executeUpdate();
    }
    public void eliminarCurso(String cod_curso) throws SQLException{
        
        eliminarEstudiantes(cod_curso);
        
        String consulta = "UPDATE CURSO SET ID_PROFESOR=NULL WHERE COD_CURSO=?";
        ps = con.prepareStatement(consulta);
        ps.setString(1, cod_curso);
        ps.executeUpdate();

    }
    
    public void editarCurso(String cod_curso, String nombre, String hora_i, String hora_f) throws SQLException{
        String consulta = "UPDATE CURSO SET NOMBRE_CURSO=?,HORA_INICIO=?, HORA_FIN=? WHERE COD_CURSO=?";
        ps = con.prepareStatement(consulta);
        ps.setString(1, nombre);
        ps.setString(2, hora_i);
        ps.setString(3, hora_f);
        ps.setString(4, cod_curso);
        ps.executeUpdate();
        System.out.println(ps.toString());
    }
    
    public Curso getCurso(String cod_curso) throws SQLException{
        String consulta = "SELECT * FROM curso WHERE cod_curso=?";
        Curso c = null;
        ps = con.prepareStatement(consulta);
        ps.setString(1,cod_curso);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            c= new Curso(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
        }
        return c;
    }
}

