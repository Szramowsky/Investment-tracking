package InvestmentTracking.service;

import InvestmentTracking.model.AppUser;
import InvestmentTracking.model.Notes;
import InvestmentTracking.repository.NotesRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotesService {

    private NotesRepo notesRepo;

    public NotesService(NotesRepo notesRepo) {
        this.notesRepo = notesRepo;
    }

    public List<Notes> findAllByUser(AppUser appUser) {
        return notesRepo.findAllByAppUser(appUser);
    }

    public void addNotes(Notes newNotes, AppUser appUser) {
        Notes notes = new Notes();
        notes.setAppUser(appUser);
        notes.setTime(LocalDateTime.now());
        notes.setText(newNotes.getText());
        notesRepo.save(notes);
    }
    public void delete(Long id) {
        notesRepo.deleteById(id);
    }
}
