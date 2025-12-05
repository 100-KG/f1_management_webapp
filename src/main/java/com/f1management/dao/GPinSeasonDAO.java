package com.f1management.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.f1management.model.GPinSeason;

public class GPinSeasonDAO extends DAO{
    public GPinSeasonDAO(){
        super();
    }

    public GPinSeason[] getCurrentGP(){
        String sql =
            "SELECT DISTINCT b.*, a.circuit, a.country " +
            "FROM tblGrandPrix a " +
            "JOIN tblGPinSeason b ON a.id = b.grandPrixId " +
            "JOIN tblSeason c ON b.seasonId = c.id " +
            "WHERE c.year = ?";

        List<GPinSeason> list = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 2025);  
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                GPinSeason g = new GPinSeason();
                g.setId(rs.getInt("id"));
                g.setSeasonId(rs.getInt("seasonId"));
                g.setGrandPrixId(rs.getInt("grandPrixId"));
                g.setScheduleId(rs.getInt("scheduleId"));

                g.setCircuit(rs.getString("circuit"));
                g.setCountry(rs.getString("country"));
                
                list.add(g);
                System.out.println("Get current GP successfully: " + g.getCountry());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return list.toArray(new GPinSeason[0]);
    }
}
