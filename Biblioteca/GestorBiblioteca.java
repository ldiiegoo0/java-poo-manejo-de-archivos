package Biblioteca;
import Biblioteca.enums.AREA;
import Biblioteca.enums.ESTATUS;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
@SuppressWarnings("all")
public class GestorBiblioteca {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Solicitante> solicitantes = new ArrayList<>();
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        int opcion;
        do {
            System.out.println("==========Bienvenido a la Biblioteca==========");
            System.out.println("1. añadir un nuevo libro a la biblioteca ");
            System.out.println("2. añadir un solicitante");
            System.out.println("3. añadir un Prestamo");
            System.out.println("4. ver contenido de los archivos ");
            System.out.println("5. Generar informes de libros populares(mas solicitados)");
            System.out.println("6. informe de entregas atrasadas.");
            System.out.println("7. Salir del programa");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    agregarLibros(libros);
                    break;
                case 2:
                    agregarSolicitante(solicitantes);
                    break;
                case 3:

                    agregarPrestamo(prestamos);
                    break;
                case 4:
                    leerArchivos();
                    break;
                case 5: 
                    librosPopulares();
                    break;
                case 6: 
                    atrasados();
                case 7: 
                System.out.println("Saliendo del Programa");
                break;
                default:
                    System.out.println("opcion invalida intenta de nuevo");
                    
            }
        } while (opcion > 0 && opcion < 7);
    }

    public static void librosPopulares() {
        ArrayList<Prestamo> prestamos = cargarPrestamosArchivo();
        ArrayList<String> idContado = new ArrayList<>();
        ArrayList<Integer> conteo = new ArrayList<>();

        for(Prestamo p : prestamos) {
            String libroId = p.getidLibro();
            int indice = idContado.indexOf(libroId);

            if(indice != -1) {
                conteo.set(indice, conteo.get(indice) + 1);
            }
            else {
                idContado.add(libroId);
                conteo.add(1);
            }
        }
        System.out.println("Libros mas prestados: ");
         for (int i = 0; i < idContado.size(); i++) {
            
            System.out.println("ID de Libro: " + idContado.get(i) + ":" + conteo.get(i) + " veces prestadas");
        }

    }

    public static void agregarLibros(ArrayList<Libro> libros) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----Registro Libro----");
        System.out.println("Ingrese el ID del libro:");
        String idLibro = sc.nextLine();
        System.out.println("Ingrese el area del libro (BASICA/MEDIA): ");
        AREA area = AREA.valueOf(sc.nextLine().toUpperCase()); 
        System.out.println("Ingrese la categoria: ");
        String categoria = sc.nextLine();
        System.out.println("Ingrese el nombre del autor: ");
        String autor = sc.nextLine();
        System.out.println("Ingrese el título del libro: ");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el año de publicación: ");
        String año = sc.nextLine();
        Libro li = new Libro(idLibro, area, categoria, autor, titulo, año);
        libros.add(li); 
        Bibliotecas bi = new Bibliotecas();
        bi.guardarLibros(li.toString());
    }

    public static void agregarSolicitante(ArrayList<Solicitante> solicitantes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----Registro Solicitante----");
        System.out.println("Ingrese el ID del solicitante: ");
        int idSolicitante = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el nombre del solicitante: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del solicitante: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese el correo del solicitante: ");
        String correo = sc.nextLine();
        System.out.println("Ingrese el celular del solicitante: ");
        String celular = sc.nextLine();
        System.out.println("Ingrese el área del solicitante (BASICA/MEDIA): ");
        AREA area = AREA.valueOf(sc.nextLine().toUpperCase());
        Solicitante soli = new Solicitante(idSolicitante, nombre, apellido, correo, celular, area); 
        solicitantes.add(soli);
        Bibliotecas bi = new Bibliotecas();
        bi.guardarSolicitantes(soli.toString());
    }

    public static void agregarPrestamo(ArrayList<Prestamo> prestamos) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID del préstamo: ");
        String idPrestamo = sc.nextLine();
        System.out.print("Ingrese la fecha del préstamo (dd/MM/yyyy): ");
        String fechaPrestamo = sc.nextLine();
        System.out.print("Ingrese el ID del solicitante: ");
        String idSolicitante = sc.nextLine();
        System.out.print("Ingrese el ID del libro: ");
        String idLibro = sc.nextLine();
        System.out.print("Ingrese la fecha de devolución (dd/MM/yyyy): ");
        String devolucion = sc.nextLine();
        System.out.print("Ingrese la fecha de entrega (dd/MM/yyyy): ");
        String entrega = sc.nextLine();
        System.out.print("Ingrese los días de préstamo: ");
        String diasPrestamo = sc.nextLine();
        System.out.print("Ingrese el estatus (ACTIVO, DEVUELTO, ATRASADO): ");
        ESTATUS estatus = ESTATUS.valueOf(sc.nextLine().toUpperCase());
        Prestamo pre = new Prestamo(idPrestamo, fechaPrestamo, idSolicitante, idLibro, devolucion, entrega, diasPrestamo, estatus);
        prestamos.add(pre);
        Bibliotecas bi = new Bibliotecas();
        bi.guardarPrestamo(pre.toString());
        pre.actualizarEstatus();
    }

    public static void leerArchivos() throws IOException {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        System.out.println("Ingrese el nombre del archivo que desea leer: ");
        respuesta = sc.nextLine();

        if(respuesta.equalsIgnoreCase("libros")) {
            Bibliotecas biblio = new Bibliotecas();
            biblio.leerLibros();
        }
        else if(respuesta.equalsIgnoreCase("solicitantes")) {
             Bibliotecas biblio = new Bibliotecas();
            biblio.leerSolicitante();
        }
        else if(respuesta.equalsIgnoreCase("prestamo")) {
             Bibliotecas biblio = new Bibliotecas();
            biblio.leerPrestamo();
        }
    }

    public static void atrasados() {
        ArrayList<Prestamo> prestamos = cargarPrestamosArchivo();
        System.out.println("\nPrestamos atrasados: ");
         for (Prestamo p : prestamos) {
            if (p.getEstatus() == ESTATUS.valueOf("ATRASADO")) {
                System.out.println(p.toString());
            }
        }

    }

    public static ArrayList<Prestamo> cargarPrestamosArchivo() {
    ArrayList<Prestamo> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Practica Java\\Biblioteca\\prestamo.txt"))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            if (linea.trim().isEmpty()) continue; 

            String[] partes = linea.split(";");
            if (partes.length < 8) {
                System.out.println("Línea malformada ignorada: " + linea);
                continue;
            }
            Prestamo p = new Prestamo(
                partes[0],
                partes[1],
                partes[2],
                partes[3],
                partes[4],
                partes[5],
                partes[6],
                ESTATUS.valueOf(partes[7].toUpperCase())
            );
            lista.add(p);
        }
    } catch (IOException e) {
        System.out.println("Error leyendo prestamos.txt");
    }
    return lista;
}

}
    

