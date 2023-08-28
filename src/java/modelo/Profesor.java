
package modelo;

public class Profesor {
    public String nombre, correo;
    public int ID;
    public Profesor(int id, String nombre, String correo) {
        this.ID = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
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
