package com.unipe.springproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Department extends Auditable implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 100)
    private String name;

    @OneToOne
    private ProjectHistory projectHistory;

    @OneToMany(mappedBy = "department")
    private Set<Person> personSet;

    public Department() {
    }

    public Department(@NotEmpty String name) {
    	super();
        this.name = name;
    }

	public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateFields(Department obj) {
        if (obj.getName().length() > 0) {
            this.setName(obj.getName());
        }
    }
}
