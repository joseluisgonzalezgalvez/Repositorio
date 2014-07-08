package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import Vistas_Empleado.VistaClientes;
import Operaciones.Operaciones;

public class control_vista_clientes implements ActionListener,MouseListener{
	VistaClientes vc;
	Operaciones op;
	
	public control_vista_clientes(VistaClientes vc){
		this.vc=vc;
		op=new Operaciones();
	}

	public void actionPerformed(ActionEvent e) {
		Object x = e.getSource();
		// ************ Boton de Altas ***********
		if(x == vc.op6){
	        for(int i=0;i<7;i++){
	        	  vc.ava.Jt[i].setEnabled(true);
	        	  vc.propi.Jt[i].setEnabled(true);
	        	  vc.vehi.Jt[i].setEnabled(true);
	        	  vc.dl.Jt[i].setEnabled(true);
	        	  vc.Jt[i].setEnabled(true);
	        }
	        vc.Jt[7].setEnabled(true);
	        vc.Jt[8].setEnabled(true);
	        vc.claves.setEnabled(true);
	        vc.Edo_Crediticio.setEnabled(true);
	        vc.Edo_Civil.setEnabled(true);
	        vc.JB[2].setEnabled(true);
	        vc.JB[5].setEnabled(true);
	        vc.JB[6].setEnabled(true);
	        vc.JB[7].setEnabled(true);
	        vc.JB[4].setEnabled(false);
	        vc.JB[3].setEnabled(false);
			
		}
		//************ Boton de Bajas ***********
		if(x == vc.op7){
	        for(int i=0;i<7;i++){
	        	  vc.ava.Jt[i].setEnabled(false);
	        	  vc.propi.Jt[i].setEnabled(false);
	        	  vc.vehi.Jt[i].setEnabled(false);
	        	  vc.dl.Jt[i].setEnabled(false);
	        	  vc.Jt[i].setEnabled(false);
	        }
	        vc.Jt[7].setEnabled(false);
	        vc.Jt[8].setEnabled(false);
	        vc.claves.setEnabled(false);
	        vc.Edo_Crediticio.setEnabled(false);
	        vc.Edo_Civil.setEnabled(false);
	        vc.JB[2].setEnabled(false);
	        vc.JB[4].setEnabled(true);
	        vc.JB[5].setEnabled(true);
	        vc.JB[6].setEnabled(true);
	        vc.JB[7].setEnabled(true);
	        vc.JB[3].setEnabled(false);
		}
		//************ Boton de Modificaciones ***********
		if(x == vc.op8){
	        for(int i=0;i<7;i++){
	        	  vc.ava.Jt[i].setEnabled(true);
	        	  vc.propi.Jt[i].setEnabled(true);
	        	  vc.vehi.Jt[i].setEnabled(true);
	        	  vc.dl.Jt[i].setEnabled(true);
	        	  vc.Jt[i].setEnabled(true);
	        }
	        vc.Jt[7].setEnabled(true);
	        vc.Jt[8].setEnabled(true);
	        vc.claves.setEnabled(true);
	        vc.Edo_Crediticio.setEnabled(true);
	        vc.Edo_Civil.setEnabled(true);
	        vc.JB[2].setEnabled(false);
	        vc.JB[3].setEnabled(true);
	        vc.JB[5].setEnabled(true);
	        vc.JB[6].setEnabled(true);
	        vc.JB[7].setEnabled(true);
	        vc.JB[4].setEnabled(false);
		}
		if(x==vc.JB[4]){
			op.b_cliente(vc.claves.getText());
		}
		
		if(x == vc.JB[0]){
			String campo="";
			op.conectar();
			if(vc.op1.isSelected())
				campo="Apellido";
			if(vc.op2.isSelected())
				campo="Id_cliente";
			if(vc.op3.isSelected())
				campo="Ciudad";
			if(vc.op4.isSelected())
				campo="Edo_crediticio";		
			
			vc.t1.setModel(op.modelos(campo, vc.Busqueda.getText()));
			op.desconectar();
		}
		
		if(x == vc.JB[1]){
			op.conectar();
			vc.t1.setModel(op.mod_tabla_gral());
			op.desconectar();
		}
		
		if(x == vc.JB[2]){
			Validar.Validaciones v = new Validar.Validaciones();
			String clave=vc.claves.getText();
			String n=vc.Jt[0].getText();
			String a=vc.Jt[1].getText();
			String dir=vc.Jt[2].getText();
			String cd=vc.Jt[3].getText();
			String tel=vc.Jt[4].getText();
			String lim_cr=vc.Jt[7].getText();
			String cl_act=vc.Jt[8].getText();
			String edo_civ=String.valueOf(vc.Edo_Civil.getSelectedItem());
			String edo_cred=String.valueOf(vc.Edo_Crediticio.getSelectedItem());
			
			if(v.Validar_code_cliente(clave)== false){
				if(v.Validar_Letras(n)==false){
					if(v.Validar_Letras(a)==false){
						if(v.Validar_Direccion(dir)==false){
							if(v.Validar_Letras(cd)==false){
								if(v.Validar_Telefonos(tel)==false){
									if(v.Validar_Precios(lim_cr)==false){
										alta_cliente();
										alta_aval();
										comprueba();
									}else{
										JOptionPane.showMessageDialog(null, "Límite Incorrecto","Error",JOptionPane.ERROR_MESSAGE);
									}
								}else{
									JOptionPane.showMessageDialog(null, "Teléfono Incorrecto","Error",JOptionPane.ERROR_MESSAGE);
								}
							}else{
								JOptionPane.showMessageDialog(null, "Ciudad Incorrecta","Error",JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "Dirección Incorrecta","Error",JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Apellido Incorrecto","Error",JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null,"Nombre Incorrecto","Error",JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null,"Clave Incorrecta","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(x == vc.JB[3]){
			cam_cliente();
			cam_aval();
		}
		
		if(x == vc.JB[6]){
			op.pasa_parametrosBD();
		}
	}
	
	public void alta_cliente(){
		String clave=vc.claves.getText();
		String n=vc.Jt[0].getText();
		String a=vc.Jt[1].getText();
		String dir=vc.Jt[2].getText();
		String cd=vc.Jt[3].getText();
		String tel=vc.Jt[4].getText();
		String lim_cr=vc.Jt[7].getText();
		String cl_act=vc.Jt[8].getText();
		String edo_civ=String.valueOf(vc.Edo_Civil.getSelectedItem());
		String edo_cred=String.valueOf(vc.Edo_Crediticio.getSelectedItem());
		
		op.a_cliente(clave,n,a,edo_civ,cd,dir,Float.parseFloat(lim_cr),edo_cred,tel,cl_act);
	}
	
	public void cam_cliente(){
		String clave=vc.claves.getText();
		String n=vc.Jt[0].getText();
		String a=vc.Jt[1].getText();
		String dir=vc.Jt[2].getText();
		String cd=vc.Jt[3].getText();
		String tel=vc.Jt[4].getText();
		String lim_cr=vc.Jt[7].getText();
		String cl_act=vc.Jt[8].getText();
		String edo_civ=String.valueOf(vc.Edo_Civil.getSelectedItem());
		String edo_cred=String.valueOf(vc.Edo_Crediticio.getSelectedItem());
		
		op.c_cliente(clave,n,a,edo_civ,cd,dir,Float.parseFloat(lim_cr),edo_cred,tel,cl_act);
	}
	
	public void alta_aval(){
		String []fields=new String[vc.ava.Jt.length]; 
		for(int i=0;i<fields.length;i++){
			fields[i]=vc.ava.Jt[i].getText();
		}
		op.a_aval("A"+vc.claves.getText(), fields[0], fields[1], fields[2], fields[5], fields[3], 
					fields[4], Float.parseFloat(fields[6]), vc.claves.getText());
	}

	public void cam_aval(){
		String []fields=new String[vc.ava.Jt.length]; 
		for(int i=0;i<fields.length;i++){
			fields[i]=vc.ava.Jt[i].getText();
		}
		op.c_aval("A"+vc.claves.getText(), fields[0], fields[1], fields[2], fields[5], fields[3], 
					fields[4], Float.parseFloat(fields[6]), vc.claves.getText());
	}
	
	public void alta_prop(){
		String []fields=new String[vc.propi.Jt.length]; 
		for(int i=0;i<fields.length;i++){
			fields[i]=vc.propi.Jt[i].getText();
		}
		
		op.a_propiedad("P"+vc.claves.getText(), fields[0], fields[3], fields[2], Float.parseFloat(fields[1]), vc.claves.getText());
	}
	
	public void cam_prop(){
		String []fields=new String[vc.propi.Jt.length]; 
		for(int i=0;i<fields.length;i++){
			fields[i]=vc.propi.Jt[i].getText();
		}
		
		op.c_propiedad("P"+vc.claves.getText(), fields[0], fields[3], fields[2], Float.parseFloat(fields[1]));
	}
	
	public void alta_vehi(){
		String []fields=new String[vc.vehi.Jt.length]; 
		for(int i=0;i<fields.length;i++){
			fields[i]=vc.vehi.Jt[i].getText();
		} 
		op.a_vehiculo("V"+vc.claves.getText(), fields[0],fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), Float.parseFloat(fields[6]), fields[5], vc.claves.getText());
	}
	
	public void cam_vehi(){
		String []fields=new String[vc.vehi.Jt.length]; 
		for(int i=0;i<fields.length;i++){
			fields[i]=vc.vehi.Jt[i].getText();
		} 
		op.c_vehiculo("V"+vc.claves.getText(), fields[0],fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), Float.parseFloat(fields[6]), fields[5], vc.claves.getText());
	}
	
	public void alta_lab(){
		String []fields=new String[vc.dl.Jt.length]; 
		for(int i=0;i<fields.length;i++){
			fields[i]=vc.dl.Jt[i].getText();
		}
		op.a_laboral("L"+vc.claves.getText(), fields[0], fields[1], fields[2], fields[3], fields[4], Float.parseFloat(fields[5]), Integer.parseInt(fields[6]), null, vc.claves.getText());
	}
	
	public void cam_lab(){
		String []fields=new String[vc.dl.Jt.length]; 
		for(int i=0;i<fields.length;i++){
			fields[i]=vc.dl.Jt[i].getText();
		}
		op.c_laboral("L"+vc.claves.getText(), fields[0], fields[1], fields[2], fields[3], fields[4], Float.parseFloat(fields[5]), Integer.parseInt(fields[6]), null, vc.claves.getText());
	}
	
	public void comprueba(){
		boolean flag1=false,flag2=false,flag3=false;
		for(int i=0;i<vc.propi.Jt.length-1;i++){
			if(i!=5 | i!=6){
				if(vc.propi.Jt[i].getText().equals("")){
					flag1=true;
				}	
			}
		}
		
		for(int i=0;i<vc.vehi.Jt.length;i++){
			if(vc.vehi.Jt[i].getText().equals("")){
				flag2=true;
			}
		}
		
		for(int i=0;i<vc.dl.Jt.length;i++){
			if(vc.dl.Jt[i].getText().equals("")){
				flag3=true;
			}
		}
		
		if(!flag1)
			alta_prop();
		if(!flag2)
			alta_vehi();
		if(!flag3)
			alta_lab();
	}

	public void comprueba2(){
		boolean flag1=false,flag2=false,flag3=false;
		for(int i=0;i<vc.propi.Jt.length-1;i++){
			if(i!=5 | i!=6){
				if(vc.propi.Jt[i].getText().equals("")){
					flag1=true;
				}	
			}
		}
		
		for(int i=0;i<vc.vehi.Jt.length;i++){
			if(vc.vehi.Jt[i].getText().equals("")){
				flag2=true;
			}
		}
		
		for(int i=0;i<vc.dl.Jt.length;i++){
			if(vc.dl.Jt[i].getText().equals("")){
				flag3=true;
			}
		}
		
		if(!flag1)
			cam_prop();
		if(!flag2)
			cam_vehi();
		if(!flag3)
			cam_lab();
	}
	
	public void mouseClicked(MouseEvent e) {
		int fila = vc.t1.rowAtPoint(e.getPoint());
        int columna = vc.t1.columnAtPoint(e.getPoint());
        if((fila > -1) && (columna> -1)){
            Object clave_tabla = vc.t1.getModel().getValueAt(fila, 0);
            String Clave = String.valueOf(clave_tabla);
            op.conectar();
            set_campos(Clave);
            op.desconectar();
        }
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}
	
	public void  set_campos(String Clave){
		vc.claves.setText(op.consulta("Id_cliente", "cliente", "Id_cliente", Clave));
        vc.Jt[0].setText(op.consulta("Nombre", "cliente", "Id_cliente", Clave));
        vc.Jt[1].setText(op.consulta("Apellido", "cliente", "Id_cliente", Clave));
        vc.Jt[2].setText(op.consulta("Direccion", "cliente", "Id_cliente", Clave));
        vc.Jt[3].setText(op.consulta("Ciudad", "cliente", "Id_cliente", Clave));
        vc.Jt[4].setText(op.consulta("Telefono", "cliente", "Id_cliente", Clave));
        vc.Jt[7].setText(op.consulta("Lim_Credito", "cliente", "Id_cliente", Clave));
        vc.Jt[8].setText(op.consulta("Eliminado", "cliente", "Id_cliente", Clave));
        vc.Edo_Civil.setSelectedItem(op.consulta("Edo_Civil", "cliente", "Id_cliente", Clave));
        vc.Edo_Crediticio.setSelectedItem(op.consulta("Edo_crediticio", "cliente", "Id_cliente", Clave));
        vc.ava.Jt[0].setText(op.consulta("Nombre", "Aval", "Id_Aval", "A"+Clave));
        vc.ava.Jt[1].setText(op.consulta("Apellido", "Aval", "Id_Aval", "A"+Clave));
        vc.ava.Jt[2].setText(op.consulta("Direccion", "Aval", "Id_Aval", "A"+Clave));
        vc.ava.Jt[3].setText(op.consulta("Empresa", "Aval", "Id_Aval", "A"+Clave));
        vc.ava.Jt[4].setText(op.consulta("Puesto", "Aval", "Id_Aval", "A"+Clave));
        vc.ava.Jt[5].setText(op.consulta("Telefono", "Aval", "Id_Aval", "A"+Clave));
        vc.ava.Jt[6].setText(op.consulta("Sueldo", "Aval", "Id_Aval", "A"+Clave));
        vc.propi.Jt[0].setText(op.consulta("Tipo", "propiedad", "Id_prop", "P"+Clave));
        vc.propi.Jt[1].setText(op.consulta("Valuacion", "propiedad", "Id_prop", "P"+Clave));
        vc.propi.Jt[2].setText(op.consulta("Superficie", "propiedad", "Id_prop", "P"+Clave));
        vc.propi.Jt[3].setText(op.consulta("Direccion", "propiedad", "Id_prop", "P"+Clave));
        vc.vehi.Jt[0].setText(op.consulta("Tipo", "vehiculo", "Id_vehiculo", "V"+Clave));
        vc.vehi.Jt[1].setText(op.consulta("Marca", "vehiculo", "Id_vehiculo", "V"+Clave));
        vc.vehi.Jt[2].setText(op.consulta("Modelo", "vehiculo", "Id_vehiculo", "V"+Clave));
        vc.vehi.Jt[3].setText(op.consulta("Color", "vehiculo", "Id_vehiculo", "V"+Clave));
        vc.vehi.Jt[4].setText(op.consulta("No_puertas", "vehiculo", "Id_vehiculo", "V"+Clave));
        vc.vehi.Jt[5].setText(op.consulta("Valuacion", "vehiculo", "Id_vehiculo", "V"+Clave));
        vc.vehi.Jt[6].setText(op.consulta("Placa", "vehiculo", "Id_vehiculo", "V"+Clave));
        vc.dl.Jt[0].setText(op.consulta("Empresa", "laboral", "Id_laboral", "L"+Clave));
        vc.dl.Jt[1].setText(op.consulta("Profesion", "laboral", "Id_laboral", "L"+Clave));
        vc.dl.Jt[2].setText(op.consulta("Empleado", "laboral", "Id_laboral", "L"+Clave));
        vc.dl.Jt[3].setText(op.consulta("Telefono", "laboral", "Id_laboral", "L"+Clave));
        vc.dl.Jt[4].setText(op.consulta("Direccion", "laboral", "Id_laboral", "L"+Clave));
        vc.dl.Jt[5].setText(op.consulta("Sueldo", "laboral", "Id_laboral", "L"+Clave));
        vc.dl.Jt[6].setText(op.consulta("Antiguedad", "laboral", "Id_laboral", "L"+Clave));
	}
}
