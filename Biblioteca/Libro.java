package Biblioteca;
import Biblioteca.enums.AREA;
import java.util.Scanner;
import Biblioteca.interfaces.MetodosLibro; 
@SuppressWarnings("all")

public class Libro implements MetodosLibro {
    Scanner sc = new Scanner(System.in);

    private String idLibro;
    private AREA area;
    private String categoria; 
    private String autor;
    private String titulo;
    private String año;

    
    public Libro(String idLibro, AREA area, String categoria, String autor, String titulo, String año) {
        this.idLibro = idLibro;
        this.area = area;
        this.categoria = categoria;
        this.autor = autor;
        this.titulo = titulo;
        this.año = año;
    }

     public Libro() {
    }

     @Override
    public String toString() {
        return idLibro + " | " + area + " | " + categoria + " | " + autor + " | " + titulo + " | " + año;
    }
    
    public String getidLibro () {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }
}
