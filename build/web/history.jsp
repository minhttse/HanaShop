<%-- 
    Document   : history
    Created on : Jan 10, 2021, 2:39:58 PM
    Author     : minhv
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <link href="CSS/history.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <c:if test="${sessionScope.LOGIN_USER==null  || sessionScope.LOGIN_USER.roleID =='AD'}">          
            <h3>Please <a href="MainController?btnAction=Logout">Login</a> with customer account</h3>
        </c:if>
        
        <c:if test="${sessionScope.LOGIN_USER!=null && sessionScope.LOGIN_USER.roleID =='US' || sessionScope.LOGIN_USER!=null && sessionScope.LOGIN_USER.roleID =='EMAIL'}">          
            <a href="MainController?btnAction=Show FoodPage" class="shopping">Back to shopping</a> 
                <a href="MainController?btnAction=Logout" class="logout">Logout</a>
                <br><br><br><h1>History : </h1><br><br>
                <div class="bootstrap-iso">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <form action="MainController" class="main-layout">
                                    Search history: <br>
                                    Date 
                                    <input type="text"  name="txtDateSearch"  
                                           value="${param.txtDateSearch==null ?"":param.txtDateSearch}">
                                    Food Name: 
                                    <input type="text" name="txtFoodNameSearch"  
                                           value="${param.txtFoodNameSearch==null ?"":param.txtFoodNameSearch}" class="price">

                                    <input type="submit" name="btnAction" value="Search History" class="search"/>
                                </form>
                            </div>
                        </div>    
                    </div>
                </div>
                <c:if test="${requestScope.LIST_ORDER!=null }">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Order Date</th>
                                <th>Order Address</th>
                                <th>Food</th>
                                <th>TotalPrice</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="string" varStatus="counter" items="${requestScope.LIST_ORDER}">
                                <c:set var="arr" value="${fn:split(string, '_')}" />                                 
                            
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${arr[0]}</td>
                                        <td>${arr[1]}</td>
                                        <td>${string.value}</td>       
                                        <td>${arr[2]}</td>  
                                    </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                </c:if>       
            </c:if>             
    
        <script>
            $(document).ready(function () {
                var dateSearch = $('input[name="txtDateSearch"]');           
                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                dateSearch.datepicker({
                    format: 'mm/dd/yyyy',
                    container: container,
                    todayHighlight: true,
                    autoclose: true,
//                    
                })
            })
        </script>
    </body>
</html>
