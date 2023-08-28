package modelo;

public class Curso {
    
    String cod,nombre, cc_profesor, hora_i, hora_f;

    public Curso(String cod, String nombre, String cc_profesor, String hora_i, String hora_f) {
        this.cod = cod;
        this.nombre = nombre;
        this.cc_profesor = cc_profesor;
        this.hora_i = hora_i;
        this.hora_f = hora_f;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCc_profesor() {
        return cc_profesor;
    }

    public void setCc_profesor(String cc_profesor) {
        this.cc_profesor = cc_profesor;
    }

    public String getHora_i() {
        int punto = hora_i.indexOf(".");
        if (punto>0){
            return hora_i.substring(0,punto);
        }
        return hora_i;
    }

    public void setHora_i(String hora_i) {
        this.hora_i = hora_i;
    }

    public String getHora_f() {
        int punto = hora_f.indexOf(".");
        if (punto>0){
            return hora_f.substring(0,punto);
        }
        return hora_f;
    }

    public void setHora_f(String hora_f) {
        this.hora_f = hora_f;
    }
    
    
}
