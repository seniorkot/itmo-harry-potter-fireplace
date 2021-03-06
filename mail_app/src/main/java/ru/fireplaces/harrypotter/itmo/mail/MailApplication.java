package ru.fireplaces.harrypotter.itmo.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application main class.
 *
 * @author seniorkot
 */
@SpringBootApplication
public class MailApplication {

    /**
     * Main method.<br>
     * Runs Spring Boot application.
     *
     * @param args App arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class, args);
    }
}
