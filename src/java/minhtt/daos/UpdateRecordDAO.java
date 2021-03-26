/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import minhtt.dtos.UpdateRecordDTO;
import minhtt.utils.DBUtils;

/**
 *
 * @author minhv
 */
public class UpdateRecordDAO {
    public int getNoOfRecord() throws SQLException{
        int result=0;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="select Count(status) as NoOfRecord\n" +
                           "From tblUpdateRecord\n";
                stm=conn.prepareStatement(sql);
                rs=stm.executeQuery();
                if(rs.next()){
                    result=rs.getInt("NoOfRecord");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs!=null)rs.close();
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
        return result;
    }
    
    public void createRecord(UpdateRecordDTO record) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="INSERT INTO tblUpdateRecord\n" +
                           "values(?,?,?,?,1)";
                stm=conn.prepareStatement(sql);
                stm.setString(1,record.getRecordID());
                stm.setString(2,record.getUserID());
                stm.setString(3,record.getFoodID());
                stm.setString(4,record.getRecordDate());
                stm.executeUpdate();          
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
    }
}
