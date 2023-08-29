package controlador;

import controlador.excepciones.ClaveNoValida;
import controlador.excepciones.CorreoNoValido;
import controlador.excepciones.CredencialesInvalidas;
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
import javax.servlet.http.HttpSession;
import modelo.Profesor;
import modelo.ProfesorDAO;
import vista.Formularios;

/**
 *
 * @author Lenovo
 */
public class RegistroProfesor extends HttpServlet {

    String correo_rgx = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    String nombre_rgx = "^[a-zA-Z]{2,}(?: [a-zA-Z]+){0,2}$";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("Login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
        String cclave = request.getParameter("cclave");
        ProfesorDAO pd = new ProfesorDAO();
        
        HttpSession sesion = request.getSession();
        
        ArrayList<String> errores = new ArrayList<>();
        boolean hayErrores = false;
        try{
            
            if (!nombre.matches(nombre_rgx)) {
                errores.add("El nombre no puede contener numeros o caracteres especiales");
                hayErrores = true;
            }
            if (!correo.matches(correo_rgx) || pd.correoDuplicado(correo)){
                errores.add("El correo ingresado no es valido");
                hayErrores = true;
            }
            if (!clave.equals(cclave)) {
                errores.add("Las claves no coinciden");
                hayErrores = true;
            }

            if (!hayErrores){
                request.setAttribute("correo", correo);
                request.setAttribute("clave", clave);
                request.setAttribute("nombre", nombre);
                request.setAttribute("registrado",false);
                
                request.getRequestDispatcher("envioCorreos").forward(request, response);       
            }
            
        } catch (SQLException ex) {
            errores.add("Parece que hay problemas para conectar con la base de datos. Intente de nuevo mas tarde.");
            System.out.println("Problemas de conexion");
            Logger.getLogger(IngresoProfesor.class.getName()).log(Level.SEVERE, null, ex);
            hayErrores = true;
        }
        
        if (hayErrores){
            request.setAttribute(Formularios.LISTA_ERRORES, errores);
            request.getRequestDispatcher("Registro.jsp").forward(request,response);
        }
    }

}
