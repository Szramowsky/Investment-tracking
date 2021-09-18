package InvestmentTracking.repository;

import InvestmentTracking.model.AppUser;
import InvestmentTracking.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findById(Long id);

    void deleteById(Long id);

    List<Wallet> findAllByAppUser(AppUser appUser);


    /*@Query("select w from Wallet w JOIN w.currency_ticker c join c.values where w.appUser= :appUser")*/
    /*@Query("select w from Wallet w JOIN w.currency_ticker c join Crypto.valuesInDollar where w.appUser= :appUser")
    List<Wallet> findAllByUser(AppUser appUser);*/

    /*Wallet findByCurrency_ticker(String ticker);*/

}
