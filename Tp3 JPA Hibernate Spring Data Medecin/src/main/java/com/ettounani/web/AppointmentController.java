package com.ettounani.web;

import com.ettounani.repositories.AppointmentRepos;
import com.ettounani.repositories.PatienRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class AppointmentController {
    private AppointmentRepos appointmentRepos;

    @GetMapping(path = "/appointment")
    public String appointments(){
        return "appointements";
    }

}
