package com.f1management.model;

import java.time.LocalDate;

public class Driver {
    private int id;
    private String fullname;
    private LocalDate dob;
    private String nationality;

    public Driver(){
        super();
    }
    public Driver(int id, String fullname, LocalDate dob, String nationality) {
        this.id = id;
        this.fullname = fullname;
        this.dob = dob;
        this.nationality = nationality;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
}