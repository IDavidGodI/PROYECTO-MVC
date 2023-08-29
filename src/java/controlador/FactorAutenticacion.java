package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ProfesorDAO;
import modelo.CodigoVerificacion;
import modelo.Autenticacion;
import vista.Formularios;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "FactorAutenticacion", urlPatterns = {"/FactorAutenticacion"})
public class FactorAutenticacion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registro.jsp");
    }
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ProfesorDAO pd = new ProfesorDAO(); 
    HttpSession sesion = request.getSession();
    ArrayList<String> errores = new ArrayList<>();
    Object objRegistrado = sesion.getAttribute("registrado");
    if (objRegistrado==null){
        sesion.invalidate();
        return;
    }
    boolean estaRegistrado = (boolean) objRegistrado;
    if (!CodigoVerificacion.codigoExpirado(request)) {
        String codigoIngresado = request.getParameter("cod_verificacion");
        String codigoEnviado = (String) sesion.getAttribute("cod_verificacion");
        if (!codigoIngresado.equals(codigoEnviado)) {
            errores.add("El codigo de verificacion no es correcto, intente de nuevo");

            request.setAttribute(Formularios.LISTA_ERRORES, errores);
            request.getRequestDispatcher("FactorAutenticacion.jsp").forward(request, response);
            return;
        }
        request.setAttribute("cod_validado", true);
        String correo =  (String) sesion.getAttribute("correo");
        String clave = (String)sesion.getAttribute("clave");
        String nombre = (String)sesion.getAttribute("nombre");
        sesion.removeAttribute("cod_verificacion"); 
        if (estaRegistrado || pd.registrarProfesor(correo, clave, nombre)){
            Autenticacion.crearSesion(request, response);
            response.sendRedirect("index.jsp");
            return;
        }
        errores.add("Hay problemas de conexion con la base de datos, intente mas tarde.");
        request.setAttribute(Formularios.LISTA_ERRORES, errores);
        request.getRequestDispatcher("FactorAutenticacion.jsp").forward(request, response);
        return;
    }
    errores.add("El código de verificación ha expirado");
    request.setAttribute(Formularios.LISTA_ERRORES, errores);
    request.getRequestDispatcher("FactorAutenticacion.jsp").forward(request, response);
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}