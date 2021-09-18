package InvestmentTracking.controller;

import InvestmentTracking.model.AppUser;
import InvestmentTracking.repository.AppUserRepo;
import InvestmentTracking.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;
    private AppUserRepo appUserRepo;

    public UserController(UserService userService, AppUserRepo appUserRepo) {
        this.userService = userService;
        this.appUserRepo = appUserRepo;
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute(new AppUser());
        return "beforeLogin/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@Valid AppUser appUser, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "beforeLogin/sign-up";
        }
        userService.addUser(appUser);
        model.addAttribute("username", appUser.getUsername());
        return "beforeLogin/successfullySignUp";
    }
}
