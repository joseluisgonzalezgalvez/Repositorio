package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Operacion_pestañas {
	static public Connection c=null;
	static private ResultSet rs;
	static private Statement st;
	static private Archivos ar=new Archivos();
	
	public void conectar(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			c=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ingenieria","sa","base");
			st=c.createStatement();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error al conectar");
		}
	}
	
	public void desconectar(){
		try{
			st.close();
			c.close();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Error al desconectar");
		}
	}
	
	public DefaultListModel op_lista(){
		DefaultListModel modelo=new DefaultListModel();
		try{
			conectar();
			rs=st.executeQuery("Select clave,nombre from empleado");
			while(rs.next()){
				modelo.addElement(rs.getInt(1)+": "+rs.getString(2));
			}
			desconectar();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error al llenado de la lista");
		}
		return modelo;			
	}
	
	public DefaultTableModel llenar(int clave){
		DefaultTableModel modelo=new DefaultTableModel();
		return modelo;
	}
}
