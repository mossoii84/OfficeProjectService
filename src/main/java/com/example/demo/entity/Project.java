package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.GenerationType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Project implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String theme;


//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(name="employeesprojects",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "employee_id"))
//    @JsonIgnoreProperties("projects")
//    private Set<Employee> employees= new HashSet<>();
//    public Set<Employee> getEmployees() { return employees; }
//    public void setEmployees(Set<Employee> employees) { this.employees = employees; }

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();
       public Set<Employee> getEmployees() { return employees; }
       public void setEmployees(Set<Employee> employees) { this.employees = employees; }





    public Project(){}
    public Project(String name, String theme) {
        this.name = name;
        this.theme = theme;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
}
