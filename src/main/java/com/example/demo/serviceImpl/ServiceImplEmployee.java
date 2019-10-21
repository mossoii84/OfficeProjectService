package com.example.demo.serviceImpl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.RepositoryEmployee;
import com.example.demo.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// реализация всех интерфейсов из сервисов(так же и соответственно репозитория)
@Service
@Transactional
public class ServiceImplEmployee implements ServiceEmployee {

    @Autowired
    private RepositoryEmployee repositoryEmployee;

    @Override
    public List<Employee> findAll(){return repositoryEmployee.findAll(); }


    //в этой версии Jpa нужно выбираь getOne вместо findById
    @Override
    public Employee getOne(long id){
        return repositoryEmployee.getOne(id);}


    @Override
    public Employee save(Employee employee){return repositoryEmployee.save(employee); }

//    @Override
//    public Employee updateAndSave(Employee employee) { return repositoryEmployee.saveAndFlush(employee);}

    // почему то не могу удалять по ID (приходиться писать employee)
    @Override
    public void delete(Employee employee) {
            repositoryEmployee.delete(employee);
    }
}
