package InvestmentTracking.service;

import InvestmentTracking.model.ConnectCryptoWallet;
import InvestmentTracking.model.Crypto;
import InvestmentTracking.model.Wallet;
import InvestmentTracking.repository.ConnectCryptoWalletRepo;
import InvestmentTracking.repository.CryptoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectCryptoWalletService {
    private ConnectCryptoWalletRepo connectCryptoWalletRepo;
    private CryptoRepo cryptoRepo;

    public ConnectCryptoWalletService(ConnectCryptoWalletRepo connectCryptoWalletRepo, CryptoRepo cryptoRepo) {
        this.connectCryptoWalletRepo = connectCryptoWalletRepo;
        this.cryptoRepo = cryptoRepo;
    }

    public List<ConnectCryptoWallet> findAllByUserId(Long id) {
        return connectCryptoWalletRepo.findAllByUser_id(id);
    }
    public ConnectCryptoWallet findById(Long id) {
        return connectCryptoWalletRepo.findById(id).get();
    }
    public void deleteByWallet(Wallet wallet) {
        connectCryptoWalletRepo.deleteByWallet(wallet);
    }
    public void add(Wallet wallet) {
        ConnectCryptoWallet connectCryptoWallet = new ConnectCryptoWallet();
        connectCryptoWallet.setWallet(wallet);
        connectCryptoWallet.setUser_id(wallet.getAppUser().getId());
        connectCryptoWallet.setTicker(wallet.getCurrency_ticker());
        connectCryptoWallet.setQuantity(wallet.getQuantity());
        for (Crypto crypto : cryptoRepo.findAll()) {
            if(crypto.getCurrencySymbol().equals(wallet.getCurrency_ticker())) {
                connectCryptoWallet.setName(crypto.getName());
                connectCryptoWallet.setTotal(Math.floor(wallet.getQuantity() * crypto.getValuesInDollar()*100)/100);
            }
        }
        connectCryptoWalletRepo.save(connectCryptoWallet);
    }
}
