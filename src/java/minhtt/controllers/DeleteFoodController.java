/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhtt.daos.FoodDAO;
import minhtt.daos.UpdateRecordDAO;
import minhtt.dtos.UpdateRecordDTO;
import minhtt.dtos.UserDTO;

/**
 *
 * @author minhv
 */
public class DeleteFoodController extends HttpServlet {
    private final static String SUCCESS="AdminSearchFoodController";
    private final static String ERROR="AdminSearchFoodController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            HttpSession session = request.getSession();
            UserDTO login_user = (UserDTO) session.getAttribute("LOGIN_USER");
            FoodDAO foodDAO=new FoodDAO();
            UpdateRecordDAO recorddao = new UpdateRecordDAO();
            if (login_user!=null && login_user.getRoleID().equals("AD")) {
                String foodID ;
                String count=request.getParameter("count");
                for(int i=1;i<=Integer.parseInt(count);i++){
                    foodID=request.getParameter("foodID"+i);
                    if(foodID!=null){                   
                        foodDAO.delete(foodID);   
                        
                        String updateRecordID = "R" + (recorddao.getNoOfRecord() + 1);//them vao record
                        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                        Date date = new Date();
                        String strCurrentDate = formatter.format(date);
                        UpdateRecordDTO recorddto = new UpdateRecordDTO(updateRecordID, login_user.getUserID(), foodID, strCurrentDate, true);
                        recorddao.createRecord(recorddto);
                        url = SUCCESS;
                    }
                }
            }
        } catch (Exception e) {
            log("Error at DeleteFoodServlet "+e.toString());
        }
        finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
