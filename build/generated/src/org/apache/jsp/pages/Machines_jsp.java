package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entities.Machine;
import service.MachineService;
import entities.Salle;
import service.SalleService;

public final class Machines_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Machines Page</title>\n");
      out.write("        <link href=\"../styles/styles.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../components/navbar.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"flex-box app\">\n");
      out.write("\n");
      out.write("            <form action=\"../MachineController\" method=\"GET\">\n");
      out.write("\n");
      out.write("                <fieldset class=\"flex-box\" style=\"flex-direction: column;\">\n");
      out.write("\n");
      out.write("                    <legend>Informations Machines</legend>  \n");
      out.write("                    <div class=\"flex-box\">\n");
      out.write("                        <label for=\"ref\">Reference :</label>\n");
      out.write("                        <input type=\"text\" name=\"ref\" value=\"\" />\n");
      out.write("\n");
      out.write("                        <label for=\"marque\">Marque :</label>\n");
      out.write("                        <input type=\"text\" name=\"marque\" value=\"\" />\n");
      out.write("\n");
      out.write("                        <label for=\"prix\">Prix :</label>\n");
      out.write("                        <input type=\"text\" name=\"prix\" value=\"\" />\n");
      out.write("\n");
      out.write("                        <label for=\"salleId\">Salle :</label>\n");
      out.write("                        <!--<input type=\"text\" name=\"salleId\" value=\"\" />-->\n");
      out.write("\n");
      out.write("                        <select name=\"salleId\" >\n");
      out.write("                            ");

                                SalleService ss = new SalleService();
                                for (Salle s : ss.findAll()) {
                            
      out.write("\n");
      out.write("                            <option  value=\"");
      out.print( s.getId());
      out.write('"');
      out.write('>');
      out.print( s.getId());
      out.write("</option>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"flex-box\" >\n");
      out.write("                        <input type=\"submit\" value=\"Ajouter\" />\n");
      out.write("                        <input type=\"reset\" value=\"Annuler\" />\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </fieldset>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            <fieldset class=\"flex-box\" >\n");
      out.write("                <legend>Liste Machines</legend>\n");
      out.write("                <table border=\"1\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>ID</th>\n");
      out.write("                            <th>Reference</th>\n");
      out.write("                            <th>Marque</th>\n");
      out.write("                            <th>Prix</th>\n");
      out.write("                            <th>Salle</th>\n");
      out.write("                            <th>Modifier</th>\n");
      out.write("                            <th>Supprimer</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            MachineService ms = new MachineService();
                            for (Machine m : ms.findAll()) {

                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print( m.getId());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( m.getRef());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( m.getMarque());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( m.getPrix());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( m.getSalle().getCode());
      out.write("</td>\n");
      out.write("\n");
      out.write("                            <td><a href=\"MachineController?op=update&id=");
      out.print( m.getId());
      out.write("&ref=");
      out.print( request.getParameter("ref"));
      out.write("&marque=");
      out.print( request.getParameter("marque"));
      out.write("&prix=");
      out.print( request.getParameter("prix"));
      out.write("&salle=");
      out.print( request.getParameter("salleId"));
      out.write("\">Modifier</a></td>\n");
      out.write("                            <td><a href=\"MachineController?op=delete&id=");
      out.print(m.getId());
      out.write("\">Delete</a></td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </fieldset>\n");
      out.write("        </div>\n");
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
