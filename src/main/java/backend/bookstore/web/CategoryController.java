package backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import backend.bookstore.domain.Category;
import backend.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired 
    private CategoryRepository repository;

        public CategoryController() {
    }

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categorylist")
    public String getCategorylist(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String addBook(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/savecategory")
    public String save(Category category) {
        repository.save(category);
        return "redirect:/categorylist";
    }

}
