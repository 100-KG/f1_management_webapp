package com.f1management.dao;

import com.f1management.model.Member;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO extends DAO {
    public MemberDAO() {
        super();  
    }
    
    public boolean checkLogin(Member a){
        String sql = "SELECT * FROM tblMember WHERE username = ? AND password = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                a.setId(rs.getInt("id"));
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}