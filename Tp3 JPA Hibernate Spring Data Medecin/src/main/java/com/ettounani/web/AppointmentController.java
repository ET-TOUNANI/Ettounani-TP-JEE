package com.ettounani.web;

import com.ettounani.entities.Appointment;
import com.ettounani.entities.Consultation;
import com.ettounani.repositories.AppointmentRepos;
import com.ettounani.repositories.PatienRepos;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@AllArgsConstructor
public class AppointmentController {
    private AppointmentRepos appointmentRepos;
    @GetMapping(path = "/appointements")
    public String appointments(Model model, @RequestParam(name = "page",defaultValue = "0")int page,
                                @RequestParam(name = "size",defaultValue = "5")int size,
                                @RequestParam(name = "keyword",defaultValue = "") String keyword
    ){
        Page<Appointment> appointments=appointmentRepos.findAll(PageRequest.of(page,size));
        model.addAttribute("listAppointments",appointments.getContent());
        model.addAttribute("pages",new int[appointments.getTotalPages()]);
        model.addAttribute("current",page);
        model.addAttribute("size",size);
        model.addAttribute("keyword",keyword);
        return "appointements";
    }

    @GetMapping(path = "/deleteAppointement")
    public String delete(long id){
        appointmentRepos.deleteById(id);
        return "redirect:/appointements";
    }
}
