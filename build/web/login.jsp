<%-- 
    Document   : login
    Created on : Jan 5, 2021, 8:03:17 PM
    Author     : minhv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-scope" content="profile email">
        <meta name="google-signin-client_id" content="681605950807-q6k0mbdtvkiqdth0o74p7rc2mqehvuh0.apps.googleusercontent.com">
        <link rel="stylesheet" href="CSS/loginn.css">   
    </head>
    <body>       
        <div class="main-div">
            <h1>Login </h1>
            <form action="MainController" method="POST" class="main-layout">
                User ID:  <input type="text" name="txtUserID" class="ID"/></br>
                Password: <input type="password" name="txtPassword" class="password"/></br>
                <input type="submit" name="btnAction" value="Login" class="login"/>
                <input type="reset" value="Reset" class="reset"/>
            </form>
            <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
            <%  String message = (String) session.getAttribute("LOGIN_INVALID");
                if (message == null) {
                    message = "";
            }%>
            <h5><%=message%></h5>
            <a href="MainController?btnAction=Show FoodPage" class="shopping">Food Shop</a> 
        </div>
            
        <script>
            function onSignIn(googleUser) {
                // Useful data for your client-side scripts:
                var auth2 = gapi.auth2.getAuthInstance();
                auth2.signOut().then(function () {
                    console.log('User signed out.');
                });
                var profile = googleUser.getBasicProfile();
                window.location.href = 'MainController?btnAction=LoginGG&txtUserID=' + profile.getEmail() + '&txtFullName=' + profile.getName();
            }
        </script>
    </body>
</html>

