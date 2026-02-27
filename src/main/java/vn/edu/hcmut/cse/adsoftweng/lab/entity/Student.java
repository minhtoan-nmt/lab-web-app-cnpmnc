package vn.edu.hcmut.cse.adsoftweng.lab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "students")
@NoArgsConstructor
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private int age;
}
