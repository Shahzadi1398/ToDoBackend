package ToDoList.services;

import ToDoList.modal.TaskManagement;
import ToDoList.repo.TaskManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ToDoList
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 21-03-2024
 * @Weekday : Thursday
 **/

@Service
public class TaskManagemnetService {

    @Autowired
    TaskManagementRepo taskManagementRepo;

    public void saveTask(TaskManagement taskManagement){
        LocalDate date = LocalDate.now();
        taskManagement.setEntryDt(date);
        taskManagementRepo.save(taskManagement);
    }

    public List<TaskManagement> getDataTaskManagement(String email){
        LocalDate date = LocalDate.now();
        List<TaskManagement> taskManagementList = taskManagementRepo.findAll();
        return taskManagementList.stream()
                .filter(t-> t.getSignUp().getEmail().equals(email))
                .filter(t-> date.equals(t.getEntryDt()))
                .collect(Collectors.toList());
    }

    public List<TaskManagement> getDataTaskManagement1(String email){
        LocalDate date = LocalDate.now();
        Integer month = date.getMonthValue();
        List<TaskManagement> taskManagementList = taskManagementRepo.findAll();
        return taskManagementList.stream()
                .filter(t-> t.getSignUp().getEmail().equals(email))
                .filter(t-> month.equals(t.getEntryDt().getMonthValue()))
                .collect(Collectors.toList());
    }

    public void deleteTask(UUID uuid){
        taskManagementRepo.deleteById(uuid);
    }

    public void editTaskToComplete(UUID uuid) {
        Optional<TaskManagement> optionalTask = taskManagementRepo.findById(uuid);
        if (optionalTask.isPresent()) {
            TaskManagement taskManagement = optionalTask.get();
            if (!taskManagement.getIsCompleted()) {
                taskManagement.setIsCompleted(true);
                taskManagementRepo.save(taskManagement);
            }
        }
    }


}
