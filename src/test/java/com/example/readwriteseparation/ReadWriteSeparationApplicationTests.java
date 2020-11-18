package com.example.readwriteseparation;

import com.example.readwriteseparation.entity.Book;
import com.example.readwriteseparation.entity.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReadWriteSeparationApplicationTests {
    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {

//        bookService.save("xx");

        Book one = bookService.findOne(1L);

        System.out.println(one);
    }

}
