package com.f1management.model;

public class GPinSeason {
    private int id;
    private int seasonId;      
    private int grandPrixId;   
    private int scheduleId;  
    private Integer resultId;  

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

    public Integer getResultId() { return resultId; }
    public void setResultId(Integer resultId) { this.resultId = resultId; }
}