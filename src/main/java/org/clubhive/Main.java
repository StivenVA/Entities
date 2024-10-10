package org.clubhive;

import lombok.RequiredArgsConstructor;
import org.clubhive.model.Detail;
import org.clubhive.model.Ticket;
import org.clubhive.repositories.implement.DetailRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Main {

    private final DetailRepository detailRepository;

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }

    public void test(){
        Detail detail = new Detail();

        Ticket ticket = new Ticket();

        ticket.setIdEvent("17");
        ticket.setQua(13);
    }
}
