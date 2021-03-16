package internallibrary.project.controllers;


import internallibrary.project.model.Author;
import internallibrary.project.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:3001", maxAge = 3600)
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Integer id){
        return authorService.getAuthor(id);
    }

    @PostMapping
    public Author postAuthor(@RequestBody Author author){
        return authorService.postAuthor(author);
    }
}
