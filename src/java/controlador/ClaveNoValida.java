package controlador;

/**
 *
 * @author Lenovo
 */
public class ClaveNoValida extends Exception{

    
    public ClaveNoValida() {
    }

    public ClaveNoValida(String msg) {
        super(msg);
    }
}