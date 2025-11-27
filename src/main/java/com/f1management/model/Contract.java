package com.f1management.model;

public class Contract {
    private int id;
    private int driverId;  
    private int teamId;

    public Contract(){
        super();
    }
    
    public Contract(int id, int driverId, int teamId) {
        this.id = id;
        this.driverId = driverId;
        this.teamId = teamId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }

    public int getTeamId() { return teamId; }
    public void setTeamId(int teamId) { this.teamId = teamId; }
}