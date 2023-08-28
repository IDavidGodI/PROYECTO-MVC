package modelo;


public class Info {
    public static final String DIR_CREDENCIALES = "conf";
    public static final String R_CREDENCIALES = DIR_CREDENCIALES+"/credenciales_conexion.props";
    public static final String R_CREDENCIALES_SMPT = DIR_CREDENCIALES+"/configuraciones.prop";
    public static final String R_CREDENCIALES_BD = DIR_CREDENCIALES+"/credenciales_conexion.props";
    
    
    public static final String P_CORREO = "usuario";
    public static final String P_CLAVE = "clave";
    
    public static final String P_CORREO_SMTP = "mail.smtp.user";
    public static final String P_CLAVE_SMTP = "mail.smtp.password";
    public static final String COD_VERIFICACION = "codigoVerificacion";
    public static final String TS_VERIFICACION = "marcaTiempoCodigoVerificacion";
    public static final String USUARIO_REGISTRADO = "registrado";
    public static final String EN_ENVIO = "EnEnvio";
    
    public static final String P_USUARIO_BD = "usuario";
    public static final String P_CLAVE_BD = "clave";
}
