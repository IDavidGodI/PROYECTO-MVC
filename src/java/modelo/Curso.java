package modelo;

public class Curso {
    int cod;
    String nombre, cc_profesor, hora_i, hora_f;

    public Curso(int cod, String nombre, String cc_profesor, String hora_i, String hora_f) {
        this.cod = cod;
        this.nombre = nombre;
        this.cc_profesor = cc_profesor;
        this.hora_i = hora_i;
        this.hora_f = hora_f;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
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
        return hora_i;
    }

    public void setHora_i(String hora_i) {
        this.hora_i = hora_i;
    }

    public String getHora_f() {
        return hora_f;
    }

    public void setHora_f(String hora_f) {
        this.hora_f = hora_f;
    }
    
    
}
