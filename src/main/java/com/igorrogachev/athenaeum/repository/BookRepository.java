package com.igorrogachev.athenaeum.repository;

import com.igorrogachev.athenaeum.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
