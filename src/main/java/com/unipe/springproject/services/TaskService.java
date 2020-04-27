package com.unipe.springproject.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipe.springproject.domain.Department;
import com.unipe.springproject.domain.Project;
import com.unipe.springproject.domain.Task;
import com.unipe.springproject.repository.TaskRepository;
import com.unipe.springproject.services.dto.DepartmentDTO;
import com.unipe.springproject.services.dto.ProjectDTO;
import com.unipe.springproject.services.dto.TaskDTO;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public Task dtoToEntity(TaskDTO dto) {
		Task task = new Task();
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setStatus(dto.getStatus());
		task.setPoints(dto.getPoints());
		task.setStartDate(dto.getStartDate());
		task.setEndDate(dto.getStartDate());
		return task;
	}
	
	public List<Task> findAll() {
		List<Task> list = repository.findAll();
        return list;
    }

    public TaskDTO save(TaskDTO taskDTO) {
        Task task = new Task();
        task = repository.save(task);
        return new TaskDTO(task);
    }
    
    public Optional<TaskDTO> findById(Long id) {
        Optional<TaskDTO> taskDTO = Optional.of(new TaskDTO(repository.findById(id).get()));
        return taskDTO;
    }
    
    public List<Task> findByDateRange(Date startDate, Date endDate) {
    	repository.findByDateRange(startDate, endDate);
		return null;
    }
    
    public List<Task> findByDateRangeWithStatus(Date startDate, Date endDate, Integer status) {
    	repository.findByDateRangeWithStatus(startDate, endDate, status);
		return null;
    }
    
    public void delete(TaskDTO dto) {
        repository.deleteById(dto.getId());
    }
}
