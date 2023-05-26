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

        Publisher almedina = new Publisher();
        almedina.setPublisherName("Almedina Books");
        almedina.setAddress("Rua da Sofia");
        almedina.setCity("Coimbra");
        almedina.setZip("3000-301");
        almedina.setState("Portugal");

        Author erinSaved = authorRepository.save(erin);
        Book dddSaved = bookRepository.save(ddd);
        Publisher almedinaSaved = publisherRepository.save(almedina);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("456456456");

        Publisher bertrand = new Publisher();
        bertrand.setPublisherName("Bertrand Books");
        bertrand.setAddress("Rua da Sofia");
        bertrand.setCity("Lisbon");
        bertrand.setZip("1100-301");
        bertrand.setState("Portugal");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);
        Publisher bertrandSaved = publisherRepository.save(bertrand);

        erinSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(erinSaved);
        authorRepository.save(rodSaved);
        publisherRepository.save(almedinaSaved);
        publisherRepository.save(bertrandSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

        System.out.println("Book list -> ");
        for (Book book : bookRepository.findAll()) {
            System.out.println("Book -> " + book.toString());
        }
        System.out.println("End of Book list");

        System.out.println("Author list -> ");
        for (Author author : authorRepository.findAll()) {
            System.out.println("Author -> " + author.toString());
        }
        System.out.println("End of Author list");

        System.out.println("Publisher list -> ");
        for (Publisher publisher : publisherRepository.findAll()) {
            System.out.println("Publisher -> " + publisher.toString());
        }
        System.out.println("End of Publisher list");

    }
}
