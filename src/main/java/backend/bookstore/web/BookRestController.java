package backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;

@Controller
@RequestMapping("/rest")
public class BookRestController {    

        private BookRepository repository;

        public BookRestController(BookRepository repository) {
            this.repository = repository;
        }

        @GetMapping("/books")
        public @ResponseBody List<Book> findAllBooksRest() {
            return (List<Book>) repository.findAll();
        }

        @GetMapping("/books/{id}")
        public @ResponseBody Optional<Book> getOneBookRest(@PathVariable("id") Long id) {
            return repository.findById(id);
        }

}
