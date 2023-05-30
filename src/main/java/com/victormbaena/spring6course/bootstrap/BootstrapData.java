package com.victormbaena.spring6course.bootstrap;

import com.victormbaena.spring6course.domain.Author;
import com.victormbaena.spring6course.domain.Book;
import com.victormbaena.spring6course.domain.Publisher;
import com.victormbaena.spring6course.repositories.AuthorRepository;
import com.victormbaena.spring6course.repositories.BookRepository;
import com.victormbaena.spring6course.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Author erin = new Author();
        erin.setFirstName("Erin");
        erin.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123123123");

        Author erinSaved = authorRepository.save(erin);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("456456456");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        erinSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        dddSaved.getAuthors().add(erinSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher almedina = new Publisher();
        almedina.setPublisherName("Almedina Books");
        almedina.setAddress("Rua da Sofia");
        almedina.setCity("Coimbra");
        almedina.setZip("3000-301");
        almedina.setState("Portugal");

        Publisher almedinaSaved = publisherRepository.save(almedina);

        Publisher bertrand = new Publisher();
        bertrand.setPublisherName("Bertrand Books");
        bertrand.setAddress("Rua da Sofia");
        bertrand.setCity("Lisbon");
        bertrand.setZip("1100-301");
        bertrand.setState("Portugal");

        Publisher bertrandSaved = publisherRepository.save(bertrand);

        dddSaved.setPublisher(bertrandSaved);
        noEJBSaved.setPublisher(almedinaSaved);

        authorRepository.save(erinSaved);
        authorRepository.save(rodSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

        for (Author author :
                authorRepository.findAll()) {
            System.out.println(author);
            System.out.println(author.getBooks());
        }


    }
}
