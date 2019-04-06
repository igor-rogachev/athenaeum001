package com.igorrogachev.athenaeum.data.repository;

import com.igorrogachev.athenaeum.data.entity.Genre;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
