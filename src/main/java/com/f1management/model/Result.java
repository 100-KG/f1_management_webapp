package com.f1management.model;

public class Result {
    private int id;
    private String time;          
    private Integer lapFinished;  
    private Integer position;    
    private int point;
    private int contractId;        
    private int memberId;         

    public Result(){
        super();
    }

    public Result(int id, String time, Integer lapFinished, Integer position, 
                  int point, int contractId, int memberId) {
        this.id = id;
        this.time = time;
        this.lapFinished = lapFinished;
        this.position = position;
        this.point = point;
        this.contractId = contractId;
        this.memberId = memberId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public Integer getLapFinished() { return lapFinished; }
    public void setLapFinished(Integer lapFinished) { this.lapFinished = lapFinished; }

    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }

    public int getPoint() { return point; }
    public void setPoint(int point) { this.point = point; }

    public int getContractId() { return contractId; }
    public void setContractId(int contractId) { this.contractId = contractId; }

    public int getMemberId() { return memberId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }
}