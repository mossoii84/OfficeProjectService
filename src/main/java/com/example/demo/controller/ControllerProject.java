package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.service.ServiceProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
public class ControllerProject {

    @Autowired
    public ServiceProject serviceProject;

    @GetMapping(value = "/project")
    private ResponseEntity<List<Project>> findAll(){
        return new ResponseEntity<List<Project>>(serviceProject.findAll(),HttpStatus.OK);
    }
    @GetMapping(value="/project/{id}")
    private ResponseEntity<Project>getOne(@PathVariable (value = "id") long id){
        Project project1=serviceProject.getOne(id);
        return new ResponseEntity<Project>(project1,HttpStatus.OK);
    }

    @PostMapping(value="/project")
    private ResponseEntity<Project> save(@RequestBody Project project){
        Project project1=serviceProject.save(project);
        return new ResponseEntity<Project>(project1,HttpStatus.OK);
    }

    // почему то save и updateAndSave работают одинаково, то есть когда в
    //постмане мы в методе Post оправляем данные с id=1, то эти данные меняются
    //а не создается новый id,как это делается в Post по этому нам нужно удалять передачу id=1
    @PutMapping(value = "/project/{id}")
    private ResponseEntity<Project>updateAndSave(@PathVariable (value="id") long id,
             @RequestBody Project project){
        Project projectPut=serviceProject.getOne(id);
        projectPut.setId(project.getId());
        projectPut.setName(project.getName());
        projectPut.setTheme(project.getTheme());
        projectPut.setEmployees(project.getEmployees());
        serviceProject.save(projectPut);
        return new ResponseEntity<Project>(projectPut,HttpStatus.OK);

    }


   @DeleteMapping(value="/project/{id}")
    private ResponseEntity<Project>deleteProject(@PathVariable (value="id") long id)
    { Project projectDelete=serviceProject.getOne(id);
      serviceProject.delete(projectDelete);
        return new ResponseEntity<Project>(projectDelete,HttpStatus.OK);
    }


}
