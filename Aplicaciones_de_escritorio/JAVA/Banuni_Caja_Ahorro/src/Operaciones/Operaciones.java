package Operaciones;

import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Operaciones {
	static public Connection c=null;
	static private ResultSet rs;
	static private Statement st;
	
	public void conectar(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			c=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Caja_Ahorro","sa","base");
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
	
	public void pasa_parametrosBD( ){
        String reportName = "Clientes";
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        //Map pars = new HashMap();
        //pars.put("precio",500f);//v1: Parametro ke se debe enkontrar dentro de la konsulta
        //pars.put("cond",n);                      //nubia: Dato
        try{
            conectar();
            JasperCompileManager.compileReportToFile(reportName+".jrxml");
            //3-Llenamos el reporte con la información (de la DB) y parámetros necesarios para la consulta
            jasperPrint = JasperFillManager.fillReport(reportName+".jasper", null,c);
            //Se lanza el Viewer de Jasper, no termina aplicaciÃ³n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Ejemplo de Visualizacion BD y exprtacion PDF");
            jviewer.setVisible(true);
            //4-Exportamos el reporte a pdf y lo guardamos en disco
            //JasperExportManager.exportReportToPdfFile(jasperPrint, "reporte/"+reportName+".pdf");

            //5-Cerrar la conexion
            desconectar();

            System.out.println("Done!");
        }catch (Exception e){
          System.out.println(e);
          e.printStackTrace();
        }
    }
	
	public ResultSet fill_table(String Clave){
		try{
			//conectar();
			st=c.createStatement();
			rs=st.executeQuery("select p.Id_prestamo,p.Tasa_interes,p.Monto_prestado,p.fecha_prestamo,p.periodo_pago,p.Edo_prest from Prestamo as p JOIN Cliente as c ON p.Id_cliente=c.Id_cliente where p.Id_cliente='"+Clave+"'");
			//desconectar();
		}catch(SQLException e){
			
		}
		return rs;
	}
	
	public ResultSet fill_pagos(String Clave,String dat){
		try{
			//conectar();
			st=c.createStatement();
			rs=st.executeQuery("Select pa.* from Prestamo as pr JOIN Pagos as pa ON pr.Id_prestamo=pa.id_prestamo where pa.id_prestamo='"+Clave+"' and pr.fecha_prestamo='"+dat+"'; ");
			//desconectar();
		}catch(SQLException e){
			
		}
		return rs;
	}
	
	
	public void a_vehiculo(String id,String tipo,String marca,String mod,String color,int puertas,float valuacion,String placa,String clie){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call a_vehiculo(?,?,?,?,?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, tipo);
    		cs.setString(3, marca);
    		cs.setString(4, mod);
    		cs.setString(5, color);
    		cs.setInt(6, puertas);
    		cs.setFloat(7, valuacion);
    		cs.setString(8, placa);
    		cs.setString(9, clie);
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"Vehiculo Guardado");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void a_propiedad(String id,String tipo,String dir,String sup,float val,String clie){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call a_propiedad(?,?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, tipo);
    		cs.setString(3, dir);
    		cs.setString(4, sup);
    		cs.setFloat(5, val);
    		cs.setString(6, clie);
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"Propiedad Guardada");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void a_laboral(String id,String emp,String prof,String empleado,String tel,String dir,float sueldo,int ant,Date f,String clie){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call a_laboral(?,?,?,?,?,?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, emp);
    		cs.setString(3, prof);
    		cs.setString(4, empleado);
    		cs.setString(5, tel);
    		cs.setString(6, dir);
    		cs.setFloat(7, sueldo);
    		cs.setInt(8, ant);
    		cs.setDate(9, f);
    		cs.setString(10, clie);
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"Datos Laborales Guardados");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void a_aval(String id,String nom,String ape,String dir,String tel,String emp,String puesto,float sueldo,String clie){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call a_aval(?,?,?,?,?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, nom);
    		cs.setString(3, ape);
    		cs.setString(4, dir);
    		cs.setString(5, tel);
    		cs.setString(6, emp);
    		cs.setString(7, puesto);
    		cs.setFloat(8, sueldo);
    		cs.setString(9, clie);
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"AVAL\n\n"+nom+" "+ ape+"\nGuardado");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void a_cliente(String id,String nom,String ape,String edo,String cd,String dir,float credito,String edo_cred,String tel,String eliminado){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call a_cliente(?,?,?,?,?,?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, nom);
    		cs.setString(3, ape);
    		cs.setString(4, edo);
    		cs.setString(5, cd);
    		cs.setString(6, dir);
    		cs.setFloat(7, credito);
    		cs.setString(8, edo_cred);
    		cs.setString(9, tel);
    		cs.setString(10, eliminado);
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"CLIENTE\n\n"+nom+" "+ ape+"\nGuardado");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void c_cliente(String id,String nom,String ape,String edo,String cd,String dir,float credito,String edo_cred,String tel,String eliminado){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call c_cliente(?,?,?,?,?,?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, nom);
    		cs.setString(3, ape);
    		cs.setString(4, edo);
    		cs.setString(5, cd);
    		cs.setString(6, dir);
    		cs.setFloat(7, credito);
    		cs.setString(8, edo_cred);
    		cs.setString(9, tel);
    		cs.setString(10, eliminado);
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"CLIENTE\n\n"+nom+" "+ ape+"\nGuardado");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void c_vehiculo(String id,String tipo,String marca,String mod,String color,int puertas,float valuacion,String placa,String clie){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call c_vehiculo(?,?,?,?,?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, tipo);
    		cs.setString(3, marca);
    		cs.setString(4, mod);
    		cs.setString(5, color);
    		cs.setInt(6, puertas);
    		cs.setFloat(7, valuacion);
    		cs.setString(8, placa);
    		cs.setString(9, clie);
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"Vehiculo Guardado");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void c_propiedad(String id,String tipo,String dir,String sup,float val){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call c_propiedad(?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, tipo);
    		cs.setString(3, dir);
    		cs.setString(4, sup);
    		cs.setFloat(5, val);    		
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"Propiedad Guardada");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void c_aval(String id,String nom,String ape,String dir,String tel,String emp,String puesto,float sueldo,String clie){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call c_aval(?,?,?,?,?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, nom);
    		cs.setString(3, ape);
    		cs.setString(4, dir);
    		cs.setString(5, tel);
    		cs.setString(6, emp);
    		cs.setString(7, puesto);
    		cs.setFloat(8, sueldo);
    		cs.setString(9, clie);
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"AVAL\n\n"+nom+" "+ ape+"\nGuardado");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void c_laboral(String id,String emp,String prof,String empleado,String tel,String dir,float sueldo,int ant,Date f,String clie){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call c_laboral(?,?,?,?,?,?,?,?,?,?)}");    		
    		cs.setString(1, id);    	
    		cs.setString(2, emp);
    		cs.setString(3, prof);
    		cs.setString(4, empleado);
    		cs.setString(5, tel);
    		cs.setString(6, dir);
    		cs.setFloat(7, sueldo);
    		cs.setInt(8, ant);
    		cs.setDate(9, f);
    		cs.setString(10, clie);
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"Datos Laborales Guardados");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	
	public void b_cliente(String clave){
		try{
    		conectar();    		
    		CallableStatement cs=c.prepareCall("{call b_cliente(?)}");    		
    		cs.setString(1, clave);    	    		
    		cs.execute();
    		JOptionPane.showMessageDialog(null,"CLIENTE\nEliminado");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
	}
	
	public DefaultTableModel mod_tabla_gral(){
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("Clave");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		try{
			rs=st.executeQuery("Select * from cliente");
			while(rs.next()){
				Object []fila={rs.getString(1),rs.getString(2),rs.getString(3)};
				modelo.addRow(fila);
			}
		}catch(SQLException e){
			
		}
		return modelo;
	}
	
	public DefaultTableModel modelos(String campo, String cond){
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("Clave");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		try{
			rs=st.executeQuery("Select * from cliente where "+campo+"='"+cond+"'");
			while(rs.next()){
				Object []fila={rs.getString(1),rs.getString(2),rs.getString(3)};
				modelo.addRow(fila);
			}
		}catch(SQLException e){
			
		}
		return modelo;
	}
	
	public String consulta(String campo,String tabla,String clave,String key){
		String s="";
		
		try{
			rs=st.executeQuery("Select "+campo+" from "+tabla+" where "+clave+"='"+key+"'");
			while(rs.next()){
				s=rs.getString(1);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error en la consulta");
		}
		return s;
	}
	
	public DefaultTableModel ver_prest(){
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("Crédito");
        modelo.addColumn("Fecha");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Interes");
        modelo.addColumn("Estado");
        modelo.addColumn("Plazos");
		try{
			rs=st.executeQuery("Select c.Lim_Credito,p.fecha_prestamo,c.Nombre,c.Apellido,p.Monto_prestado,p.Tasa_interes,c.Edo_crediticio,p.periodo_pago from Cliente as c JOIN Prestamo as p ON c.Id_cliente=p.Id_cliente");
			while(rs.next()){
				Object []fila={rs.getFloat(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getFloat(6),rs.getString(7),rs.getString(8)};
				modelo.addRow(fila);
			}
		}catch(SQLException e){
			
		}
		return modelo;
	}
	
    public void Alta_Prestamos(String id,double tasa,double monto,String fecha,String periodo,String id_cli,int id_emp,String Eliminado, String Edo_pres) throws SQLException{
        String Consultando = "Insert into Prestamo VALUES ('"+id+"',"+tasa+","+monto+",'"+fecha+"','"+periodo+"','"+id_cli+"',"+id_emp+",'"+Eliminado+"','"+Edo_pres+"')";
            st.executeUpdate(Consultando);
       }
    public void Alta_Tabla_Amortizacion(String id_pre,String fechpa,String fecha,String interes,String abono,String pago_realizado,String deuda,String estado) throws SQLException{
        String Consultando = "Insert into Pagos VALUES ('"+id_pre+"','"+fechpa+"','"+fecha+"','"+interes+"','"+abono+"','"+pago_realizado+"','"+deuda+"','"+estado+"')";
            st.executeUpdate(Consultando);
       }
    
    public void mod_edo(String clave, String f){
		try{
    		conectar();    		
    		String csa="update Pagos set estado='Pagado' where id_prestamo='"+clave+"' AND fecha='"+f+"'";
            st.executeUpdate(csa);
            JOptionPane.showMessageDialog(null, "Pagado");
    		desconectar();
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
	/*
    public static void main(String Args[]){
    	Operaciones c = new Operaciones();
    	c.conectar();
    	c.fill_table("C01");
    	c.desconectar();
    	
    }*/
    
}
