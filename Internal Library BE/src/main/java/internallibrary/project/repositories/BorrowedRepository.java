package internallibrary.project.repositories;


import internallibrary.project.model.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedRepository  extends JpaRepository<Borrowed,String> {
    public Borrowed findBorrowedByUserId(String userId);
}
