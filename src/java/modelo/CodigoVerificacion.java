package modelo;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CodigoVerificacion {
    
    private static float TIEMPO_EXPIRACION;
    
    public static void setCodigoVerificacion(HttpServletRequest request, String codigo, float tiempo) {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("cod_verificacion", codigo);
        
        sesion.setAttribute("ts_codigo", new Date());
        TIEMPO_EXPIRACION = tiempo;
        System.out.println(TIEMPO_EXPIRACION);
    }
    
    public static boolean codigoExpirado(HttpServletRequest request) {
        HttpSession sesion = request.getSession();
        String codigoGuardado = (String) sesion.getAttribute("cod_verificacion");
        if (codigoGuardado != null) {
            Date tiempoCreacion = (Date) sesion.getAttribute("ts_codigo");
            long expiracion = tiempoCreacion.getTime() + ((long)TIEMPO_EXPIRACION  * 60 * 1000);
            return System.currentTimeMillis() > expiracion;
        }
        System.out.println(codigoGuardado);
        return true;
    }
    
}