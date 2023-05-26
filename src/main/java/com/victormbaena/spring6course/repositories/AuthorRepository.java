package com.victormbaena.spring6course.repositories;

import com.victormbaena.spring6course.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
