package com.example.greeting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String greeting;
    private String createdBy;
    private String originCountry;
    private Timestamp dateCreated;

    public Greeting(int id, String greeting, String createdBy, String originCountry) {
//        We need to signifiy that below is the primary key

        this.id = id;
        this.greeting = greeting;
        this.createdBy = createdBy;
        this.originCountry = originCountry;
        this.dateCreated = new Timestamp(new Date().getTime());
    }

//    We need a new constructor

    public Greeting(){
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

//    to string is method built into every class
//    we are over-writing it to make something more readable


    @Override
    public String toString() {
        return "Greeting{" +
                "createdBy='" + createdBy + '\'' +
                ", greeting='" + greeting + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}