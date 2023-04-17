package ettounani_abderrahmane.web;
import ettounani_abderrahmane.DAO.entities.Client;
import ettounani_abderrahmane.metier.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ClientController {
    private IClientService clientService;
    @GetMapping(path = "/")
    public String home(){
        return "redirect:/user/client";
    }

    @GetMapping(path = "/user/client")
    public String clients(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5")int size,
                           @RequestParam(name = "keyword",defaultValue = "")String keyword){
        Page<Client> clients=clientService.getClientsByName(keyword,PageRequest.of(page,size));
        model.addAttribute("listClients",clients.getContent());
        model.addAttribute("pages",new int[clients.getTotalPages()]);
        model.addAttribute("allPages", clients.getTotalElements());
        model.addAttribute("current",page);
        model.addAttribute("size",size);
        model.addAttribute("keyword",keyword);
        return "clients";
    }
    @PostMapping(path = "/admin/addClient")
    public String addClient(@RequestBody Client client){
            clientService.addClient(client);
            return "redirect:/user/client";
    }
    @GetMapping(path = "/admin/deleteClient")
    public String deleteClient(long id){
        clientService.deleteById(id);
        return "redirect:/user/client";
    }
}
