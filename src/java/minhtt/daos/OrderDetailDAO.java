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
import java.util.ArrayList;
import java.util.List;
import minhtt.dtos.OrderDetailDTO;
import minhtt.utils.DBUtils;

/**
 *
 * @author minhv
 */
public class OrderDetailDAO {
    public int getNoOfOrderDetail() throws SQLException{
        int result=0;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="select Count(status) as NoOfOrderDetail\n" +
                           "From tblOrderDetail\n";
                stm=conn.prepareStatement(sql);
                rs=stm.executeQuery();
                if(rs.next()){
                    result=rs.getInt("NoOfOrderDetail");
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
    
    public void createOrderDetail(OrderDetailDTO orderDetail) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="INSERT INTO tblOrderDetail\n" +
                           "values(?,?,?,?,?,1)";
                stm=conn.prepareStatement(sql);
                stm.setString(1,orderDetail.getOrderDetailID());
                stm.setString(2,orderDetail.getOrderID());
                stm.setString(3,orderDetail.getFoodID());
                stm.setInt(4, orderDetail.getAmount());
                stm.setFloat(5,orderDetail.getPrice());
                stm.executeUpdate();          
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
    }
    
    public List<String> getListFoodName(String orderID) throws SQLException{
        List<String> result = null;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="SELECT F.foodName\n" +
                           "from tblOrderDetail OD,tblFoods F\n" +
                           "where orderID=? and OD.foodID=F.foodID";
                stm=conn.prepareStatement(sql);
                stm.setString(1,orderID);
                rs=stm.executeQuery();
                while(rs.next()){
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(rs.getString("foodName"));            
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
}
