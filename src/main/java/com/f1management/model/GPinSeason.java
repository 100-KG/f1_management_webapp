package com.f1management.model;

public class GPinSeason {
    private int id;
    private int seasonId;      
    private int grandPrixId;   
    private int scheduleId;  
    private Integer resultId;  
    private String Country;
    private String Circuit;
    public GPinSeason(){
        super();
    }

    public GPinSeason(int id, int seasonId, int grandPrixId, int scheduleId, Integer resultId) {
        this.id = id;
        this.seasonId = seasonId;
        this.grandPrixId = grandPrixId;
        this.scheduleId = scheduleId;
        this.resultId = resultId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getSeasonId() { return seasonId; }
    public void setSeasonId(int seasonId) { this.seasonId = seasonId; }

    public int getGrandPrixId() { return grandPrixId; }
    public void setGrandPrixId(int grandPrixId) { this.grandPrixId = grandPrixId; }

    public int getScheduleId() { return scheduleId; }
    public void setScheduleId(int scheduleId) { this.scheduleId = scheduleId; }

    public int getResultId() { return resultId; }
    public void setResultId(Integer resultId) { this.resultId = resultId; }

    public String getCountry() { return Country; }
    public void setCountry(String Country) { this.Country = Country; }

    public String getCircuit() { return Circuit; }
    public void setCircuit(String Circuit) { this.Circuit = Circuit; }
}