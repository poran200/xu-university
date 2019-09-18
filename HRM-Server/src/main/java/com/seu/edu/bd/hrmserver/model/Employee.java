package com.seu.edu.bd.hrmserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = {"initial"})
public class Employee {
    @Id
    private String  initial;
    private  String name;
    private  String email;
    private String program;
    private  String loginpassword;
    @Enumerated(EnumType.STRING)
    private  Role  role;

}
