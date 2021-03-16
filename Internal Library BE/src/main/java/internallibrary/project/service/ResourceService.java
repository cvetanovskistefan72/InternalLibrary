package internallibrary.project.service;


import internallibrary.project.model.Author;
import internallibrary.project.model.Resource;
import internallibrary.project.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService extends BindingResultErrors {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private  AuthorService authorService;

    public List<Resource> getResources() {
        return resourceRepository.findAll();
    }



    public void saveResource(Resource resource) {
        List<Author> authors = resource.getAuthors();
        List<Author> newAuthors = new ArrayList<>();
        System.out.println(authors);
        for(Author author : authors){
            author.setResources(null);
            if(author.getId()!=null){
                newAuthors.add(authorService.getAuthor(author.getId()));
            }else{
                Author author2 = authorService.postAuthor(author);
                newAuthors.add(author2);
            }
        }

        resource.setAuthors(newAuthors);
        resourceRepository.save(resource);
    }

    public Resource getResource(Integer id) {
        return resourceRepository.findResourceById(id);
    }

    public Resource deleteResource(Resource resource) {
        resourceRepository.delete(resource);
        return resource;
    }



}
