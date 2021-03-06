package internallibrary.project.controllers;


import internallibrary.project.model.Resource;
import internallibrary.project.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/resource")
public class ResourceRestController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public ResponseEntity<List<Resource>> getResources() {
        return new ResponseEntity<>(resourceService.getResources(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postResource(@Valid @RequestBody Resource resource,
                                          BindingResult bindingResult) {

        System.out.println(bindingResult);
        if (!bindingResult.hasErrors()) {

            resourceService.saveResource(resource);
        } else {

            return resourceService.bindingResultErrors(bindingResult);
        }

        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> putResource(@Valid @RequestBody Resource resource,
                                         BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {

            resourceService.saveResource(resource);
        } else {

            return resourceService.bindingResultErrors(bindingResult);
        }

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResource(@PathVariable Integer id) {
        return new ResponseEntity<>(resourceService.getResource(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable Integer id) {
        return new ResponseEntity<>(resourceService.deleteResource(id), HttpStatus.OK);
    }


}
