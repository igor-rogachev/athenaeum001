package com.igorrogachev.athenaeum.dao;

import com.igorrogachev.athenaeum.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Integer> {
}
