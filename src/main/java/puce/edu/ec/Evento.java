package puce.edu.ec;

public class Evento {
    private String nombreEvento;
    private double precioEntrada;
    private Asistente[] asistentes;
    private int contadorAsistentes;

    public Evento(String nombreEvento, int capacidad, double precioEntrada) {
        this.nombreEvento = nombreEvento;
        this.precioEntrada = precioEntrada;
        this.asistentes = new Asistente[capacidad];
        this.contadorAsistentes = 0;
    }

    public boolean registrarAsistente(String nombre, int edad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println(" Error: El nombre no puede estar vacío.");
            return false;
        }

        if (edad < 18) {
            System.out.println(" Error: " + nombre + " es menor de edad. Ingreso denegado.");
            return false;
        }

        if (contadorAsistentes >= asistentes.length) {
            System.out.println(" Error: Aforo lleno. No se puede ingresar a " + nombre + ".");
            return false;
        }

        asistentes[contadorAsistentes] = new Asistente(nombre, edad);
        contadorAsistentes++;
        System.out.println(" Acceso concedido a " + nombre + ".");
        return true;
    }

    public double calcularTotalRecaudado() {
        return contadorAsistentes * precioEntrada;
    }

    public void mostrarResumen() {
        System.out.println("\n==========================================");
        System.out.println(" RESUMEN DEL EVENTO: " + nombreEvento);
        System.out.println("Lista de asistentes ingresados:");

        for (int i = 0; i < contadorAsistentes; i++) {
            System.out.println(" - " + asistentes[i].getNombre() + " (" + asistentes[i].getEdad() + " años)");
        }
        System.out.println("Total de asistentes: " + contadorAsistentes + "/" + asistentes.length);
        System.out.println("Cupos disponibles: " + (asistentes.length - contadorAsistentes));
        System.out.println("Monto total recaudado: $" + calcularTotalRecaudado());
        System.out.println("==========================================\n");
    }
}