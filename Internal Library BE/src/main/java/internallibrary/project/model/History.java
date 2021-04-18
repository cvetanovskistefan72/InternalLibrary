package internallibrary.project.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class History {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "type")
    private String type;


    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name ="borrowed_date")
    private Date borrowedDate;

    @Column(name = "userId")
    private String userId;

    @Column(name = "status")
    private String status;



    public History(String resourceName, String type, Date borrowedDate, String userId, String status) {

        this.resourceName = resourceName;
        this.type = type;
        this.borrowedDate = borrowedDate;
        this.userId = userId;
        this.status = status;
    }
    public History() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
