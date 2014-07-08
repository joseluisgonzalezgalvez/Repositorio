/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Control.*;
//import com.birosoft.liquid.LiquidLookAndFeel;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class Vista_Factura extends JPanel{
    public DefaultTableModel modelo,modelo2;
    public JPanel JP[]= new JPanel[5];
    public JButton JB[]= new JButton[20];
    public JTextField JT[]= new JTextField[20];
    JLabel JL[]= new JLabel[20];
    public JCheckBox JCK[]= new JCheckBox[4];
    public JComboBox C;
    public JTable Valuacion2,Valuacion;
    public ResultSet r1;
    Vistas_Finales.VistaPrincipal o =new Vistas_Finales.VistaPrincipal();
    Base_Datos.Sentecias_BD Op= new Base_Datos.Sentecias_BD();
    
   
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
                        fila = new Object[7]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                 for (int i=0;i<7;i++)
                        fila[i] = r1.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
             modelo.addRow(fila);
            }
           Op.Close();

    }catch(SQLException e){}
    // Se añade al modelo la fila completa.



}
    public void Borrar_Productos(){
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
    public Vista_Factura(){
        Disenio();
    }
    public void Disenio() {
        setLayout(null);
        setSize(1020,600);
        for(int i=0;i<5;i++){
            JP[i] = new JPanel();
            JP[i].setLayout(null);
        }
        for(int i=0;i<20;i++){
            JT[i] = new JTextField();
            JT[i].setEnabled(false);
        }
        //++++++++++++++++ Titulo ++++++++++++++++++++++++++++++++++++++++++++++
        JL[0]= new JLabel("FARMACIAS DEL ISTMO");
        JL[1]= new JLabel("       Sucursal Ixtepec");
        JL[2]= new JLabel("Calle Vicente Guerrero, Avenida Hidalgo Nº 90");
        JL[0].setBounds(435,5,150,30);
        JL[1].setBounds(435,25,150,30);
        JL[2].setBounds(370,45,300,30);
        
        //++++++++++++++++ Panel Tarjeta++++++++++++++++++++++++++++++++++++++++++++++
        
        JL[3]= new JLabel("Numero de Tarjeta: ");
        JL[3].setBounds(10,20, 120,30);
        JT[0].setBounds(140,35, 120,25);
        JT[0].setEnabled(false);
        

        JB[0] = new JButton("Buscar");
        JB[0].setEnabled(false);
        JB[0].addActionListener(new ControlVistaFactura(this));
        JB[0].setBounds(270,35, 100,25);
        
        JP[0].add(JL[3]);
        JP[0].add(JT[0]);
        JP[0].add(JB[0]);
        //+++++++++++++++++ Datos del Cliente ++++++++++++++++++++++++++++++++++++++++
        
        JL[4] = new JLabel("Nombre :");
        JL[5] = new JLabel("Direccion: ");
        JL[6] = new JLabel("Ciudad: ");
        JL[7] = new JLabel("Telefono: ");
        JL[8] = new JLabel("Codigo Postal: ");
        JL[9] = new JLabel("Estado: ");
        JL[10] = new JLabel("Numero de Tarjeta: ");
        
        JL[4].setBounds(10,20,120,30);
        JL[5].setBounds(10,50,120,30);
        JL[6].setBounds(10,80,120,30);
        JL[7].setBounds(10,110,120,30);
        JL[8].setBounds(10,140,120,30);
        JL[9].setBounds(10,170,120,30);
        JL[10].setBounds(10,200,120,30);



        JT[4].setBounds(140,20,220,25);
        JT[5].setBounds(140,50,220,25);
        JT[6].setBounds(140,80,220,25);
        JT[7].setBounds(140,110,220,25);
        JT[8].setBounds(140,140,220,25);
        JT[9].setBounds(140,170,220,25);
        JT[10].setBounds(140,200,220,25);
         for(int i=4;i<11;i++)
         {
             JT[i].addActionListener(new ControlVistaFactura(this));             
         }

        
        JB[1]= new JButton("Guardar");
        JB[1].setBounds(10,230, 100,25);
        JP[1].add(JB[1]);
        JB[2]= new JButton("Modificar");
        JB[2].setBounds(140,230, 100,25);
        JP[1].add(JB[2]);
        JB[3]= new JButton("Limpiar");
        JB[3].setBounds(270,230, 100,25);
        JP[1].add(JB[3]);
        for(int i=1;i<4;i++)
            JB[i].addActionListener(new ControlVistaFactura(this));
        
        
        JB[1].setEnabled(false);
        JB[2].setEnabled(false);
        JB[3].setEnabled(false);
        
        JP[1].add(JL[4]);
        JP[1].add(JL[5]);
        JP[1].add(JL[6]);
        JP[1].add(JL[7]);
        JP[1].add(JL[8]);
        JP[1].add(JL[9]);
        JP[1].add(JL[10]);
        
        JP[1].add(JT[4]);
        JP[1].add(JT[5]);
        JP[1].add(JT[6]);
        JP[1].add(JT[7]);
        JP[1].add(JT[8]);
        JP[1].add(JT[9]);
        JP[1].add(JT[10]);
        
        JT[4].setEnabled(false);
        JT[5].setEnabled(false);
        JT[6].setEnabled(false);
        JT[7].setEnabled(false);
        JT[8].setEnabled(false);
        JT[9].setEnabled(false);
        JT[10].setEnabled(false);
        
        //+++++++++++++++++ Panel del Empleado ++++++++++++++++++++++++++++++++
        
        JL[11] = new JLabel("Identificado: ");
        JL[12] = new JLabel("Nombre: ");
        JL[11].setBounds(10,20,120,30);
        JL[12].setBounds(10,50,120,30);   
        Op.Open();
        JT[11].setText(Op.Obtener_Name(o.Nombre_Usuario));
        JT[12].setText(o.Nombre_Usuario);
        Op.Close();
        JT[11].setBounds(140,20,220,25);
        JT[12].setBounds(140,50,220,25);
        
        JP[2].add(JL[11]);
        JP[2].add(JL[12]);
        JP[2].add(JT[11]);
        JP[2].add(JT[12]);
        
        JT[11].setEnabled(false);
        JT[12].setEnabled(false);
        //+++++++++++++++++++++ panel de consulta ++++++++++++++++++++++++++++++
        C = new JComboBox();
        C.addItem("");
        C.addItem("Id_Producto");
        C.addItem("Nombre_Producto");
        C.addItem("Forma_Farmaceutica");
        C.addItem("Precio");
        C.addItem("Cantidad");
        C.setBounds(10,20 ,140, 20);
        C.addActionListener(new ControlVistaFactura(this));
        JT[13].setBounds(160,20,250, 20);
        JB[8] = new JButton("Buscar");
        JB[8].addActionListener(new ControlVistaFactura(this));
        JB[8].setEnabled(false);
        JB[8].setBounds(430, 20,100,25);
        JP[3].add(C);
        JP[3].add(JT[13]);
        JP[3].add(JB[8]);
        
        modelo=new DefaultTableModel();
        modelo.addColumn("Id_Producto");
        modelo.addColumn("Nombre_Producto");
        modelo.addColumn("Nombre_Cientifico");
        modelo.addColumn("Forma_Farmaceutica");
        modelo.addColumn("Cantidad_Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        
        Valuacion2= new JTable(modelo);

        JScrollPane scr2=new JScrollPane(Valuacion2);

        //establece el tamaño del puerto de vista desplazable
        Valuacion2.setPreferredScrollableViewportSize(new Dimension(800,150));
        Valuacion2.setEnabled(false);
        scr2.setBounds(10, 60, 540,130);
        JP[3].add(scr2);
        
        JCK[2]= new JCheckBox("Agregar Producto");
        JCK[2].setEnabled(false);
        JCK[2].setBounds(180,210,150,30);
        JCK[2].addActionListener(new Control.ControlVistaFactura(this));
        JP[3].add(JCK[2]);
        
        JB[4]= new JButton("Agregar a Compra");
       JB[4].setEnabled(false);
    //  JB[4].setBounds(350,210,150,25);
        JP[3].add(JB[4]);
        //+++++++++++++++++++++++++ Panel Compras +++++++++++++++++++++++++++++++
        modelo2= new DefaultTableModel();
        modelo2.addColumn("Nombre_Producto");
        modelo2.addColumn("Forma_Farmaceutica");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("Precio");
        modelo2.addColumn("Cantidad Compra");
        modelo2.addColumn("Subtotal");
        
        
        //Construir la Tabla con el constructor (cadena,matriz de objetos)
        Valuacion=new JTable(modelo2);
        
        
        
        //agragar la tabla a un panel de desplazamiento
        JScrollPane scr=new JScrollPane(Valuacion);
        //establece el tamaño del puerto de vista desplazable
        Valuacion.setPreferredScrollableViewportSize(new Dimension(800,150));
        Valuacion.setEnabled(false);
        scr.setBounds(10, 15, 540,130);
        JP[4].add(scr);
        
        JCK[3]= new JCheckBox("Quitar Producto");
        JCK[3].setEnabled(false);
        JCK[3].setBounds(350,185,150,25);
        JCK[3].addActionListener(new Control.ControlVistaFactura(this));
        JP[4].add(JCK[3]);
        
        JB[5]= new JButton("Quitar Producto");
        JB[5].setEnabled(false);
        JB[5].addActionListener(new ControlVistaFactura(this));
        //JB[5].setBounds(360,145,150,25);
        //JP[4].add(JB[5]);
        
        JB[6]= new JButton("Limpiar");
        JB[6].setEnabled(false);
        JB[6].addActionListener(new ControlVistaFactura(this));
        JB[6].setBounds(30,185,100,25);
        JP[4].add(JB[6]);
        
        JB[7]= new JButton("Imprimir");
        JB[7].addActionListener(new ControlVistaFactura(this));
        JB[7].setEnabled(false);
        JB[7].setBounds(190,185,100,25);
        JP[4].add(JB[7]);
        
        JB[9]= new JButton("Limpiar Todo");
        JB[9].addActionListener(new ControlVistaFactura(this));
        JB[9].setEnabled(false);
        //JB[5].setBounds(350,185,150,25);
        JP[4].add(JB[5]);
        
        JL[14] = new JLabel("Precio Total: ");
        JL[14].setBounds(10,145,100,20);
        JT[14].setBounds(90,147,100,20);

        //JT[14].setEnabled(false);
        JP[4].add(JL[14]);
        JP[4].add(JT[14]);

        //++++++++++++++++ Panel Tarjeta++++++++++++++++++++++++++++++++++++++++++++++
        JCK[0] = new JCheckBox("Tarjeta Farmaceutica");
        JCK[0].addActionListener(new ControlVistaFactura(this));
        JCK[0].setBounds(10,75, 150, 25);
        JCK[1] = new JCheckBox("Registrar Cliente");
        JCK[1].addActionListener(new ControlVistaFactura(this));
        JCK[1].setBounds(10,190,150, 25);
        JP[0].setBorder(BorderFactory.createTitledBorder("Tarjeta Farmaceutica"));
        JP[0].setBounds(10,100,400,80);
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos Del Cliente"));
        JP[1].setBounds(10,220,400,270);
        JP[2].setBorder(BorderFactory.createTitledBorder("Datos Del Empleado"));
        JP[2].setBounds(10,500,400,90);
        JP[3].setBorder(BorderFactory.createTitledBorder("Consultas de Productos"));
        JP[3].setBounds(430,100,570,250);
        
        JP[4].setBorder(BorderFactory.createTitledBorder("Lista de Compras"));
        JP[4].setBounds(430,370,570,230);
        
        add(JCK[0]);
        add(JCK[1]);
        add(JL[0]);
        add(JL[1]);
        add(JL[2]);
        add(JP[0]);
        add(JP[1]);
        add(JP[2]);
        add(JP[3]);
        add(JP[4]);
    } 
    /*
    public static void main (String Args[]){
            try{


                UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                LiquidLookAndFeel.setLiquidDecorations(true, "panther");
            }
            catch(Exception e){}        
        Vista_Factura Vf = new Vista_Factura();
        Vf.Disenio();
        Vf.setVisible(true);
        Vf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }*/
}
