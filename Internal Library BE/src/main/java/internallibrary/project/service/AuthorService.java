package internallibrary.project.service;

import internallibrary.project.model.Author;
import internallibrary.project.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthor(Integer id){
        return authorRepository.findAuthorById(id);
    }

    public Author postAuthor(Author author){ return authorRepository.save(author); }
}
