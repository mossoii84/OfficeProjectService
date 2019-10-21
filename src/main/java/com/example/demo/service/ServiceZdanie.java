package com.example.demo.service;


import com.example.demo.entity.Zdanie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceZdanie {

    List<Zdanie> findAll();
    Zdanie getOne(long id); //не важно как мы пишем Long или long

    Zdanie save(Zdanie zdanie);
//    Zdanie updateAndSave(Zdanie zdanie);

    void delete(Zdanie zdanie);


}
