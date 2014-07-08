package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Operacion_altas {
	static public Connection c=null;
	static private ResultSet rs;
	static private Statement st;

	
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
	
	public void alta(int clave, String nom, String puesto,String tipo){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call alta(?,?,?,?)}");    		
    		cs.setInt(1, clave);    	
    		cs.setString(2, nom);
    		cs.setString(3, puesto);
    		cs.setString(4, tipo);    		
    		cs.execute();
    		JOptionPane.showMessageDialog(null,tipo+" "+nom+"\nGuardado!");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
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
}
