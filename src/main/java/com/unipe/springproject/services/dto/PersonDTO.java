package com.unipe.springproject.services.dto;

import java.io.Serializable;
import java.util.Date;

import com.unipe.springproject.domain.Department;
import com.unipe.springproject.domain.Person;
import com.unipe.springproject.domain.Project;

public class PersonDTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private DepartmentDTO department;
    private ProjectDTO project;
    private ProjectDTO projectManager;
    private Date created;
    private Date modified;

    public PersonDTO() {}

	public PersonDTO(Person p) {
		super();
		this.id = p.getId();
		this.firstName = p.getFirstName();
		this.lastName = p.getLastName();
		this.email = p.getEmail();
		this.phoneNumber = p.getPhoneNumber();
		this.hireDate = p.getHireDate();
		this.department = new DepartmentDTO(p.getDepartment());
		this.project = new ProjectDTO(p.getProject());
		this.projectManager = new ProjectDTO(p.getProjectManager());
		this.created = p.getCreated();
		this.modified = p.getModified();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	public ProjectDTO getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectDTO projectManager) {
		this.projectManager = projectManager;
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