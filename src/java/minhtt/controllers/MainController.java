/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author minhv
 */
public class MainController extends HttpServlet {
    private final static String DEFAULT="shopping.jsp";
    private final static String LOGIN="LoginController";
    private final static String ADMIN_SEARCH_FOOD="AdminSearchFoodController";
    private final static String UPDATE_FOOD="UpdateFoodController";
    private final static String DELETE_FOOD="DeleteFoodController";  
    private final static String LOGOUT="LogoutController";
    private final static String SHOW_CREATE_PAGE="ShowCreateFoodController";
    private final static String CREATE_FOOD="CreateFoodController";
    private final static String ADD="AddFoodController";
    private final static String CREATE_PAGE="create.jsp";
    private final static String SHOW_SHOPPING_PAGE="shopping.jsp";
    private final static String SEARCH_FOOD="SearchFoodController";
    private final static String VIEW="viewBillPage.jsp";
    private final static String UPDATE_ADDRESS_CART="UpdateAddressCartController";
    private final static String UPDATE_AMOUNT_CART="UpdateAmountCartController";
    private final static String DELETE_FOOD_CART="DeleteFoodCartController"; 
    private final static String BUY_FOOD="BuyFoodController";
    private final static String SEARCH_HISTORY="SearchHistoryController";
    private final static String SHOW_UPDATE_PAGE="ShowUpdatePageController";
    private final static String LOGIN_GOOGLE="LoginGoogleController";
    
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
        String url=DEFAULT;
        try {
            String action =request.getParameter("btnAction");
            if("Login".equals(action)){
                url=LOGIN;
            }else if("Logout".equals(action)){
                url=LOGOUT;
            }else if("Create Page".equals(action)){
                url=CREATE_PAGE;
            }else if("Show FoodPage".equals(action)){
                url=SHOW_SHOPPING_PAGE;
            }else if("Search Food".equals(action)){
                url=SEARCH_FOOD;
            }else if("Search".equals(action)){
                url=ADMIN_SEARCH_FOOD;
            }else if("Show CreatePage".equals(action)){
                url=SHOW_CREATE_PAGE;
            }else if("Create Food".equals(action)){
                url=CREATE_FOOD;
            }else if("Add".equals(action)){
                url=ADD;
            }else if("View".equals(action)){
                url=VIEW;
            }else if("Update Address".equals(action)){
                url=UPDATE_ADDRESS_CART;
            }else if("Update Amount".equals(action)){
                url=UPDATE_AMOUNT_CART;
            }else if("Delete Food Cart".equals(action)){
                url=DELETE_FOOD_CART;
            }else if("Buy Food".equals(action)){
                url=BUY_FOOD;
            }else if("Search History".equals(action)){
                url=SEARCH_HISTORY;
            }else if("Update Food".equals(action)){
                url=UPDATE_FOOD;
            }else if("Delete Food".equals(action)){
                url=DELETE_FOOD;
            }else if("Show Update Page".equals(action)){
                url=SHOW_UPDATE_PAGE;
            }else if("LoginGG".equals(action)){
                url=LOGIN_GOOGLE;
            }
            
        }catch(Exception e){
            log("Error at Maincontroller "+e.toString());
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

