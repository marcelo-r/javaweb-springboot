package com.unipe.springproject.services.dto;

import java.io.Serializable;
import java.util.Date;

import com.unipe.springproject.domain.ProjectHistory;

public class ProjectHistoryDTO implements Serializable {

    private Long id;
    private Date startDate;
    private Date endDate;
    private PersonDTO manager;
    private ProjectDTO project;
    private Date created;
    private Date modified;
    
	public ProjectHistoryDTO() {
		super();
	}

	public ProjectHistoryDTO(ProjectHistory h) {
		super();
		this.id = h.getId();
		this.startDate = h.getStartDate();
		this.endDate = h.getEndDate();
		this.manager = new PersonDTO(h.getManager());
		this.project = new ProjectDTO(h.getProject());
		this.created = h.getCreated();
		this.modified = h.getModified();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public PersonDTO getManager() {
		return manager;
	}

	public void setManager(PersonDTO manager) {
		this.manager = manager;
	}

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
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
