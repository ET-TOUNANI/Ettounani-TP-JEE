package com.ettounani.web;

import com.ettounani.repositories.ConsultationRepos;
import com.ettounani.repositories.PatienRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ConsultationController {
    private ConsultationRepos consultationRepos;

    @GetMapping(path = "/consultation")
    public String consultations(){
        return "consultations";
    }

}
