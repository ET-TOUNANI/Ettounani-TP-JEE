package ettounani_abderrahmane.web;

import ettounani_abderrahmane.DAO.entities.Session;
import ettounani_abderrahmane.metier.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class SessionController {
    private SessionService sessionService;
    @GetMapping(path = "/user/session")
    public String sessions(Model model,
                           @RequestParam(name = "size",defaultValue = "5")int size,
                           @RequestParam(name = "page",defaultValue = "0")int page,
                           @RequestParam(name = "keyword",defaultValue = "")String keyword
                           ){
        Page<Session>sessions=sessionService.getSessions(keyword, PageRequest.of(page,size));
        model.addAttribute("sessions",sessions.getContent());
        model.addAttribute("pages",new int[sessions.getTotalPages()]);
        model.addAttribute("size",size);
        model.addAttribute("allPages",sessions.getTotalElements());
        model.addAttribute("kayword",keyword);
        model.addAttribute("current",page);
        return "session";
    }


}
