package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class e_005flistView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    window.onload = function ()\n");
      out.write("{        alert(\":SS:S\");\n");
      out.write("\n");
      out.write("    ListPage();\n");
      out.write("};\n");
      out.write("var http = new XMLHttpRequest();\n");
      out.write("function ListPage()\n");
      out.write("{\n");
      out.write("    http.onreadystatechange = PT;\n");
      out.write("\n");
      out.write("    function PT()\n");
      out.write("    {\n");
      out.write("        var data = http.responseText;\n");
      out.write("        var obj = JSON.parse(data);\n");
      out.write("        if (http.readyState == 4 && http.status == 200)\n");
      out.write("        {\n");
      out.write("            if (obj.length > 1)\n");
      out.write("                document.getElementById(\"Delte_B\").setAttribute(\"style\", \"visibility: visible\");\n");
      out.write("            document.getElementById(\"name\").innerHTML = obj[0].E_FNAME + \" \" + obj[0].E_LNAME;\n");
      out.write("            var parent = document.getElementById(\"list\");\n");
      out.write("            while (parent.hasChildNodes())\n");
      out.write("            {\n");
      out.write("                parent.removeChild(parent.lastChild);\n");
      out.write("            }\n");
      out.write("            for (var i = 1; i < obj.length; i++)\n");
      out.write("            {\n");
      out.write("                var L = document.createElement(\"li\");\n");
      out.write("                var S = document.createElement(\"span\");\n");
      out.write("                //var B = document.createElement(\"button\");\n");
      out.write("                //B.setAttribute(\"class\",\"btn btn-success\");\n");
      out.write("                //B.setAttribute(\"type\",\"submit\");                \n");
      out.write("                //B.innerHTML=\"Success\";\n");
      out.write("                S.setAttribute(\"class\", \"badge\");\n");
      out.write("                //S.appendChild(B);\n");
      out.write("                L.setAttribute(\"class\", \"list-group-item\");\n");
      out.write("                L.innerHTML = obj[i].FNAME + \" \" + obj[i].LNAME+\" \"+1;\n");
      out.write("                L.appendChild(S);\n");
      out.write("                parent.appendChild(L);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    http.open(\"GET\", \"e_listLoader\", true);\n");
      out.write("    http.send(null);\n");
      out.write("}\n");
      out.write("    </script>\n");
      out.write("            <!-- MAIN -->\n");
      out.write("            <main role=\"main\">\n");
      out.write("                <!-- Content -->\n");
      out.write("                <article>\n");
      out.write("                    <header class=\"section background-white\">\n");
      out.write("                        <div style=\" margin: 0 auto; width: 250px;text-align: center\"> \n");
      out.write("                           <h3>Vodafone Waiting List</h3> \n");
      out.write("                           <h3 id=\"name\" ></h3> \n");
      out.write("                        </div>\n");
      out.write("                        <form>\n");
      out.write("                        <ul id=\"list\" class=\"list-group\">\n");
      out.write("                <!--            <li class=\"list-group-item\">Emad Sayed<span class=\"badge\"><button type=\"submit\" class=\"btn btn-success\">Success</button></span></li>         -->\n");
      out.write("                        </ul>\n");
      out.write("                            <div style=\"visibility: hidden\" id=\"Delte_B\" class=\"em_center\">  <button onclick=\"DeleteFromList()\" class=\" btn-danger s-12  button text-white\" type=\"submit\">Delete The Top</button></div>\n");
      out.write("                        </form>\n");
      out.write("                    </header>\n");
      out.write("\n");
      out.write("                </article>\n");
      out.write("            </main>\n");
      out.write("\n");
      out.write("            <!-- FOOTER -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("   \n");
      out.write("<script type=\"text/javascript\" src=\"js/Je   mployeeList.js\"></script> \n");
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
