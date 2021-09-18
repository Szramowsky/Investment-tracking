package InvestmentTracking.service;

import InvestmentTracking.model.AppUser;
import InvestmentTracking.model.Wallet;
import InvestmentTracking.repository.WalletRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private WalletRepo walletRepo;

    public WalletService(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }

    public void addWallet(Wallet wallet) {
        walletRepo.save(wallet);
    }

    public List<Wallet> findAll() {
        return walletRepo.findAll();
    }

    public Wallet findById(Long id) {
        return walletRepo.findById(id).get();
    }

    public void deleteById(Long id) {
        walletRepo.deleteById(id);
    }

    public List<Wallet> findAllByUser(AppUser appUser) {
        return walletRepo.findAllByAppUser(appUser);
    }
    public void delete(Wallet wallet) {
        walletRepo.delete(wallet);
    }


}
