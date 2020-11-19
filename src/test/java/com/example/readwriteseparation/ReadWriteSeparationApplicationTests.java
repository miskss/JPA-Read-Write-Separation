package com.example.readwriteseparation;

import com.example.readwriteseparation.entity.Book;
import com.example.readwriteseparation.entity.BookService;
import com.example.readwriteseparation.entity.BookUpdateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReadWriteSeparationApplicationTests {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookUpdateService bookUpdateService;
    @Test
    void contextLoads() {
//        Book one = bookService.findOne(1L);
//        System.out.println(one);
        bookUpdateService.update(1L,"小羊羔2");
    }

}
