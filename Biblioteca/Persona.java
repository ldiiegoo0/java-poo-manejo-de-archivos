package Biblioteca;
import Biblioteca.enums.AREA;

public class Persona {

    protected String nombre;
    protected String apellido;
    protected String correo;
    protected String celular;
    protected AREA area; 

    public Persona(String nombre, String apellido, String correo, String celular, AREA area) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.area = area;

    }




   
}