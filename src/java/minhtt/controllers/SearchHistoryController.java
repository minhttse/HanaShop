/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import minhtt.daos.OrderDAO;
import minhtt.daos.OrderDetailDAO;
import minhtt.dtos.OrderDTO;

/**
 *
 * @author minhv
 */
public class SearchHistoryController extends HttpServlet {
    private final static String SUCCESS="history.jsp";
    private final static String ERROR="history.jsp";
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
            String foodName = request.getParameter("txtFoodNameSearch");
            String orderDate = request.getParameter("txtDateSearch");
            OrderDAO orderDao = new OrderDAO();
            OrderDetailDAO orderDetailDao =new OrderDetailDAO();
            List<OrderDTO> listOrder = orderDao.getOrder(orderDate, foodName);
            if (listOrder != null) {
                Map<String,List<String>> history= new HashMap<String,List<String>>();
                for (OrderDTO orderDTO : listOrder) {
                    List<String> listFood = orderDetailDao.getListFoodName(orderDTO.getOrderID());
                    if (listFood != null){
                        history.put(orderDTO.getOrderDate()+"_"+orderDTO.getOrderAddress()+"_"+orderDTO.getTotalPrice(), listFood);
                    }
                }
                url = SUCCESS;
                request.setAttribute("LIST_ORDER", history);
            }
        
        } catch (Exception e) {
            log("Error at SearchFoodServlet "+e.toString());
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
