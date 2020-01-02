package com.alibaba.statemachine;

/**
 * Application
 *
 * @author Frank Zhang
 * @date 2020-01-02 22:02
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//tag::snippetA[]
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
