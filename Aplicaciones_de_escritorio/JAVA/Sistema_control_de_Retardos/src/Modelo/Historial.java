package Modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.swing.JOptionPane;

public class Historial implements Serializable{
	public int clave;
	public Date fecha;
	public String i1,i2,i3,o1,o2,o3;
	public String total;
	public String claveh;
	
	public Historial(int clave, Date fecha, String i1,String i2,String i3, String o1, String o2, String o3){
		this.clave=clave;
		this.fecha=fecha;
		this.i1=i1;
		this.i2=i2;
		this.i3=i3;
		this.o1=o1;
		this.o2=o2;
		this.o3=o3;
		this.total=total(i1,i2,i3,o1,o2,o3);
		this.claveh=String.valueOf(fecha)+"-"+String.valueOf(clave);
	}
	
	public String toString(){
		return "\nClave: "+clave+"\nFecha: "+fecha+
			"\nE1: "+i1+"\nE2: "+i2+"\nE3: "+i3+
			"\nS1: "+o1+"\nS2: "+o2+"\nS3: "+o3+
			"\nTotal: "+total;
	}
	
	public String total(String e1,String e2,String e3,String s1,String s2,String s3){
		int ah=Integer.parseInt(s1.substring(0, 2))-Integer.parseInt(e1.substring(0, 2));
		int bh=Integer.parseInt(s2.substring(0, 2))-Integer.parseInt(e2.substring(0, 2));
		int ch=Integer.parseInt(s3.substring(0, 2))-Integer.parseInt(e3.substring(0, 2));
		int am=Integer.parseInt(s1.substring(3, 5))-Integer.parseInt(e1.substring(3, 5));
		if(am<0){
			ah--;
			am=Integer.parseInt(s1.substring(3, 5))+60-Integer.parseInt(e1.substring(3, 5));
		}
		int bm=Integer.parseInt(s2.substring(3, 5))-Integer.parseInt(e2.substring(3, 5));
		if(bm<0){
			bh--;
			bm=Integer.parseInt(s2.substring(3, 5))+60-Integer.parseInt(e2.substring(3, 5));
		}
		int cm=Integer.parseInt(s3.substring(3, 5))-Integer.parseInt(e3.substring(3, 5));
		if(cm<0){
			ch--;
			cm=Integer.parseInt(s3.substring(3, 5))+60-Integer.parseInt(e3.substring(3, 5));
		}
		int t1=ah+bh+ch;
		int t2=am+bm+cm;
		t1+=t2/60;
		t2%=60;
		return t1+":"+t2+" hrs";
	}

}
