
package modelo;

public class Profesor {
    public String cc, nombre, correo;

    public Profesor(String cc, String nombre, String correo) {
        this.cc = cc;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
