package InvestmentTracking.controller;

import InvestmentTracking.model.AppUser;
import InvestmentTracking.model.Notes;
import InvestmentTracking.service.NotesService;
import InvestmentTracking.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class NotesController {

    private NotesService notesService;
    private UserService userService;

    public NotesController(NotesService notesService, UserService userService) {
        this.notesService = notesService;
        this.userService = userService;
    }

    @GetMapping("/allNotes")
    public String getAll(Model model, Principal principal) {
        AppUser appUser = userService.findByUsername(principal.getName());
        List<Notes> notesList = notesService.findAllByUser(appUser);
        model.addAttribute("notesList", notesList);
        return "afterLogin/allNotes";
    }
    @GetMapping("/addNotes")
    public String addNotes(Model model) {
        Notes notes = new Notes();
        model.addAttribute(notes);
        return "afterLogin/addNotes";
    }
    @PostMapping("/addNotes")
    public String addNotes(@Valid Notes notes, Model model, Principal principal) {
        AppUser appUser = userService.findByUsername(principal.getName());
        notesService.addNotes(notes, appUser);
        List<Notes> notesList = notesService.findAllByUser(appUser);
        model.addAttribute("notesList", notesList);
        return "afterLogin/allNotes";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model, Principal principal) {
        notesService.delete(id);
        AppUser appUser = userService.findByUsername(principal.getName());
        List<Notes> notesList = notesService.findAllByUser(appUser);
        model.addAttribute("notesList", notesList);
        return "afterLogin/allNotes";
    }
}
