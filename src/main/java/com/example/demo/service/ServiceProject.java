package com.example.demo.service;

import com.example.demo.entity.Project;

import java.util.List;

public interface ServiceProject {

    List<Project> findAll();
    Project getOne(long id); //не важно как мы пишем Long или long

    Project save(Project project);
//    Project updateAndSave(Project project);

    void delete(Project project);
}
