<%-- 
    Document   : admin
    Created on : Jan 6, 2021, 8:06:38 PM
    Author     : minhv
--%>

<%@page import="minhtt.dtos.CategoryDTO"%>
<%@page import="minhtt.dtos.FoodDTO"%>
<%@page import="java.util.List"%>
<%@page import="minhtt.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="CSS/adminn.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <% UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");%>
        <%
            if (session.getAttribute("LOGIN_USER") == null || user.getRoleID().equals("US") || user.getRoleID().equals("EMAIL")) {
        %>       
                <h3>You must be a Admin to manage food, please <a href="MainController?btnAction=Logout">Login</a> with admin account</h3>
        <%
            } else {
        %>      
                <a href="MainController?btnAction=Logout" class="logout">Logout</a>
                <a href="MainController?btnAction=Show CreatePage" class="create">Create Food</a>
                <h1>Welcome admin:<%= user.getFullName()%></h1>      
                <form action="MainController" class="main-layout">
                    Search food: <br>     
                    Name 
                    <input type="text"  name="adminTxtNameSearch" 
                           value="<%= request.getParameter("adminTxtNameSearch") == null ? "" : request.getParameter("adminTxtNameSearch")%>"><br>
                    Price: 
                    <input type="text" name="adminTxtPriceSearch" 
                           value="<%= request.getParameter("adminTxtPriceSearch") == null ? "" : request.getParameter("adminTxtPriceSearch")%>">
                    <br>
                    Category:  
                    <input type="text" name="adminTxtCategorySearch"  
                           value="<%= request.getParameter("adminTxtCategorySearch") == null ? "" : request.getParameter("adminTxtCategorySearch")%>">
                    <br>                      

                    <input type="submit" name="btnAction" value="Search"/>
                </form>
                    
                <form action="MainController" class="delete">     
                <%
                    List<FoodDTO> list = (List<FoodDTO>) request.getAttribute("LIST");
                    List<CategoryDTO> listCategory = (List<CategoryDTO>) request.getAttribute("LIST_CATEGORY");
                    int count = 0;
                    if (list != null) {
                %>  
                    <input type="submit" name="btnAction" value="Delete Food" onclick="return confirm('Do you want to delete?')" class="input"/><br><br>
                    <input type="hidden" name="adminTxtNameSearch"  value=<%= request.getParameter("adminTxtNameSearch") == null ? "" : request.getParameter("adminTxtNameSearch")%>>
                    <input type="hidden" name="adminTxtPriceSearch" value=<%= request.getParameter("adminTxtPriceSearch") == null ? "" : request.getParameter("adminTxtPriceSearch")%>>
                    <input type="hidden" name="adminTxtCategorySearch"  value=<%= request.getParameter("adminTxtCategorySearch") == null ? "" : request.getParameter("adminTxtCategorySearch")%>>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>NO</th>
                                <th>FoodID</th>
                                <th>Name</th>
                                <th>Img</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Description</th>
                                <th>Create date</th>
                                <th>Expiration date</th>
                                <th>Category</th>
                                <th>Status</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (FoodDTO fooddto : list) {
                            %>                  
                                <tr>
                                    <form action="MainController">
                                        <td><%= ++count%></td>
                                        <td>
                                            <%= fooddto.getFoodID()%>
                                            <input type="hidden" name="txtFoodID" value="<%= fooddto.getFoodID()%>"/>
                                        </td>
                                        <td>
                                            <%= fooddto.getFoodName()%>
                                            <input type="hidden" name="txtFoodName" value="<%= fooddto.getFoodName()%>"/>
                                        </td>
                                        <td>
                                            <img src="<%=fooddto.getLinkImg()%>" width="250" height="200"/><br>
                                            <input type="hidden" name="txtImg" value="<%=fooddto.getLinkImg()%>"/>
       
                                        </td>
                                        <td>
                                            <%=fooddto.getFoodPrice()%>
                                            <input type="hidden" name="txtFoodPrice"  value=<%=fooddto.getFoodPrice()%>>
                                        </td>
                                        <td>
                                            <%=fooddto.getQuantity()%>
                                            <input type="hidden" name="txtQuantity"  value="<%=fooddto.getQuantity()%>" >
                                        </td>
                                        <td>
                                            <%=fooddto.getDescription()%>
                                            <input type="hidden" name="txtDescription"  value=<%=fooddto.getDescription()%>>
                                        </td>
                                        <td>
                                            <%= fooddto.getCreateDate()%>
                                            <input type="hidden" name="txtCreateDate"  value=<%=fooddto.getCreateDate()%>>
                                        </td>
                                        <td>
                                            <%= fooddto.getExpirationDate()%>
                                            <input type="hidden" name="txtExpirationDate"  value=<%=fooddto.getExpirationDate()%>>
                                        </td>
                                        <td>
                                            <%for (CategoryDTO categorydto : listCategory) {
                                                    if (fooddto.getCategoryID().equals(categorydto.getCategoryID())) {
                                            %>
                                                        <%=categorydto.getCategoryName()%>
                                                        <input type="hidden" name="txtCategoryID"  value=<%=categorydto.getCategoryID()%>>
                                            <%  
                                                    }
                                            }%>
                                          
                                        </td>
                                        <td>
                                            <%
                                                if (fooddto.isStatus() == true) {
                                            %> 
                                                    Active
                                                    <input type="hidden" name="txtStatus"  value=<%=fooddto.isStatus()%>>
                                            <%  } else {
                                            %>
                                                    Inactive
                                                    <input type="hidden" name="txtStatus"  value=<%=fooddto.isStatus()%>>
                                            <%
                                                }
                                            %>
                                         
                                        </td>
                                        <td>                                           
                                            
                                            <input type="submit" name="btnAction" value="Show Update Page" />
                                        </td>
                                    </form>
                                    <td>
                                        <% if(fooddto.isStatus()==true){
                                        %>
                                            <input type="checkbox" name="foodID<%=count%>" value="<%=fooddto.getFoodID()%>">   
                                        <%
                                        }%>
                                    </td>             
                                </tr
                            <%      
                            }
                            %>
                        </tbody>
                    </table>
                    <input type="hidden" name="count" value="<%=count%>">
                    </form>         
                    <nav>
                       <ul class="pagination justify-content-center">
                            <%   
                               int totalPage = (int) request.getAttribute("TOTAL_PAGE");
                               if(request.getAttribute("TOTAL_PAGE")!=null){
                                
                                    for (int i = 1; i <= totalPage; i++) {
                            %>
                                        <li class="page-item">
                                            <a class="page-link" href="MainController?btnAction=Search&txtCurrentPage=<%=i%>&adminTxtNameSearch=<%=request.getParameter("adminTxtNameSearch")%>&adminTxtPriceSearch=<%=request.getParameter("adminTxtPriceSearch")%>&adminTxtCategorySearch=<%=request.getParameter("adminTxtCategorySearch")%>"><%=i%></a>
                                        </li>
                            <%      }
                               }
                            %>
                       </ul>
                    </nav>
        <%      }
            } 
        %>
        
    </body>
</html>
