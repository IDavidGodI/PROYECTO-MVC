package modelo;

public class Estudiante {
    String cc, nombre;
    int cod_materia;
    float nota;

    public Estudiante(String cc, String nombre, int cod_materia, float nota) {
        this.cc = cc;
        this.nombre = nombre;
        this.cod_materia = cod_materia;
        this.nota = nota;
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

    public int getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(int cod_materia) {
        this.cod_materia = cod_materia;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    
}
