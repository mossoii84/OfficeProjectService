package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Zdanie implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String nameZdanie;

    //одно здание с многими офисами
    @OneToMany(mappedBy = "zdanie",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonIgnoreProperties("zdanie")
    private List<Office> offices = new ArrayList<>();
       public List<Office> getOffices() {return offices; }
       public void setOffices(List<Office> offices) { this.offices = offices; }

    public Zdanie(){}
    public Zdanie(String nameZdanie, List<Office> offices) {
        this.nameZdanie = nameZdanie;
        this.offices = offices;
    }

    public static long getSerialVersionUID(){return serialVersionUID; }

    public Long getId() { return Id;}
    public void setId(Long id) { Id = id; }

    public String getNameZdanie() { return nameZdanie; }
    public void setNameZdanie(String nameZdanie) { this.nameZdanie = nameZdanie; }


}
