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
import minhtt.daos.FoodDAO;
import minhtt.dtos.FoodDTO;
import minhtt.dtos.FoodErrorDTO;

/**
 *
 * @author minhv
 */
public class CreateFoodController extends HttpServlet {
    private final static String ERROR = "createFood.jsp";
    private final static String SUCCESS = "admin.jsp";

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
            String foodID = request.getParameter("txtFoodID");
            String foodName = request.getParameter("txtFoodName");
            String priceFood = request.getParameter("txtPrice");
            String quantity = request.getParameter("txtQuantity");
            String description = request.getParameter("txtDescription");
            String expirationDate = request.getParameter("txtExpirationDate");
            String categoryID = request.getParameter("cmbCategory");
            String linkImg = request.getParameter("txtFile");
            FoodErrorDTO errorObject = new FoodErrorDTO("", "", "", "", "", "","", "", "", "");
            FoodDAO dao = new FoodDAO();
            boolean check = true;
            if (foodID.isEmpty()) {
                check = false;
                errorObject.setFoodIDError("FoodID is not empty !");
            }
            if (foodName.isEmpty()) {
                check = false;
                errorObject.setFoodNameError("Food Name is not empty !");
            }
            if (priceFood.isEmpty() ) {
                check = false;
                errorObject.setFoodPriceError("Food price is not empty !");
            }
            if (!priceFood.matches("[0-9.]*") || priceFood.matches("[0]*")) {
                check = false;
                errorObject.setFoodPriceError("Room price is number more than 0 !");
            }
            if (quantity.isEmpty() ) {
                check = false;
                errorObject.setQuantityError("Quantity is not empty !");
            }
            if (!quantity.matches("[0-9]*") || quantity.matches("[0]*")) {
                check = false;
                errorObject.setQuantityError("Quantity is number more than 0 !");
            }
            if (description.isEmpty()) {
                check = false;
                errorObject.setDescriptionError("Description is not empty !");
            }
            if (expirationDate.isEmpty()) {
                check = false;
                errorObject.setExpirationDateError("Expiration Date is not empty !");
            }
            if (linkImg.isEmpty()) {
                check = false;
                errorObject.setLinkImgError("Please choose img !");
            }
            
            if (dao.checkFoodID_create(foodID)==true) {
                check = false;
                errorObject.setFoodIDError("FoodID is duplicate !");
            }
            if (check == true) {
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                String strCurrentDate = formatter.format(date);
                FoodDTO food = new FoodDTO(foodID, foodName, Float.parseFloat(priceFood), Integer.parseInt(quantity), description,strCurrentDate,expirationDate, "Images/"+linkImg, categoryID, true);
                dao.create(food);
                url = SUCCESS;               
            } else {
                request.setAttribute("FOOD_ERROR", errorObject);
            }
        } catch (Exception e) {
            log("Error at CreateFoodServlet: " + e.toString());
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
