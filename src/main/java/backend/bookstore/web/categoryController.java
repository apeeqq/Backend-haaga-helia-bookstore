package backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import backend.bookstore.domain.CategoryRepository;

@Controller
public class categoryController {

    @Autowired 
    private CategoryRepository repository;

        public categoryController() {
    }

    public categoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categorylist")
    public String getCategorylist(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }

}
