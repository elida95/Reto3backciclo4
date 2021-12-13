package com.limpieza;

import com.limpieza.repository.crud.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.limpieza.repository.crud.CleanCrudRepository;
import com.limpieza.repository.crud.OrderCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class LimpiezaApplication implements CommandLineRunner {

    @Autowired
    private UserCrudRepository userRepo;

    @Autowired
    private CleanCrudRepository supRepo;
    
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(LimpiezaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
      SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      userRepo.deleteAll();
      supRepo.deleteAll();
      orderCrudRepository.deleteAll();


    }

}
