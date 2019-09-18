package com.seu.edu.bd.hrmserver.service;

import com.seu.edu.bd.hrmserver.exception.ResourseAlreadyExist;
import com.seu.edu.bd.hrmserver.exception.ResourseNotFoundException;
import com.seu.edu.bd.hrmserver.model.Employee;
import com.seu.edu.bd.hrmserver.repository.EmployeeRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRpository employeeRpository;

    public List<Employee> findAll() {
        return employeeRpository.findAll();
    }

    public Employee create(Employee employee) throws ResourseAlreadyExist {
        Optional<Employee> optionalEmployee = employeeRpository.findById(employee.getInitial());
        if (optionalEmployee.isPresent()) {
            throw new ResourseAlreadyExist(optionalEmployee.get().getInitial());
        } else {
            employee.setInitial(employee.getInitial());
            employee.setName(employee.getName());
            employee.setEmail(employee.getEmail());
            employee.setProgram(employee.getProgram());
            employee.setRole(employee.getRole());
            return employeeRpository.save(employee);
        }

    }

    public Employee findByInitial(String initial) throws ResourseNotFoundException {
        Optional<Employee> optionalEmployee = employeeRpository.findById(initial);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new ResourseNotFoundException(initial);
        }
    }


    public List<Employee> finByProgram(String program) {
        return employeeRpository.findAllByProgram(program);
    }


    public Employee updateEmployee(String inital, Employee employee) throws ResourseNotFoundException {
        Optional<Employee> optionalEmployee = employeeRpository.findById(inital);
        if (optionalEmployee.isPresent()) {
            employee.setInitial(inital);
            employee.setName(employee.getName());
            employee.setEmail(employee.getEmail());
            employee.setProgram(employee.getProgram());
            employee.setRole(employee.getRole());

            Employee saveEmployee = employeeRpository.save(employee);
            return  saveEmployee;
        }
        throw new ResourseNotFoundException(inital);
    }


    public String delete(String id) throws ResourseNotFoundException {
        Optional<Employee> optionalEmployee = employeeRpository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRpository.deleteById(id);
            return id + " deleted !";
        } else {
            throw new ResourseNotFoundException(id);
        }

    }
}