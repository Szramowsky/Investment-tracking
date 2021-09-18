package InvestmentTracking.controller;

import InvestmentTracking.model.*;
import InvestmentTracking.service.ConnectCryptoWalletService;
import InvestmentTracking.service.CryptoService;
import InvestmentTracking.service.UserService;
import InvestmentTracking.service.WalletService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.awt.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WalletController {
    private WalletService walletService;
    private CryptoService cryptoService;
    private UserService userService;
    private ConnectCryptoWalletService connectCryptoWalletService;

    public WalletController(WalletService walletService, CryptoService cryptoService, UserService userService, ConnectCryptoWalletService connectCryptoWalletService) {
        this.walletService = walletService;
        this.cryptoService = cryptoService;
        this.userService = userService;
        this.connectCryptoWalletService = connectCryptoWalletService;
    }

    @ModelAttribute
    public List<Crypto> cryptoList() {
        return cryptoService.findAll();
    }

    @GetMapping("/listCrypto")
    public String getAll(Model model) {
        model.addAttribute("cryptoList", cryptoList());
        return "afterLogin/cryptoList";
    }

    @GetMapping("/addCrypto")
    public String addCrypto(Long id, Model model) {
        Wallet wallet;
        if (id != null) {
            wallet = walletService.findById(id);
        } else {
            wallet = new Wallet();
        }
        model.addAttribute("wallet", wallet);
        return "afterLogin/addCrypto";
    }

    @Transactional
    @PostMapping("/addCrypto")
    public String addCrypto(@Valid Wallet wallet, Model model, Principal principal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "afterLogin/addCrypto";
        }
        AppUser appUser = userService.findByUsername(principal.getName());
        Double qua = wallet.getQuantity();
        List<Wallet> walletList = walletService.findAllByUser(appUser);
        String line = "";
        String line2 = "";
        for (Wallet wallet1 : walletList) {
            if (wallet.getCurrency_ticker().equals(wallet1.getCurrency_ticker())) {
                wallet.setQuantity(wallet1.getQuantity() + wallet.getQuantity());
                connectCryptoWalletService.deleteByWallet(wallet1);
                walletService.deleteById(wallet1.getId());
            }
        }

        if(qua < 0) {
            line = "You have successfully reduce " + (qua * -1) + wallet.getCurrency_ticker();
        } else {
            line = "You have successfully added " + qua + wallet.getCurrency_ticker();
        }
        line2 = "" + wallet.getQuantity() + wallet.getCurrency_ticker();

        wallet.setAppUser(appUser);
        walletService.addWallet(wallet);
        connectCryptoWalletService.add(wallet);
        model.addAttribute("line", line);
        model.addAttribute("line2", line2);
        return "afterLogin/successfullyAdded";
    }


}
