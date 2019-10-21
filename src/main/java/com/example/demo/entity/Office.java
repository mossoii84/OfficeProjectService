package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Office  implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String nameOffice;

    //много офисов в одном здании
    //как я понимаю, сюда нужно передавать zdanie
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zdanie_id")
    @JsonIgnoreProperties(value = {"offices"})
    private Zdanie zdanie;

    public Zdanie getZdanie() { return zdanie; }
    public void setZdanie(Zdanie zdanie) { this.zdanie = zdanie; }

    public Office(){}
    public Office(String nameOffice, Zdanie zdanie) {
        this.nameOffice = nameOffice;
        this.zdanie = zdanie;
    }

    public Long getId(){return Id; }
    public void setId(Long id) { Id = id; }

    public String getNameOffice() { return nameOffice; }
    public void setNameOffice(String nameOffice) { this.nameOffice = nameOffice; }

}
