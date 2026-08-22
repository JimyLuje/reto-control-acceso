package puce.edu.ec;

public class Asistente {
    private String nombre;
    private int edad;

    public Asistente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}