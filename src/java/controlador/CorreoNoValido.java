package controlador;

/**
 *
 * @author Lenovo
 */
public class CorreoNoValido extends Exception{

    
    public CorreoNoValido() {
    }

    public CorreoNoValido(String msg) {
        super(msg);
    }
}

