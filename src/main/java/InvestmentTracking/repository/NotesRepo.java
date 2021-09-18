package InvestmentTracking.repository;

import InvestmentTracking.model.AppUser;
import InvestmentTracking.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Long> {

    List<Notes> findAllByAppUser(AppUser appUser);
}
