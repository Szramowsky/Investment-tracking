package InvestmentTracking.controller;

import InvestmentTracking.model.AppUser;
import InvestmentTracking.model.ConnectCryptoWallet;
import InvestmentTracking.service.ConnectCryptoWalletService;
import InvestmentTracking.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    private UserService userService;
    private ConnectCryptoWalletService connectCryptoWalletService;

    public DashboardController(UserService userService, ConnectCryptoWalletService connectCryptoWalletService) {
        this.userService = userService;
        this.connectCryptoWalletService = connectCryptoWalletService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        AppUser appUser = userService.findByUsername(principal.getName());
        List<ConnectCryptoWallet> walletList = connectCryptoWalletService.findAllByUserId(appUser.getId());

        double total = 0;

        for (ConnectCryptoWallet cn : walletList) {
            total += cn.getTotal();
        }

        model.addAttribute("total", total);
        model.addAttribute("wallet", walletList);
        return "afterLogin/dashboard";
    }

}
