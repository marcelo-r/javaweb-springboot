package com.unipe.springproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties(value = {"project", "created", "modified"}, allowGetters = true)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Length(max = 60)
    private String firstName;

    @NotEmpty
    @Length(max = 100)
    private String lastName;

    @NotEmpty
    @Email
    private String email;

    @Length(max = 15)
    private String phoneNumber;

    @NotEmpty
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    
    @OneToOne
    private Project projectManager;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modified;

    public Person() {}

    public Person(@NotNull String firstName, @NotNull String lastName, @NotNull @Email String email, String phoneNumber, Date hireDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Project getProject() {
        return project;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setProject(Project project) {
        this.project = project;
    }

	public Project getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(Project projectManager) {
		this.projectManager = projectManager;
	}

	public Department getDepartment() {
		return department;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
}