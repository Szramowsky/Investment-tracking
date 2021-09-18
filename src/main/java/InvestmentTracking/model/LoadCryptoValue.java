package InvestmentTracking.model;

import InvestmentTracking.repository.ConnectCryptoWalletRepo;
import InvestmentTracking.repository.CryptoRepo;
import InvestmentTracking.repository.WalletRepo;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadCryptoValue {

    public LoadCryptoValue(ConnectCryptoWalletRepo connectCryptoWalletRepo, WalletRepo walletRepo, CryptoRepo cryptoRepo) {
        connectCryptoWalletRepo.deleteAll();

        List<Wallet> walletList = walletRepo.findAll();

        for (Wallet wallet : walletList) {
            Double total = 0D;
            String name = "";
            for (Crypto crypto : cryptoRepo.findAll()) {
                if(crypto.getCurrencySymbol().equals(wallet.getCurrency_ticker())) {
                    name = crypto.getName();
                    total = wallet.getQuantity() * crypto.getValuesInDollar();
                }
            }
            ConnectCryptoWallet connectCryptoWallet = new ConnectCryptoWallet();

            connectCryptoWallet.setName(name);
            connectCryptoWallet.setUser_id(wallet.getAppUser().getId());
            connectCryptoWallet.setTicker(wallet.getCurrency_ticker());
            connectCryptoWallet.setQuantity(wallet.getQuantity());
            connectCryptoWallet.setTotal(Math.floor(total * 100)/100);
            connectCryptoWallet.setWallet(wallet);

            connectCryptoWalletRepo.save(connectCryptoWallet);
        }


    }
}
