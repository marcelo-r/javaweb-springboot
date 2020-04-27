package com.unipe.springproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/*
    title       String
    manager 	Person
    minSalary 	Long
    maxSalary 	Long
*/
@Entity
@Table(name = "project")
@JsonIgnoreProperties(value = {"created", "modified"}, allowGetters = true)
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "project requires a title")
    @Length(max = 100)
    private String title;
    
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Person manager;

    @PositiveOrZero
    private Long minSalary;

    @PositiveOrZero
    private Long maxSalary;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Person> personSet;

    @ManyToMany
    @JoinTable(
    		name = "projects_tasks", 
    		joinColumns = @JoinColumn(name = "project_id"), 
    		inverseJoinColumns = @JoinColumn(name = "task_id")
    		)
    private Set<Task> tasks;

    @OneToOne
    @JoinColumn(name = "project_history_id", referencedColumnName = "id")
    private ProjectHistory projectHistory;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modified;

    public Project() {
    }

    public Project(Long id, @NotEmpty(message = "project requires a title") @Length(max = 100) String title, @PositiveOrZero Long minSalary, @PositiveOrZero Long maxSalary) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getMinSalary() {
        return minSalary;
    }

    public Long getMaxSalary() {
        return maxSalary;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

	public Person getManager() {
		return manager;
	}

	public Set<Person> getPersonSet() {
		return personSet;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public ProjectHistory getProjectHistory() {
		return projectHistory;
	}
    
}
