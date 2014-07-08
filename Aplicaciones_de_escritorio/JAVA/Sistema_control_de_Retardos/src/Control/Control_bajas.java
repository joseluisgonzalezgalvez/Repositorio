package Control;

import java.awt.event.*;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import BD.Operacion_bajas;
import Vistas.Bajas;

public class Control_bajas implements ActionListener,ItemListener{
	Bajas ba;
	Operacion_bajas op;
	
	DefaultListModel mod1=new DefaultListModel(),mod2,baja;
	public Control_bajas(Bajas ba){
		this.ba=ba;
		op=new Operacion_bajas();
	}
	
	public void actionPerformed(ActionEvent e){
		Object o=e.getSource();
		int []index=ba.existen.getSelectedIndices();
		int []index2=ba.aborrar.getSelectedIndices();
		mod2=(DefaultListModel)ba.existen.getModel();
		
		if(o==ba.mov_list[0]){
			for(int i=0;i<index.length;i++)
				mod1.addElement(mod2.getElementAt(index[i]));
			
			for(int i=index.length-1;i>=0;i--)
				mod2.removeElementAt(index[i]);
			
			ba.existen.setModel(mod2);
			ba.aborrar.setModel(mod1);
		}
		
		if(o==ba.mov_list[1]){
			for(int i=0;i<index2.length;i++)
				mod2.addElement(mod1.getElementAt(index2[i]));
				
			for(int i=index2.length-1;i>=0;i--)
				mod1.removeElementAt(index2[i]);
			
			ba.existen.setModel(mod2);
			ba.aborrar.setModel(mod1);
		}
		
		if(o==ba.mov_list[2]){
			baja=(DefaultListModel)ba.aborrar.getModel();
			int x=0;
			String s="";  
			for(int i=0;i<=ba.aborrar.getLastVisibleIndex();i++){
				s=(String)baja.getElementAt(i);
				for(int j=0;j<s.length();j++){
					if(s.charAt(j)==':')
						x=j;
				}
				op.remove(Integer.parseInt(s.substring(0, x)));
			}
				
			/*
			*/
		}
	}
	
	public void itemStateChanged(ItemEvent it){
		DefaultListModel f;
		System.out.println(ba.aborrar.getLastVisibleIndex());
		try{
			f=(DefaultListModel)ba.aborrar.getModel();
			f.removeAllElements();
			ba.aborrar.setModel(f);
		}catch(ClassCastException e){}
		
		
		refresh();
	}
	
	public void refresh(){
		ba.existen.setModel(op.del_lista(""+ba.personal.getSelectedItem()));
	}
	
}
