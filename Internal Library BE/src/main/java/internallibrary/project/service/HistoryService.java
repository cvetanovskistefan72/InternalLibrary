package internallibrary.project.service;


import internallibrary.project.model.History;
import internallibrary.project.repositories.HistoryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryResource historyResource;

    public void addData(History history){
        historyResource.save(history);
    }

    public List<History> getHistory(){
        return historyResource.findAll();
    }
}
