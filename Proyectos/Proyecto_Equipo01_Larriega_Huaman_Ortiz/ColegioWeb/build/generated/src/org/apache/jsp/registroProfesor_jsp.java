package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registroProfesor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/SignIn.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menuPrincipal.jsp", out, false);
      out.write("</div>\n");
      out.write("        ");

            if (request.getAttribute("info") != null) {
                out.print("<p>" + request.getAttribute("info").toString() + "</p>");
            }
        
      out.write("\n");
      out.write("        <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("        </c:if>\n");
      out.write("    \n");
      out.write("        <h1 class=\"titulo-registro\">Registro Profesor</h1>\n");
      out.write("        <hr class=\"border\">\n");
      out.write("    \n");
      out.write("<div class=\"contenedor-formulario\">\n");
      out.write("  <div class=\"wrap\">\n");
      out.write("    <form action=\"ProfesorRegistro\" class=\"formulario\" name=\"formulario_registro\" method=\"post\">\n");
      out.write("      <div>\n");
      out.write("        <div class=\"input-group\">\n");
      out.write("          <input type=\"text\" name=\"usuario\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("          <label class=\"label\">Usuario:</label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-group\">\n");
      out.write("          <input type=\"text\" name=\"nombres\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.nombres}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("          <label class=\"label\">Nombres:</label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-group\">\n");
      out.write("          <input type=\"text\" name=\"dni\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.dni}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("          <label class=\"label\">DNI:</label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-group\">\n");
      out.write("          <input type=\"text\" name=\"estudios\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.estudios}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("          <label class=\"label\">Estudios:</label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-group\">\n");
      out.write("          <input type=\"password\" name=\"password\">\n");
      out.write("          <label class=\"label\">Password:</label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-group\">\n");
      out.write("          <input type=\"password\" name=\"confirm-password\">\n");
      out.write("          <label class=\"label\">Repetir Password:</label>\n");
      out.write("        </div>\n");
      out.write("        <input type=\"submit\" id=\"btn-submit\" value=\"Registrar\">\n");
      out.write("      </div>\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("    <script src=\"css/efectos.js\"></script>\n");
      out.write("</body>\n");
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
