package com.example.readwriteseparation.entity;

import com.example.readwriteseparation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author peter
 * date 2020/11/18 15:51
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
