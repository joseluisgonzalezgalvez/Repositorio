package Base_Datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
public class Sentencias{
    static public Connection conn = null;
    static private Statement st;
    static private ResultSet rs;
    Connection conexion;
    ResultSet resultado;
    @SuppressWarnings("unused")
	private String id_contact;
    
    public void Open(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Caja_Ahorro", "sa", "base");
            st = conn.createStatement();
          }catch ( Exception  e ) {
              JOptionPane.showMessageDialog(null,"¡Ocurrió un error  al conectarse con el Servidor de BD, Porfavor Contacte a mantenimiento","Configuración de Servidor",JOptionPane.INFORMATION_MESSAGE);
          }
    }
    public void Eliminar_Tabla_Amortizacion(){
        try {
            rs = st.executeQuery("if Object_id('Amortizacion') is not null drop table Amortizacion;");
            while (rs.next()){}
        } catch (SQLException ex) {}
   }
    public void Crear_Tabla_Amortizacion(){
        try {
            rs = st.executeQuery("Create Table Amortizacion(periodo int identity,fecha datetime,interes_mensual money,abono_capital money,pago_realizado money,deuda_actual money,);");
            while (rs.next()){}
        } catch (SQLException ex) {}
   }
    public void Alta_Amortizacion(String fecha,String interes,String abono,String pago_realizado,String deuda) throws SQLException{
        String Consultando = "Insert into Amortizacion VALUES ('"+fecha+"','"+interes+"','"+abono+"','"+pago_realizado+"','"+deuda+"')";
            st.executeUpdate(Consultando);
       }
    
    public void Close (){
    	try{
            conn.close();
           	st.close();
        }
        catch(SQLException ex){}
    }
    
    public void Alta_Prestamos(String id,float tasa,float monto,String fecha,String periodo,String id_cli,int id_emp,String Eliminado, String Edo_pres) throws SQLException{
        String Consultando = "Insert into Prestamos VALUES ('"+id+"',"+tasa+","+monto+",'"+fecha+"','"+periodo+"','"+id_cli+"',"+id_emp+",'"+Eliminado+"','"+Edo_pres+"')";
            st.executeUpdate(Consultando);
       }
    
    public void print_morti( ){
        String reportName = "Tabla_Amortizacion";
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        //Map pars = new HashMap();
        //pars.put("precio",500f);//v1: Parametro ke se debe enkontrar dentro de la konsulta
        //pars.put("cond",n);                      //nubia: Dato
        try{
            Open();
            JasperCompileManager.compileReportToFile(reportName+".jrxml");
            //3-Llenamos el reporte con la información (de la DB) y parámetros necesarios para la consulta
            jasperPrint = JasperFillManager.fillReport(reportName+".jasper", null,conn);
            //Se lanza el Viewer de Jasper, no termina aplicaciÃ³n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Ejemplo de Visualizacion BD y exprtacion PDF");
            jviewer.setVisible(true);
            //4-Exportamos el reporte a pdf y lo guardamos en disco
            //JasperExportManager.exportReportToPdfFile(jasperPrint, "reporte/"+reportName+".pdf");

            //5-Cerrar la conexion
            Close();

            System.out.println("Done!");
        }catch (Exception e){
          System.out.println(e);
          e.printStackTrace();
        }
    }
    /*
    public static void main(String Args[]){
    	Sentencias s = new Sentencias();
    	s.Open();
    	s.Eliminar_Tabla_Amortizacion();
    	s.Crear_Tabla_Amortizacion();
    	try {
			s.Alta_Amortizacion("2002-2-2", "$12.22", "$12.22",  "$12.22", "$12.22");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	s.Close();
    }*/
}

