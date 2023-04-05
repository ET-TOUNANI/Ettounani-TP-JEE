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

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping(path = "/")
    public String home(){
        return "redirect:/user/home";
    }

    @GetMapping(path = "/user/home")
    public String homePage(){
        return "home";
    }

}
