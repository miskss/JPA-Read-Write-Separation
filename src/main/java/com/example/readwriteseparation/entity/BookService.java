package com.example.readwriteseparation.entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author peter
 * date 2020/11/18 15:53
 */
@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = false)
    public Book save(final String name) {
        return repository.save(new Book(name));
    }

    @Transactional(readOnly = true)
    public Book findOne(final Long id) {
        return repository.findById(id).orElse(null);
    }


}
