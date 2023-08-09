/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO {
    Connection con = null;
    PreparedStatement ps;
    public CursoDAO(){
        con = Conexion.getConexion();
    }
    
    
    
    public ArrayList<Curso> getCursos(String cc)throws SQLException{
        ArrayList<Curso> cursos = null;
        
        String consulta = "SELECT * FROM ing_sistemas WHERE cc_profesor=?";
        
        ps = con.prepareStatement(consulta);
        ps.setString(1,cc);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()){
            Curso c = new Curso(
                rs.getInt(1),
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
    private void eliminarEstudiantes(int cod_curso) throws SQLException{
        String consulta = "UPDATE ESTUDIANTE SET COD_CURSO=NULL WHERE COD_CURSO=?";
        ps = con.prepareStatement(consulta);
        ps.setInt(1, cod_curso);
        ps.executeUpdate();
    }
    public void eliminarCurso(int cod_curso) throws SQLException{
        
        eliminarEstudiantes(cod_curso);
        
        String consulta = "UPDATE ING_SISTEMAS SET CC_PROFESOR=NULL WHERE COD_CURSO=?";
        ps = con.prepareStatement(consulta);
        ps.setInt(1, cod_curso);
        ps.executeUpdate();

    }
    
    public void editarCurso(int cod_curso, String nombre, String hora_i, String hora_f) throws SQLException{
        String consulta = "UPDATE ING_SISTEMAS SET NOMBRE_CURSO=?,HORA_INICIO=?, HORA_FIN=? WHERE COD_CURSO=?";
        ps = con.prepareStatement(consulta);
        ps.setString(1, nombre);
        ps.setString(2, hora_i);
        ps.setString(3, hora_f);
        ps.setInt(4, cod_curso);
        ps.executeUpdate();
        System.out.println(ps.toString());
    }
    
    public Curso getCurso(int cod_curso) throws SQLException{
        String consulta = "SELECT * FROM ing_sistemas WHERE cod_curso=?";
        Curso c = null;
        ps = con.prepareStatement(consulta);
        ps.setInt(1,cod_curso);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            c= new Curso(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
        }
        return c;
    }
}
