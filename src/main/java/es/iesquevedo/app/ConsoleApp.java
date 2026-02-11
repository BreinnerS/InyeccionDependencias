package es.iesquevedo.app;

import es.iesquevedo.dao.JsonSocioDao;
import es.iesquevedo.modelo.Socio;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@ApplicationScoped
public class ConsoleApp {
    private final JsonSocioDao socioDao;


    // los DAOs/servicio se crean internamente
    @Inject
    public ConsoleApp(JsonSocioDao socioDao) {
        this.socioDao = socioDao;
    }


    public void crearSocio(Scanner scanner) {
        System.out.print("DNI: ");
        String dni = scanner.nextLine().trim();
        if (dni.isEmpty()) {
            System.out.println("DNI vacío");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Nombre vacío");
            return;
        }
        Socio s = new Socio(dni, nombre);
        socioDao.save(s);
        System.out.println("Socio guardado: " + s);
    }

    public void listarSocios() {
        List<Socio> list = socioDao.findAll();
        if (list.isEmpty()) System.out.println("No hay socios");
        else list.forEach(System.out::println);
    }

    public void eliminarSocio(Scanner scanner) {
        System.out.print("DNI a eliminar: ");
        String dni = scanner.nextLine().trim();
        if (dni.isEmpty()) {
            System.out.println("DNI vacío");
            return;
        }
        Optional<Socio> s = socioDao.findByDni(dni);
        if (s.isEmpty()) {
            System.out.println("No existe un socio con ese DNI");
            return;
        }
        Socio socio = s.get();
        socioDao.remove(socio);
        System.out.println("Socio eliminado: " + s);
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTIÓN DE SOCIOS ---");
            System.out.println("1. Listar socios");
            System.out.println("2. Crear socio");
            System.out.println("3. Eliminar socio");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    listarSocios();
                    break;
                case "2":
                    crearSocio(scanner);
                    break;
                case "3":
                    eliminarSocio(scanner);
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        System.out.println("¡Adiós!");
    }
}
