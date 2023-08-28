
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
import modelo.EstudianteDAO;
import vista.Formularios;

public class CalificarEstudiante extends HttpServlet {
    String nota_regex = "^(([0-9]*)(\\.([0-9]+))?)$";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String s_nota = request.getParameter("nota_estudiante");
        String cc = request.getParameter("cc");
        ArrayList<String> errores = new ArrayList<>();
        boolean hayErrores = false;
        EstudianteDAO ed = new EstudianteDAO();
        
        try {
            if (!s_nota.matches(nota_regex) || s_nota.isEmpty()) throw new NotaNoValida();
            if (!ed.ValidarEstudiante(cc)) throw new CorreoNoValido();
            
            float nota = Float.parseFloat(s_nota);
            if (nota<0 || nota>5) throw new NotaNoValida();
            System.out.println(nota);
            ed.editarNota(cc, nota, ed.GetMateriaInscrita(cc));

            request.setAttribute("cod_curso", ed.GetMateriaInscrita(cc));
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }catch(CorreoNoValido e){
            errores.add("Esta cédula no fue encontrada.");
            System.out.println("Cedula no encontrada");
            hayErrores = true;
        } catch (NotaNoValida ex) {
            errores.add("Este no es un valor de nota valido. 🧐");
            hayErrores = true;
            
            Logger.getLogger(CalificarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            errores.add("Parece que hay problemas de conexión. Intente de nuevo mas tarde.");
            System.out.println("Problemas de conexion");
            Logger.getLogger(IngresoProfesor.class.getName()).log(Level.SEVERE, null, ex);
            hayErrores = true;
        }
        
        if (hayErrores){
            request.setAttribute(Formularios.LISTA_ERRORES, errores);
            request.setAttribute("cc_estudiante", cc);
            try {
                request.setAttribute("cod_curso", ed.GetMateriaInscrita(cc));
            } catch (SQLException ex) {
                Logger.getLogger(CalificarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
