package puce.edu.ec;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Evento evento = new Evento("Clásico Deportivo", 5, 10.0);

        System.out.println("--- SISTEMA DE CONTROL DE ACCESO A EVENTOS ---");
        while (true) {
            System.out.println("\n1. Registrar Asistente");
            System.out.println("2. Ver Resumen y Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(" Error: Debe ingresar un número entero válido.");
                scanner.nextLine();
                continue;
            }

            if (opcion == 1) {
                System.out.print("Nombre del asistente: ");
                String nombre = scanner.nextLine();

                int edad = -1;
                while (true) {
                    System.out.print("Edad del asistente: ");
                    try {
                        edad = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println(" Error: La edad debe ser un número. Intente de nuevo.");
                        scanner.nextLine();
                    }
                }

                evento.registrarAsistente(nombre, edad);
            } else if (opcion == 2) {
                evento.mostrarResumen();
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}