package com.f1management.dao;

import com.f1management.model.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class ResultDAO extends DAO{
    public ResultDAO(){
        super();
    }

    public Result[] getGPResult(String selectedGP){
        String sql = 
                    "SELECT r.*, d.fullname AS driverName, t.name AS teamName " +
                    "FROM tblResult r " +
                    "JOIN tblContract c ON r.contractId = c.id " +
                    "JOIN tblDriver d   ON c.driverId = d.id " +
                    "JOIN tblTeam  t    ON c.teamId = t.id " +
                    "WHERE r.gpinSeasonId = ? ";
        ArrayList<Result> ls = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, selectedGP);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Result r = new Result();
                r.setId(rs.getInt("id"));
                r.setTime(rs.getString("time"));
                r.setLapFinished(rs.getInt("lapFinished"));
                r.setPosition(rs.getInt("position"));
                r.setPoint(rs.getInt("point"));
                r.setContractId(rs.getInt("contractId"));
                r.setMemberId(rs.getInt("memberId"));
                r.setGPinSeasonId(rs.getInt("gpinSeasonId"));

                r.setDriver(rs.getString("driverName"));
                r.setTeam(rs.getString("teamName"));

                ls.add(r);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ls.toArray(new Result[0]);
    }

    public boolean updateResult(Result[] results) {
        String sql = "UPDATE tblResult " +
                    "SET time=?, lapFinished=?, position=?, point=? " +
                    "WHERE id=?";

        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sql);

            for (Result r : results) {
                ps.setString(1, r.getTime());
                ps.setInt(2, r.getLapFinished());
                ps.setInt(3, r.getPosition());
                ps.setInt(4, r.getPoint());
                ps.setInt(5, r.getId());
                ps.addBatch();
            }

            ps.executeBatch();
            connection.commit();
            ps.close();
            return true;
        } catch (Exception e) {
            try { connection.rollback(); } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
    }

}
