package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import minhtt.dtos.FoodErrorDTO;
import minhtt.dtos.CategoryDTO;
import java.util.List;
import minhtt.dtos.UserDTO;

public final class createFood_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Create Page</title>\n");
      out.write("        <link href=\"CSS/createFood.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
  UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            List<CategoryDTO> listCategory = (List<CategoryDTO>) session.getAttribute("LIST_CATEGORY");
            FoodErrorDTO errorDTO = (FoodErrorDTO) request.getAttribute("FOOD_ERROR");
            if (errorDTO == null) {
                errorDTO = new FoodErrorDTO("", "", "", "", "", "","", "","","");
            }
        
      out.write("\n");
      out.write("        ");

            if (session.getAttribute("LOGIN_USER") == null || user.getRoleID().equals("US")|| user.getRoleID().equals("EMAIL")) {
        
      out.write("\n");
      out.write("               <h3>You must be a Admin to create food, please <a href=\"MainController?btnAction=Logout\">Login</a> with admin account</h3>\n");
      out.write("        ");
      
            } else {
        
      out.write("\n");
      out.write("               <a href=\"MainController?btnAction=Logout\" class=\"logout\">Logout</a><br>\n");
      out.write("               <h2>Admin: ");
      out.print(user.getFullName());
      out.write("</h2>\n");
      out.write("               <div>     \n");
      out.write("                    <h1>Create food </h1>\n");
      out.write("                    ");
if (listCategory != null) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date();
                        String strCurrentDate = formatter.format(date);
                    
      out.write("\n");
      out.write("                        <form action=\"MainController\" method=\"POST\" class=\"main-layout\">\n");
      out.write("                            Food ID<input type=\"text\" name=\"txtFoodID\" class=\"id\">\n");
      out.write("                            ");
      out.print(errorDTO.getFoodIDError());
      out.write("</br>\n");
      out.write("                            \n");
      out.write("                            Food Name<input type=\"text\" name=\"txtFoodName\" class=\"name\">\n");
      out.write("                            ");
      out.print(errorDTO.getFoodNameError());
      out.write("</br>\n");
      out.write("                            \n");
      out.write("                            Food price<input type=\"text\" name=\"txtPrice\" class=\"price\">\n");
      out.write("                            ");
      out.print(errorDTO.getFoodPriceError());
      out.write("</br>\n");
      out.write("\n");
      out.write("                            Quantity<input type=\"text\" name=\"txtQuantity\" class=\"quantity\">\n");
      out.write("                            ");
      out.print(errorDTO.getQuantityError());
      out.write("</br>\n");
      out.write("\n");
      out.write("                            Description<input type=\"text\" name=\"txtDescription\" class=\"description\">\n");
      out.write("                            ");
      out.print(errorDTO.getDescriptionError());
      out.write("</br>\n");
      out.write("                            \n");
      out.write("                            Expiration date<input type=\"date\" name=\"txtExpirationDate\" min=\"");
      out.print(strCurrentDate);
      out.write("\"class=\"expirationdate\">\n");
      out.write("                            ");
      out.print(errorDTO.getExpirationDateError());
      out.write("</br>\n");
      out.write("                            \n");
      out.write("                            Category <select name=\"cmbCategory\" class=\"typeFood\">\n");
      out.write("                                ");
for (CategoryDTO categoryDTO : listCategory) {
      out.write("\n");
      out.write("                                     <option value=\"");
      out.print(categoryDTO.getCategoryID());
      out.write('"');
      out.write('>');
      out.print(categoryDTO.getCategoryName());
      out.write("</option>\n");
      out.write("                                ");
}
      out.write("   \n");
      out.write("                            </select></br>\n");
      out.write("\n");
      out.write("                            Img<input type=\"file\" name=\"txtFile\" id=\"file\" class=\"img\" accept=\"image/*\" onchange=\"previewImage()\">\n");
      out.write("                                      \n");
      out.write("                            ");
      out.print(errorDTO.getLinkImgError());
      out.write("</br>\n");
      out.write("\n");
      out.write("                            <input type=\"submit\" name=\"btnAction\" value=\"Create Food\" class=\"create\">\n");
      out.write("                            <input type=\"reset\"  value=\"Reset\" class=\"reset\">\n");
      out.write("                        </form>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("               </div>\n");
      out.write("        \n");
      out.write("            <script>\n");
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
      out.write("            </script>\n");
      out.write("        ");
  }
        
      out.write("\n");
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
