package InvestmentTracking.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Crypto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String currencySymbol;
    private Double valuesInDollar;
    private Double percent_change_24h;
    private Double percent_change_7d;
    private LocalDateTime lastUpdate;

    public Crypto(String name, String currencySymbol, Double valuesInDollar, Double percent_change_24h, Double percent_change_7d, LocalDateTime lastUpdate) {
        this.name = name;
        this.currencySymbol = currencySymbol;
        this.valuesInDollar = valuesInDollar;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.lastUpdate = lastUpdate;
    }

    public Crypto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(Double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public Double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(Double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public Double getValuesInDollar() {
        return valuesInDollar;
    }

    public void setValuesInDollar(Double valuesInDollar) {
        this.valuesInDollar = valuesInDollar;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
