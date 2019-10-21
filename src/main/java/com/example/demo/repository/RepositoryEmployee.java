package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositoryEmployee extends JpaRepository<Employee,Long> {

    //Теперь я делаю инача, для проектов лучше делать вызов логики через Service и ServiceImpl

    //Но напрямую использовать Repositories для получение данных на
   // Пользовательский Интерфейс не принято и считается плохим тоном, для этого были придуманы Services.
}
