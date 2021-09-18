package InvestmentTracking.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;
    @NotBlank
    private String currency_ticker;
    @NotBlank
    @NotNull
    @Min(value = 0, message = "Quantity must be greater then 0")
    private Double quantity;

    public Wallet() {
    }
    public Wallet(String ticker) {
        this.currency_ticker = ticker;
        this.quantity = 0D;
    }

    public Wallet(String currency_ticker, Double quantity) {
        this.currency_ticker = currency_ticker;
        this.quantity = quantity;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency_ticker() {
        return currency_ticker;
    }

    public void setCurrency_ticker(String currency_ticker) {
        this.currency_ticker = currency_ticker;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
