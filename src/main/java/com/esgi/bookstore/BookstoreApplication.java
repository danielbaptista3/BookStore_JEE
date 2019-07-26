package com.esgi.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackageClasses = {
//        BookstoreApplication.class,
//        Jsr310JpaConverters.class
//})
//@ComponentScan({"com.esgi.bookstore",
//        "com.esgi.bookstore.assembler",
//        "com.esgi.bookstore.controller",
//        "com.esgi.bookstore.exception",
//        "com.esgi.bookstore.model",
//        "com.esgi.bookstore.repository"})
//@EnableJpaRepositories("com.esgi.bookstore.repository")
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
}
