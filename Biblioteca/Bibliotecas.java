package Biblioteca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Collectors;
@SuppressWarnings("all")

public class Bibliotecas {

    public void guardarLibros(String data) {
        try {
            FileWriter fw = new FileWriter("C:\\Practica Java\\Biblioteca\\libros.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al guardar el archivo");
        }
    }

    public static void guardarSolicitantes(String data) { 
        try {
            FileWriter fw = new FileWriter("C:\\Practica Java\\Biblioteca\\solicitantes.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al guardar el archivo");
        }
    }
    public void guardarPrestamo(String data) {
        try {
            FileWriter fw = new FileWriter("C:\\Practica Java\\Biblioteca\\prestamo.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al guardar el archivo");
        }
    }

    public void leerPrestamo() throws IOException {   

    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Practica Java\\Biblioteca\\prestamo.txt"))) {
        String linea;
        System.out.println("\nContenido de prestamo: ");
        while ((linea = reader.readLine()) != null) {
            System.out.println(linea);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error al leer el archivo de solicitantes");
    }
    }

    public void leerSolicitante() throws IOException {   

    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Practica Java\\Biblioteca\\solicitantes.txt"))) {
        String linea;
        System.out.println("\nContenido de solicitantes: ");
        while ((linea = reader.readLine()) != null) {
            System.out.println(linea);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error al leer el archivo de solicitantes");
    }
    }

    public void leerLibros() throws IOException {   

    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Practica Java\\Biblioteca\\libros.txt"))) {
        String linea;
        System.out.println("\nContenido de libros: ");
        while ((linea = reader.readLine()) != null) {
            System.out.println(linea);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error al leer el archivo de solicitantes");
    }
    }
    
}
