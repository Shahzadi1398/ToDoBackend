package ToDoList.repo;

import ToDoList.modal.TaskManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ToDoList
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 21-03-2024
 * @Weekday : Thursday
 **/

@Repository
public interface TaskManagementRepo extends JpaRepository<TaskManagement, UUID> {
}
