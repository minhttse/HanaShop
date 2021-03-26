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
import minhtt.dtos.OrderDTO;
import minhtt.utils.DBUtils;

/**
 *
 * @author minhv
 */
public class OrderDAO {
    public int getNoOfOrder() throws SQLException{
        int result=0;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="select Count(status) as NoOfOrder\n" +
                            "From tblOrders\n";
                stm=conn.prepareStatement(sql);
                rs=stm.executeQuery();
                if(rs.next()){
                    result=rs.getInt("NoOfOrder");
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
    
    public void createOrder(OrderDTO order) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="INSERT INTO tblOrders\n" +
                           "values(?,?,?,?,?,1)";
                stm=conn.prepareStatement(sql);
                stm.setString(1,order.getOrderID());
                stm.setString(2,order.getUserID());
                stm.setFloat(3,order.getTotalPrice());
                stm.setString(4,order.getOrderDate());
                stm.setString(5,order.getOrderAddress());
                stm.executeUpdate();          
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
    }
    
    public List<OrderDTO> getOrder(String orderDate,String foodName) throws SQLException{
        List<OrderDTO> result = null;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="SELECT O.orderID,userID,totalPrice,orderDate,orderAddress,O.status\n" +
                           "from tblOrders O, tblOrderDetail D,tblFoods F\n" +
                           "where orderDate = ? and O.orderID=D.orderID and D.foodID=F.foodID and F.foodName like ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1,orderDate);
                stm.setString(2,"%"+foodName+"%");
                rs=stm.executeQuery();
                while(rs.next()){
                    String orderID =rs.getString("orderID");
                    String userID =rs.getString("userID");
                    float totalPrice=rs.getFloat("totalPrice");
                    String date =rs.getString("orderDate");
                    String orderAddress =rs.getString("orderAddress");
                    boolean status=rs.getBoolean("status");
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    if(status==true){
                        result.add(new OrderDTO(orderID, userID, totalPrice, date, orderAddress, status));
                    }
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
