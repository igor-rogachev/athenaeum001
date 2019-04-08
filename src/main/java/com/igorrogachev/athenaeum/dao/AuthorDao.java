package com.igorrogachev.athenaeum.dao;

import com.igorrogachev.athenaeum.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDao extends CrudRepository<Author, Long> {
}
