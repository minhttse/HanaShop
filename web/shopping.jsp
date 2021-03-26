<%-- 
    Document   : shopping
    Created on : Jan 5, 2021, 8:19:34 PM
    Author     : minhv
--%>

<%@page import="minhtt.dtos.FoodDTO"%>
<%@page import="java.util.List"%>
<%@page import="minhtt.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>       
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="CSS/shoppingg.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            List<FoodDTO> listFood = (List<FoodDTO>) request.getAttribute("LIST_FOOD");
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user != null &&user.getRoleID().equals("US") || user != null &&user.getRoleID().equals("EMAIL")) {
        %>         
                <a href="MainController?btnAction=Search History">History</a>
                <a href="MainController?btnAction=Logout">Logout</a>
                <h1>Welcome <%=user.getFullName()%> to Hana Shop</h1><br><br><br><br><br>
        <%
            } else {
        %>
                <a href="MainController?btnAction=Logout">Login</a>
                <h1>Welcome to Hana Shop</h1><br><br><br><br><br>
        <%
            }
        %>
        <form action="MainController" class="main-layout">
            Search food: <br>     
            Name 
            <input type="text"  name="txtNameSearch" class="name"
                   value="<%= request.getParameter("txtNameSearch") == null ? "" : request.getParameter("txtNameSearch")%>"><br>
            Price: 
            <input type="text" name="txtPriceSearch" class="price"
                   value="<%= request.getParameter("txtPriceSearch") == null ? "" : request.getParameter("txtPriceSearch")%>">
            <br>
            Category:  
            <input type="text" name="txtCategorySearch"  class="category"
                   value="<%= request.getParameter("txtCategorySearch") == null ? "" : request.getParameter("txtCategorySearch")%>">
            <br>                      

            <input type="submit" name="btnAction" value="Search Food"/>
            <%if (user != null &&user.getRoleID().equals("US") || user != null &&user.getRoleID().equals("EMAIL")) { %> 
                <input type="submit" name="btnAction" value="View"/>
            <%}
            %>    
            <br><br>
        </form>
            <nav>
                <ul class="pagination justify-content-center">
                    <%
                        if (request.getAttribute("TOTAL_PAGE") != null) {
                            int totalPage = (int) request.getAttribute("TOTAL_PAGE");
                            for (int i = 1; i <= totalPage; i++) {
                    %>
                                <li class="page-item">
                                    <a class="page-link" href="MainController?btnAction=Search Food&txtCurrentPage=<%=i%>&txtNameSearch=<%=request.getParameter("txtNameSearch")%>&txtPriceSearch=<%=request.getParameter("txtPriceSearch")%>&txtCategorySearch=<%=request.getParameter("txtCategorySearch")%>"><%=i%></a>
                                </li>
                    <%      }
                        }
                    %>
                </ul>
            </nav><br>
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message != null) {
        %>
               <h3><%= message%></h3>
        <%
            }
        %>
 
        <%
            if (listFood != null) {
                for (FoodDTO food : listFood) {
        %>
                    <form action="MainController" class="food-layout">
                        <div>
                            <image src="<%=food.getLinkImg()%>" width="280" height="180">
                            <h5><%=food.getFoodName()%></h5>
                            <h5>Price: <%=food.getFoodPrice()%> VND</h5>
                            <h5>Quantity: <%=food.getQuantity()%> </h5>
                            <h5>Create Date: <%=food.getCreateDate()%></h5>
                            <h5>Expiration Date: <%=food.getExpirationDate()%></h5>
                            <h5>Description: <%=food.getDescription()%></h5>

                            <input type="hidden" name="txtFoodID"  value=<%= food.getFoodID()%>>
                            <input type="hidden" name="txtFoodName"  value=<%= food.getFoodName()%>>
                            <input type="hidden" name="txtFoodPrice"  value=<%= food.getFoodPrice()%>>
                            <input type="hidden" name="txtCreateDate"  value=<%= food.getCreateDate()%>>
                            <input type="hidden" name="txtExpirationDate"  value=<%= food.getExpirationDate()%>>                       
                            <input type="hidden" name="txtDescription"  value=<%= food.getDescription()%>>
                            <input type="hidden" name="txtQuantity"  value=<%= food.getQuantity()%>>
                            <input type="hidden" name="txtlinkImg"  value=<%= food.getLinkImg()%>>
                            <input type="hidden" name="txtCategoryID"  value=<%= food.getCategoryID()%>>

                            <input type="hidden" name="txtNameSearch"  value=<%= request.getParameter("txtNameSearch") == null ? "" : request.getParameter("txtNameSearch")%>>
                            <input type="hidden" name="txtPriceSearch" value=<%= request.getParameter("txtPriceSearch") == null ? "" : request.getParameter("txtPriceSearch")%>>
                            <input type="hidden" name="txtCategorySearch"  value=<%= request.getParameter("txtCategorySearch") == null ? "" : request.getParameter("txtCategorySearch")%>>
                            <%if (user != null && user.getRoleID().equals("US") || user != null && user.getRoleID().equals("EMAIL")) { %> 
                            <input type="submit" name="btnAction" value="Add" class="add"/>
                            <%}
                            %>  

                        </div>
                    </form>
        <%
                }
        %>
                
                
        <%
            }
        %>
        
    </body>
</html>
