<%-- 
    Document   : createFood
    Created on : Jan 7, 2021, 12:54:12 PM
    Author     : minhv
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="minhtt.dtos.FoodErrorDTO"%>
<%@page import="minhtt.dtos.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="minhtt.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
        <link href="CSS/createFood.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%  UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            List<CategoryDTO> listCategory = (List<CategoryDTO>) session.getAttribute("LIST_CATEGORY");
            FoodErrorDTO errorDTO = (FoodErrorDTO) request.getAttribute("FOOD_ERROR");
            if (errorDTO == null) {
                errorDTO = new FoodErrorDTO("", "", "", "", "", "","", "","","");
            }
        %>
        <%
            if (session.getAttribute("LOGIN_USER") == null || user.getRoleID().equals("US")|| user.getRoleID().equals("EMAIL")) {
        %>
               <h3>You must be a Admin to create food, please <a href="MainController?btnAction=Logout">Login</a> with admin account</h3>
        <%      
            } else {
        %>
               <a href="MainController?btnAction=Logout" class="logout">Logout</a><br>
               <h2>Admin: <%=user.getFullName()%></h2>
               <div>     
                    <h1>Create food </h1>
                    <%if (listCategory != null) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date();
                        String strCurrentDate = formatter.format(date);
                    %>
                        <form action="MainController" method="POST" class="main-layout">
                            Food ID<input type="text" name="txtFoodID" class="id">
                            <%=errorDTO.getFoodIDError()%></br>
                            
                            Food Name<input type="text" name="txtFoodName" class="name">
                            <%=errorDTO.getFoodNameError()%></br>
                            
                            Food price<input type="text" name="txtPrice" class="price">
                            <%=errorDTO.getFoodPriceError()%></br>

                            Quantity<input type="text" name="txtQuantity" class="quantity">
                            <%=errorDTO.getQuantityError()%></br>

                            Description<input type="text" name="txtDescription" class="description">
                            <%=errorDTO.getDescriptionError()%></br>
                            
                            Expiration date<input type="date" name="txtExpirationDate" min="<%=strCurrentDate%>" class="expirationdate">
                            <%=errorDTO.getExpirationDateError()%></br>
                            
                            Category <select name="cmbCategory" class="typeFood">
                                <%for (CategoryDTO categoryDTO : listCategory) {%>
                                     <option value="<%=categoryDTO.getCategoryID()%>"><%=categoryDTO.getCategoryName()%></option>
                                <%}%>   
                            </select></br>

                            Img<input type="file" name="txtFile" id="file" class="img" accept="image/*" onchange="previewImage()">
                                      
                            <%=errorDTO.getLinkImgError()%></br>

                            <input type="submit" name="btnAction" value="Create Food" class="create">
                            <input type="reset"  value="Reset" class="reset">
                        </form>
                    <%}%>
               </div>
        
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
        <%  }
        %>
    </body>
</html>
