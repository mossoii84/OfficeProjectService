package com.example.demo.serviceImpl;

import com.example.demo.entity.Zdanie;
import com.example.demo.repository.RepositoryZdanie;
import com.example.demo.service.ServiceZdanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceImplZdanie implements ServiceZdanie {

    @Autowired
    private RepositoryZdanie repositoryZdanie;

    @Override
    public List<Zdanie> findAll(){return repositoryZdanie.findAll(); }

    //в этой версии Jpa нужно выбираь getOne вместо findById
    @Override
    public Zdanie getOne(long id){ return repositoryZdanie.getOne(id);}

    @Override
    public Zdanie save(Zdanie zdanie){return repositoryZdanie.save(zdanie); }

    // почему то не могу удалять по ID (приходиться писать employee)
    @Override
    public void delete(Zdanie zdanie) {
        repositoryZdanie.delete(zdanie);
    }




}
