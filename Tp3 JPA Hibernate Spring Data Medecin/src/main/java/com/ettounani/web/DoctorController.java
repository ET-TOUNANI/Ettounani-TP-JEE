package com.ettounani.web;

import com.ettounani.repositories.DoctorRepos;
import com.ettounani.repositories.PatienRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class DoctorController {
    private DoctorRepos doctorRepos;

    @GetMapping(path = "/doctor")
    public String doctors(){
        return "doctors";
    }

}
