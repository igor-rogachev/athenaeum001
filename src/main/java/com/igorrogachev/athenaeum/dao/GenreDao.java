package com.igorrogachev.athenaeum.dao;

import com.igorrogachev.athenaeum.entity.Genre;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface GenreDao extends CrudRepository<Genre, Integer> {
}
