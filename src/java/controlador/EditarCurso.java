/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CursoDAO;
import vista.Formularios;

/**
 *
 * @author Lenovo
 */
public class EditarCurso extends HttpServlet {
    String hora_regex = "([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre_curso");
        String hora_i = request.getParameter("hora_i");
        String hora_f = request.getParameter("hora_f");
        String codigo = request.getParameter("cod_curso");
        ArrayList<String> errores = new ArrayList<>();
        boolean hayErrores = false;
        CursoDAO cd = new CursoDAO();
        
        try {
            if (nombre.isEmpty()){ 
                errores.add("El nombre del curso no puede estar vacio. 🤨");
                throw new InfoCursoNoValida();
            }
            if (!hora_i.matches(hora_regex) || !hora_f.matches(hora_regex)){ 
                errores.add("Usar un formato de hora valido.");
                throw new InfoCursoNoValida();
            }
            
            
            cd.editarCurso(codigo, nombre, hora_i, hora_f);
            request.setAttribute("cod_curso", codigo);
            request.setAttribute("info_curso", cd.getCurso(codigo));
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }catch(InfoCursoNoValida e){
            System.out.println("Algo ahi esta mal");
            hayErrores = true;
        }catch (SQLException ex) {
            errores.add("Parece que hay problemas de conexión. Intente de nuevo mas tarde.");
            System.out.println("Problemas de conexion");
            Logger.getLogger(IngresoProfesor.class.getName()).log(Level.SEVERE, null, ex);
            hayErrores = true;
        }
        
        if (hayErrores){
            request.setAttribute(Formularios.LISTA_ERRORES, errores);
            request.setAttribute("cod_curso", codigo);
            try {
                request.setAttribute("info_curso", cd.getCurso(codigo));
            } catch (SQLException ex) {
                Logger.getLogger(EditarCurso.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
