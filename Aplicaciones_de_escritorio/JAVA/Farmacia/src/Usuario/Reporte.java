/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuario;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;
public class Reporte
{
    Connection conn=null;
    public void Reporte1()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();//para obtener informacion de la clase del driver //se carga el driver
            conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Farmacia_PV", "sa", "root");
            JOptionPane.showMessageDialog(null,"Conexiónestablecida, para reporte");
        }
        catch (Exception ex)
        {
        ex.printStackTrace();
        }
    }
    
    public void ejecutarReporte(int p_id)
    {
        try
        {
            String archivo = "Reporte.jasper";
            System.out.println("Cargando desde: " + archivo);
            if(archivo == null)
            {
                System.out.println("No se encuentra el archivo.");
            }
            System.exit(2);
            JasperReport masterReport= null;
            try
            {
                masterReport= (JasperReport) JRLoader.loadObject(archivo);
            }
            catch(JRException e)
            {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }
            //este es el parámetro, se pueden agregar más parámetros//basta con poner mas parametro.put
            Map parametro= new HashMap();
            parametro.put("Id_Receta",p_id);
            //Reporte diseñado y compilado con iReport
            JasperPrint jasperPrint= JasperFillManager.fillReport(masterReport,parametro,conn);
            //Se lanza el Viewerde Jasper, no termina aplicación al salir
            JasperViewer jviewer= new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Geniz -Reporte");
            jviewer.setVisible(true);
        }
        catch(Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
    }
    public void cerrar()
    {
        try
        {
            conn.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
