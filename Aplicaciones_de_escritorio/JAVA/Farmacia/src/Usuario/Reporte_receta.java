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
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;
public class Reporte_receta
{
    Connection conn=null;
    public void Reporte_receta()
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
    
    
   /* 
    
    public void pasa_parametrosBD()
    {
        //String reportName = "Reporte_Receta";
        JasperReport jasperReport;
        JasperPrint jasperPrint;
/*        Map pars = new HashMap();

        //pase de parametros
        pars.put("FILA00","R4411");
        pars.put("FILA01","Y452");
        pars.put("FILA02",null);
        pars.put("FILA03","1235");
        pars.put("FILA70","IU6325");
  */     
  /*      try
        {
            
            //2-Compilamos el archivo XML y lo cargamos en memoria
            /*jasperReport = */
        //JasperReport reporte = (JasperReport) JRLoader.loadObject("reporte2.jasper");
/*            JOptionPane.showMessageDialog(null,"1");
            JasperCompileManager.compileReportToFile("Reporte_Receta.jrxml");
            JOptionPane.showMessageDialog(null,"2");
            //3-Llenamos el reporte con la informaciÃ³n (de la DB) y parÃ¡metros necesarios para la consulta
            
            jasperPrint = JasperFillManager.fillReport("Reporte_Receta.jasper",null, conn);

            //Se lanza el Viewer de Jasper, no termina aplicacion al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("LISTA DE LIBROS EN LA BIBLIOTECA");
            jviewer.setVisible(true);
            //jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage("ReelDVD.png"));
            jviewer.setSize(1100,700);
            jviewer.setResizable(false);
            //4-Exportamos el reporte a pdf y lo guardamos en disco

            JasperExportManager.exportReportToPdfFile(jasperPrint, "Reporte_Receta.pdf");


            //5-Cerrar la conexion
            conn.close();

            //System.out.println("Done!");
        }catch (Exception e){
          System.out.println(e);
          e.printStackTrace();
        }
    }
    
    
  /*  
public void m() throws JRException{
 
        JasperReport reporte = (JasperReport) JRLoader.loadObject("Reporte_Receta.jasper");

        JasperPrint jasperPrint= JasperFillManager.fillReport(reporte,/*parametro*//*null,conn);

        JRExporter exporter = new JRPdfExporter(); 
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte2PDF_2.pdf")); 
        exporter.exportReport();
}
 
*/
/*
    public void ejecutarReporte(){
        try{
            String archivo = "Reporte_Recet.jasper";
            System.out.println("Cargando desde: " + archivo);
            if(archivo == null){
                JOptionPane.showMessageDialog(null,"No se encuentra el archivo");
            }
            //System.exit(2);
            JasperReport masterReport= null;
            try{
                masterReport= (JasperReport) JRLoader.loadObject(archivo);
            }
            catch(JRException e){
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }
            //este es el parámetro, se pueden agregar más parámetros//basta con poner mas parametro.put
            //Map parametro= new HashMap();
            //parametro.put("Id_Receta",p_id);
            //Reporte diseñado y compilado con iReport
 /*           JasperPrint jasperPrint= JasperFillManager.fillReport(masterReport,/*parametro*///null,conn);
 /*           //Se lanza el Viewerde Jasper, no termina aplicación al salir
            JasperViewer jviewer= new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Geniz -Reporte");
            jviewer.setVisible(true);
            
            

        JRExporter exporter = new JRPdfExporter();  
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte_RecetaPDF.pdf")); 
        exporter.exportReport(); 
            
            
        }
        catch(Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
    }
 
    */
        
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
    /*
    public void Algo() throws JRException{
    
    //  ParticipantesDatasource datasource = new ParticipantesDatasource();  

      //  for (int i = 1; i <= 10; i++) 
     //   { 
//            Participante p = new Participante(i, "Particpante " + i, "Usuario " + i, "Pass " + i, "Comentarios para " + i); 
//            datasource.addParticipante(p); 
//        }  

        JasperReport reporte = (JasperReport) JRLoader.loadObject("Reporte_Tabla.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conn);  

        JRExporter exporter = new JRPdfExporter();  
        exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint); 
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte_Receta.pdf")); 
        exporter.exportReport(); 
        
        
    }
    */
    
    public static void main (String Args[]) throws JRException{
        Usuario.Reporte_receta rr = new Usuario.Reporte_receta();
        rr.Reporte_receta();
        //rr.Algo();
        //rr.pasa_parametrosBD();
        
        
        
        
        
        
        rr.cerrar();   
    }
}

