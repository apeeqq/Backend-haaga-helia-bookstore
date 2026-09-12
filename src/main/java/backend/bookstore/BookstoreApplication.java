package backend.bookstore;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner books(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Aarteenmetsästys", "John Doe", 2000, "978-3-16-148410-0", new BigDecimal("15"));
			Book b2 = new Book("Hulivili", "Jane Doe", 1800, "072-3-16-135410-5", new BigDecimal("20"));

		};
	}

}
