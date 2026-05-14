package Biblioteca;
import Biblioteca.enums.ESTATUS;
import Biblioteca.interfaces.MetodosPrestamo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.print.DocFlavor.READER; 
@SuppressWarnings("all")

public class Prestamo implements MetodosPrestamo {
    Scanner sc = new Scanner(System.in);

    private String idPrestamo;
    private String fechaPrestamo;
    private String idSolicitante; 
    private String idLibro;
    private String devolucion; 
    private String entrega; 
    private String diasPrestamo;
    private ESTATUS estatus; 
    
    public Prestamo(String idPrestamo, String fechaPrestamo, String idSolicitante, String idLibro, String devolucion, String entrega, String diasPrestamo, ESTATUS estatus) {
        this.idPrestamo = idPrestamo; 
        this.fechaPrestamo = fechaPrestamo;
        this.idSolicitante = idSolicitante;
        this.idLibro = idLibro;
        this.devolucion = devolucion;
        this.entrega = entrega;
        this.diasPrestamo = diasPrestamo;
        this.estatus = estatus; 
    }

    public ESTATUS getEstatus() {
        return estatus;
    }
    public String getidLibro() {
        return idLibro; 
    }

    @Override
    public String toString() {
        return idPrestamo + "; " + fechaPrestamo + "; " + idSolicitante + "; " + idLibro + "; " + devolucion + "; " + entrega + "; " + diasPrestamo + ";" +estatus ;
    }

    @Override
    public void cambiarEstatus(ESTATUS nuevoEstatus) {
        this.estatus = nuevoEstatus;
    }

    public void actualizarEstatus() {
    if (entrega == null || devolucion == null || entrega.isBlank() || devolucion.isBlank()) {
        System.out.println("Las fechas de entrega o devolución no están completas.");
        return;
    }
    try {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        java.time.LocalDate fechaEntrega = java.time.LocalDate.parse(entrega, formatter);
        java.time.LocalDate fechaDevolucion = java.time.LocalDate.parse(devolucion, formatter);
        if (fechaDevolucion.isAfter(fechaEntrega)) {
            cambiarEstatus(ESTATUS.ATRASADO);
        } else {
            cambiarEstatus(ESTATUS.DEVUELTO);
        }
    } catch (Exception e) {
        System.out.println("Error al analizar las fechas del préstamo: " + e.getMessage());
    }
}
}
