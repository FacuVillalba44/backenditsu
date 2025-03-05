package edu.itsu.inscripciones.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {
    private static final Logger logger = LoggerFactory.getLogger(DotenvConfig.class);

    public DotenvConfig() {
        try {
            Dotenv dotenv = Dotenv.configure()
                .directory("./") // Busca .env en la raíz del proyecto
                .ignoreIfMissing() // No falla si .env no existe
                .load();
            if (dotenv != null) {
                dotenv.entries().forEach(entry -> {
                    System.setProperty(entry.getKey(), entry.getValue());
                    logger.info("Cargada variable de entorno: {} = {}", entry.getKey(), entry.getValue());
                });
            } else {
                logger.warn("No se encontró el archivo .env; usando valores por defecto.");
            }
        } catch (Exception e) {
            logger.error("Error al cargar el archivo .env: {}", e.getMessage(), e);
        }
    }
}