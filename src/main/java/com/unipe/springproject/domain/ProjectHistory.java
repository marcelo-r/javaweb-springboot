package com.unipe.springproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties(value = {"created", "modified"}, allowGetters = true)
public class ProjectHistory implements Serializable {
    /*
    * startDate 	Date
    * endDate 	    Date
    * manager 	    Person
    */

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @NotEmpty
    private Person manager;

    @OneToOne
    private Project project;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modified;

    public Long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Person getManager() {
        return manager;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }
}
