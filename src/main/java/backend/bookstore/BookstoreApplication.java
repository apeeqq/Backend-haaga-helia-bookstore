package backend.bookstore;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner books(BookRepository repository) {
		return (args) -> {
			log.info("save some sample books");
			Book b1 = new Book("Aarteenmetsästys", "John Doe", 2000, "978-3-16-148410-0", new BigDecimal("15"));
			Book b2 = new Book("Hulivili", "Jane Doe", 1800, "072-3-16-135410-5", new BigDecimal("20"));

			repository.save(b1);
			repository.save(b2);

			log.info("Fetch all the books");
			log.info("Book 1: id={} Title={}, Author={}, Year={}, isbn={}", b1.getId(), b1.getTitle(), b1.getAuthor(), b1.getPublicationYear(), b1.getIsbn());
			log.info("Book 2: id={} Title={}, Author={}, Year={}, isbn={}", b2.getId(), b2.getTitle(), b2.getAuthor(), b2.getPublicationYear(), b2.getIsbn());
		};
	}

}
