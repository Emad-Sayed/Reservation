package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class m_005fAddBranch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("      \n");
      out.write("<script>\n");
      out.write("    window.onload=function LoadCategory()\n");
      out.write("{\n");
      out.write("    alert(\"QQ\")\n");
      out.write("    http.onreadystatechange = PT;\n");
      out.write("\n");
      out.write("    function PT()\n");
      out.write("    {\n");
      out.write("        \n");
      out.write("        var data = http.responseText;\n");
      out.write("        var obj  =JSON.parse(data);\n");
      out.write("        if (http.readyState == 4 && http.status == 200)\n");
      out.write("        {\n");
      out.write("            var Parent=document.getElementById(\"Category_\");\n");
      out.write("            for (var i = 1; i < obj.length; i++)\n");
      out.write("            {\n");
      out.write("                var L = document.createElement(\"option\");\n");
      out.write("                L.innerHTML = obj[i].CAT ;\n");
      out.write("                Parent.appendChild(L);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    http.open(\"GeT\", 'LoadCategory',true);\n");
      out.write("    http.send(null);\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("            <!-- MAIN -->\n");
      out.write("            <main role=\"main\">\n");
      out.write("                <!-- Content -->\n");
      out.write("                <article>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <section class=\"section-top-padding background-white\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"ControlBoth\">\n");
      out.write("                        <div class=\"form-style-2\" style=\"float: left;\">\n");
      out.write("                            <div class=\"form-style-2-heading\">New Brunch</div>\n");
      out.write("\n");
      out.write("                            <form  method=\"post\">\n");
      out.write("                                <label for=\"field1\"><span> Name  <span class=\"required\">*</span></span><input id='Name_' type=\"text\" class=\"input-field\" name=\"Name\" value=\"\" /></label>\n");
      out.write("                                      <label for=\"field1\"><span>Director  <span class=\"required\">*</span></span><input id='Director_' type=\"text\" class=\"input-field\" name=\"Director\" value=\"\" /></label>\n");
      out.write("                                <label for=\"field1\"><span> Phone  <span class=\"required\">*</span></span><input id='Phone_' type=\"text\" class=\"input-field\" name=\"Phone\" value=\"\" /></label>\n");
      out.write("                          \n");
      out.write("                                <label for=\"field2\"><span> Description  <span class=\"required\">*</span></span><input id='Description_' type=\"text\" class=\"input-field\" name=\"Description\" value=\"\" /></label>\n");
      out.write("\n");
      out.write("                                <label for=\"field2\"><span>Category<span class=\"required\">*</span></span>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <select class=\"form-control\" id=\"Category_\" name=\"Category\">\n");
      out.write("                                            \n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </label>\n");
      out.write("                                    <div style=\"margin-top: 50px\"class=\"center\">\n");
      out.write("                                        <button  onclick=\"AddBranch()\" type=\"button\" class=\"btn\">Add Brunch</button>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-style-2\" style=\"float: right\">\n");
      out.write("                            <div class=\"form-style-2-heading\">New Category</div>\n");
      out.write("\n");
      out.write("                            <form action=\"\" method=\"post\">\n");
      out.write("                                <label for=\"field1\"><span> Name  <span class=\"required\">*</span></span><input id='Cat_Name_' type=\"text\" class=\"input-field\" name=\"field1\" value=\"\" /></label>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <div style=\"margin-top: 85px\"class=\"center\">\n");
      out.write("                                        <button onclick=\"AddCategory()\" type=\"button\" class=\"btn btn-danger\">Add Category</button>                                    \n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                        </div>     \n");
      out.write("                        </div>\n");
      out.write("                    </section>\n");
      out.write("                </article>\n");
      out.write("            </main>\n");
      out.write("            <div style=\"clear: both\"></div>\n");
      out.write("            <!-- FOOTER -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("   \n");
      out.write("<script type=\"text/javascript\" src=\"js/JaddBranchCategory.js\"></script> \n");
      out.write("</body>\n");
      out.write("</html>");
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
