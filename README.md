# java-poo-manejo-de-archivos
Este repositorio contiene un proyecto que demuestra el dominio de la Programación Orientada a Objetos (POO) avanzada y la gestión de flujos de datos en Java.

## Sistema de Gestión de Biblioteca (Library Management System)

Un sistema robusto diseñado para administrar el inventario de libros, el registro de solicitantes y el control de préstamos mediante persistencia en archivos planos.

### Características Técnicas:
* **Arquitectura de Herencia:** Clase base `Persona` extendida por `Solicitante` para reutilización de atributos comunes.
* **Diseño basado en Interfaces:** Implementación de los contratos `MetodosLibro`, `MetodosPrestamo` y `MetodosSolicitante` para estandarizar comportamientos.
* **Persistencia de Datos (File I/O):** Uso de `BufferedWriter` y `BufferedReader` para el almacenamiento y recuperación de información en archivos `.txt`.
* **Lógica de Negocio y Reportes:**
    * Cálculo dinámico del estatus de préstamo (ACTIVO, DEVUELTO, ATRASADO) basado en fechas con `java.time`.
    * Generación de informes de popularidad (libros más solicitados).
    * Detección y listado de entregas atrasadas.
* **Tipado Seguro:** Uso de `Enums` (`AREA`, `ESTATUS`) para limitar y validar los estados del sistema.
