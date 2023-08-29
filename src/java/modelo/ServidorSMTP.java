
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class ServidorSMTP {
    private static Properties propiedades;
    private static void cargarConfiguracion() throws InvalidParameterException, IOException {
        File f = new File(Info.R_CREDENCIALES_SMPT);
        if (!f.exists()) ConfigurarEnvio.setCredenciales(f);
        System.out.println("Archivo de credenciales: "+f.getAbsolutePath());
        InputStream is = new FileInputStream(f);
        
        propiedades.load(is);
        if (propiedades.get(Info.P_CORREO_SMTP) == null || ((String)propiedades.get(Info.P_CORREO_SMTP)).isEmpty() ||
            propiedades.get(Info.P_CLAVE_SMTP) == null || ((String)propiedades.get(Info.P_CLAVE_SMTP)).isEmpty())
        {
            ConfigurarEnvio.setCredenciales(f);
            cargarConfiguracion();
        }

    }
    public static boolean enviarEmail(String para, String asunto,String contenido) throws IOException {
        if (para==null) return false;

        
        System.out.println("tamo vivos");

        propiedades = new Properties();
        cargarConfiguracion();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
        propiedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        final String remitente = propiedades.getProperty(Info.P_CORREO_SMTP);
        final String clave = propiedades.getProperty(Info.P_CLAVE_SMTP);
        
        Session session = Session.getInstance(propiedades, new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
             }
          });
        try {

         Message mensaje;

         mensaje = new javax.mail.internet.MimeMessage(session);

         mensaje.setFrom(new InternetAddress(remitente));
         mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
         mensaje.setSubject(asunto);
         Multipart contenidoHTML = new MimeMultipart();
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(contenido, "text/html");
        contenidoHTML.addBodyPart(htmlPart);
         mensaje.setContent(contenidoHTML);


         Transport.send(mensaje);

         System.out.println("Correo electrónico enviado.");
         return true;
        } catch (MessagingException e) {
            return false;
        }
   }
}
