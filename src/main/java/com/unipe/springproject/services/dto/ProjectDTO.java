package com.unipe.springproject.services.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.unipe.springproject.domain.Person;
import com.unipe.springproject.domain.Project;
import com.unipe.springproject.domain.ProjectHistory;
import com.unipe.springproject.domain.Task;

public class ProjectDTO implements Serializable {


    private Long id;
    private String title;
    private PersonDTO manager;
    private Long minSalary;
    private Long maxSalary;
    private Set<PersonDTO> personSet;
    private Set<TaskDTO> tasks;
    private ProjectHistoryDTO projectHistory;
    private Date created;
    private Date modified;

    public ProjectDTO() {
    }

	public ProjectDTO(Project p) {
		super();
		this.id = p.getId();
		this.title = p.getTitle();
		this.manager = new PersonDTO(p.getManager());
		this.minSalary = p.getMinSalary();
		this.maxSalary = p.getMaxSalary();
		this.setPersonSetDTO(p.getPersonSet());
		this.setTasksDTO(p.getTasks());
		this.projectHistory = new ProjectHistoryDTO(p.getProjectHistory());
		this.created = p.getCreated();
		this.modified = p.getModified();
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

	public PersonDTO getManager() {
		return manager;
	}

	public void setManager(PersonDTO person) {
		this.manager = person;
	}

	public Long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public Long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Set<PersonDTO> getPersonSet() {
		return personSet;
	}

	public void setPersonSetDTO(Set<Person> set) {
		Set<PersonDTO> result = new HashSet<PersonDTO>(); 
		for(Person p: set) {
			PersonDTO dto = new PersonDTO(p);
			result.add(dto);
		}
		this.personSet = result;
	}

	public void setPersonSet(Set<PersonDTO> personSet) {
		this.personSet = personSet;
	}

	public void setTasks(Set<TaskDTO> tasks) {
		this.tasks = tasks;
	}

	public Set<TaskDTO> getTasks() {
		return tasks;
	}

	public void setTasksDTO(Set<Task> set) {
		Set<TaskDTO> result = new HashSet<TaskDTO>();
		for (Task t: set) {
			TaskDTO dto = new TaskDTO(t);
			result.add(dto);
		}
		this.tasks = result;
	}

	public ProjectHistoryDTO getProjectHistory() {
		return projectHistory;
	}

	public void setProjectHistory(ProjectHistoryDTO history) {
		this.projectHistory = history;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
    
    
    
}
