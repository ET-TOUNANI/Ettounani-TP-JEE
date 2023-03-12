package com.ettounani.web;
import com.ettounani.entities.Patient;
import com.ettounani.repositories.PatienRepos;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatienRepos patienRepos;

    @GetMapping(path = "/patient")
    public String patients(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5")int size,
                           @RequestParam(name = "keyword",defaultValue = "")String keyword){
        Page<Patient> patients=patienRepos.findAllByNameContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients",patients.getContent());
        model.addAttribute("pages",new int[patients.getTotalPages()]);
        model.addAttribute("current",page);
        model.addAttribute("size",size);
        model.addAttribute("keyword",keyword);
        return "patients";
    }
    @GetMapping(path = "/delete")
    public String delete(long id){
        patienRepos.deleteById(id);
        return "redirect:/patient";
    }
}
