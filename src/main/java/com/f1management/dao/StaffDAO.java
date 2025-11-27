package com.f1management.dao;

import com.f1management.model.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffDAO extends DAO {
    public StaffDAO(){
        super();
    }

    public Member getStaffInfo(Member m){
        String sql = "SELECT * FROM tblMember WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, m.getId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                m.setFullname(rs.getString("fullname"));
                return m;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
