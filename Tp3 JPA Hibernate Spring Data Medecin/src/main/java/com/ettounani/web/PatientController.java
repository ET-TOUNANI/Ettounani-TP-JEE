package com.ettounani.web;

import com.ettounani.repositories.PatienRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatienRepos patienRepos;

    @GetMapping(path = "/patient")
    public String patients(){
        return "patients";
    }

}
