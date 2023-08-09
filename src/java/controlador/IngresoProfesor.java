/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import vista.Formularios;
import modelo.ProfesorDAO;
import modelo.Profesor;

public class IngresoProfesor extends HttpServlet {
    String cc_regex = "^[0-9]+$";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IngresoProfesor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IngresoProfesor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("Login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cc = request.getParameter("cc_profesor");
        ProfesorDAO pd = new ProfesorDAO();
        
        HttpSession sesion = request.getSession();
        
        ArrayList<String> errores = new ArrayList<>();
        boolean hayErrores = false;
        try{
            if (!cc.matches(cc_regex))throw new CedulaNoValida();
            Profesor p = pd.getProfesor(cc);
            if (p==null) throw new CedulaNoValida();
            
            sesion.setAttribute("cc", p.getCc());
            sesion.setAttribute("nombre", p.getNombre());
            sesion.setAttribute("correo", p.getCorreo());
            
            response.sendRedirect("index.jsp");        
        }catch(CedulaNoValida e){
            errores.add("Esta cédula no fue encontrada.");
            System.out.println("Cedula no encontrada");
            hayErrores = true;
        } catch (SQLException ex) {
            errores.add("Parece que hay problemas para conectar con la base de datos. Intente de nuevo mas tarde.");
            System.out.println("Problemas de conexion");
            Logger.getLogger(IngresoProfesor.class.getName()).log(Level.SEVERE, null, ex);
            hayErrores = true;
        }
        
        if (hayErrores){
            request.setAttribute(Formularios.LISTA_ERRORES, errores);
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
