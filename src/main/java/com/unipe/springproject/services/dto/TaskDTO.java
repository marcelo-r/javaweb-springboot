package com.unipe.springproject.services.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import com.unipe.springproject.domain.Task;

public class TaskDTO implements Serializable {
	
	private Long id;
    private String title;
    private String description;
    private Long points;
    private Long status;
    private Date startDate;
    private Date endDate;
    private Set<ProjectDTO> projects;
    
	public TaskDTO() {
		super();
	}

	public TaskDTO(Task task) {
		super();
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.points = task.getPoints();
		this.status = task.getStatus();
		this.startDate = task.getStartDate();
		this.endDate = task.getEndDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectDTO> projects) {
		this.projects = projects;
	}
    
    
    
}
