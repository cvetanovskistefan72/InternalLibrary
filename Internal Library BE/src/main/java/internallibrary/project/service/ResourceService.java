package internallibrary.project.service;


import internallibrary.project.model.Resource;
import internallibrary.project.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService extends BindingResultErrors {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getResources() {
        return resourceRepository.findAll();
    }



    public void saveResource(Resource resource) {
        resourceRepository.save(resource);
    }

    public Resource getResource(Integer id) {
        return resourceRepository.findResourceById(id);
    }

    public Resource deleteResource(Integer id) {

        Resource resource = resourceRepository.findResourceById(id);
        resourceRepository.delete(resource);
        return resource;
    }

}
