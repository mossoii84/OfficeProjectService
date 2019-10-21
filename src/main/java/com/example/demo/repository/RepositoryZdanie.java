package com.example.demo.repository;


import com.example.demo.entity.Zdanie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryZdanie extends JpaRepository<Zdanie,Long> {
}
