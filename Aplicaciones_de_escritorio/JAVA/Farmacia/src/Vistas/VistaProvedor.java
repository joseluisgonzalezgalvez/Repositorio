/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaProvedor extends JPanel{
    public DefaultTableModel modelo;
    JPanel JP[]= new JPanel[10];
    JLabel Jl[]= new JLabel[13];
    public JTextField Jt[]= new JTextField[13];
    public JButton JB[]= new JButton[13];
    public JTextField JT[]= new JTextField[20];
    JLabel JL[]= new JLabel[20];
    public JTable Valuacion2;
    public JComboBox A,B,C,D,val,ml,grm;
    public JCheckBox Veri,Validax;
    ResultSet r1;
    Base_Datos.Sentecias_BD Op=new Base_Datos.Sentecias_BD();
    public VistaProvedor(){
        Disenio();
    }
    public void Llenar_Tabla(ResultSet R){
        // Creamos las columnas.
        Object [] fila;
    // Bucle para cada resultado en la consulta
    try{
           Op.Open();
           r1=R;
            while (r1.next())
                {
                    // Se crea un array que será una de las filas de la tabla.
                        fila = new Object[5]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                 for (int i=0;i<5;i++)
                        fila[i] = r1.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
             modelo.addRow(fila);
            }
           Op.Close();

    }catch(SQLException e){}
    // Se añade al modelo la fila completa.
} 
    public void Borrar_Provedores(){
//int i =Vp.modelo.getColumnCount();
            int i = modelo.getRowCount();
            //int y =
            //JOptionPane.showMessageDialog(null,"Numero de Lineas"+i);
            for(int m=i-1;m>=0;m--){
              //  JOptionPane.showMessageDialog(null,"indice"+m);
               // JOptionPane.showMessageDialog(null,"Numero de Lineas"+i);
                    modelo.removeRow(m);
            }
            //JOptionPane.showMessageDialog(null,"Borro todo");
    }
    public void Disenio() {
        setLayout(null);
        setSize(1024,450);
        //setSize(1024,768);
        //***************** creamos los paneles  *******************************
        for(int i=0; i<10;i++){
                JP[i]= new JPanel();
                JP[i].setLayout(null);
        }
        for(int i=0; i<4; i++){
            JT[i]= new JTextField();
        }
        //-------------- Crear Labels ------------------------------------------
        //++++ datos de la tabla Producto
        Jl[0]= new JLabel("Nombre Provedor: ");
        Jl[1]= new JLabel("Empresa Farmaceutica: ");
        Jl[2]= new JLabel("Direccion: ");
        Jl[3]= new JLabel("Telefono: ");
        //---------------- Posicionarlos----------------------------------------
        Jl[0].setBounds(10, 25,140,40);
        Jl[1].setBounds(10, 65,140,40);
        Jl[2].setBounds(5, 20,130,40);
        Jl[3].setBounds(5, 60,130,40);
        for(int i=0;i<4;i++){
            Jt[i]= new JTextField();
        }
        //--------- Posicionando las cajas de Textos ---------------------------
        Jt[0].setBounds(150, 33, 150, 20);
        Jt[1].setBounds(150, 73, 150, 20);
        Jt[2].setBounds(75, 28, 160, 20);
        Jt[3].setBounds(75, 68, 160, 20);
        JP[1].add(Jl[0]);
        JP[1].add(Jl[1]);
        JP[2].add(Jl[2]);
        JP[2].add(Jl[3]);
        JP[1].add(Jt[0]);
        JP[1].add(Jt[1]);
        JP[2].add(Jt[2]);
        JP[2].add(Jt[3]);
        //*******************************************************************
        C = new JComboBox();
        C.addItem("");
        C.addItem("Id_Provedor");
        C.addItem("Nombre_Provedor");
        C.addItem("Empresa");
        C.addItem("Direccion");
        C.addItem("Telefono");
        C.addActionListener(new Control.Control_Vista_Provedor(this));
        C.setBounds(30,50 ,140, 20);
        JT[0].setBounds(30,100 ,140, 20);
        JT[0].setEnabled(false);
        JP[7].add(C);
        JP[7].add(JT[0]);
        //***************** Componentes del Panel 3 como entregar el money *****
        
        modelo=new DefaultTableModel();
        modelo.addColumn("Id_Provedor");
        modelo.addColumn("Nombre_Provedor");
        modelo.addColumn("Empresa");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        
        
        
        Valuacion2= new JTable(modelo);

        JScrollPane scr=new JScrollPane(Valuacion2);

        Valuacion2.setPreferredScrollableViewportSize(new Dimension(800,150));
        Valuacion2.setEnabled(false);
        
        //Valuacion2.addMouseListener(new Control.Control_Vista_Provedor(this));
        
        scr.setBounds(10, 15, 960,130);
        JP[3].add(scr);
        //**********************************************************************
        JB[0]= new JButton("Agregar");
        JB[1]= new JButton("Limpiar");
        JB[2]= new JButton("Modificar");
        JB[3]= new JButton("Buscar");
        
        JB[5]= new JButton("Guardar");
        JB[6]= new JButton("Eliminar");
        Veri= new JCheckBox("Todos Provedores");
        Veri.setBounds(830, 20, 150, 25);
        Veri.addActionListener(new Control.Control_Vista_Provedor(this));
        
        //Veri.setEnabled(true);
        //Veri.removeActionListener(new Control.Control_Vista_Provedor(this));
        
        JB[3].setEnabled(false);
        JB[5].setEnabled(false);
        //JB[6].setEnabled(false);
        JB[0].setBounds(10, 20, 100, 25);
        JB[1].setBounds(120, 20, 100, 25);
        //JB[2].setBounds(340, 20, 100, 25);
        JB[3].setBounds(230, 20, 100, 25);
        //JB[5].setBounds(560, 20, 100, 25);
        Validax= new JCheckBox("Modificar/Eliminar");
        Validax.addActionListener(new Control.Control_Vista_Provedor(this));
        Validax.setEnabled(false);
        Validax.setBounds(670, 20, 150, 25);
        JP[5].add(Validax);
        //JB[6].setBounds(450, 20, 100, 25);
        for(int i=0;i<7;i++){
            if(i!=4){
                JB[i].addActionListener(new Control.Control_Vista_Provedor((this)));
            }
         }
        
        JP[5].add(JB[0]);
        JP[5].add(JB[1]);
        JP[5].add(JB[2]);
        JP[5].add(JB[3]);
        
        JP[5].add(JB[5]);
        JP[5].add(JB[6]);
        JP[5].add(Veri);
        //***************** Establecemos los tamaños y puestos *****************
        JP[0].setBounds(10, 10,630,175);
        JP[1].setBounds(5, 15,350,150);
        JP[2].setBounds(365, 15,250,150);
        JP[4].setBounds(365, 170,250,145);
        JP[5].setBounds(10,190,990,60);
        //****** Icono del Panel *********************************************
        JL[0] = new JLabel(new ImageIcon( "Provedor.jpg" ));
        JL[0].setBounds(5,10,140,165);
        JP[6].add(JL[0]);
        //************************ Paneles +++++++++++++++++++++++++++++++++++
        JP[6].setBounds(850,10,150,175);
        JP[7].setBounds(650,10,200,175);
        JP[3].setBounds(10, 255, 990, 170);
        JP[0].setBorder(BorderFactory.createTitledBorder("Provedores"));
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos del Provedor"));
        JP[2].setBorder(BorderFactory.createTitledBorder("*"));
        JP[5].setBorder(BorderFactory.createTitledBorder("Acciones"));
        JP[0].add(JP[1]);
        JP[0].add(JP[2]);
        //JP[0].add(JP[4]);
        JP[3].setBorder(BorderFactory.createTitledBorder("Lista de Provedores"));
        JP[6].setBorder(BorderFactory.createTitledBorder("Farmacias del Istmo"));
        JP[7].setBorder(BorderFactory.createTitledBorder("Consultas"));
        add(JP[0]);
        add(JP[3]);
        add(JP[5]);
        add(JP[6]);
        add(JP[7]);
    }
}
