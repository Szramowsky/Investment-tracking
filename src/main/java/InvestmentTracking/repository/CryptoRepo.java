package InvestmentTracking.repository;

import InvestmentTracking.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptoRepo extends JpaRepository<Crypto, Long> {

    void deleteAll();

    Crypto findByCurrencySymbol(String symbol);

    List<Crypto> findAll();
}
