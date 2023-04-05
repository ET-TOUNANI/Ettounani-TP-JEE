package et.tounani.webservicetask;

import et.tounani.webservicetask.entities.Task;
import et.tounani.webservicetask.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WebServiceTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceTaskApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(TaskRepository taskRepository){
		return args -> {
           Task t1=new Task(0,"Regression");
		   taskRepository.save(t1);
			Task t2=new Task(0,"El youusfi ");
			taskRepository.save(t2);
			Task t3=new Task(0,"SparkSQL");
			taskRepository.save(t3);
			Task t4=new Task(0,"IA");
			taskRepository.save(t4);
			taskRepository.findAll().forEach(e->System.out.println(e.getLibelle()));
		};
	}


}
