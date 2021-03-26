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
import minhtt.dtos.CategoryDTO;
import minhtt.utils.DBUtils;

/**
 *
 * @author minhv
 */
public class CategoryDAO {
    public List<CategoryDTO> getAllCategory() throws SQLException {
        List<CategoryDTO> result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT categoryID,categoryName,status\n" +
                             "from tblCategory";
                stm = conn.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    String categoryID =rs.getString("categoryID");
                    String categoryName=rs.getString("categoryName");
                    boolean status=rs.getBoolean("status");
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    if (status==true) {
                        result.add(new CategoryDTO(categoryID, categoryName, status));
                    }
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
}
