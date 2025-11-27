package com.f1management.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private int id;
    private LocalDate date;
    private String purpose;    
    private LocalTime startTime;

    public Schedule(){
        super();
    }

    public Schedule(int id, LocalDate date, String purpose, LocalTime startTime) {
        this.id = id;
        this.date = date;
        this.purpose = purpose;
        this.startTime = startTime;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
}