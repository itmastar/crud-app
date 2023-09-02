package com.example.crudapp.service;

import com.example.crudapp.model.EmployeeEntity;
import com.example.crudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public String createEmployee(EmployeeEntity employee){
        repository.save(employee);
        return "Record created with employee id :"+employee.getId();
    }

    public List<EmployeeEntity> getEmployees(){
        return repository.findAll();
    }
}
