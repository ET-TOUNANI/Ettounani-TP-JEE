package com.ettounani.ws.web;

import com.ettounani.ws.entities.Contact;
import com.ettounani.ws.repository.IContactRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ContactController {
    private final IContactRepo contactRepo;

    @GetMapping("/contacts")
    public List<Contact> all(){
        return contactRepo.findAll();
    }
    @PostMapping("/contact")
    Contact newContact(@RequestBody Contact newContact){
        return contactRepo.save(newContact);
    }
    @GetMapping("/contacts/{id}")
    Contact one(@PathVariable Long id) {
        return contactRepo.findById(id).isPresent()?contactRepo.findById(id).get():new Contact();
    }
    @DeleteMapping("/contacts/{id}")
    void deleteContact(@PathVariable Long id) {
        contactRepo.deleteById(id);
    }
    @PutMapping("/contacts/{id}")
    Contact updateContact(@RequestBody Contact contact, @PathVariable Long id) {
        return contactRepo.findById(id)
                .map(contact1 -> {
                    contact1.setEmail(contact.getEmail());
                    contact1.setNom(contact.getNom());
                    contact1.setTel(contact.getTel());
                    contact1.setPrenom(contact.getPrenom());
                    contact1.setTel(contact.getTel());
                    return contactRepo.save(contact1);
                })
                .orElseGet(() -> {
                    contact.setId(id);
                    return contactRepo.save(contact);
                });
    }

}
