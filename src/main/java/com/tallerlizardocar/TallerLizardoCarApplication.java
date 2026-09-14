package com.tallerlizardocar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot del sistema Taller Lizardo Car.
 *
 * La anotación @SpringBootApplication combina tres anotaciones de Spring:
 *  - @Configuration: permite definir configuración de beans en esta clase.
 *  - @EnableAutoConfiguration: configura automáticamente el servidor web
 *    embebido (Tomcat), Thymeleaf y el acceso a datos, a partir de las
 *    dependencias declaradas en el pom.xml.
 *  - @ComponentScan: escanea el paquete com.tallerlizardocar y sus
 *    subpaquetes en busca de componentes de Spring (@Controller,
 *    @Service, @Repository).
 */
@SpringBootApplication
public class TallerLizardoCarApplication {

    /**
     * Punto de entrada de la aplicación. Levanta el servidor embebido
     * (Tomcat) en el puerto configurado en application.properties.
     */
    public static void main(String[] args) {
        SpringApplication.run(TallerLizardoCarApplication.class, args);
    }
}
