package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menuAdministrador_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         \n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilosAdministrador.css\">\n");
      out.write("         <link href='https://fonts.googleapis.com/css?family=Raleway:400,300' rel='stylesheet' type='text/css'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <ul id=\"myTopnav\">\n");
      out.write("            <li><a href=\"administrador.jsp\">Inicio</a></li>\n");
      out.write("            <li class=\"dropdown\"><a href=\"#\" class=\"dropbtn\">Clases</a>\n");
      out.write("                <div class=\"dropdown-content\">\n");
      out.write("                    <a href=\"AsigProfCurso\">Asignar Profesores</a>\n");
      out.write("                    <a href=\"ModifProfCurso\">Modificar</a>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\"><a href=\"#\" class=\"dropbtn\">Profesores</a>\n");
      out.write("                <div class=\"dropdown-content\">\n");
      out.write("                    <a href=\"registroProfesor.jsp\">Registrar</a>\n");
      out.write("                    <a href=\"ElimProf\">Eliminar</a>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\"><a href=\"#\" class=\"dropbtn\">Alumnos</a>\n");
      out.write("                <div class=\"dropdown-content\">\n");
      out.write("                    <a href=\"registroAlumno.jsp\">Registrar</a>\n");
      out.write("                    <a href=\"ElimAlum\">Eliminar</a>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\"><a href=\"#\" class=\"dropbtn\">Reportes</a>\n");
      out.write("                <div class=\"dropdown-content\">\n");
      out.write("                    <a href=\"reportesAlumnos.jsp\">Alumnos</a>\n");
      out.write("                    <a href=\"reportesMatriculados.jsp\">Alumnos Matriculados</a>\n");
      out.write("                    <a href=\"reportesProfesores.jsp\">Profesores</a>\n");
      out.write("                    <a href=\"reportesCursos.jsp\">Cursos</a>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
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
