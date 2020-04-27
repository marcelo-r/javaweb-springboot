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

@Entity
@JsonIgnoreProperties(value = {"created", "modified"}, allowGetters = true)
public class Task extends Auditable implements Serializable {
    /*
    title 	        String
    description 	String
    taskPoints 	    Long
    status 	        Long
    startDate 	    Date
    endDate 	    Date
    */

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "task requires a title")
    @Length(max = 100)
    private String title;

    @Length(max = 500)
    private String description;

    @PositiveOrZero
    private Long points;
    private Long status;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToMany
    private Set<Project> projects;

    public Task() {
    }

    public Task(@NotEmpty(message = "task requires a title") @Length(max = 100) String title, @Length(max = 500) String description, @PositiveOrZero Long points, Long status, Date startDate, Date endDate) {
        this.title = title;
        this.description = description;
        this.points = points;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getPoints() {
        return points;
    }

    public Long getStatus() {
        return status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    
    public Set<Project> getProjects() {
		return projects;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
