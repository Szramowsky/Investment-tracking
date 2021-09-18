package InvestmentTracking.service;

import InvestmentTracking.model.Crypto;
import InvestmentTracking.repository.CryptoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoService {

    private CryptoRepo cryptoRepo;

    public CryptoService(CryptoRepo cryptoRepo) {
        this.cryptoRepo = cryptoRepo;
    }

    public List<Crypto> findAll() {
        return cryptoRepo.findAll();
    }
    public Crypto findByCurrencySymbol(String symbol) {
        return findByCurrencySymbol(symbol);
    }
}
