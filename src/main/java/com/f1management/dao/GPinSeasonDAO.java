package com.f1management.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.f1management.model.GPinSeason;

public class GPinSeasonDAO extends DAO{
    public GPinSeasonDAO(){
        super();
    }

    public GPinSeason[] getCurrentGP(){
        String year = "2025";
        String sql = "SELECT * FROM tblGPinSeason WHERE year = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, year);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                GPinSeason g = new GPinSeason();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
