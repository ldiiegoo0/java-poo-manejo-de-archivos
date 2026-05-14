package Biblioteca;
import java.util.Scanner;
import Biblioteca.enums.AREA;
import Biblioteca.interfaces.MetodosSolicitante; 
@SuppressWarnings("all")

public class Solicitante extends Persona implements MetodosSolicitante{
    Scanner sc = new Scanner(System.in);

    private int idSolicitante;
    
    public Solicitante(int idSolicitante, String nombre, String apellido, String correo, String celular, AREA area) {
        super(nombre, apellido, correo, celular, area);
        this.idSolicitante = idSolicitante;
        nombre = nombre;
        apellido = apellido;
        correo = correo;
        celular = celular;
        area = area;
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    @Override
    public String toString() {
        return idSolicitante + "; " + nombre + "; " + apellido + "; " + correo + "; " + celular + "; " + area + ";";
    }
}
