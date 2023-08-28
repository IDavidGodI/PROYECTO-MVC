package controlador;

/**
 *
 * @author Lenovo
 */
public class CredencialesInvalidas extends Exception{

    public CredencialesInvalidas() {
    }

    public CredencialesInvalidas(String msg) {
        super(msg);
    }
}
