package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import minhtt.dtos.FoodDTO;
import java.util.List;
import minhtt.dtos.UserDTO;

public final class shopping_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Shopping Page</title>       \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"CSS/shoppingg.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            List<FoodDTO> listFood = (List<FoodDTO>) request.getAttribute("LIST_FOOD");
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user != null &&user.getRoleID().equals("US") || user != null &&user.getRoleID().equals("EMAIL")) {
        
      out.write("         \n");
      out.write("                <a href=\"MainController?btnAction=Search History\">History</a>\n");
      out.write("                <a href=\"MainController?btnAction=Logout\">Logout</a>\n");
      out.write("                <h1>Welcome ");
      out.print(user.getFullName());
      out.write(" to Hana Shop</h1><br><br><br><br><br>\n");
      out.write("        ");

            } else {
        
      out.write("\n");
      out.write("                <a href=\"MainController?btnAction=Logout\">Login</a>\n");
      out.write("                <h1>Welcome to Hana Shop</h1><br><br><br><br><br>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <form action=\"MainController\" class=\"main-layout\">\n");
      out.write("            Search food: <br>     \n");
      out.write("            Name \n");
      out.write("            <input type=\"text\"  name=\"txtNameSearch\" class=\"name\"\n");
      out.write("                   value=\"");
      out.print( request.getParameter("txtNameSearch") == null ? "" : request.getParameter("txtNameSearch"));
      out.write("\"><br>\n");
      out.write("            Price: \n");
      out.write("            <input type=\"text\" name=\"txtPriceSearch\" class=\"price\"\n");
      out.write("                   value=\"");
      out.print( request.getParameter("txtPriceSearch") == null ? "" : request.getParameter("txtPriceSearch"));
      out.write("\">\n");
      out.write("            <br>\n");
      out.write("            Category:  \n");
      out.write("            <input type=\"text\" name=\"txtCategorySearch\"  class=\"category\"\n");
      out.write("                   value=\"");
      out.print( request.getParameter("txtCategorySearch") == null ? "" : request.getParameter("txtCategorySearch"));
      out.write("\">\n");
      out.write("            <br>                      \n");
      out.write("\n");
      out.write("            <input type=\"submit\" name=\"btnAction\" value=\"Search Food\"/>\n");
      out.write("            ");
if (user != null &&user.getRoleID().equals("US") || user != null &&user.getRoleID().equals("EMAIL")) { 
      out.write(" \n");
      out.write("                <input type=\"submit\" name=\"btnAction\" value=\"View\"/>\n");
      out.write("            ");
}
            
      out.write("    \n");
      out.write("            <br><br>\n");
      out.write("        </form>\n");
      out.write("            <nav>\n");
      out.write("                <ul class=\"pagination justify-content-center\">\n");
      out.write("                    ");

                        if (request.getAttribute("TOTAL_PAGE") != null) {
                            int totalPage = (int) request.getAttribute("TOTAL_PAGE");
                            for (int i = 1; i <= totalPage; i++) {
                    
      out.write("\n");
      out.write("                                <li class=\"page-item\">\n");
      out.write("                                    <a class=\"page-link\" href=\"MainController?btnAction=Search Food&txtCurrentPage=");
      out.print(i);
      out.write("&txtNameSearch=");
      out.print(request.getParameter("txtNameSearch"));
      out.write("&txtPriceSearch=");
      out.print(request.getParameter("txtPriceSearch"));
      out.write("&txtCategorySearch=");
      out.print(request.getParameter("txtCategorySearch"));
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\n");
      out.write("                                </li>\n");
      out.write("                    ");
      }
                        }
                    
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </nav><br>\n");
      out.write("        ");

            String message = (String) request.getAttribute("MESSAGE");
            if (message != null) {
        
      out.write("\n");
      out.write("               <h3>");
      out.print( message);
      out.write("</h3>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write(" \n");
      out.write("        ");

            if (listFood != null) {
                for (FoodDTO food : listFood) {
        
      out.write("\n");
      out.write("                    <form action=\"MainController\" class=\"food-layout\">\n");
      out.write("                        <div>\n");
      out.write("                            <image src=\"");
      out.print(food.getLinkImg());
      out.write("\" width=\"280\" height=\"180\">\n");
      out.write("                            <h5>");
      out.print(food.getFoodName());
      out.write("</h5>\n");
      out.write("                            <h5>Price: ");
      out.print(food.getFoodPrice());
      out.write(" VND</h5>\n");
      out.write("                            <h5>Quantity: ");
      out.print(food.getQuantity());
      out.write(" </h5>\n");
      out.write("                            <h5>Create Date: ");
      out.print(food.getCreateDate());
      out.write("</h5>\n");
      out.write("                            <h5>Expiration Date: ");
      out.print(food.getExpirationDate());
      out.write("</h5>\n");
      out.write("                            <h5>Description: ");
      out.print(food.getDescription());
      out.write("</h5>\n");
      out.write("\n");
      out.write("                            <input type=\"hidden\" name=\"txtFoodID\"  value=");
      out.print( food.getFoodID());
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"txtFoodName\"  value=");
      out.print( food.getFoodName());
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"txtFoodPrice\"  value=");
      out.print( food.getFoodPrice());
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"txtCreateDate\"  value=");
      out.print( food.getCreateDate());
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"txtExpirationDate\"  value=");
      out.print( food.getExpirationDate());
      out.write(">                       \n");
      out.write("                            <input type=\"hidden\" name=\"txtDescription\"  value=");
      out.print( food.getDescription());
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"txtQuantity\"  value=");
      out.print( food.getQuantity());
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"txtlinkImg\"  value=");
      out.print( food.getLinkImg());
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"txtCategoryID\"  value=");
      out.print( food.getCategoryID());
      out.write(">\n");
      out.write("\n");
      out.write("                            <input type=\"hidden\" name=\"txtNameSearch\"  value=");
      out.print( request.getParameter("txtNameSearch") == null ? "" : request.getParameter("txtNameSearch"));
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"txtPriceSearch\" value=");
      out.print( request.getParameter("txtPriceSearch") == null ? "" : request.getParameter("txtPriceSearch"));
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"txtCategorySearch\"  value=");
      out.print( request.getParameter("txtCategorySearch") == null ? "" : request.getParameter("txtCategorySearch"));
      out.write(">\n");
      out.write("                            ");
if (user != null && user.getRoleID().equals("US") || user != null && user.getRoleID().equals("EMAIL")) { 
      out.write(" \n");
      out.write("                            <input type=\"submit\" name=\"btnAction\" value=\"Add\" class=\"add\"/>\n");
      out.write("                            ");
}
                            
      out.write("  \n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("        ");

                }
        
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
