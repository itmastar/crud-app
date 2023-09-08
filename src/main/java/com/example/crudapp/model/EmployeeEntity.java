package com.example.crudapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String firstName;
    private String lastName;
    private int salary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_address_emp")
    private List<AddressEntity> address;

}
