package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.ServiceEmployee;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j2
@CrossOrigin(maxAge = 3600)
@RestController
public class ControllerEmployee {

    @Autowired
    private ServiceEmployee serviceEmployee;


    @GetMapping(value="/employee")
    private ResponseEntity<List<Employee>> findAll(){
        //Это наш Logger, пишем log так как мы установили Lombok, иначе бы писали стандартно Logger log=..
        log.error("Logger Controller Employee");  // тут log красный, но работает
        return new ResponseEntity<List<Employee>>(serviceEmployee.findAll(),HttpStatus.OK);
    }

    @GetMapping(value="/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable (value="id") long id){
        Employee employeeById=serviceEmployee.getOne(id);
        return new ResponseEntity<Employee>(employeeById,HttpStatus.OK);
    }

    @PostMapping(value="/employee")
    public ResponseEntity<Employee> getPostEmployee(@RequestBody Employee employee){
        Employee employee1=serviceEmployee.save(employee);
        return new ResponseEntity<Employee>(employee1,HttpStatus.OK);
    }

    @PutMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> updateAndSave(@PathVariable (value="id") long id,
                                                  @RequestBody Employee employee){
        Employee employeePut=serviceEmployee.getOne(id);
        employeePut.setId(employee.getId());
        employeePut.setName(employee.getName());
        employeePut.setAge(employee.getAge());
        employeePut.setProjects(employee.getProjects());
        serviceEmployee.save(employeePut); //тут поменял вметос UpdateAnd
        return new ResponseEntity<Employee>(employeePut,HttpStatus.OK);
    }


  @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<Employee>deleteEmployee(@PathVariable(value="id") long id)
  {
      Employee employeeDelete=this.serviceEmployee.getOne(id);
      serviceEmployee.delete(employeeDelete);
      return new ResponseEntity<Employee>(employeeDelete,HttpStatus.OK);
  }




}
