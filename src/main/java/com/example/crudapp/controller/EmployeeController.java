package com.example.crudapp.controller;

import com.example.crudapp.model.EmployeeEntity;
import com.example.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee")
    public String createEmployee(@RequestBody EmployeeEntity employee){
        service.createEmployee(employee);
        return "Employee record created with id :"+employee.getId();
    }

    @GetMapping("/employee")
    public List<EmployeeEntity> getEmployees(){
        return service.getEmployees();
    }

   @GetMapping("/employee/{id}")
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable int id){
       return  service.getEmployeeById(id);
    }
//    @GetMapping("/employee")
//    public Optional<EmployeeEntity> getEmpById(@RequestParam int id){
//        return service.getEmpById(id);
//    }
    @PutMapping("/employee/{id}")
    public String updateEmployee(@RequestBody EmployeeEntity updatedEmployee,@PathVariable int id){
        service.updateEmployee(updatedEmployee,id);
        return "Employee salary updated with "+updatedEmployee.getSalary();
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(int id){
        service.deleteEmployee(id);
        return "Employee record deleted  with id "+id;
    }
}
