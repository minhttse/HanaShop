package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import minhtt.dtos.OrderDetailDTO;
import java.util.Map;
import minhtt.dtos.OrderDTO;
import java.util.List;
import minhtt.dtos.UserDTO;

public final class history_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>History Page</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.11.3.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://formden.com/static/cdn/bootstrap-iso.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css\"/>\n");
      out.write("        <link href=\"CSS/history.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 Map<String,List<String>> listOrder = (Map<String,List<String>>) request.getAttribute("LIST_ORDER");
           UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
           if (session.getAttribute("LOGIN_USER") == null || user.getRoleID().equals("AD")) {
        
      out.write("\n");
      out.write("                <h3>Please <a href=\"MainController?btnAction=Logout\">Login</a> with customer account</h3>\n");
      out.write("        ");

            }else{     
        
      out.write("   \n");
      out.write("                <a href=\"MainController?btnAction=Show FoodPage\" class=\"shopping\">Back to shopping</a> \n");
      out.write("                <a href=\"MainController?btnAction=Logout\" class=\"logout\">Logout</a>\n");
      out.write("                <br><br><br><h1>History : </h1><br><br>\n");
      out.write("                <div class=\"bootstrap-iso\">\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6 col-sm-6 col-xs-12\">\n");
      out.write("                                <form action=\"MainController\" class=\"main-layout\">\n");
      out.write("                                    Search history: <br>\n");
      out.write("                                    Date \n");
      out.write("                                    <input type=\"text\"  name=\"txtDateSearch\"  \n");
      out.write("                                           value=\"");
      out.print( request.getParameter("txtDateSearch") == null ? "" : request.getParameter("txtDateSearch"));
      out.write("\">\n");
      out.write("                                    Food Name: \n");
      out.write("                                    <input type=\"text\" name=\"txtFoodNameSearch\" \n");
      out.write("                                           value=\"");
      out.print( request.getParameter("txtFoodNameSearch") == null ? "" : request.getParameter("txtFoodNameSearch"));
      out.write("\" class=\"price\">\n");
      out.write("\n");
      out.write("                                    <input type=\"submit\" name=\"btnAction\" value=\"Search History\" class=\"search\"/>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>    \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                                               \n");
      out.write("                ");
if (listOrder != null) {           
                      int no = 1; 
                
      out.write("\n");
      out.write("                    <table border=\"1\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>No</th>\n");
      out.write("                                <th>Order Date</th>\n");
      out.write("                                <th>Order Address</th>\n");
      out.write("                                <th>Food</th>\n");
      out.write("                                <th>TotalPrice</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
  Set<String> key = listOrder.keySet();
                                for (String order : key) {
                                    String[] arr = order.split("_");
                                    String orderDate = arr[0];
                                    String orderAddress = arr[1];
                                    String totalPrice = arr[2];
                            
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>");
      out.print( no++);
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print( orderDate);
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print( orderAddress);
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print( listOrder.get(order));
      out.write("</td>       \n");
      out.write("                                        <td>");
      out.print( totalPrice);
      out.write("</td>  \n");
      out.write("                                    </tr>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>                           \n");
      out.write("        ");

                }
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var dateSearch = $('input[name=\"txtDateSearch\"]');           \n");
      out.write("                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : \"body\";\n");
      out.write("                dateSearch.datepicker({\n");
      out.write("                    format: 'mm/dd/yyyy',\n");
      out.write("                    container: container,\n");
      out.write("                    todayHighlight: true,\n");
      out.write("                    autoclose: true,\n");
      out.write("//                    \n");
      out.write("                })\n");
      out.write("            })\n");
      out.write("        </script>\n");
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
