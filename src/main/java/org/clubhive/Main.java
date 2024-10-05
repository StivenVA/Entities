package org.clubhive;

import lombok.RequiredArgsConstructor;
import org.clubhive.repositories.implement.CustomerRepoImpl;
import org.clubhive.repositories.implement.OrganizerRepoImpl;
import org.clubhive.repositories.jpa.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class Main {

    @Autowired
    private CustomerRepoImpl customerRepo;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        // Obtener el bean de la clase Main gestionado por Spring
        Main main = context.getBean(Main.class);


        main.test();
    }

    public void test() {
        System.out.println(customerRepo.findAll());
    }
}

