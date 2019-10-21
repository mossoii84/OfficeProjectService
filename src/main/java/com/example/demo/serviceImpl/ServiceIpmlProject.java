package com.example.demo.serviceImpl;

import com.example.demo.entity.Project;
import com.example.demo.repository.RepositoryProject;
import com.example.demo.service.ServiceProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceIpmlProject  implements ServiceProject {

    @Autowired
    private RepositoryProject repositoryProject;

    @Override
    public List<Project> findAll() {
        return repositoryProject.findAll();
    }

    @Override
    public Project getOne(long id) {
        return repositoryProject.getOne(id);} //findById - этого нет в сервисе, это прямо из Crud


    @Override
    public Project save(Project project) {
        return repositoryProject.save(project);
    }

//    @Override
//    public Project updateAndSave(Project project){return repositoryProject.save(project); }

    @Override
    public void delete(Project project){
        repositoryProject.delete(project);
    }
}
