package com.run;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author edxuanlen
 */




@MapperScan(value = "com.run.mapper")
@SpringBootApplication
public class QuestionaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionaireApplication.class, args);
    }

}
