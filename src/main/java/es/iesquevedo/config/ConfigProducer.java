package es.iesquevedo.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import java.nio.file.Path;
import java.nio.file.Paths;

@ApplicationScoped
public class ConfigProducer {

    @Produces
    @Named("fileSocios") // Este es el nombre clave para pedir el archivo
    public Path getPath() {
        // user.dir apunta a la raíz de tu proyecto InyeccionDependencias
        return Paths.get(System.getProperty("user.dir"), "socios.json");
    }
}