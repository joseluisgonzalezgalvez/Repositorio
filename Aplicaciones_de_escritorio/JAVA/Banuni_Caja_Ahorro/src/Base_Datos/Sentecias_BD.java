/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_Datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Sentecias_BD{
    static public Connection conn = null;//para realizar la conexion
    static private Statement st;//para definir una sentencia en Mysql
    static private ResultSet rs;//para almacenar la informacion obtenida de la BD
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
    public void Close (){
    	try{
               conn.close();
           	st.close();
        }
        catch(SQLException ex){}
    }
    
    public String Obtener_Contrasenia(String Nombre){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Contrasenia From Empleados Where Nombre_Empleado ='"+Nombre+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
            }
        } catch (SQLException ex) {}
        return n;
    }
   
        public String Obtener_Id(String Name){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Id_Empleado From Empleados Where Nombre_Empleado ='"+Name+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
            }
        } catch (SQLException ex) {}
        return n;
        }
        
        public String Obtener_Name(String Nombre){
            String n="";
            try {
                //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
                rs = st.executeQuery("Select Nombre_Empleado From Empleados Where Id_Empleado ='"+Nombre+"'");
                //JOptionPane.showMessageDialog(null,rs);
                while (rs.next()){
                    n=rs.getString(1);
                }
            } catch (SQLException ex) {}
            return n;
        }

    


    @SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox Pruebita(String Columna,JComboBox Nombres){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Nombre_Empleado From Empleados Where Puesto ='"+Columna+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
                Nombres.addItem(n);
                //JOptionPane.showMessageDialog(null,n);
            }
        } catch (SQLException ex) {}
        return Nombres;
        
    }


}

