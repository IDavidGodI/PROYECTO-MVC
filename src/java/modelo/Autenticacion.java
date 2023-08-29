
package modelo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

/**
 *
 * @author Lenovo
 */
public class Autenticacion {
    private static final float DURACION_COOKIES = 3;
    private static final String COOKIE_SESION = "cookie_sesion";
    public static void crearSesion(HttpServletRequest request, HttpServletResponse response){
            String idSesion = GeneradorCodigos.getUUID();
            String idDobleFactor = GeneradorCodigos.getUUID();
            HttpSession sesion = request.getSession();
            
            Cookie cookieSesion = new Cookie(COOKIE_SESION,idSesion);
            sesion.setAttribute(COOKIE_SESION,idSesion);
            cookieSesion.setMaxAge((int)(DURACION_COOKIES*120));
            response.addCookie(cookieSesion);
            if (!validarDobleFactor(request, response)){
                boolean codigoValidado = (boolean) request.getAttribute("cod_validado");
                if (!codigoValidado) return;
                Cookie cookieVerificacion = new Cookie("cookie_valida",idDobleFactor);
                sesion.setAttribute("cookie_valida",idDobleFactor);
                cookieVerificacion.setMaxAge((int)(DURACION_COOKIES*60));
                response.addCookie(cookieVerificacion);
            }
    }
    public static void cerrarSesion(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        HttpSession sesion = request.getSession();
        for (Cookie cookie : cookies){
            if (COOKIE_SESION.equals(cookie.getName())){
                sesion.removeAttribute(COOKIE_SESION);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
    private static boolean compararCookie(String atributo,HttpServletRequest request, HttpServletResponse response){
        HttpSession sesion = request.getSession();
        String valorSesion = (String) sesion.getAttribute(atributo);
        Cookie[] cookies = request.getCookies();
        if (valorSesion==null) return false;
        for (Cookie cookie : cookies){
            if (atributo.equals(cookie.getName())){
                String valorCookie = (String)cookie.getValue();
                return valorSesion.equals(valorCookie);
            }
        }
        return false;
    }
    public static boolean validarSesion(HttpServletRequest request, HttpServletResponse response){
        return compararCookie(COOKIE_SESION, request, response);
    }
    
    public static boolean validarDobleFactor(HttpServletRequest request, HttpServletResponse response){
        return compararCookie("cookie_valida", request, response);
    }
}
