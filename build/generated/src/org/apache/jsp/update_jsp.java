package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import minhtt.dtos.FoodDTO;
import minhtt.dtos.FoodErrorDTO;
import minhtt.dtos.CategoryDTO;
import java.util.List;
import minhtt.dtos.UserDTO;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Update Page</title>\n");
      out.write("        <link href=\"CSS/update.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
  UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            List<CategoryDTO> listCategory = (List<CategoryDTO>) session.getAttribute("LIST_CATEGORY");
            FoodDTO foodUpdate = (FoodDTO) session.getAttribute("FOOD_UPDATE");
        
      out.write("\n");
      out.write("        ");

            if (session.getAttribute("LOGIN_USER") == null || user.getRoleID().equals("US") || user.getRoleID().equals("EMAIL")) {
        
      out.write("\n");
      out.write("               <h3>You must be a Admin to update food, please <a href=\"MainController?btnAction=Logout\">Login</a> with admin account</h3>\n");
      out.write("        ");
      
            } else {
        
      out.write("\n");
      out.write("               <a href=\"MainController?btnAction=Logout\" class=\"logout\">Logout</a><br>\n");
      out.write("               <h2>Admin: ");
      out.print(user.getFullName());
      out.write("</h2>\n");
      out.write("               <div>     \n");
      out.write("                    <h1>Update food </h1>\n");
      out.write("                    ");
if (listCategory != null) {
                    
      out.write("\n");
      out.write("                        <form action=\"MainController\" method=\"POST\" class=\"main-layout\">\n");
      out.write("                            <img src=\"");
      out.print(foodUpdate.getLinkImg());
      out.write("\" width=\"250\" height=\"200\"/><br>\n");
      out.write("                            <input type=\"file\" name=\"txtFile\" id=\"file\" class=\"img\" accept=\"image/*\" onchange=\"previewImage()\"></br>\n");
      out.write("                            Food ID : ");
      out.print(foodUpdate.getFoodID());
      out.write("<br>\n");
      out.write("                            Create date : ");
      out.print(foodUpdate.getCreateDate());
      out.write("<br>\n");
      out.write("                            Expiration date : ");
      out.print(foodUpdate.getExpirationDate());
      out.write("\n");
      out.write("                            <input type=\"hidden\" name=\"txtFoodID\" value=\"");
      out.print(foodUpdate.getFoodID());
      out.write("\" class=\"id\">\n");
      out.write("                            </br>\n");
      out.write("                            \n");
      out.write("                            Food Name  <input type=\"text\" name=\"txtFoodName\" value=\"");
      out.print(foodUpdate.getFoodName());
      out.write("\" class=\"name\">\n");
      out.write("                            </br>\n");
      out.write("                            \n");
      out.write("                            Food price <input type=\"text\" name=\"txtFoodPrice\" value=\"");
      out.print(foodUpdate.getFoodPrice());
      out.write("\" class=\"price\">\n");
      out.write("                            </br>\n");
      out.write("\n");
      out.write("                            Quantity <input type=\"text\" name=\"txtQuantity\" value=\"");
      out.print(foodUpdate.getQuantity());
      out.write("\" class=\"quantity\">\n");
      out.write("                            </br>\n");
      out.write("\n");
      out.write("                            Description <input type=\"text\" name=\"txtDescription\" value=\"");
      out.print(foodUpdate.getDescription());
      out.write("\" class=\"description\">\n");
      out.write("                            </br>\n");
      out.write("                            \n");
      out.write("                            Category <select name=\"cmbCategory\" class=\"typeFood\">\n");
      out.write("                                ");
for (CategoryDTO categorydto : listCategory) {
                                    if (foodUpdate.getCategoryID().equals(categorydto.getCategoryID())) {
                                
      out.write("\n");
      out.write("                                         <option value=\"");
      out.print(categorydto.getCategoryID());
      out.write("\" selected=\"true\">");
      out.print(categorydto.getCategoryName());
      out.write("</option>\n");
      out.write("                                ");
  } else {
                                
      out.write("\n");
      out.write("                                         <option value=\"");
      out.print(categorydto.getCategoryID());
      out.write('"');
      out.write('>');
      out.print(categorydto.getCategoryName());
      out.write("</option>\n");
      out.write("                                ");

                                    }
                                }
      out.write("\n");
      out.write("                            </select></br>\n");
      out.write("                             \n");
      out.write("                            \n");
      out.write("                            Status<select name=\"cmbStatus\" class=\"status\">\n");
      out.write("                                ");

                                    if (foodUpdate.isStatus() == true) {
                                
      out.write(" \n");
      out.write("                                       <option value=\"false\">Inactive</option>\n");
      out.write("                                       <option value=\"true\" selected=\"true\">Active</option>\n");
      out.write("                                ");
  } else {
                                
      out.write("\n");
      out.write("                                       <option value=\"false\" selected=\"true\">Inactive</option>\n");
      out.write("                                       <option value=\"true\">Active</option>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                           </select>         \n");
      out.write("                           </br>\n");
      out.write("\n");
      out.write("                            <input type=\"submit\" name=\"btnAction\" value=\"Update Food\" class=\"update\">\n");
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("               </div>\n");
      out.write("        \n");
      out.write("            \n");
      out.write("        ");
  }
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function previewImage(){\n");
      out.write("                var file=document.getElementById(\"file\").files;\n");
      out.write("                if(file.length >0){\n");
      out.write("                    var fileReader=new FileReader();\n");
      out.write("                    fileReader.onload =function (event){\n");
      out.write("                        document.getElementById(\"preview\").setAttribute(\"src\",event.target.result);\n");
      out.write("                    };\n");
      out.write("                    fileReader.readAsDataURL(file[0]);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
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
