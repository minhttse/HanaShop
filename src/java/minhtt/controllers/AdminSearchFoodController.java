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
import minhtt.daos.CategoryDAO;
import minhtt.daos.FoodDAO;
import minhtt.dtos.CategoryDTO;
import minhtt.dtos.FoodDTO;

/**
 *
 * @author minhv
 */
public class AdminSearchFoodController extends HttpServlet {
    private final static String SUCCESS="admin.jsp";
    private final static String ERROR="admin.jsp";

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
            String price = request.getParameter("adminTxtPriceSearch");
            String nameSearch = request.getParameter("adminTxtNameSearch");
            String categorySearch = request.getParameter("adminTxtCategorySearch");
            String currentPage = request.getParameter("txtCurrentPage");
            if (price.isEmpty()) {
                price = "1";
            }
            if (currentPage==null) {
                currentPage = "1";
            }
            FoodDAO dao = new FoodDAO();
            int count=dao.getNoOfAdminSearchResult(nameSearch, Float.parseFloat(price), categorySearch);
            int totalPage=0;
            if(count % 20!=0){
                totalPage=count/20 +1;
            }else{
                totalPage=count/20;
            }
            request.setAttribute("TOTAL_PAGE", totalPage);
            List<FoodDTO> list = dao.getListFood_Admin(nameSearch, Float.parseFloat(price), categorySearch,Integer.parseInt(currentPage));
            if (list != null) {
                url = SUCCESS;
                request.setAttribute("LIST", list);
                
                CategoryDAO categoryDao=new CategoryDAO();
                List<CategoryDTO> listCategory=categoryDao.getAllCategory();
                request.setAttribute("LIST_CATEGORY", listCategory);
            }
      
        } catch (Exception e) {
            log("Error at AdminSearchFoodServlet "+e.toString());
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
