package com.f1management.model;

public class GrandPrix {
    private int id;
    private String country;
    private String circuit;
    private double length; 
    private int laps;

    public GrandPrix(){
        super();
    }

    public GrandPrix(int id, String country, String circuit, double length, int laps) {
        this.id = id;
        this.country = country;
        this.circuit = circuit;
        this.length = length;
        this.laps = laps;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCircuit() { return circuit; }
    public void setCircuit(String circuit) { this.circuit = circuit; }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public int getLaps() { return laps; }
    public void setLaps(int laps) { this.laps = laps; }
}