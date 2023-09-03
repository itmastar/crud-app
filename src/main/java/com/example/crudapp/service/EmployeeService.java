package com.example.crudapp.service;

import com.example.crudapp.model.EmployeeEntity;
import com.example.crudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<EmployeeEntity> getEmployeeById(int id){
       return repository.findById(id);
    }
//    public Optional<EmployeeEntity> getEmpById(int id){
//        return repository.findById(id);
//    }

    public String updateEmployee(EmployeeEntity updatedEmployee,int id){
      Optional<EmployeeEntity> existingEmployee= repository.findById(id);
        if(existingEmployee.isPresent()){
       EmployeeEntity employee=existingEmployee.get();
            employee.setSalary(updatedEmployee.getSalary());
            repository.save(employee);
            return " Employee salary has been updated with :"+employee.getSalary();
        }else{
            return "Employee record does not exist ";
        }
    }

    public String deleteEmployee(int id){
        final Optional<EmployeeEntity> employeeToBeDeleted = repository.findById(id);
        repository.delete(employeeToBeDeleted);
        return "Employee record deleted  ";
    }
}
