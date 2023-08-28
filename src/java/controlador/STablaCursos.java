/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.CursoDAO;

public class STablaCursos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        CursoDAO cd = new CursoDAO();
        String codigo = (String) request.getParameter("codigo");
        System.out.println("A: "+codigo);
        try {
            if (request.getParameter("ver") != null) {
                request.setAttribute("cod_curso", codigo);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            } else if (request.getParameter("eliminar") != null) {
                    cd.eliminarCurso(codigo);
                    response.sendRedirect("index.jsp");
            } else if (request.getParameter("editar") != null) {
                request.setAttribute("cod_curso", codigo);
                request.setAttribute("info_curso", cd.getCurso(codigo));
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(STablaCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
