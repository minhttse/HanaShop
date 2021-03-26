package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import minhtt.dtos.CategoryDTO;
import minhtt.dtos.FoodDTO;
import java.util.List;
import minhtt.dtos.UserDTO;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"CSS/adminn.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
      out.write("\n");
      out.write("        ");

            if (session.getAttribute("LOGIN_USER") == null || user.getRoleID().equals("US") || user.getRoleID().equals("EMAIL")) {
        
      out.write("       \n");
      out.write("                <h3>You must be a Admin to manage food, please <a href=\"MainController?btnAction=Logout\">Login</a> with admin account</h3>\n");
      out.write("        ");

            } else {
        
      out.write("      \n");
      out.write("                <a href=\"MainController?btnAction=Logout\" class=\"logout\">Logout</a>\n");
      out.write("                <a href=\"MainController?btnAction=Show CreatePage\" class=\"create\">Create Food</a>\n");
      out.write("                <h1>Welcome admin:");
      out.print( user.getFullName());
      out.write("</h1>      \n");
      out.write("                <form action=\"MainController\" class=\"main-layout\">\n");
      out.write("                    Search food: <br>     \n");
      out.write("                    Name \n");
      out.write("                    <input type=\"text\"  name=\"adminTxtNameSearch\" \n");
      out.write("                           value=\"");
      out.print( request.getParameter("adminTxtNameSearch") == null ? "" : request.getParameter("adminTxtNameSearch"));
      out.write("\"><br>\n");
      out.write("                    Price: \n");
      out.write("                    <input type=\"text\" name=\"adminTxtPriceSearch\" \n");
      out.write("                           value=\"");
      out.print( request.getParameter("adminTxtPriceSearch") == null ? "" : request.getParameter("adminTxtPriceSearch"));
      out.write("\">\n");
      out.write("                    <br>\n");
      out.write("                    Category:  \n");
      out.write("                    <input type=\"text\" name=\"adminTxtCategorySearch\"  \n");
      out.write("                           value=\"");
      out.print( request.getParameter("adminTxtCategorySearch") == null ? "" : request.getParameter("adminTxtCategorySearch"));
      out.write("\">\n");
      out.write("                    <br>                      \n");
      out.write("\n");
      out.write("                    <input type=\"submit\" name=\"btnAction\" value=\"Search\"/>\n");
      out.write("                </form>\n");
      out.write("                    \n");
      out.write("                <form action=\"MainController\" class=\"delete\">     \n");
      out.write("                ");

                    List<FoodDTO> list = (List<FoodDTO>) request.getAttribute("LIST");
                    List<CategoryDTO> listCategory = (List<CategoryDTO>) request.getAttribute("LIST_CATEGORY");
                    int count = 0;
                    if (list != null) {
                
      out.write("  \n");
      out.write("                    <input type=\"submit\" name=\"btnAction\" value=\"Delete Food\" onclick=\"return confirm('Do you want to delete?')\" class=\"input\"/><br><br>\n");
      out.write("                    <input type=\"hidden\" name=\"adminTxtNameSearch\"  value=");
      out.print( request.getParameter("adminTxtNameSearch") == null ? "" : request.getParameter("adminTxtNameSearch"));
      out.write(">\n");
      out.write("                    <input type=\"hidden\" name=\"adminTxtPriceSearch\" value=");
      out.print( request.getParameter("adminTxtPriceSearch") == null ? "" : request.getParameter("adminTxtPriceSearch"));
      out.write(">\n");
      out.write("                    <input type=\"hidden\" name=\"adminTxtCategorySearch\"  value=");
      out.print( request.getParameter("adminTxtCategorySearch") == null ? "" : request.getParameter("adminTxtCategorySearch"));
      out.write(">\n");
      out.write("                    <table border=\"1\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>NO</th>\n");
      out.write("                                <th>FoodID</th>\n");
      out.write("                                <th>Name</th>\n");
      out.write("                                <th>Img</th>\n");
      out.write("                                <th>Price</th>\n");
      out.write("                                <th>Quantity</th>\n");
      out.write("                                <th>Description</th>\n");
      out.write("                                <th>Create date</th>\n");
      out.write("                                <th>Expiration date</th>\n");
      out.write("                                <th>Category</th>\n");
      out.write("                                <th>Status</th>\n");
      out.write("                                <th>Update</th>\n");
      out.write("                                <th>Delete</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
 for (FoodDTO fooddto : list) {
                            
      out.write("                  \n");
      out.write("                                <tr>\n");
      out.write("                                    <form action=\"MainController\">\n");
      out.write("                                        <td>");
      out.print( ++count);
      out.write("</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");
      out.print( fooddto.getFoodID());
      out.write("\n");
      out.write("                                            <input type=\"hidden\" name=\"txtFoodID\" value=\"");
      out.print( fooddto.getFoodID());
      out.write("\"/>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");
      out.print( fooddto.getFoodName());
      out.write("\n");
      out.write("                                            <input type=\"hidden\" name=\"txtFoodName\" value=\"");
      out.print( fooddto.getFoodName());
      out.write("\"/>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <img src=\"");
      out.print(fooddto.getLinkImg());
      out.write("\" width=\"250\" height=\"200\"/><br>\n");
      out.write("                                            <input type=\"hidden\" name=\"txtImg\" value=\"");
      out.print(fooddto.getLinkImg());
      out.write("\"/>\n");
      out.write("       \n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");
      out.print(fooddto.getFoodPrice());
      out.write("\n");
      out.write("                                            <input type=\"hidden\" name=\"txtFoodPrice\"  value=");
      out.print(fooddto.getFoodPrice());
      out.write(">\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");
      out.print(fooddto.getQuantity());
      out.write("\n");
      out.write("                                            <input type=\"hidden\" name=\"txtQuantity\"  value=\"");
      out.print(fooddto.getQuantity());
      out.write("\" >\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");
      out.print(fooddto.getDescription());
      out.write("\n");
      out.write("                                            <input type=\"hidden\" name=\"txtDescription\"  value=");
      out.print(fooddto.getDescription());
      out.write(">\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");
      out.print( fooddto.getCreateDate());
      out.write("\n");
      out.write("                                            <input type=\"hidden\" name=\"txtCreateDate\"  value=");
      out.print(fooddto.getCreateDate());
      out.write(">\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");
      out.print( fooddto.getExpirationDate());
      out.write("\n");
      out.write("                                            <input type=\"hidden\" name=\"txtExpirationDate\"  value=");
      out.print(fooddto.getExpirationDate());
      out.write(">\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");
for (CategoryDTO categorydto : listCategory) {
                                                    if (fooddto.getCategoryID().equals(categorydto.getCategoryID())) {
                                            
      out.write("\n");
      out.write("                                                        ");
      out.print(categorydto.getCategoryName());
      out.write("\n");
      out.write("                                                        <input type=\"hidden\" name=\"txtCategoryID\"  value=");
      out.print(categorydto.getCategoryID());
      out.write(">\n");
      out.write("                                            ");
  
                                                    }
                                            }
      out.write("\n");
      out.write("                                          \n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");

                                                if (fooddto.isStatus() == true) {
                                            
      out.write(" \n");
      out.write("                                                    Active\n");
      out.write("                                                    <input type=\"hidden\" name=\"txtStatus\"  value=");
      out.print(fooddto.isStatus());
      out.write(">\n");
      out.write("                                            ");
  } else {
                                            
      out.write("\n");
      out.write("                                                    Inactive\n");
      out.write("                                                    <input type=\"hidden\" name=\"txtStatus\"  value=");
      out.print(fooddto.isStatus());
      out.write(">\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\n");
      out.write("                                         \n");
      out.write("                                        </td>\n");
      out.write("                                        <td>                                           \n");
      out.write("                                            \n");
      out.write("                                            <input type=\"submit\" name=\"btnAction\" value=\"Show Update Page\" />\n");
      out.write("                                        </td>\n");
      out.write("                                    </form>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");
 if(fooddto.isStatus()==true){
                                        
      out.write("\n");
      out.write("                                            <input type=\"checkbox\" name=\"foodID");
      out.print(count);
      out.write("\" value=\"");
      out.print(fooddto.getFoodID());
      out.write("\">   \n");
      out.write("                                        ");

                                        }
      out.write("\n");
      out.write("                                    </td>             \n");
      out.write("                                </tr\n");
      out.write("                            ");
      
                            }
                            
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    <input type=\"hidden\" name=\"count\" value=\"");
      out.print(count);
      out.write("\">\n");
      out.write("                    </form>         \n");
      out.write("                    <nav>\n");
      out.write("                       <ul class=\"pagination justify-content-center\">\n");
      out.write("                            ");
   
                               int totalPage = (int) request.getAttribute("TOTAL_PAGE");
                               if(request.getAttribute("TOTAL_PAGE")!=null){
                                
                                    for (int i = 1; i <= totalPage; i++) {
                            
      out.write("\n");
      out.write("                                        <li class=\"page-item\">\n");
      out.write("                                            <a class=\"page-link\" href=\"MainController?btnAction=Search&txtCurrentPage=");
      out.print(i);
      out.write("&adminTxtNameSearch=");
      out.print(request.getParameter("adminTxtNameSearch"));
      out.write("&adminTxtPriceSearch=");
      out.print(request.getParameter("adminTxtPriceSearch"));
      out.write("&adminTxtCategorySearch=");
      out.print(request.getParameter("adminTxtCategorySearch"));
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\n");
      out.write("                                        </li>\n");
      out.write("                            ");
      }
                               }
                            
      out.write("\n");
      out.write("                       </ul>\n");
      out.write("                    </nav>\n");
      out.write("        ");
      }
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
