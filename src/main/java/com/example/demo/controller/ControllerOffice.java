package com.example.demo.controller;

import com.example.demo.entity.Office;
import com.example.demo.service.ServiceOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class ControllerOffice {

    @Autowired
    private ServiceOffice serviceOffice;

    @GetMapping(value="/office")
    private ResponseEntity<List<Office>> findAll(){
        return new ResponseEntity<List<Office>>(serviceOffice.findAll(),HttpStatus.OK);
    }

    @GetMapping(value="/office/{id}")
    public ResponseEntity<Office> getOfficeById(@PathVariable(value="id") long id){
        Office officeById=serviceOffice.getOne(id);
        return new ResponseEntity<Office>(officeById,HttpStatus.OK);
    }

    @PostMapping(value="/office")
    public ResponseEntity<Office> getPostOffice(@RequestBody Office office){
        Office office1=serviceOffice.save(office);
        return new ResponseEntity<Office>(office1,HttpStatus.OK);
    }

    @PutMapping(value = "/office/{id}")
    public ResponseEntity<Office> updateAndSave(@PathVariable (value="id") long id,
                                                @RequestBody Office office){
        Office officePut=serviceOffice.getOne(id);
        officePut.setId(office.getId());
        officePut.setNameOffice(office.getNameOffice());
        officePut.setZdanie(office.getZdanie());
        serviceOffice.save(officePut); //тут поменял вместо UpdateAnd
        return new ResponseEntity<Office>(officePut,HttpStatus.OK);
    }


    @DeleteMapping(value = "/office/{id}")
    public ResponseEntity<Office>deleteOffice(@PathVariable(value="id") long id)
    {   Office officeDelete=this.serviceOffice.getOne(id);
        serviceOffice.delete(officeDelete);
        return new ResponseEntity<Office>(officeDelete,HttpStatus.OK);
    }



}
