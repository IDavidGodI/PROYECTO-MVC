package modelo;

public class Estudiante {
    String cc, nombre, cod_curso;
    float nota;

    public Estudiante(String cc, String nombre, String cod_materia, float nota) {
        this.cc = cc;
        this.nombre = nombre;
        this.cod_curso = cod_materia;
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

    public String getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(String cod_materia) {
        this.cod_curso = cod_materia;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    
}
