package com.igorrogachev.athenaeum.data.repository;

import com.igorrogachev.athenaeum.data.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
