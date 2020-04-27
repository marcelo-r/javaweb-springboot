package com.unipe.springproject.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unipe.springproject.domain.Task;
import com.unipe.springproject.services.TaskService;
import com.unipe.springproject.services.dto.TaskDTO;

@RestController
@RequestMapping(value = "/api/task")
public class TaskRest {
	
	@Autowired
	private TaskService service;
	

    @GetMapping("/list")
    public ResponseEntity<List<Task>> findAll(){
        /*
        * GET all departments at /api/department/list
        * */
    	List<Task> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping
    public ResponseEntity<List<Task>> findByDateRange(
    		@RequestParam(name = "start_date") Date startDate, 
    		@RequestParam(name = "end_date") Date endDate,
    		@RequestParam(name = "status", required = false) Integer status){
    	List<Task> list;
    	if (status == null) {
    		list = service.findByDateRange(startDate, endDate);
    	} else {
    		list = service.findByDateRangeWithStatus(startDate, endDate, status);
    	}
    	
		return ResponseEntity.ok().body(list);
    	
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
    	/*
    	 * GET to find a specific department by its id
    	 * */
        Optional<TaskDTO> dto = service.findById(id);
        return ResponseEntity.ok().body(dto.get());
    }

    @PostMapping()
    public ResponseEntity<TaskDTO> save(@RequestBody TaskDTO taskDTO) {
    	/*
    	 * POST a department to create a new one
    	 * */
    	TaskDTO dto = service.save(taskDTO);
        return ResponseEntity.ok().body(dto);
    }
    
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody TaskDTO taskDTO) {
    	service.delete(taskDTO);
		return ResponseEntity.ok().body("deleted");
    }
    

}
