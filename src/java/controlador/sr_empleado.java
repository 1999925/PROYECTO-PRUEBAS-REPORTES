package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.GeneraReportes; // Importar la clase GeneraReportes

/**
 *
 * @author Usuario
 */
public class sr_empleado extends HttpServlet {

    Empleado empleado;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_empleado</title>");
            out.println("</head>");
            out.println("<body>");

            empleado = new Empleado(request.getParameter("txt_codigo"),
                    Integer.valueOf(request.getParameter("drop_puesto")),
                    Integer.valueOf(request.getParameter("txt_id")),
                    request.getParameter("txt_nombres"),
                    request.getParameter("txt_apellidos"),
                    request.getParameter("txt_direccion"),
                    request.getParameter("txt_telefono"),
                    request.getParameter("txt_fn"));

            // Botón agregar
            if ("agregar".equals(request.getParameter("btn_agregar"))) {
                if (empleado.agregar() > 0) {
                    // Generar el reporte después de agregar exitosamente
                    GeneraReportes generaReportes = new GeneraReportes(); // Línea agregada
                    generaReportes.generarReporte(); // Línea agregada

                    // Redireccionar después de generar el reporte
                    response.sendRedirect("index.jsp");
                } else {
                    out.println("<h1>Error...................</h1>");
                    out.println("<a href ='index.jsp'>Regresar</a>");
                }
            }

            // Botón modificar
            if ("modificar".equals(request.getParameter("btn_modificar"))) {
                if (empleado.modificar() > 0) {
                    response.sendRedirect("index.jsp");
                } else {
                    out.println("<h1>Error al modificar</h1>");
                    out.println("<a href ='index.jsp'>Regresar</a>");
                }
            }

            // Botón Eliminar
            if ("eliminar".equals(request.getParameter("btn_eliminar"))) {
                if (empleado.eliminar() > 0) {
                    response.sendRedirect("index.jsp");
                } else {
                    out.println("<h1>No se pudo eliminar</h1>");
                    out.println("<a href ='index.jsp'>Regresar</a>");
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
