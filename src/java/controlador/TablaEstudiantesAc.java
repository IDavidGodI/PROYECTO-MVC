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

import modelo.EstudianteDAO;

public class TablaEstudiantesAc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String cc = request.getParameter("cc");
        EstudianteDAO ed = new EstudianteDAO();
        try {
            
            if (request.getParameter("editar") != null) {
                request.setAttribute("cc_estudiante", cc);
                request.setAttribute("cod_curso", ed.GetMateriaInscrita(cc));
                request.getRequestDispatcher("index.jsp").forward(request,response);
            } else if (request.getParameter("eliminar") != null) {
                request.setAttribute("cod_curso", ed.GetMateriaInscrita(cc));
                ed.eliminarEstudiante(cc);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaEstudiantesAc.class.getName()).log(Level.SEVERE, null, ex);
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
