/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhtt.daos.CategoryDAO;
import minhtt.dtos.CategoryDTO;
import minhtt.dtos.FoodDTO;
import minhtt.dtos.UserDTO;

/**
 *
 * @author minhv
 */
public class ShowUpdatePageController extends HttpServlet {

    private final static String SUCCESS = "update.jsp";
    private final static String ERROR = "update.jsp";

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
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserDTO login_user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (login_user != null && login_user.getRoleID().equals("AD")) {
                String foodID = request.getParameter("txtFoodID");
                String foodName = request.getParameter("txtFoodName");
                String foodPrice = request.getParameter("txtFoodPrice");
                String quantity = request.getParameter("txtQuantity");
                String description = request.getParameter("txtDescription");
                String createDate= request.getParameter("txtCreateDate");
                String expirationDate= request.getParameter("txtExpirationDate");
                String linkImg = request.getParameter("txtImg");
                String categoryID = request.getParameter("txtCategoryID");
                String status = request.getParameter("txtStatus");
                FoodDTO fooddto=new FoodDTO(foodID, foodName, Float.parseFloat(foodPrice), Integer.parseInt(quantity), description, createDate,expirationDate, linkImg, categoryID, Boolean.parseBoolean(status));
                session.setAttribute("FOOD_UPDATE", fooddto);
                CategoryDAO dao = new CategoryDAO();
                List<CategoryDTO> list = dao.getAllCategory();
                if (list != null) {
                    url = SUCCESS;
                    session.setAttribute("LIST_CATEGORY", list);
                }
            }
        } catch (Exception e) {
            log("Error at ShowUpdatePageServlet " + e.toString());
        } finally {
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
