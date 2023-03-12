package com.ettounani.web;

import com.ettounani.entities.Doctor;
import com.ettounani.entities.Patient;
import com.ettounani.repositories.DoctorRepos;
import com.ettounani.repositories.PatienRepos;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class DoctorController {
    private DoctorRepos doctorRepos;

    @GetMapping(path = "/doctors")
    public String doctors(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5")int size,
                           @RequestParam(name = "keyword",defaultValue = "")String keyword){
        Page<Doctor> doctors=doctorRepos.findAllByNameContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listDoctors",doctors.getContent());
        model.addAttribute("pages",new int[doctors.getTotalPages()]);
        model.addAttribute("current",page);
        model.addAttribute("size",size);
        model.addAttribute("keyword",keyword);
        return "doctors";
    }
    @GetMapping(path = "/deleteDoctor")
    public String delete(long id){
        doctorRepos.deleteById(id);
        return "redirect:/doctors";
    }
}
