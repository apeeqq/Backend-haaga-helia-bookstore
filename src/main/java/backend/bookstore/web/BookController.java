package backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import backend.bookstore.domain.BookRepository;

@Controller 
public class BookController {

    @Autowired 
    private BookRepository repository;

    public BookController() {
    }

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/index")
    public String getHome(){
        return "index";
    }

    @GetMapping("/booklist")
    public String getBooklist(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

}
