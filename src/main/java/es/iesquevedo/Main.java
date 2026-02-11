package es.iesquevedo;

import org.jboss.weld.environment.se.Weld;
import jakarta.enterprise.inject.se.SeContainer;
import es.iesquevedo.app.ConsoleApp;

public class Main {
    public static void main(String[] args) {

        // Iniciamos el contenedor de CDI
        try (SeContainer container = Weld.newInstance().initialize()) {

            // Pedimos nuestra aplicación ya montada
            ConsoleApp app = container.select(ConsoleApp.class).get();

            // Arrancamos el menú
            app.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}