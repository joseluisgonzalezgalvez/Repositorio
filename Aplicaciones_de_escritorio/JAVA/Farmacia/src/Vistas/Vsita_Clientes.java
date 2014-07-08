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

/**
 *
 * @author Administrador
 */
public class Vsita_Clientes extends JPanel{
    public DefaultTableModel modelo;
    public JPanel JP[]= new JPanel[10];
    JLabel Jl[]= new JLabel[13];
    public JTextField Jt[]= new JTextField[13];
    public JButton JB[]= new JButton[13];
    public JTextField JT[]= new JTextField[20];
    JLabel JL[]= new JLabel[20];
    public JTable Valuacion2;
    public JComboBox A,B,C,D,val,ml,grm,copia;
    public JCheckBox Veri,Verix;
    public JPasswordField Contra,Contra2;
    ResultSet r1;
    Base_Datos.Sentecias_BD Op=new Base_Datos.Sentecias_BD();;
    public Vsita_Clientes(){
        Disenio();
    }
    public void Llenar_Tabla_Clientes(ResultSet R){
        // Creamos las columnas.
        Object [] fila;
    // Bucle para cada resultado en la consulta
    try{
           Op.Open();
           r1=R;
            while (r1.next())
                {
                    // Se crea un array que será una de las filas de la tabla.
                        fila = new Object[8]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                 for (int i=0;i<8;i++)
                        fila[i] = r1.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
             modelo.addRow(fila);
            }
           Op.Close();

    }catch(SQLException e){}
    // Se añade al modelo la fila completa.



} 
    public void Borrar_Cliente(){
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
        for(int i=0; i<10; i++){
            JT[i]= new JTextField();
        }
        //-------------- Crear Labels ------------------------------------------
        //++++ datos de la tabla Producto
        JL[0]= new JLabel();
        JL[1]= new JLabel("");
        
        


        
        //copia.setEnabled(false);
        //JP[7].add(copia);
        Contra = new JPasswordField();
        Contra2 = new JPasswordField();
        
        

        Jl[0]= new JLabel("Nombre Cliente: ");
        Jl[1]= new JLabel("Direccion: ");
        Jl[2]= new JLabel("Estado: ");
        Jl[3]= new JLabel("Ciudad: ");
        
        JL[2]= new JLabel("Telefono ");
        JL[3]= new JLabel("Codigo Postal: ");
        
        //---------------- Posicionarlos----------------------------------------
        JL[0].setBounds(10, 15,140,30);
        Jl[0].setBounds(10, 45,140,30);
        Jl[1].setBounds(10, 70,140,30);
        JL[1].setBounds(10, 95,140,30);
        
        
        
        Jl[2].setBounds(5, 10,130,40);
        Jl[3].setBounds(5, 40,130,40);
        
        JL[2].setBounds(5, 5,130,40);
        JL[3].setBounds(5, 35,130,40);
        for(int i=0;i<4;i++){
            Jt[i]= new JTextField();
        }
        //--------- Posicionando las cajas de Textos ---------------------------
        Jt[0].setBounds(150, 50, 150, 20);
        Jt[1].setBounds(150, 77, 150, 20);
        //JT[1].setBounds(150, 104, 150, 20);
        JT[4].setBounds(115, 13, 120, 20);
        JT[5].setBounds(115, 43, 120, 20);
        Contra.setBounds(115, 18, 120, 20);
        Contra2.setBounds(115, 48, 120, 20);
        JP[4].add(JL[2]);
        JP[4].add(JT[4]);
        JP[4].add(JT[5]);
        JP[4].add(JL[3]);
        //JT[4].setVisible(false);
        //JT[5].setVisible(false);
        //JP[4].setVisible(false);
        JP[1].add(JL[0]);
        JP[1].add(JL[1]);
        JP[1].add(Jl[1]);
        JP[1].add(Jl[0]);
        JP[2].add(Jl[2]);
        JP[2].add(Jl[3]);
        JP[1].add(Jt[0]);
       
        JP[1].add(Jt[1]);
        JP[1].add(JT[1]);
    //    JP[2].add(Jt[2]);
     //   JP[2].add(Jt[3]);
        
        JP[2].add(Contra);
        JP[2].add(Contra2);
        //*******************************************************************
        C = new JComboBox();
        C.addItem("");
        C.addItem("Id_Cliente");
        C.addItem("Nombre_Cliente");
        C.addItem("Direccion");
        C.addItem("Telefono");
        C.addItem("Ciudad");
        C.addItem("Estado");
        C.addItem("Numero_Tarjeta");
  //      C.addActionListener(new Control.Control_Vista_Empleado(this));
        C.setBounds(30,50 ,140, 20);
        JT[0].setBounds(30,100 ,140, 20);
        JT[0].setEnabled(false);
        JP[7].add(C);
        JP[7].add(JT[0]);
///        JP[7].add(copia);
        //***************** Componentes del Panel 3 como entregar el money *****
        
        modelo=new DefaultTableModel();
        modelo.addColumn("Id_Cliente");
        modelo.addColumn("Nombre_Cliente");
        modelo.addColumn("Direccion");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Codigo_Postal");
        modelo.addColumn("Estado");
        modelo.addColumn("Numero_Tarjeta");
        Valuacion2= new JTable(modelo);

        JScrollPane scr=new JScrollPane(Valuacion2);

        Valuacion2.setPreferredScrollableViewportSize(new Dimension(800,150));
        //Valuacion2.setEnabled(false);
        //Valuacion2.addMouseListener(new Control.Control_Vista_Empleado(this));
        scr.setBounds(10, 15, 960,130);
        JP[3].add(scr);
        //**********************************************************************
        JB[0]= new JButton("Agregar");
        JB[1]= new JButton("Limpiar");
        JB[2]= new JButton("Modificar");
        JB[3]= new JButton("Buscar");
        JB[4]= new JButton("Modificar/Eliminar");
        Verix= new JCheckBox("Modifica/Eliminar");
        
        
        JB[5]= new JButton("BuscarA");
        JB[6]= new JButton("Eliminar");
        Veri= new JCheckBox("Todos Clientes");
        Veri.setBounds(830, 20, 150, 25);
        //Veri.setEnabled(true);
        //Veri.addActionListener(new Control.Control_Vista_Provedor(this));
        /*JB[2].setEnabled(false);
        JB[3].setEnabled(false);
        JB[5].setEnabled(false);
        JB[6].setEnabled(false);
        JB[4].setEnabled(false);*/
        JB[0].setBounds(10, 20, 100, 25);
        JB[1].setBounds(120, 20, 100, 25);
  //      JB[2].setBounds(340, 20, 100, 25);
  //      JB[3].setBounds(230, 20, 100, 25);
        //Veri.addActionListener(new Control.Control_Vista_Empleado(this));

        Verix.setEnabled(false);
        JB[3].setEnabled(false);
        
        
        JB[3].setBounds(560, 20, 100, 25);
        Verix.setBounds(670, 20, 150, 25);
        //JB[6].setBounds(450, 20, 100, 25);
        for(int i=0;i<7;i++){
                //JB[i].addActionListener(new Control.Control_Vista_Empleado(this));
                }
        
        JP[5].add(JB[0]);
        JP[5].add(JB[1]);
        JP[5].add(JB[2]);
        //JP[5].add(JB[3]);
        JP[5].add(Verix);
        JP[5].add(JB[3]);
        JP[5].add(JB[6]);
        JP[5].add(Veri);
        //***************** Establecemos los tamaños y puestos *****************
        JP[0].setBounds(10, 10,630,175);
        JP[1].setBounds(5, 15,350,150);
        JP[2].setBounds(365, 15,250,80);
        JP[4].setBounds(365, 95,250,70);
        JP[5].setBounds(10,190,990,60);
        //****** Icono del Panel *********************************************
        JL[0] = new JLabel(new ImageIcon( "Logito4.jpg" ));
        JL[0].setBounds(5,10,140,165);
        JP[6].add(JL[0]);
        //************************ Paneles +++++++++++++++++++++++++++++++++++
        JP[6].setBounds(850,10,150,175);
        JP[7].setBounds(650,10,200,175);
        JP[3].setBounds(10, 255, 990, 170);
        JP[0].setBorder(BorderFactory.createTitledBorder("Clientes"));
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
        JP[2].setBorder(BorderFactory.createTitledBorder(""));
        JP[5].setBorder(BorderFactory.createTitledBorder("Acciones"));
        JP[4].setBorder(BorderFactory.createTitledBorder(""));
        JP[0].add(JP[1]);
        JP[0].add(JP[2]);
        JP[0].add(JP[4]);
        JP[3].setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
        JP[6].setBorder(BorderFactory.createTitledBorder("Farmacias del Istmo"));
        JP[7].setBorder(BorderFactory.createTitledBorder("Consultas"));
        add(JP[0]);
        add(JP[3]);
        add(JP[5]);
        add(JP[6]);
        add(JP[7]);
    }
}
