package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Operacion_cambios {
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
	
	public DefaultComboBoxModel employ_lista(){
		DefaultComboBoxModel modelo=new DefaultComboBoxModel();
		modelo.addElement("--Clave--");
		try{
			conectar();
			rs=st.executeQuery("Select clave from empleado");
			while(rs.next()){
				modelo.addElement(rs.getInt(1));
			}
			desconectar();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error al llenado de la lista");
		}
		return modelo;			
	}
	
	public String query(String campo, int clave){
		String s="";
		try{
			conectar();
			rs=st.executeQuery("Select "+campo+" from empleado where clave='"+clave+"'");
			while(rs.next()){		
				s=rs.getString(1);
			}
			desconectar();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error al llenado de la lista");
		}
		return s;
	}
	public void upd(int cl, String n, String p, String t){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call upd_emp(?,?,?,?)}");    		
    		cs.setInt(1, cl);    	
    		cs.setString(2, n);
    		cs.setString(3, p);
    		cs.setString(4, t);    		
    		cs.execute();
    		JOptionPane.showMessageDialog(null, "Elemento Modificado");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
	}
}
