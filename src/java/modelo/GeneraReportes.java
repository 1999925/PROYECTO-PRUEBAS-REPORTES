/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package modelo;

/**
 *
 * @author Usuario
 */
/*public class GeneraReportes {
    
}*/
import net.sf.jasperreports.engine.*;
import java.sql.Connection;
import java.sql.DriverManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*public class GeneraReportes {
    public void generarReporte() {
        try {
            // Conexión a la base de datos
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_empresa", "usr_empresa", "Empresa@123");

            // Cargar el archivo .jasper
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\Usuario\\Desktop\\Practica Java\\web_empresa_bd\\Empleados.jasper");

            // Llenar el reporte con datos
            JasperPrint impresion = JasperFillManager.fillReport(reporte, null, conn);

            // Mostrar el reporte
            JasperViewer.viewReport(impresion, false);

            // Cerrar conexión
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
public class GeneraReportes {
    public String generarReporte() {
        String rutaPdf = "C:\\Users\\Usuario\\Desktop\\Practica Java\\web_empresa_bd\\EmpleadosReporte.pdf";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_empresa", "usr_empresa", "Empresa@123");
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\Usuario\\Desktop\\Practica Java\\web_empresa_bd\\Empleados.jasper");
            JasperPrint impresion = JasperFillManager.fillReport(reporte, null, conn);
            JasperExportManager.exportReportToPdfFile(impresion, rutaPdf);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rutaPdf; // Retornar la ruta del archivo PDF
    }
}