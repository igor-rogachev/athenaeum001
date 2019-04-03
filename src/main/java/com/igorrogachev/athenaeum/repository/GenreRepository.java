package com.igorrogachev.athenaeum.repository;

import com.igorrogachev.athenaeum.domain.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository  extends CrudRepository<Genre, Integer> {
}
