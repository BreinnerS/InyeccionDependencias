package es.iesquevedo.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleApp app = new ConsoleApp();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();
                System.out.print("Elige una opción: ");
                String opt = scanner.nextLine().trim();
                switch (opt) {
                    case "1" -> app.crearSocio(scanner);
                    case "2" -> app.eliminarSocio(scanner);
                    case "3" -> app.listarSocios();
                    case "0" -> {
                        running = false;
                        System.out.println("Saliendo...");
                    }
                    default -> System.out.println("Opción no válida");
                }
                System.out.println();
            }
        }
    }

    private static void printMenu() {
        System.out.println("--- Videoclub ---");
        System.out.println("1) Añadir Socio");
        System.out.println("2) Eliminar Socio");
        System.out.println("3) Listar Socios");
        System.out.println("0) Salir");
    }
}
