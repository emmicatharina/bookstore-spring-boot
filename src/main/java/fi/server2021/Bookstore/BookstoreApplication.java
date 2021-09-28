package fi.server2021.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.server2021.Bookstore.domain.Book;
import fi.server2021.Bookstore.domain.BookRepository;
import fi.server2021.Bookstore.domain.Category;
import fi.server2021.Bookstore.domain.CategoryRepository;
import fi.server2021.Bookstore.domain.User;
import fi.server2021.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return(args) -> {
			
			log.info("save a couple of categorys");
			crepository.save(new Category("novel"));
			crepository.save(new Category("short story"));
			
			log.info("save a couple of books");
			brepository.save(new Book("Valapatto", "Leena Lehtolainen", 2019, "978-952-04-0829-9", 25.90, crepository.findByName("novel").get(0)));
			brepository.save(new Book("Mannerheim, tuntematon golffari", "Jukka Paakki", 2021, "978-952-7347-93-5", 25.90, crepository.findByName("novel").get(0)));
			
			log.info("create users");
			urepository.save(new User("user", "$2a$10$3q0D8buuuE06yL0qImeXAeomR66j.X7n2VnNt/my7MI6iz/m60cQO", "USER"));
			urepository.save(new User("admin", "$2a$10$j/Q1/tLRHx8qQoM1p2uEj.UAKWc0KTTZcEx70RcxEq5rmUR7IU9LC", "ADMIN"));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
