package InvestmentTracking.model;

import InvestmentTracking.apis.CoinMarketCapApi;
import InvestmentTracking.model.cryptoModel.Cryptocurrency;
import InvestmentTracking.model.cryptoModel.Datum;
import InvestmentTracking.repository.CryptoRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class LoadCryptoApi {

    public LoadCryptoApi(CryptoRepo cryptoRepo) throws JsonProcessingException {
        cryptoRepo.deleteAll();

        String result = CoinMarketCapApi.JsonFormat();
        ObjectMapper mapper = new ObjectMapper();
        Cryptocurrency cry = mapper.readValue(result, Cryptocurrency.class);


        for (int i = 0; i < cry.getData().size(); i++) {
            Datum cryptocurrency = cry.getData().get(i);

            Crypto crypto = new Crypto();

            crypto.setName(cryptocurrency.getName());
            crypto.setCurrencySymbol(cryptocurrency.getSymbol());
            crypto.setValuesInDollar(cryptocurrency.getQuote().getUsd().getPrice());
            crypto.setPercent_change_24h(cryptocurrency.getQuote().getUsd().getPercentChange24h());
            crypto.setPercent_change_7d(cryptocurrency.getQuote().getUsd().getPercentChange7d());
            crypto.setLastUpdate(LocalDateTime.now());


            cryptoRepo.save(crypto);
        }
    }

}
