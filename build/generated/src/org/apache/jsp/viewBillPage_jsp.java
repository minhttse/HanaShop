package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import minhtt.dtos.CartDTO;
import minhtt.dtos.UserDTO;

public final class viewBillPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>View Bill Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/viewBillPage.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
           if (session.getAttribute("LOGIN_USER") == null || user.getRoleID().equals("AD")) {
        
      out.write("\n");
      out.write("                <h3>Please <a href=\"MainController?btnAction=Logout\">Login</a> with customer account</h3>\n");
      out.write("                \n");
      out.write("        ");

            }else{
        
      out.write(" \n");
      out.write("                <a href=\"MainController?btnAction=Logout\" class=\"logout\">Logout</a>\n");
      out.write("                <h1>Your bill: </h1>\n");
      out.write("                ");

                CartDTO cart = (CartDTO) session.getAttribute("CART");
                float totalMoney = 0;
                if (cart != null) {
                    
                    int no = 1;      
                
      out.write("\n");
      out.write("                    <h3>Name : ");
      out.print(cart.getCustomerName());
      out.write("</h3>\n");
      out.write("                    <h3>Date : ");
      out.print(cart.getOrderDate());
      out.write("</h3>\n");
      out.write("                    <form action=\"MainController\" class=\"update\">\n");
      out.write("                        Delivery address\n");
      out.write("                        <input type=\"text\" name=\"txtOrderAddress\" value=");
      out.print( cart.getOrderAddress()== null ? "" : cart.getOrderAddress());
      out.write("> \n");
      out.write("                        <input type=\"submit\" name=\"btnAction\" value=\"Update Address\"/><br>\n");
      out.write("\n");
      out.write("                        ");
 String messageUpdate = (String) request.getAttribute("ERROR_UPDATE_MESSAGE");
                            if (messageUpdate != null) {
                        
      out.write("   \n");
      out.write("                                ");
      out.print(messageUpdate);
      out.write("\n");
      out.write("                        ");
 }
                        
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                                \n");
      out.write("                    <br>\n");
      out.write("                    <table border=\"1\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>No</th>\n");
      out.write("                                <th>Food Name</th>\n");
      out.write("                                <th>Amount</th>\n");
      out.write("                                <th>Price</th>\n");
      out.write("                                <th>Total</th>\n");
      out.write("                                <th>Update</th>\n");
      out.write("                                <th>Delete</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
  Set<String> key= cart.getCart().keySet();
                                for (String id : key) {
                                    totalMoney += cart.getCart().get(id).getFoodPrice() * cart.getCart().get(id).getQuantity();
                            
      out.write("\n");
      out.write("                                    <form action=\"MainController\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>");
      out.print( no++);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print( cart.getCart().get(id).getFoodName());
      out.write("\n");
      out.write("                                                <input type=\"hidden\" name=\"txtFoodID\" value=\"");
      out.print(cart.getCart().get(id).getFoodID());
      out.write("\"/>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" name=\"txtAmount\" value=\"");
      out.print(cart.getCart().get(id).getQuantity());
      out.write("\"/>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>");
      out.print( cart.getCart().get(id).getFoodPrice());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print( cart.getCart().get(id).getFoodPrice() * cart.getCart().get(id).getQuantity());
      out.write("</td>\n");
      out.write("                                            <td>                       \n");
      out.write("                                                <input type=\"submit\" name=\"btnAction\" value=\"Update Amount\"/>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>                                                                   \n");
      out.write("                                                <input type=\"submit\" name=\"btnAction\" value=\"Delete Food Cart\" onclick=\"return confirm('Do you want to delete?')\"/>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </form>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("         \n");
      out.write("                    <h2>Total: ");
      out.print(totalMoney);
      out.write("</h2>\n");
      out.write("                    ");
 String messageBuyError = (String) request.getAttribute("MESSAGE_BUY_ERROR");
                        if (messageBuyError != null) {
                    
      out.write("   \n");
      out.write("                            <h3>");
      out.print(messageBuyError);
      out.write("</h3>\n");
      out.write("                    ");
  }
                    
      out.write("\n");
      out.write("                    <form action=\"MainController\" class=\"buyFood\">\n");
      out.write("                        <input type=\"submit\" name=\"btnAction\" value=\"Buy Food\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getUserID());
      out.write("\"/>    \n");
      out.write("                        <input type=\"hidden\" name=\"orderAddress\" value=\"");
      out.print(cart.getOrderAddress());
      out.write("\"/>   \n");
      out.write("                        <input type=\"hidden\" name=\"totalMoney\" value=\"");
      out.print(totalMoney);
      out.write("\"/> \n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                ");

                }
                
      out.write("\n");
      out.write("\n");
      out.write("                ");
 String messageBuy = (String) request.getAttribute("MESSAGE_BUY");
                    if (messageBuy != null) {
                
      out.write("   \n");
      out.write("                        <h3>");
      out.print(messageBuy);
      out.write("</h3>\n");
      out.write("                ");
  }
                
      out.write("\n");
      out.write("                <a href=\"shopping.jsp\" class=\"add\">Add more food !</a> \n");
      out.write("\n");
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
