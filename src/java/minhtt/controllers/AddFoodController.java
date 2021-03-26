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
import minhtt.dtos.CartDTO;
import minhtt.dtos.FoodDTO;
import minhtt.dtos.UserDTO;

/**
 *
 * @author minhv
 */
public class AddFoodController extends HttpServlet {

    private final static String ERROR = "login.jsp";
    private final static String SUCCESS = "SearchFoodController";

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
            if (login_user != null && login_user.getRoleID().equals("US") || login_user != null && login_user.getRoleID().equals("EMAIL")) {
                String foodID = request.getParameter("txtFoodID");
                String foodName = request.getParameter("txtFoodName");
                String createDate = request.getParameter("txtCreateDate");
                String expirationDate = request.getParameter("txtExpirationDate");
                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                float foodPrice = Float.parseFloat(request.getParameter("txtFoodPrice"));
                String description = request.getParameter("txtDescription");
                String linkImg = request.getParameter("txtlinkImg");
                String categoryID = request.getParameter("txtCategoryID");

                CartDTO cart = (CartDTO) session.getAttribute("CART");

                if (cart == null) {
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    Date date = new Date();
                    String strCurrentDate = formatter.format(date);
                    cart = new CartDTO(login_user.getFullName(), login_user.getAddress(), strCurrentDate, null);
                    
                    FoodDTO food = new FoodDTO(foodID, foodName, foodPrice, 1, description, createDate,expirationDate, linkImg, categoryID, true);
                    cart.add(food);
                    session.setAttribute("CART", cart);
                    request.setAttribute("MESSAGE", "You have added food successful , total food in cart :" + cart.getCart().values().size());
                    url = SUCCESS;
                } else {               
                    if (cart.getCart().containsKey(foodID)) {
                        if(cart.getCart().get(foodID).getQuantity()>=quantity){
                            request.setAttribute("MESSAGE", "You can not add more this food !");
                            url = SUCCESS;
                        }else {
                            FoodDTO food = new FoodDTO(foodID, foodName, foodPrice, 1, description, createDate,expirationDate, linkImg, categoryID, true);
                            cart.add(food);
                            session.setAttribute("CART", cart);
                            request.setAttribute("MESSAGE", "You have added food successful , total food in cart :" + cart.getCart().values().size());
                            url = SUCCESS;
                        }
                    } else {
                        FoodDTO food = new FoodDTO(foodID, foodName, foodPrice, 1, description, createDate,expirationDate, linkImg, categoryID, true);
                        cart.add(food);
                        session.setAttribute("CART", cart);
                        request.setAttribute("MESSAGE", "You have added food successful , total food in cart :" + cart.getCart().values().size());
                        url = SUCCESS;
                    }
                }

            } else if (login_user == null) {
                session.setAttribute("LOGIN_INVALID", "You must login to add food !");
            }
        } catch (Exception e) {
            log("Error at AddFoodServlet: " + e.toString());
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
