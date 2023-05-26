package com.victormbaena.spring6course.repositories;

import com.victormbaena.spring6course.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
