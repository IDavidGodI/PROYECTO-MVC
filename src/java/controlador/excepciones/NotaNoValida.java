package controlador.excepciones;


public class NotaNoValida extends Exception{

    
    public NotaNoValida() {
    }

    public NotaNoValida(String msg) {
        super(msg);
    }
}
