package com.victormbaena.spring6course.repositories;

import com.victormbaena.spring6course.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
