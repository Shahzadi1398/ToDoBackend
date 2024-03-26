package ToDoList.controller;

import ToDoList.modal.ResponseMessage;
import ToDoList.modal.TaskManagement;
import ToDoList.services.TaskManagemnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ToDoList
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 21-03-2024
 * @Weekday : Thursday
 **/

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/task")
public class TaskManagementController {

    @Autowired
    TaskManagemnetService taskManagemnetService;

    @PostMapping("/save")
    public ResponseEntity<?> saveTaskManagementData(@RequestBody TaskManagement taskManagement) {
        try {
            taskManagemnetService.saveTask(taskManagement);
            return new ResponseEntity<>(new ResponseMessage("1", "Record save Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getData/{email}")
    public ResponseEntity<?> getTaskManagementData(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(taskManagemnetService.getDataTaskManagement(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getData1/{email}")
    public ResponseEntity<?> getTaskManagementData1(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(taskManagemnetService.getDataTaskManagement1(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<?> deleteTaskManagementData(@PathVariable("uuid") UUID uuid) {
        try {
            taskManagemnetService.deleteTask(uuid);
            return new ResponseEntity<>(new ResponseMessage("1", "Record deleted Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> updateTaskManagementData(@PathVariable("uuid") UUID uuid) {
        try {
            taskManagemnetService.editTaskToComplete(uuid);
            return new ResponseEntity<>(new ResponseMessage("1", "Record updated Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
