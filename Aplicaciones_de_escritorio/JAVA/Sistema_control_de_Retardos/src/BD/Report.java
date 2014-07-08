package BD;
import java.awt.Color;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Report {
    private Connection conn;
    private final String login = "sa"; //usuario de acceso a MySQL
    private final String password = "root"; //contraseña de usuario
    private String url = "jdbc:mysql://localhost/prueba";
    private String id_contact;

    public void conectar(){
         try
        {
            Class.forName("com.mysql.jdbc.Driver"); //se carga el driver
            conn = DriverManager.getConnection(url,login,password);
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

    }
    
    public void conexion(){
		try{                     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();                       
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ingenieria","sa","base");
			//st=c.createStatement();
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null,"Error al conectar");
                        e.printStackTrace();
		}
	}

    public void pasa_parametrosBD(int n){
        String reportName = "Sistema_Idetificador_Retardos";
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        Map pars = new HashMap();
        //pars.put("precio",500f);//v1: Parametro ke se debe enkontrar dentro de la konsulta
        pars.put("cond",n);                      //nubia: Dato
        try{
            conexion();
            JasperCompileManager.compileReportToFile(reportName+".jrxml");
            //3-Llenamos el reporte con la información (de la DB) y parámetros necesarios para la consulta
            jasperPrint = JasperFillManager.fillReport(reportName+".jasper",pars, conn);
            //Se lanza el Viewer de Jasper, no termina aplicaciÃ³n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Ejemplo de Visualizacion BD y exprtacion PDF");
            jviewer.setBackground(Color.red);
            jviewer.setVisible(true);
            //4-Exportamos el reporte a pdf y lo guardamos en disco
            //JasperExportManager.exportReportToPdfFile(jasperPrint, "reporte/"+reportName+".pdf");

            //5-Cerrar la conexion
            conn.close();

            System.out.println("Done!");
        }catch (Exception e){
          System.out.println(e);
          e.printStackTrace();
        }
    }
/*
    public static void main(String arg[]){
        Report r2=new Report();
        r2.pasa_parametrosBD();
    }*/
}