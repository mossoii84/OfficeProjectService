package com.example.demo.controller;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Zdanie;
import com.example.demo.service.ServiceZdanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class ControllerZdanie {

    @Autowired
    private ServiceZdanie serviceZdanie;

    @GetMapping(value="/zdanie")
    private ResponseEntity<List<Zdanie>> findAll(){
        return new ResponseEntity<List<Zdanie>>(serviceZdanie.findAll(),HttpStatus.OK);
    }

    @GetMapping(value="/zdanie/{id}")
    public ResponseEntity<Zdanie> getZdanieById(@PathVariable(value="id") long id){
        Zdanie zdanieById=serviceZdanie.getOne(id);
        return new ResponseEntity<Zdanie>(zdanieById,HttpStatus.OK);
    }

    @PostMapping(value="/zdanie")
    public ResponseEntity<Zdanie> getPostZdanie(@RequestBody Zdanie zdanie){
        Zdanie zdanie1=serviceZdanie.save(zdanie);
        return new ResponseEntity<Zdanie>(zdanie1,HttpStatus.OK);
    }

    @PutMapping(value = "/zdanie/{id}")
    public ResponseEntity<Zdanie> updateAndSave(@PathVariable (value="id") long id,
                                                  @RequestBody Zdanie zdanie){
        Zdanie zdaniePut=serviceZdanie.getOne(id);
        zdaniePut.setId(zdanie.getId());
        zdaniePut.setNameZdanie(zdanie.getNameZdanie());
        zdaniePut.setOffices(zdanie.getOffices());
        serviceZdanie.save(zdaniePut); //тут поменял вметос UpdateAnd
        return new ResponseEntity<Zdanie>(zdaniePut,HttpStatus.OK);
    }


    @DeleteMapping(value = "/zdanie/{id}")
    public ResponseEntity<Zdanie>deleteZdanie(@PathVariable(value="id") long id)
    {   Zdanie zdanieDelete=this.serviceZdanie.getOne(id);
        serviceZdanie.delete(zdanieDelete);
        return new ResponseEntity<Zdanie>(zdanieDelete,HttpStatus.OK);
    }




}
