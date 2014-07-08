package Vistas;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BD.Operacion_pestañas;
import Control.Control_p1;
public class Pestañas extends JFrame{	
	Operacion_pestañas op_p=new Operacion_pestañas();
	Control_p1 evento=new Control_p1(this);
	public JTabbedPane pan;
	public JPanel[] p;
	public Container c;
	public JMenu[] menu;
	public JMenuItem[] item;
	public JButton[] b;
	public JList lista;
	public JScrollPane pane_list,pane_table;
	public JTable tabla;
	private JMenuBar barra;
	
	public Pestañas(){				
		setLayout(new BorderLayout());
		setSize(1000,700);
		setResizable(false);
		setTitle("SISTEMA IDENTIFICADOR DE RETARDOS");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		Barra_Menu(this);
		diseño();		
	}
	
	public void diseño(){
		p=new JPanel[3];
		
		p[0]=new JPanel();
		p[0].setLayout(null);
		add(p[0]);
		
		pan=new JTabbedPane();
		pan.addTab("Altas", new Altas());
		pan.addTab("Bajas", new Bajas());
		pan.addTab("Cambios", new Cambios());
		pan.setBounds(550, 10, 440, 400);
		p[0].add(pan);
		
		p[1]=new JPanel();
		p[1].setLayout(null);
		p[1].setBounds(10, 10, 550, 400);
		Botones(p[1]);
		p[1].add(lista());
		
		p[2]=new JPanel();
		p[2].setLayout(null);		
		p[2].setBounds(20, 410, 970, 220);
		p[2].add(tabla(new BD.Archivos().query(0)));
		incidencias(p[2]);
		
		p[0].add(p[1]);
		p[0].add(p[2]);
	}
	
	public void Barra_Menu(JFrame p){
		String[] menu_name={"Archivo","Ir a","Ayuda","Reportes","Informacion"};		
		String[] item_name={"Por Clave"};
		menu=new JMenu[menu_name.length];
		item=new JMenuItem[item_name.length];
		barra=new JMenuBar();
		for(int i=0;i<menu.length;i++){
			menu[i]=new JMenu(menu_name[i]);
			barra.add(menu[i]);			
		}		
		
		for(int i=0;i<item.length;i++){
			item[i]=new JMenuItem(item_name[i]);
			if(i==0){
				item[i].addActionListener(evento);
				menu[3].add(item[i]);
			}
		}
		
		p.add(barra,BorderLayout.NORTH);
	}
	
	public void Botones(JPanel p){
		String[] s_b={"Tolerancias","Retardos","Faltas","Historial"};
		b=new JButton[s_b.length];
		for(int i=0;i<b.length;i++){
			b[i]=new JButton(s_b[i]);
			b[i].setBounds(420, 30+(i*70), 110, 30);			
			b[i].addActionListener(evento);
			if(b[i].getLabel().equals("Historial"))
				b[i].setBounds(420, 30+(i*98), 110, 30);
			p.add(b[i]);
		}
	}
	
	public JScrollPane lista(){
		lista=new JList(op_p.op_lista());
		lista.addFocusListener(evento);
		lista.setSelectionBackground(Color.blue);
		lista.setSelectionForeground(Color.white);
		lista.setSelectionMode(0);
		pane_list=new JScrollPane(lista);
		pane_list.setBorder(BorderFactory.createTitledBorder("Personal"));
		pane_list.setBounds(10, 10, 400, 390);
		return pane_list;
	}
	
	public JScrollPane tabla(DefaultTableModel modelo){
		tabla=new JTable(modelo);
		pane_table=new JScrollPane(tabla);
		pane_table.setBounds(0, 0, 970, 200);
		return pane_table;
	}
	
	public void incidencias(JPanel p){		
		String[] nombre={"Tolerancia","Retardo","Inasistencia"};
		JLabel[] et=new JLabel[nombre.length+3];		
		for(int i=0,j=0;i<et.length;i++){
			if(i%2==0){
				et[i]=new JLabel();
				et[i].setOpaque(true);
				switch(i){				
				case 0:et[i].setBackground(Color.GREEN);
						break;
				case 2:et[i].setBackground(Color.ORANGE);
						break;
				case 4:et[i].setBackground(Color.RED);
						break;
				}				
				et[i].setBounds(90+(i*100), 210, 10, 10);
			}
			else{
				et[i]=new JLabel(nombre[j]);	
				j++;
				et[i].setBounds(10+(i*100), 200, 130, 30);
			} 
			
			p.add(et[i]);
		}
		
	}

}
