package backend.bookstore;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.AppUser;
import backend.bookstore.domain.AppUserRepository;
import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;
import backend.bookstore.domain.Category;
import backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
	private final AppUserRepository appUserRepository;
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    BookstoreApplication(CategoryRepository categoryRepository, BookRepository bookRepository, AppUserRepository appUserRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
		this.appUserRepository = appUserRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner books(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {

			log.info("save some sample categories");
			Category sports= new Category("Sports");
			Category childrensBooks = new Category("Children's Books");

			crepository.save(sports);
			crepository.save(childrensBooks);

			log.info("save some sample books");
			Book b1 = new Book("Aarteenmetsästys", "John Doe", 2000, "978-3-16-148410-0", new BigDecimal("15"), crepository.findByName("Children's Books").get(0));
			Book b2 = new Book("Hulivili", "Jane Doe", 1800, "072-3-16-135410-5", new BigDecimal("20"), crepository.findByName("Children's Books").get(0));
			Book b3 = new Book("The New Encyclopedia of Modern Bodybuilding : The Bible of Bodybuilding, Fully Updated and Revised", "Arnold Schwarzenegger", 1999, "978-0684857213", new BigDecimal("20"), crepository.findByName("Sports").get(0));

			brepository.save(b1);
			brepository.save(b2);
			brepository.save(b3);

			log.info("Fetch all the categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			log.info("Fetch all the books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			AppUser user1 = new AppUser("user1", "$2a$10$3OImzXAjA85zn2pMFfgziO8CGYXl/TG.ZyVjmfuHsn9xb0Kif7huG", "user1@user1.com", "USER");
			AppUser user2 = new AppUser("user2", "$2a$10$H40D4DtLswoiYD.i/jWRNOZNrXeEsRBUhNuTR8ycRXiL7wh45pHtS", "user2@user2.com", "ADMIN");

			appUserRepository.save(user1);
			appUserRepository.save(user2);

		};
	}

}
