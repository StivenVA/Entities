package org.clubhive;

import lombok.RequiredArgsConstructor;

import org.clubhive.repositories.implement.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.naming.Context;

@SpringBootApplication
@RequiredArgsConstructor
public class Main {

    @Autowired
    private DetailRepository detailRepository;

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);

        applicationContext.getBean(Main.class).test();

    }

    public void test(){
        System.out.println(detailRepository.findByQr("CHQR-ce315644-e4c5-4bc8-972b-e686b4e6ce6a"));
    }
}
