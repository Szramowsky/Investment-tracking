package InvestmentTracking.repository;

import InvestmentTracking.model.ConnectCryptoWallet;
import InvestmentTracking.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConnectCryptoWalletRepo extends JpaRepository<ConnectCryptoWallet, Long> {


    @Query("select c from ConnectCryptoWallet c where c.user_id= :id")
    List<ConnectCryptoWallet> findAllByUser_id(Long id);

    Optional<ConnectCryptoWallet> findById(Long id);

    void deleteByWallet(Wallet wallet);
}
