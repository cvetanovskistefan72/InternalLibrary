package internallibrary.project.controllers;


import internallibrary.project.model.History;
import internallibrary.project.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
@CrossOrigin(origins = "http://localhost:3001", maxAge = 3600)
public class HistoryRestController {

    @Autowired
    HistoryService historyService;

    @GetMapping
    public List<History> getHistory(){
        return historyService.getHistory();
    }
}
