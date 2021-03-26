/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhtt.daos.FoodDAO;
import minhtt.daos.OrderDAO;
import minhtt.daos.OrderDetailDAO;
import minhtt.dtos.CartDTO;
import minhtt.dtos.OrderDTO;
import minhtt.dtos.OrderDetailDTO;

/**
 *
 * @author minhv
 */
public class BuyFoodController extends HttpServlet {

    private static final String SUCCESS = "viewBillPage.jsp";
    private static final String ERROR = "viewBillPage.jsp";

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
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            String userID = request.getParameter("userID");
            String orderAddress = request.getParameter("orderAddress");
            String totalmoney = request.getParameter("totalMoney");

            ArrayList<String> foodOutOfStock = new ArrayList<>();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            FoodDAO foodDao = new FoodDAO();
            boolean check = true;
            Set<String> key = cart.getCart().keySet();
            for (String id : key) {
                if (foodDao.checkID_Buy(id, cart.getCart().get(id).getQuantity()) == false) {
                    check = false;
                    foodOutOfStock.add(cart.getCart().get(id).getFoodName());
                }
            }
            if (orderAddress.isEmpty()) {
                request.setAttribute("ERROR_UPDATE_MESSAGE", "Address must not be empty ! ");
            } else {
                if (check == true) {//them du lieu vao 2 bang tblOrder va tblOrderDetail
                    OrderDAO orderDao = new OrderDAO();
                    String orderID = "O" + (orderDao.getNoOfOrder() + 1);
                    Date date = new Date();
                    String orderDate = formatter.format(date);
                    OrderDTO orderDto = new OrderDTO(orderID, userID, Float.parseFloat(totalmoney), orderDate, orderAddress, true);
                    orderDao.createOrder(orderDto);

                    OrderDetailDAO orderDetailDao = new OrderDetailDAO();
                    String orderDetailID;
                    for (String id : key) {

                        orderDetailID = "D" + (orderDetailDao.getNoOfOrderDetail() + 1);
                        OrderDetailDTO orderDetailDto = new OrderDetailDTO(orderDetailID, orderID, id, cart.getCart().get(id).getQuantity(),
                                cart.getCart().get(id).getQuantity() * cart.getCart().get(id).getFoodPrice(), true);
                        orderDetailDao.createOrderDetail(orderDetailDto);
                        foodDao.updateAmount_AfterBuy(id, cart.getCart().get(id).getQuantity());
                    }
                    request.setAttribute("MESSAGE_BUY", "Buy successful !");
                    url = SUCCESS;
                    session.setAttribute("CART", null);
                } else {
                    request.setAttribute("MESSAGE_BUY_ERROR", "Buy failed, Food(s):" + foodOutOfStock + " out of stock, please change amount or delete food(s)!");
                }
            }

        } catch (Exception e) {
            log("Error at BuyFoodServlet: " + e.toString());
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
