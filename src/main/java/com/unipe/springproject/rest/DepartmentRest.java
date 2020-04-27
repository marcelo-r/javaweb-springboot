package com.unipe.springproject.rest;

import com.unipe.springproject.domain.Department;
import com.unipe.springproject.services.DepartmentService;
import com.unipe.springproject.services.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.metamodel.StaticMetamodel;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentRest {

    @Autowired
    private DepartmentService service;

    @GetMapping("list")
    public ResponseEntity<List<Department>> findAll(){
        /*
        * GET all departments at /api/department/list
        * */
        List<Department> departmentList = service.findAll();
        return ResponseEntity.ok().body(departmentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
    	/*
    	 * GET to find a specific department by its id
    	 * */
        Optional<DepartmentDTO> dto = service.findById(id);
        return ResponseEntity.ok().body(dto.get());
    }

    @PostMapping()
    public ResponseEntity<DepartmentDTO> save(@RequestBody DepartmentDTO department) {
    	/*
    	 * POST a department to create a new one
    	 * */
        DepartmentDTO dto = service.save(department);
        return ResponseEntity.ok().body(dto);
    }
    
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody DepartmentDTO departmentDTO) {
    	service.delete(departmentDTO);
		return ResponseEntity.ok().body("deleted");
    }
    

}
