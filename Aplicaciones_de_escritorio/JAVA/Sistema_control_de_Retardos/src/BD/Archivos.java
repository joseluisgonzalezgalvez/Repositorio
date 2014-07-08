package BD;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Historial;

public class Archivos {
	static public Connection c=null;
	static private ResultSet rs;
	static private Statement st;

	ArrayList<Historial> hist=new ArrayList<Historial>(); 
	ArrayList<Historial> array_aux=new ArrayList<Historial>();
	Historial aux;
	
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
	
	public void fill_data(){
		File file=new File("Historial.bin");
		FileOutputStream fout = null;
		ObjectInputStream anterior = null;
		ObjectOutputStream objeto = null;
		if(file.exists()){
			
			try {
				anterior = new ObjectInputStream(new FileInputStream(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				hist=(ArrayList<Historial>)anterior.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		boolean flag=true;
		
		try {
			fout = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			objeto = new ObjectOutputStream(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			hist.add(aux);		
			JOptionPane.showMessageDialog(null, "Guardado!");
		}
		try {
			objeto.writeObject(hist);
			objeto.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public void altas(int clave, Date fecha,String e1,String e2,String e3,String s1,String s2,String s3) throws IOException{
		File file=new File("Historial.bin");
		if(file.exists()){
			ObjectInputStream anterior=new ObjectInputStream(new FileInputStream(file));
			try {
				hist=(ArrayList<Historial>)anterior.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		boolean flag=true;
		FileOutputStream fout=new FileOutputStream(file);
		ObjectOutputStream objeto=new ObjectOutputStream(fout);
		aux=new Historial(clave,fecha,e1,e2,e3,s1,s2,s3);
		for(Historial h: hist){
			if(h.claveh.equals(fecha+"-"+clave))
				flag=false;
		}
		if(flag){
			conectar();
			CallableStatement cs;
			try {
				cs = c.prepareCall("{call alta_his(?,?,?,?,?,?,?,?,?,?)}");
				cs.setInt(1, clave);    	
	    		cs.setDate(2, fecha);
	    		cs.setString(3, e1);
	    		cs.setString(4, e2);
	    		cs.setString(5, e3);
	    		cs.setString(6, s1);
	    		cs.setString(7, s2);
	    		cs.setString(8, s3);
	    		cs.setString(9, aux.total);
	    		cs.setString(10, aux.claveh);
	    		cs.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}    		
    		
			desconectar();
			hist.add(aux);		
			JOptionPane.showMessageDialog(null, "Guardado!");
		}
		objeto.writeObject(hist);
		objeto.close();	
	}
	
	public static void main(String []args){
		Archivos a=new Archivos();
		Date f=new Date(0,0,0);
		f=Date.valueOf(2012+"-"+02+"-"+17);		
		try{
			a.altas(2, f, "08:05", "16:05", "00:00", "13:00", "19:00", "00:00");
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
	public ArrayList<String> tol(int clave){
		ObjectInputStream obj;
		ArrayList<String> s=new ArrayList<String>();
		try {
			int h1,m1,h2,m2;
			obj = new ObjectInputStream(new FileInputStream("Historial.bin"));
			array_aux=(ArrayList<Historial>)obj.readObject();
			for(Historial h: array_aux){
				h1=Integer.parseInt(h.i1.substring(0,2));
				h2=Integer.parseInt(h.i2.substring(0,2));
				m1=Integer.parseInt(h.i1.substring(3,5));
				m2=Integer.parseInt(h.i2.substring(3,5));
				if(h.clave==clave){
					if((h1==8 & m1>=5 & m1<10)){
						s.add(h.claveh);
					}
					if((h2==19 & m2>=5 & m2<10)){
						s.add(h.claveh);
					}
				}
			}
		}catch (EOFException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public ArrayList<String> ret(int clave){
		ObjectInputStream obj;
		ArrayList<String> s=new ArrayList<String>();
		try {
			int h1,m1,h2,m2;
			obj = new ObjectInputStream(new FileInputStream("Historial.bin"));
			array_aux=(ArrayList<Historial>)obj.readObject();
			for(Historial h: array_aux){
				h1=Integer.parseInt(h.i1.substring(0,2));
				h2=Integer.parseInt(h.i2.substring(0,2));
				m1=Integer.parseInt(h.i1.substring(3,5));
				m2=Integer.parseInt(h.i2.substring(3,5));
				if(h.clave==clave){
					if((h1>=8 & m1>10 & m1<=30)|(h2>=16 & m2>10 & m2<=30)){
						s.add(h.claveh);
					}
				}
			}
		}catch (EOFException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public ArrayList<String> faltas(int clave){
		ObjectInputStream obj;
		ArrayList<String> s=new ArrayList<String>();
		try {
			int h1,m1,h2,m2;
			obj = new ObjectInputStream(new FileInputStream("Historial.bin"));
			array_aux=(ArrayList<Historial>)obj.readObject();
			for(Historial h: array_aux){
				h1=Integer.parseInt(h.i1.substring(0,2));
				h2=Integer.parseInt(h.i2.substring(0,2));
				m1=Integer.parseInt(h.i1.substring(3,5));
				m2=Integer.parseInt(h.i2.substring(3,5));
				if(h.clave==clave){
					if((h1>=8 | m1>30)|(h2>=16 | m2>30)){
						s.add(h.claveh);
					}
				}
			}
		}catch (EOFException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public DefaultTableModel query(int clave){
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("Clave");
		modelo.addColumn("Fecha");
		modelo.addColumn("Entrada 1");
		modelo.addColumn("Salida 1");
		modelo.addColumn("Entrada 2");
		modelo.addColumn("Salida 2");
		modelo.addColumn("Entrada 3");
		modelo.addColumn("Salida 3");
		modelo.addColumn("Total de Horas");
		ObjectInputStream obj;
		try {
			obj = new ObjectInputStream(new FileInputStream("Historial.bin"));
			array_aux=(ArrayList<Historial>)obj.readObject();
			for(Historial h: array_aux){
				if(h.clave==clave){
					Object []fila={h.clave,h.fecha,h.i1,h.o1,h.i2,h.o2,h.i3,h.o3,h.total};
					modelo.addRow(fila);
				}
			}
		}catch (EOFException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return modelo;
	}
	
}
