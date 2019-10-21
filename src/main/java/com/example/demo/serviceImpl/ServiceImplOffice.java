package com.example.demo.serviceImpl;


import com.example.demo.entity.Office;
import com.example.demo.repository.RepositoryOffice;
import com.example.demo.repository.RepositoryZdanie;
import com.example.demo.service.ServiceOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceImplOffice implements ServiceOffice {

    @Autowired
    private RepositoryOffice repositoryOffice;

    @Override
    public List<Office> findAll(){return repositoryOffice.findAll(); }

    //в этой версии Jpa нужно выбираь getOne вместо findById
    @Override
    public Office getOne(long id){ return repositoryOffice.getOne(id);}

    @Override
    public Office save(Office office){return repositoryOffice.save(office); }

    // почему то не могу удалять по ID (приходиться писать employee)
    @Override
    public void delete(Office office) {
        repositoryOffice.delete(office);
    }


}
