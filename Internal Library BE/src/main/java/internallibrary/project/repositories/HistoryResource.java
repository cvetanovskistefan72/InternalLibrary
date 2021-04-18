package internallibrary.project.repositories;

import internallibrary.project.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HistoryResource extends JpaRepository<History,Integer> {
    History findHistoryByUserId(String userId);
}
