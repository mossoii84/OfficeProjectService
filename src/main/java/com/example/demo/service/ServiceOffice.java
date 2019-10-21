package com.example.demo.service;


import com.example.demo.entity.Office;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceOffice {

    List<Office> findAll();
    Office getOne(long id); //не важно как мы пишем Long или long

    Office save(Office office);
//    Office updateAndSave(Office office);

    void delete(Office office);


}
