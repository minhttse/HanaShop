<%-- 
    Document   : viewBillPage
    Created on : Jan 7, 2021, 8:03:05 PM
    Author     : minhv
--%>

<%@page import="java.util.Set"%>
<%@page import="minhtt.dtos.CartDTO"%>
<%@page import="minhtt.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Bill Page</title>
        <link rel="stylesheet" href="CSS/viewBillPage.css">
    </head>
    <body>
        <% UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
           if (session.getAttribute("LOGIN_USER") == null || user.getRoleID().equals("AD")) {
        %>
                <h3>Please <a href="MainController?btnAction=Logout">Login</a> with customer account</h3>
                
        <%
            }else{
        %> 
                <a href="MainController?btnAction=Logout" class="logout">Logout</a>
                <h1>Your bill: </h1>
                <%
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                float totalMoney = 0;
                if (cart != null) {
                    
                    int no = 1;      
                %>
                    <h3>Name : <%=cart.getCustomerName()%></h3>
                    <h3>Date : <%=cart.getOrderDate()%></h3>
                    <form action="MainController" class="update">
                        Delivery address
                        <input type="text" name="txtOrderAddress" value=<%= cart.getOrderAddress()== null ? "" : cart.getOrderAddress()%>> 
                        <input type="submit" name="btnAction" value="Update Address"/><br>

                        <% String messageUpdate = (String) request.getAttribute("ERROR_UPDATE_MESSAGE");
                            if (messageUpdate != null) {
                        %>   
                                <%=messageUpdate%>
                        <% }
                        %>
                    </form>
                                
                    <br>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Food Name</th>
                                <th>Amount</th>
                                <th>Price</th>
                                <th>Total</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%  Set<String> key= cart.getCart().keySet();
                                for (String id : key) {
                                    totalMoney += cart.getCart().get(id).getFoodPrice() * cart.getCart().get(id).getQuantity();
                            %>
                                    <form action="MainController">
                                        <tr>
                                            <td><%= no++%></td>
                                            <td><%= cart.getCart().get(id).getFoodName()%>
                                                <input type="hidden" name="txtFoodID" value="<%=cart.getCart().get(id).getFoodID()%>"/>
                                            </td>
                                            <td>
                                                <input type="text" name="txtAmount" value="<%=cart.getCart().get(id).getQuantity()%>"/>
                                            </td>
                                            <td><%= cart.getCart().get(id).getFoodPrice()%></td>
                                            <td><%= cart.getCart().get(id).getFoodPrice() * cart.getCart().get(id).getQuantity()%></td>
                                            <td>                       
                                                <input type="submit" name="btnAction" value="Update Amount"/>
                                            </td>
                                            <td>                                                                   
                                                <input type="submit" name="btnAction" value="Delete Food Cart" onclick="return confirm('Do you want to delete?')"/>
                                            </td>
                                        </tr>
                                    </form>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
         
                    <h2>Total: <%=totalMoney%></h2>
                    <% String messageBuyError = (String) request.getAttribute("MESSAGE_BUY_ERROR");
                        if (messageBuyError != null) {
                    %>   
                            <h3><%=messageBuyError%></h3>
                    <%  }
                    %>
                    <form action="MainController" class="buyFood">
                        <input type="submit" name="btnAction" value="Buy Food"/>
                        <input type="hidden" name="userID" value="<%=user.getUserID()%>"/>    
                        <input type="hidden" name="orderAddress" value="<%=cart.getOrderAddress()%>"/>   
                        <input type="hidden" name="totalMoney" value="<%=totalMoney%>"/> 
                    </form>


                <%
                }
                %>

                <% String messageBuy = (String) request.getAttribute("MESSAGE_BUY");
                    if (messageBuy != null) {
                %>   
                        <h3><%=messageBuy%></h3>
                <%  }
                %>
                <a href="shopping.jsp" class="add">Add more food !</a> 

        <%
            }
        %>
        
    </body>
</html>
