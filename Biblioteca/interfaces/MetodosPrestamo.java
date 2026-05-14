package Biblioteca.interfaces;

import Biblioteca.enums.ESTATUS;

public interface MetodosPrestamo {
    String toString();
    public void cambiarEstatus(ESTATUS nuevoEstatus);
    public void actualizarEstatus();

}
