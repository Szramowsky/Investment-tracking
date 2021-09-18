package InvestmentTracking.controller;

import InvestmentTracking.model.Crypto;
import InvestmentTracking.repository.CryptoRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomepageController {

    private CryptoRepo cryptoRepo;

    public HomepageController(CryptoRepo cryptoRepo) {
        this.cryptoRepo = cryptoRepo;
    }

    @GetMapping("")
    public String homepage(Model model) {
        List<Crypto> cryptoList = cryptoRepo.findAll();
        model.addAttribute("cryptoList", cryptoList);
        return "beforeLogin/homePage";
    }

    @GetMapping("/about")
    public String about() {
        return "beforeLogin/about";
    }
    @GetMapping("/faq")
    public String faq() {
        return "beforeLogin/faq";
    }

}
