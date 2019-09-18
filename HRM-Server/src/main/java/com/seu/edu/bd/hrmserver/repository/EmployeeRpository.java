package com.seu.edu.bd.hrmserver.repository;

import com.seu.edu.bd.hrmserver.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface EmployeeRpository extends JpaRepository<Employee, String> {
    List<Employee> findAllByProgram(String program);
}
