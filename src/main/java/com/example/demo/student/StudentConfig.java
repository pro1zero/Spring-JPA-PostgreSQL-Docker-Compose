package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository){
        return args ->{

            Student jenish = new Student(10L, "Jenish", "jenish1097@gmail.com", LocalDate.of(1997, Month.OCTOBER, 10));
            Student kanchal = new Student(10L, "Kanchal", "kbsoni1306@gmail.com", LocalDate.of(2002, Month.JUNE, 13));
            repository.saveAll(List.of(jenish, kanchal));
        };
    }
}
