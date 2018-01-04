package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Reservation</title>\n");
      out.write("\n");
      out.write("        <!-- CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://fonts.googleapis.com/css?family=Roboto:400,100,300,500\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/form-elements.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style2.css\">\n");
      out.write("       <script type=\"text/javascript\" src=\"js/Jlogin.js\"></script>       \n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("        <!-- Favicon and touch icons -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"assets/ico/favicon.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"assets/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"assets/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"assets/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" href=\"assets/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("      ");

           //to make sure the user never back to login page again
           try
           {
           int Flag=(Integer)session.getAttribute("flag");
           response.sendRedirect("home.jsp");
           }
           catch(Exception E)
           {
               
           }
           
           
      out.write("\n");
      out.write("        <!-- Top content -->\n");
      out.write("        <div class=\"top-content\">\n");
      out.write("        \t\n");
      out.write("            <div class=\"inner-bg\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                \t\n");
      out.write("\n");
      out.write("                    \n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-5\">\n");
      out.write("                        \t\n");
      out.write("                        \t<div class=\"form-box\">\n");
      out.write("\t                        \t<div class=\"form-top\">\n");
      out.write("\t                        \t\t<div class=\"form-top-left\">\n");
      out.write("\t                        \t\t\t<h3>Login</h3>\n");
      out.write("\t                            \t\t<p>Enter username and password to log on:</p>\n");
      out.write("\t                        \t\t</div>\n");
      out.write("\t                        \t\t<div class=\"form-top-right\">\n");
      out.write("\t                        \t\t\t<i class=\"fa fa-key\"></i>\n");
      out.write("\t                        \t\t</div>\n");
      out.write("\t                            </div>\n");
      out.write("\t                            <div class=\"form-bottom\">\n");
      out.write("\t\t\t\t                    <form role=\"form\" action=\"\" method=\"post\" class=\"login-form\">\n");
      out.write("\t\t\t\t                    \t<div class=\"form-group\">\n");
      out.write("\t\t\t\t                    \t\t<label class=\"sr-only\" for=\"form-username\">Username</label>\n");
      out.write("                                                                <input id=\"mail\" type=\"text\" name=\"form-username\" placeholder=\"Username...\" class=\"form-username form-control\" id=\"form-username\">\n");
      out.write("\t\t\t\t                        </div>\n");
      out.write("\t\t\t\t                        <div class=\"form-group\">\n");
      out.write("\t\t\t\t                        \t<label class=\"sr-only\" for=\"form-password\">Password</label>\n");
      out.write("                                                                <input id=\"pass\" type=\"password\" name=\"form-password\" placeholder=\"Password...\" class=\"form-password form-control\" id=\"form-password\">\n");
      out.write("\t\t\t\t                        </div>\n");
      out.write("                                                        <h3 id=\"error\" style=\"color: red\"></h3>\n");
      out.write("\n");
      out.write("                                                        <button onclick=\"LoginChecker()\" type=\"button\" class=\"btn\">Sign in!</button>\n");
      out.write("\t\t\t\t                    </form>\n");
      out.write("\t\t\t                    </div>\n");
      out.write("\t\t                    </div>\n");
      out.write("\t\t  \n");
      out.write("\t                        \n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"col-sm-1 middle-border\"></div>\n");
      out.write("                        <div class=\"col-sm-1\"></div>\n");
      out.write("                        \t\n");
      out.write("                        <div class=\"col-sm-5\">\n");
      out.write("                        \t\n");
      out.write("                        \t<div class=\"form-box\">\n");
      out.write("                        \t\t<div class=\"form-top\">\n");
      out.write("\t                        \t\t<div class=\"form-top-left\">\n");
      out.write("\t                        \t\t\t<h3>Sign up now</h3>\n");
      out.write("\t                            \t\t<p>Fill in the form below to get instant access:</p>\n");
      out.write("\t                        \t\t</div>\n");
      out.write("\t                        \t\t<div class=\"form-top-right\">\n");
      out.write("\t                        \t\t\t<i class=\"fa fa-pencil\"></i>\n");
      out.write("\t                        \t\t</div>\n");
      out.write("\t                            </div>\n");
      out.write("\t                            <div class=\"form-bottom\">\n");
      out.write("\t\t\t\t                    <form role=\"form\" action=\"\" method=\"post\" class=\"registration-form\">\n");
      out.write("\t\t\t\t                    \t<div class=\"form-group\">\n");
      out.write("\t\t\t\t                    \t\t<label class=\"sr-only\" for=\"form-first-name\">First name</label>\n");
      out.write("\t\t\t\t                        \t<input type=\"text\" name=\"form-first-name\" placeholder=\"First name...\" class=\"form-first-name form-control\" id=\"form-first-name\">\n");
      out.write("\t\t\t\t                        </div>\n");
      out.write("\t\t\t\t                        <div class=\"form-group\">\n");
      out.write("\t\t\t\t                        \t<label class=\"sr-only\" for=\"form-last-name\">Last name</label>\n");
      out.write("\t\t\t\t                        \t<input type=\"text\" name=\"form-last-name\" placeholder=\"Last name...\" class=\"form-last-name form-control\" id=\"form-last-name\">\n");
      out.write("\t\t\t\t                        </div>\n");
      out.write("\t\t\t\t                        <div class=\"form-group\">\n");
      out.write("\t\t\t\t                        \t<label class=\"sr-only\" for=\"form-email\">Email</label>\n");
      out.write("\t\t\t\t                        \t<input type=\"text\" name=\"form-email\" placeholder=\"Email...\" class=\"form-email form-control\" id=\"form-email\">\n");
      out.write("\t\t\t\t                        </div>\n");
      out.write("\t\t\t\t                        <button type=\"submit\" class=\"btn\">Sign me up!</button>\n");
      out.write("\t\t\t\t                    </form>\n");
      out.write("\t\t\t                    </div>\n");
      out.write("                        \t</div>\n");
      out.write("                        \t\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Javascript -->\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <!--[if lt IE 10]>\n");
      out.write("            <script src=\"assets/js/placeholder.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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
