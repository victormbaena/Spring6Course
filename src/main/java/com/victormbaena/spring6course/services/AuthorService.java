package com.victormbaena.spring6course.services;

import com.victormbaena.spring6course.domain.Author;
import com.victormbaena.spring6course.domain.Book;
import org.springframework.stereotype.Service;

public interface AuthorService {
    Iterable<Author> findAll();
}
