package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

// тут больше нет аннотации сервис, это интерфейс
public interface ServiceEmployee {
    //теперь то что я писал в Репозитории я пишу тут и потом обращаюсь к этому через ServiceImpl(тут уже будет вызов через return

    List<Employee> findAll();
    Employee getOne(long id);

    Employee save(Employee employee);
//    Employee updateAndSave(Employee employee);

    void delete(Employee employee);

}
