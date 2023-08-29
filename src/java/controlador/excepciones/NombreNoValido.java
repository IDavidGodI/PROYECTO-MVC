package controlador.excepciones;

/**
 *
 * @author Lenovo
 */
public class NombreNoValido extends Exception {

    public NombreNoValido() {
    }

    public NombreNoValido(String msg) {
        super(msg);
    }
}
