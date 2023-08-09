package controlador;


public class NotaNoValida extends Exception{

    
    public NotaNoValida() {
    }

    public NotaNoValida(String msg) {
        super(msg);
    }
}
