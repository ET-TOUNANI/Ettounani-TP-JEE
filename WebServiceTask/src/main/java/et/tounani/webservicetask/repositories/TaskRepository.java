package et.tounani.webservicetask.repositories;

import et.tounani.webservicetask.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

   public Page<Task> findAllByLibelleContains(String keyword, Pageable pageable);
}
