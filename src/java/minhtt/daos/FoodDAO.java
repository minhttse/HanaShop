/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.daos;

/**
 *
 * @author minhv
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import minhtt.dtos.FoodDTO;
import minhtt.utils.DBUtils;

public class FoodDAO {
    public int getNoOfAdminSearchResult(String name,float price,String categoryName) throws SQLException{
        int result=0;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="select Count(F.foodID) as NoOfFood\n" +
                           "from tblFoods F,tblCategory C\n" +
                           "where foodName like ? and foodPrice >=? and F.categoryID=C.categoryID and C.categoryName like ? ";
                stm=conn.prepareStatement(sql);
                stm.setString(1,"%"+name+"%");
                stm.setFloat(2, price);
                stm.setString(3,"%"+ categoryName+"%");
                rs=stm.executeQuery();
                if(rs.next()){
                    result=rs.getInt("NoOfFood");
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
    public int getNoOfUserSearchResult(String name,float price,String categoryName) throws SQLException{
        int result=0;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="select Count(F.foodID) as NoOfFood\n" +
                           "from tblFoods F,tblCategory C\n" +
                           "where foodName like ? and foodPrice >=? and F.status='1' and F.quantity>0 and F.expirationDate>=? and F.categoryID=C.categoryID and C.categoryName like ?";
                stm=conn.prepareStatement(sql);
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                String strCurrentDate = formatter.format(date);
                
                stm.setString(1,"%"+name+"%");
                stm.setFloat(2, price);
                stm.setString(3,strCurrentDate);
                stm.setString(4,"%"+ categoryName+"%");
                rs=stm.executeQuery();
                if(rs.next()){
                    result=rs.getInt("NoOfFood");
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
    public List<FoodDTO> getListFood_User(String name,float price,String categoryName,int currentPage) throws SQLException {
        List<FoodDTO> result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int offset=(currentPage-1)*20;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT foodID,foodName,foodPrice,quantity,description,createDate,expirationDate,linkImg,F.categoryID,F.status\n" +
                             "from tblFoods F,tblCategory C\n" +
                             "where foodName like ? and foodPrice >=? and F.status='1' and F.quantity>0 and F.expirationDate>=? and F.categoryID=C.categoryID and C.categoryName like ? order by createDate\n"+
                             "offset ? rows fetch next 20\n" +
                             "rows only";
                stm = conn.prepareStatement(sql);
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                String strCurrentDate = formatter.format(date);
                
                stm.setString(1,"%"+name+"%");
                stm.setFloat(2, price);
                stm.setString(3,strCurrentDate);
                stm.setString(4,"%"+ categoryName+"%");  
                stm.setInt(5,offset);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String foodID =rs.getString("foodID");
                    String foodName=rs.getString("foodName");
                    float foodPrice =rs.getFloat("foodPrice");
                    int quantity= rs.getInt("quantity");
                    String description=rs.getString("description");
                    String createDate=rs.getString("createDate");
                    String expirationDate=rs.getString("expirationDate");
                    String categoryID=rs.getString("categoryID");
                    String linkImg=rs.getString("linkImg");
                    boolean status=rs.getBoolean("status");
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(new FoodDTO(foodID, foodName, foodPrice, quantity, description, createDate, expirationDate , linkImg, categoryID, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
    
    public List<FoodDTO> getListFood_Admin(String name,float price,String categoryName,int currentPage) throws SQLException {
        List<FoodDTO> result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int offset=(currentPage-1)*20;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT foodID,foodName,foodPrice,quantity,description,createDate,expirationDate,linkImg,F.categoryID,F.status\n" +
                             "from tblFoods F,tblCategory C\n" +
                             "where foodName like ? and foodPrice >=? and F.categoryID=C.categoryID and C.categoryName like ? order by createDate\n"+
                             "offset ? rows fetch next 20\n" +
                             "rows only";
                stm = conn.prepareStatement(sql);
               
                stm.setString(1,"%"+name+"%");
                stm.setFloat(2, price);
                stm.setString(3,"%"+ categoryName+"%");
                stm.setInt(4,offset);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String foodID =rs.getString("foodID");
                    String foodName=rs.getString("foodName");
                    float foodPrice =rs.getFloat("foodPrice");
                    int quantity= rs.getInt("quantity");
                    String description=rs.getString("description");
                    String createDate=rs.getString("createDate");
                    String expirationDate=rs.getString("expirationDate");
                    String categoryID=rs.getString("categoryID");
                    String linkImg=rs.getString("linkImg");
                    boolean status=rs.getBoolean("status");
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(new FoodDTO(foodID, foodName, foodPrice, quantity, description, createDate,expirationDate, linkImg, categoryID, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
    
    public boolean checkFoodID_create(String foodID) throws SQLException{
        boolean result=false;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="SELECT foodID\n" +
                           "from tblFoods\n" +
                           "where foodID=?";
                stm=conn.prepareStatement(sql);
                stm.setString(1,foodID);
                rs=stm.executeQuery();
                if(rs.next()){
                    result=true;
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
    
    public void create(FoodDTO food) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="INSERT INTO tblFoods\n" +
                           "values(?,?,?,?,?,?,?,?,?,1)";
                stm=conn.prepareStatement(sql);
                stm.setString(1,food.getFoodID());
                stm.setString(2,food.getFoodName());
                stm.setFloat(3,food.getFoodPrice());
                stm.setInt(4,food.getQuantity());
                stm.setString(5,food.getDescription());
                stm.setString(6,food.getCreateDate());
                stm.setString(7,food.getExpirationDate());
                stm.setString(8,food.getLinkImg());
                stm.setString(9,food.getCategoryID());             
                stm.executeUpdate();          
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
    }
    
    public boolean checkID_Buy(String foodID, int amount) throws SQLException{
        boolean result=true;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="SELECT foodID\n" +
                           "from tblFoods \n" +
                           "where foodID = ? and quantity < ?";                         
                stm=conn.prepareStatement(sql);
                stm.setString(1,foodID);
                stm.setInt(2, amount);
                rs=stm.executeQuery();
                if(rs.next()){
                    result=false;
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
    
    public void updateAmount_AfterBuy(String foodID,int amountBuy) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="UPDATE tblFoods\n" +
                           "SET quantity=quantity-?\n" +
                           "WHERE foodID = ?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1,amountBuy);
                stm.setString(2,foodID);
                stm.executeUpdate();          
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
    }
    
    public void updateNoChangeImg(FoodDTO food) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="UPDATE tblFoods\n" +
                           "SET foodName=?,foodPrice=?,quantity=?,description=?,categoryID=?,status=?\n" +
                           "WHERE foodID = ?";
                stm=conn.prepareStatement(sql);
                
                stm.setString(1, food.getFoodName());
                stm.setFloat(2, food.getFoodPrice());
                stm.setInt(3,food.getQuantity());
                stm.setString(4,food.getDescription());
                stm.setString(5,food.getCategoryID());
                stm.setBoolean(6, food.isStatus());
                stm.setString(7,food.getFoodID());
                stm.executeUpdate();          
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
    }
    
    public void updateChangeImg(FoodDTO food) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="UPDATE tblFoods\n" +
                           "SET foodName=?,foodPrice=?,quantity=?,description=?,linkImg=?,categoryID=?,status=?\n" +
                           "WHERE foodID = ?";
                stm=conn.prepareStatement(sql);
                
                stm.setString(1, food.getFoodName());
                stm.setFloat(2, food.getFoodPrice());
                stm.setInt(3,food.getQuantity());
                stm.setString(4,food.getDescription());
                stm.setString(5,food.getLinkImg());
                stm.setString(6,food.getCategoryID());
                stm.setBoolean(7, food.isStatus());
                stm.setString(8,food.getFoodID());   
                stm.executeUpdate();     
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
    }
    
    public void delete(String foodID) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="UPDATE tblFoods\n" +
                           "SET status=0\n" +
                           "WHERE foodID = ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1,foodID);
                stm.executeUpdate();          
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
    }
    public int getQuantityOfFood(String foodID) throws SQLException{
        int result=0;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="select quantity\n" +
                           "from tblFoods \n" +
                           "where foodID = ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1,foodID);
                rs=stm.executeQuery();
                if(rs.next()){
                    result=rs.getInt("quantity");
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
