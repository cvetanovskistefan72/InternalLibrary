package internallibrary.project.service;


import internallibrary.project.model.Borrowed;
import internallibrary.project.model.History;
import internallibrary.project.model.Resource;
import internallibrary.project.repositories.BorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BorrowedService {
    @Autowired
    BorrowedRepository borrowedRepository;

    @Autowired
    ResourceService resourceService;

    @Autowired
    HistoryService historyService;


    public void addResourceToBorrowed(Borrowed borrowed){


      if(borrowedRepository.findBorrowedByUserId(borrowed.getUserId())==null){
          Resource resource = borrowed.getResourceList().get(0);
          resource.setQuantity(resource.getQuantity()-1);
          resourceService.saveResource(resource);
          borrowed.setResourceList(new ArrayList<>());
          borrowed.addResourceToList(resource);
          borrowedRepository.save(borrowed);

      }else{
          Borrowed borrowed1 = borrowedRepository.findBorrowedByUserId(borrowed.getUserId());
          Resource resource = borrowed.getResourceList().get(0);
          resource.setQuantity(resource.getQuantity()-1);
          resourceService.saveResource(resource);
          borrowed1.addResourceToList(resource);
          borrowedRepository.save(borrowed1);
      }
        historyService.addData(addHistory(borrowed,"borrowed"));
    }




    public Borrowed getBorrowed(String userId){
        return  borrowedRepository.findBorrowedByUserId(userId);
    }

    public void removeResourceToBorrowed(Borrowed borrowed){

        Borrowed borrowed1 = borrowedRepository.findBorrowedByUserId(borrowed.getUserId());
        List<Resource> resources = borrowed1.getResourceList();
        borrowed1.setResourceList(new ArrayList<>());
        for(Resource resource : resources){
            if(!resource.getId().equals(borrowed.getResourceList().get(0).getId())){
                borrowed1.addResourceToList(resource);
            }else{
                resource.setQuantity(resource.getQuantity()+1);
                resourceService.saveResource(resource);
            }
        }
        borrowedRepository.save(borrowed1);
        historyService.addData(addHistory(borrowed,"returned"));
    }

    public History addHistory(Borrowed borrowed,String status){
        String resourceName = borrowed.getResourceList().get(0).getName();
        String type = borrowed.getResourceList().get(0).getType();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        dateFormat.format(date);
        return new History(resourceName,type,date,borrowed.getUserId(),status);
    }
}
