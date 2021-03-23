package internallibrary.project.controllers;


import internallibrary.project.model.Borrowed;
import internallibrary.project.service.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowed")
@CrossOrigin(origins = "http://localhost:3001", maxAge = 3600)
public class BorrowedRestController {
    @Autowired
    public BorrowedService borrowedService;
    @PostMapping
    public void addResourceToBorrowed(@RequestBody Borrowed borrowed){
        borrowedService.addResourceToBorrowed(borrowed);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getBorrowedByUserId(@PathVariable String userId){
        return new ResponseEntity<>(borrowedService.getBorrowed(userId), HttpStatus.OK);
    }

    @PutMapping("/return")
    public void removeResource(@RequestBody Borrowed borrowed){
        borrowedService.removeResourceToBorrowed(borrowed);
    }
}


