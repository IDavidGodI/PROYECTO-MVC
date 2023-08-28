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
    String correo_rgx = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("Login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
        ProfesorDAO pd = new ProfesorDAO();
        
        HttpSession sesion = request.getSession();
        
        ArrayList<String> errores = new ArrayList<>();
        boolean hayErrores = false;
        try{
            if (!correo.matches(correo_rgx))throw new CorreoNoValido();
            if (clave.length()<6) throw new ClaveNoValida();
            if (!pd.validarProfesor(correo, clave)) throw new CredencialesInvalidas();
            
            Profesor p = pd.getProfesor(correo);
            if (p==null) throw new CorreoNoValido();
            
            sesion.setAttribute("ID", p.getID());
            sesion.setAttribute("nombre", p.getNombre());
            sesion.setAttribute("correo", p.getCorreo());
            
            response.sendRedirect("index.jsp");        
        }catch(CorreoNoValido e){
            errores.add("Este correo no es valido.");
            System.out.println("Correo no encontrado");
            hayErrores = true;
        } catch (ClaveNoValida ex) {
            errores.add("La clave debe tener minimo 6 caracteres");
            System.out.println("Clave corta");
            hayErrores = true;
        } catch (CredencialesInvalidas ex) {
            errores.add("La informacion no es valida");
            System.out.println("credenciales");
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
