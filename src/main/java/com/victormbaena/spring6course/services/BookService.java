package com.victormbaena.spring6course.services;

import com.victormbaena.spring6course.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
