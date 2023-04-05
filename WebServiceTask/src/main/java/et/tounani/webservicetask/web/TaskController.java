package et.tounani.webservicetask.web;


import et.tounani.webservicetask.entities.Task;
import et.tounani.webservicetask.repositories.TaskRepository;
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
public class TaskController {
    private TaskRepository taskRepository;

    @GetMapping(path = "/task/getALL")
    public String getTasks(
                            Model model,
                            @RequestParam(name = "page",defaultValue = "0")int page,
                            @RequestParam(name = "size",defaultValue = "5")int size,
                            @RequestParam(name = "keyword",defaultValue = "")String keyword
                           ){
        Page<Task> tasks=taskRepository.findAllByLibelleContains(keyword, PageRequest.of(page,size));
        model.addAttribute("tasks",tasks.getContent());
        return "tasks";
    }
    @PostMapping(path = "/task/addTask")
    public String addTask(@RequestBody Task task){
        try {
            taskRepository.save(task);
            return "Task added succesfuly";
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
