/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador;

/**
 *
 * @author Lenovo
 */
public class InfoCursoNoValida extends Exception{
    public InfoCursoNoValida() {
    }

    public InfoCursoNoValida(String msg) {
        super(msg);
    }
}
