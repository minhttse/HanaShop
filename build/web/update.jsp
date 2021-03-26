<%-- 
    Document   : update
    Created on : Jan 14, 2021, 2:53:11 PM
    Author     : minhv
--%>

<%@page import="minhtt.dtos.FoodDTO"%>
<%@page import="minhtt.dtos.FoodErrorDTO"%>
<%@page import="minhtt.dtos.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="minhtt.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
        <link href="CSS/update.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%  UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            List<CategoryDTO> listCategory = (List<CategoryDTO>) session.getAttribute("LIST_CATEGORY");
            FoodDTO foodUpdate = (FoodDTO) session.getAttribute("FOOD_UPDATE");
        %>
        <%
            if (session.getAttribute("LOGIN_USER") == null || user.getRoleID().equals("US") || user.getRoleID().equals("EMAIL")) {
        %>
               <h3>You must be a Admin to update food, please <a href="MainController?btnAction=Logout">Login</a> with admin account</h3>
        <%      
            } else {
        %>
               <a href="MainController?btnAction=Logout" class="logout">Logout</a><br>
               <h2>Admin: <%=user.getFullName()%></h2>
               <div>     
                    <h1>Update food </h1>
                    <%if (listCategory != null) {
                    %>
                        <form action="MainController" method="POST" class="main-layout">
                            <img src="<%=foodUpdate.getLinkImg()%>" width="250" height="200"/><br>
                            <input type="file" name="txtFile" id="file" class="img" accept="image/*" onchange="previewImage()"></br>
                            Food ID : <%=foodUpdate.getFoodID()%><br>
                            Create date : <%=foodUpdate.getCreateDate()%><br>
                            Expiration date : <%=foodUpdate.getExpirationDate()%>
                            <input type="hidden" name="txtFoodID" value="<%=foodUpdate.getFoodID()%>" class="id">
                            </br>
                            
                            Food Name  <input type="text" name="txtFoodName" value="<%=foodUpdate.getFoodName()%>" class="name">
                            </br>
                            
                            Food price <input type="text" name="txtFoodPrice" value="<%=foodUpdate.getFoodPrice()%>" class="price">
                            </br>

                            Quantity <input type="text" name="txtQuantity" value="<%=foodUpdate.getQuantity()%>" class="quantity">
                            </br>

                            Description <input type="text" name="txtDescription" value="<%=foodUpdate.getDescription()%>" class="description">
                            </br>
                            
                            Category <select name="cmbCategory" class="typeFood">
                                <%for (CategoryDTO categorydto : listCategory) {
                                    if (foodUpdate.getCategoryID().equals(categorydto.getCategoryID())) {
                                %>
                                         <option value="<%=categorydto.getCategoryID()%>" selected="true"><%=categorydto.getCategoryName()%></option>
                                <%  } else {
                                %>
                                         <option value="<%=categorydto.getCategoryID()%>"><%=categorydto.getCategoryName()%></option>
                                <%
                                    }
                                }%>
                            </select></br>
                             
                            
                            Status<select name="cmbStatus" class="status">
                                <%
                                    if (foodUpdate.isStatus() == true) {
                                %> 
                                       <option value="false">Inactive</option>
                                       <option value="true" selected="true">Active</option>
                                <%  } else {
                                %>
                                       <option value="false" selected="true">Inactive</option>
                                       <option value="true">Active</option>
                                <%
                                    }
                                %>
                           </select>         
                           </br>

                            <input type="submit" name="btnAction" value="Update Food" class="update">

                        </form>
                    <%}%>
               </div>
        
            
        <%  }
        %>
        <script>
            function previewImage(){
                var file=document.getElementById("file").files;
                if(file.length >0){
                    var fileReader=new FileReader();
                    fileReader.onload =function (event){
                        document.getElementById("preview").setAttribute("src",event.target.result);
                    };
                    fileReader.readAsDataURL(file[0]);
                }
            }
            
        </script>
    </body>
</html>
