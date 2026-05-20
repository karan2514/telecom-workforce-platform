package com.telecom.platform.attendance.service;

import com.telecom.platform.attendance.model.Employee;
import com.telecom.platform.attendance.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int id){
        return employeeRepo.findById(id).orElseThrow();
    }


    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
}
