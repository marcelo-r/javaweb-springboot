package com.unipe.springproject.services;

import com.unipe.springproject.domain.Department;
import com.unipe.springproject.repository.DepartmentRepository;
import com.unipe.springproject.services.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<Department> findAll() {
        List<Department> list = repository.findAll();
        return list;
    }

    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        Department department = new Department(departmentDTO.getName());
        department = repository.save(department);
        return new DepartmentDTO(department);
    }

    public Optional<DepartmentDTO> findById(Long id) {
        Optional<DepartmentDTO> departmentDTO = Optional.of(new DepartmentDTO(repository.findById(id).get()));
        return departmentDTO;
    }

    public void delete(DepartmentDTO dto) {
        repository.deleteById(dto.getId());
    }

    public DepartmentDTO update(Long id, DepartmentDTO departmentDTO) {
        Department department = new Department(departmentDTO.getName());
        repository.save(department);
        return new DepartmentDTO(department);
    }

    public DepartmentRepository getRepository() {
        return repository;
    }
}
