package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menuPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>COLEGIO</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilosMenu.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <ul class=\"topnav\" id=\"myTopnav\">\n");
      out.write("            <li><a href=\"index.jsp\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i> Login</a></li>\n");
      out.write("            <li><a href=\"loginAlumno.jsp\"><i class=\"fa fa-graduation-cap\" aria-hidden=\"true\"></i> Alumnos</a></li>\n");
      out.write("            <li><a href=\"loginProfesor.jsp\"><i class=\"fa fa-users\" aria-hidden=\"true\"></i> Profesores</a></li>\n");
      out.write("            <li><a href=\"loginAdministrador.jsp\"><i class=\"fa fa-user\" aria-hidden=\"true\"></i> Administrador</a></li>\n");
      out.write("            <li class=\"icon\">\n");
      out.write("            <a href=\"javascript:void(0);\" onclick=\"myFunction()\">&#9776;</a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("        <script>\n");
      out.write("            function myFunction() {\n");
      out.write("                 var x = document.getElementById(\"myTopnav\");\n");
      out.write("                 if (x.className === \"topnav\") {\n");
      out.write("                    x.className += \" responsive\";\n");
      out.write("                } else {\n");
      out.write("                      x.className = \"topnav\";\n");
      out.write("                }\n");
      out.write("            }\n");
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
