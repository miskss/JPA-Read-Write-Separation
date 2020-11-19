package com.example.readwriteseparation.entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author peter
 * date 2020/11/18 17:52
 */
@Service
public class BookUpdateService {

    private final BookService bookService;

    public BookUpdateService(BookService bookService) {
        this.bookService = bookService;
    }

    @Transactional
    public void update(Long id, String name) {
        Book one = bookService.findOne(id);
        System.out.println("update ==> " + one);
        if (one != null) {
            one.setName(name);
        }
    }
}
