package com.unipe.springproject.services.dto;

import java.io.Serializable;
import java.util.Date;

import com.unipe.springproject.domain.Department;

public class DepartmentDTO implements Serializable {

    private Long id;
    private String name;
    
    public DepartmentDTO() {
		super();
	}
    
	public DepartmentDTO(Department entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public String getName() {
        return name;
    }

    public Long getId() {
        return id;
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
