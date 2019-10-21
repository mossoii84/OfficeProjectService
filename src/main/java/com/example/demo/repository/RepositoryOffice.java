package com.example.demo.repository;

import com.example.demo.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOffice extends JpaRepository<Office,Long> {
}
