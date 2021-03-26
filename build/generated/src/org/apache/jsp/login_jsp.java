package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login Page</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n");
      out.write("        <meta name=\"google-signin-scope\" content=\"profile email\">\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"681605950807-q6k0mbdtvkiqdth0o74p7rc2mqehvuh0.apps.googleusercontent.com\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/loginn.css\">   \n");
      out.write("    </head>\n");
      out.write("    <body>       \n");
      out.write("        <div class=\"main-div\">\n");
      out.write("            <h1>Login </h1>\n");
      out.write("            <form action=\"MainController\" method=\"POST\" class=\"main-layout\">\n");
      out.write("                User ID:  <input type=\"text\" name=\"txtUserID\" class=\"ID\"/></br>\n");
      out.write("                Password: <input type=\"password\" name=\"txtPassword\" class=\"password\"/></br>\n");
      out.write("                <input type=\"submit\" name=\"btnAction\" value=\"Login\" class=\"login\"/>\n");
      out.write("                <input type=\"reset\" value=\"Reset\" class=\"reset\"/>\n");
      out.write("            </form>\n");
      out.write("            <div class=\"g-signin2\" data-onsuccess=\"onSignIn\" data-theme=\"dark\"></div>\n");
      out.write("            ");
  String message = (String) session.getAttribute("LOGIN_INVALID");
                if (message == null) {
                    message = "";
            }
      out.write("\n");
      out.write("            <h5>");
      out.print(message);
      out.write("</h5>\n");
      out.write("            <a href=\"MainController?btnAction=Show FoodPage\" class=\"shopping\">Food Shop</a> \n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        <script>\n");
      out.write("            function onSignIn(googleUser) {\n");
      out.write("                // Useful data for your client-side scripts:\n");
      out.write("                var auth2 = gapi.auth2.getAuthInstance();\n");
      out.write("                auth2.signOut().then(function () {\n");
      out.write("                    console.log('User signed out.');\n");
      out.write("                });\n");
      out.write("                var profile = googleUser.getBasicProfile();\n");
      out.write("                window.location.href = 'MainController?btnAction=LoginGG&txtUserID=' + profile.getEmail() + '&txtFullName=' + profile.getName();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
