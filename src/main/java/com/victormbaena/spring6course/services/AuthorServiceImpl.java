package com.victormbaena.spring6course.services;

import com.victormbaena.spring6course.domain.Author;
import com.victormbaena.spring6course.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;
    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
