package internallibrary.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Borrowed {
    @Id
    @Column(name="userId")
    public String userId;


    @Column(name="borrowed_date")
    private String borrowedDate;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "resource_borroed",
            joinColumns = @JoinColumn(name = "borrowed_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id"))
    private List<Resource> resourceList;


    public String getUserId() {
        return userId;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public void addResourceToList(Resource resource){
        if(resourceList == null){
            resourceList = new ArrayList<>();
        }
        resourceList.add(resource);
    }
}
