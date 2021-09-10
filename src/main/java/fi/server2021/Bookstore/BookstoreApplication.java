package fi.server2021.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.server2021.Bookstore.domain.Book;
import fi.server2021.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return(args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Valapatto", "Leena Lehtolainen", 2019, "978-952-04-0829-9", 25.90));
			repository.save(new Book("Mannerheim, tuntematon golffari", "Jukka Paakki", 2021, "978-952-7347-93-5", 25.90));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
