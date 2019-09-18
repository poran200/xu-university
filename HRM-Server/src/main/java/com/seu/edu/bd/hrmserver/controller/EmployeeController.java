package com.seu.edu.bd.hrmserver.controller;

import com.seu.edu.bd.hrmserver.exception.ResourseAlreadyExist;
import com.seu.edu.bd.hrmserver.exception.ResourseNotFoundException;
import com.seu.edu.bd.hrmserver.model.Employee;
import com.seu.edu.bd.hrmserver.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Employee>> findAll(){
        return  ResponseEntity.ok().body(employeeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Employee> findById(@PathVariable String id){
        try {
            return ResponseEntity.ok().body(employeeService.findByInitial(id));
        } catch (ResourseNotFoundException e) {
             return ResponseEntity.notFound().build();
        }
    }
   @GetMapping(value = "/program{program}")
    public  ResponseEntity<List<Employee>> findEmployeeByProgram(@PathVariable String program){
        return  ResponseEntity.ok().body(employeeService.finByProgram(program));
    }
    @PostMapping(value = "")
    public ResponseEntity<Employee> create(Employee employee){
        try {
            return ResponseEntity.ok().body(employeeService.create(employee));
        } catch (ResourseAlreadyExist resourseAlreadyExist) {
           return  ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id,@RequestBody Employee employee){
        try {
            return  ResponseEntity.accepted().body(employeeService.updateEmployee(id,employee));
        } catch (ResourseNotFoundException e) {
             return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<String> delete(@PathVariable String id){
        try {
            return  ResponseEntity.ok().body(employeeService.delete(id));
        } catch (ResourseNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch ( Exception e){
            return ResponseEntity.badRequest().build();
        }

    }


}
