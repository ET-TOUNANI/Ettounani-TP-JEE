package com.ettounani.web;

import com.ettounani.entities.Consultation;
import com.ettounani.repositories.ConsultationRepos;
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
public class ConsultationController {
    private ConsultationRepos consultationRepos;

    @GetMapping(path = "/consultations")
    public String consultations(Model model, @RequestParam(name = "page",defaultValue = "0")int page,
                                @RequestParam(name = "size",defaultValue = "5")int size,
                                @RequestParam(name = "keyword",defaultValue = "")String keyword
                                ){
        Page<Consultation>consultations=consultationRepos.findAllByPatientNameContainsOrDoctorNameContains(keyword,keyword,  PageRequest.of(page,size));
        model.addAttribute("listConsults",consultations.getContent());
        model.addAttribute("pages",new int[consultations.getTotalPages()]);
        model.addAttribute("current",page);
        model.addAttribute("allPages", consultations.getTotalElements());
        model.addAttribute("size",size);
        model.addAttribute("keyword",keyword);
        return "consultations";
    }

    @GetMapping(path = "/deleteConsultation")
    public String delete(long id){
        consultationRepos.deleteById(id);
        return "redirect:/consultations";
    }

}
