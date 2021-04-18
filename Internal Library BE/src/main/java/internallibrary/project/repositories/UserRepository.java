package internallibrary.project.repositories;


import internallibrary.project.model.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserClass,String> {
    UserClass findUserClassByUserId(String userId);
}
