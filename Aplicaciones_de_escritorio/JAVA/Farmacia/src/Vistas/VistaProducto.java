/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tiago
 */
public class VistaProducto extends JPanel{
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
    public JLabel Mesagito;
    public JTextField Imagen;
    ResultSet r1;
    Base_Datos.Sentecias_BD Op = new Base_Datos.Sentecias_BD();
    public VistaProducto(){
        Disenio();
        LlenarCombo();
    }
    public void Disenio() {
        setLayout(null);
        setSize(1024,520);
        //***************** creamos los paneles  *******************************
        for(int i=0; i<10;i++){
                JP[i]= new JPanel();
                JP[i].setLayout(null);
        }
        for(int i=0; i<20; i++){
            JT[i]= new JTextField();
        }
        //-------------- Crear Labels ------------------------------------------
        //++++ datos de la tabla Producto
        Jl[0]= new JLabel("Nombre Producto: ");
        Jl[1]= new JLabel("Nombre Generico: ");
        Jl[2]= new JLabel("Tipo: ");
        Jl[3]= new JLabel("Caducidad: ");
        Jl[4]= new JLabel("Cantidad En Frasco: ");
        Jl[5]= new JLabel("Precio: ");
        
        Mesagito = new JLabel("Imagen");
        Mesagito.setBounds(20, 255,130,40);
        JP[1].add(Mesagito);
        
        Imagen = new JTextField();
        Imagen.setBounds(150, 263, 150, 20);
        JP[1].add(Imagen);
        
        Jl[6]= new JLabel("Clasificacion: ");
        //+++++++ datos de la tabla almacen
        Jl[7]= new JLabel("Cantidad: ");
        Jl[8]= new JLabel("Existencia Minima: ");
        Jl[9]= new JLabel("Existencia Maxima: ");
        //+++++++ datos del proveerdor
        Jl[10]= new JLabel("Id_Proveedor: ");
        Jl[11]= new JLabel("Nombre Proveedor: ");
        Jl[12]= new JLabel("Empresa: ");
        //---------------- Posicionarlos----------------------------------------
        Jl[0].setBounds(20, 25,130,40);
        Jl[1].setBounds(20, 65,130,40);
        Jl[2].setBounds(20, 105,130,40);
        Jl[3].setBounds(20, 145,130,40);
        Jl[4].setBounds(20, 185,130,40);
        Jl[5].setBounds(20, 225,130,40);
        Jl[6].setBounds(20, 265,130,40);

        Jl[7].setBounds(5, 20,130,40);
        Jl[8].setBounds(5, 60,130,40);
        Jl[9].setBounds(5, 100,130,40);

        Jl[10].setBounds(5, 12,130,40);
        Jl[11].setBounds(5, 60,130,40);
        Jl[12].setBounds(5, 100,130,40);
        for(int i=0;i<13;i++){
            Jt[i]= new JTextField();
        }
        //--------- Posicionando las cajas de Textos ---------------------------
         //JT[0] = new JTextField("Este es JT[0+");
        Jt[0].setBounds(150, 33, 150, 20);
        Jt[1].setBounds(150, 73, 150, 20);
        A = new JComboBox();
        A.addItem("");
        A.addItem("Jarabe");
        A.addItem("Tabletas");
        A.addItem("Gel Pomada");
        A.addItem("Solucion");
        A.addItem("Inyectable");
        A.setBounds(150, 113, 150, 20);
        A.addItemListener(new Control.ControlVistaProductos(this));
        Jt[3].setBounds(150, 153, 110, 20);
        Jt[3].setEnabled(false);
        
        JT[1].setBounds(30, 90, 110, 20);
        JT[2].setBounds(30, 120, 110, 20);
        JT[1].setVisible(false);
        JT[2].setVisible(false);
        
        //Jt[3].setEnabled(false);
        JB[1]= new JButton("*");
        JB[0]= new JButton("*");
        JB[2]= new JButton("*");
        JB[1].setBounds(260, 153, 40, 20);
        JB[0].setBounds(140, 90, 40, 20);
        JB[0].setVisible(false);
        JB[2].setVisible(false);
        JB[2].setBounds(140, 120, 40, 20);
        JB[1].addActionListener(new Vista_Calendario(this));
        JB[0].addActionListener(new Vista_Calendario2(this));
        JB[2].addActionListener(new Vista_Calendario3(this));
        JP[1].add(JB[1]);
        
        
        val = new JComboBox();
        val.addItem("");
        val.addItem("ml");
        val.addItem("grms");
        
        val.setBounds(225, 193, 75, 20);
        
        ml = new JComboBox();
        ml.addItem("");
        ml.addItem("50");
        ml.addItem("75");
        ml.addItem("100");
        ml.addItem("125");
        ml.addItem("150");
        ml.addItem("200");
        ml.addItem("250");
        ml.addItem("375");
        ml.addItem("500");
        ml.addItem("750");
        ml.addItem("1000");
        ml.addItem("1500");
        ml.addItem("2000");
        ml.setBounds(150, 193, 75, 20);
        
        //Jt[4].setBounds(150, 193, 150, 20);
        
        
        Jt[5].setBounds(150, 233, 150, 20);
        Jt[6].setBounds(150, 273, 150, 20);


        Jt[7].setBounds(140, 28, 100, 20);
        Jt[8].setBounds(140, 68, 100, 20);
        Jt[9].setBounds(140, 108, 100, 20);

        B = new JComboBox();
        JB[12] = new JButton("Actualizar Provedor");
        JB[12].setEnabled(false);
        JB[12].addActionListener(new Control.ControlVistaProductos(this));
        //B.addItem("");
        //B.addItem("Agregar Nuevo");
        B.addItemListener(new Control.ControlVistaProductos(this));
        B.setBounds(140, 20, 100, 20);
        JB[12].setBounds(50, 45, 150, 23);
        Jt[11].setBounds(140, 75, 100, 20);
        Jt[12].setBounds(140, 115, 100, 20);
        
        D = new JComboBox();
        D.addItem("");
        D.addItem("Jarabe");
        D.addItem("Tabletas");
        D.addItem("Gel Pomada");
        D.addItem("Solucion");
        D.addItem("Inyectable");
        D.setBounds(30,100 ,140, 20);
        D.setVisible(false);
        D.addItemListener(new Control.ControlVistaProductos(this));
        
        C = new JComboBox();
        C.addItem("");
        C.addItem("Id_Producto");
        C.addItem("Nombre_Producto");
        C.addItem("Forma_Farmaceutica");
        C.addItem("Fecha_Caducidad");
        C.addItem("Precio");
        C.addItem("Cantidad_Producto");
        C.addItem("Existencia_Minima");
        C.addItem("Existencia_Maxima");
        C.addActionListener(new Control.ControlVistaProductos(this));
        C.setBounds(30,50 ,140, 20);
        JT[0].setBounds(30,100 ,140, 20);

        JP[7].add(C);
        JP[7].add(D);
        JT[0].setEnabled(false);
        JP[7].add(JT[0]);
        JP[7].add(JT[1]);
        JP[7].add(JT[2]);
        JP[7].add(JB[0]);
        JP[7].add(JB[2]);

        JP[1].add(val);
        JP[1].add(ml);
        for(int i=0; i<6;i++){
            JP[1].add(Jl[i]);
            if(i!=2){
                JP[1].add(Jt[i]);
            }

        }
        JP[1].add(A);
        for(int i=7; i<10;i++){
                JP[2].add(Jl[i]);
                JP[2].add(Jt[i]);
        }
        JP[4].add(B);
        JP[4].add(JB[12]);
        for(int i=10; i<13;i++){
            JP[4].add(Jl[i]);
            if(i!=10)
                Jt[i].setEnabled(false);
                JP[4].add(Jt[i]);

        }
        //***************** Componentes del Panel 3 como entregar el money *****
        modelo=new DefaultTableModel();
        modelo.addColumn("Id_Producto");
        modelo.addColumn("Nombre_Producto");
        modelo.addColumn("Nombre_Cientifico");
        modelo.addColumn("Forma_Farmaceutica");
        modelo.addColumn("Fecha_Caducidad");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad_Producto");
        modelo.addColumn("Existencia_Minima");
        modelo.addColumn("Existencia_Maxima");
        modelo.addColumn("Imagen");
        Valuacion2= new JTable(modelo);

        JScrollPane scr=new JScrollPane(Valuacion2);

        Valuacion2.setPreferredScrollableViewportSize(new Dimension(800,150));
        Valuacion2.setEnabled(false);
        scr.setBounds(10, 15, 960,130);
        JP[3].add(scr);
        //**********************************************************************
        JB[3]= new JButton("Agregar Proveedor");
        JB[3].setEnabled(false);
        JB[5]= new JButton("Agregar Producto");
        JB[6]= new JButton("      Buscar     ");
        JB[6].setEnabled(false);
        JB[7]= new JButton("Modificar/Eliminar");
        
        Validax= new JCheckBox("Modificar/Eliminar");
        Validax.addActionListener(new Control.ControlVistaProductos(this));
        Validax.setEnabled(false);
        Validax.setBounds(180, 50, 160, 25);
        JP[5].add(Validax);
        
        JB[7].setEnabled(false);
        JB[4]= new JButton("Limpiar Formulario");
        JB[4].setEnabled(true);
        JB[8]= new JButton("Guardar Modificacion");
        JB[8].setEnabled(false);
        JB[9]= new JButton("Eliminar Producto");
        JB[9].setEnabled(false);
        Veri= new JCheckBox("Todos Productos");
        //Veri.setEnabled(false);
        Veri.setBounds(180, 80, 160, 25);
        Veri.addActionListener(new Control.ControlVistaProductos(this));
        //JB[3].setBounds(10, 20, 160, 25);
        JB[4].setBounds(10, 50, 160, 25);
        JB[5].setBounds(10, 80, 160, 25);
        for(int i=3; i<10;i++){
            JB[i].addActionListener(new Control.ControlVistaProductos(this));
        }
        JB[6].setBounds(180, 20, 160, 25);
        //JB[7].setBounds(180, 50, 160, 25);
        //JB[8].setBounds(180, 80, 160, 25);
      //  JB[9].setBounds(180, 110, 160, 25);
        JP[5].add(JB[3]);
        JP[5].add(JB[6]);
        JP[5].add(JB[4]);
        JP[5].add(JB[5]);
        JP[5].add(JB[7]);
        JP[5].add(JB[8]);
        JP[5].add(JB[9]);
        JP[5].add(Veri);
        //***************** Establecemos los tamaños y puestos *****************
        JP[0].setBounds(10, 10,630,330);
        JP[1].setBounds(5, 15,350,300);
        JP[2].setBounds(365, 15,250,150);
        JP[4].setBounds(365, 170,250,145);
        JP[5].setBounds(650,190,350,150);
        
        //JP[6].setLayout( new GridLayout());
        JL[0] = new JLabel(new ImageIcon( "Logito2.jpg" ));
        JL[0].setBounds(5,10,140,165);
        JP[6].add(JL[0]);
        JP[6].setBounds(850,10,150,175);
        JP[7].setBounds(650,10,200,175);
        JP[3].setBounds(10, 340, 990, 170);
        JP[0].setBorder(BorderFactory.createTitledBorder("Productos"));
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
        JP[2].setBorder(BorderFactory.createTitledBorder("Datos de la Bodega"));
        JP[4].setBorder(BorderFactory.createTitledBorder("Datos del Proveedor"));
        JP[5].setBorder(BorderFactory.createTitledBorder("Acciones"));
        JP[0].add(JP[1]);
        JP[0].add(JP[2]);
        JP[0].add(JP[4]);
        JP[3].setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        JP[6].setBorder(BorderFactory.createTitledBorder("Farmacias del Istmo"));
        JP[7].setBorder(BorderFactory.createTitledBorder("Consultas"));
        add(JP[0]);
        add(JP[3]);
        add(JP[5]);
        add(JP[6]);
        add(JP[7]);

    }
    public void LlenarCombo(){
                try{
                    Op.Open();
//                    B.removeAllItems();
                    r1= Op.Consulta_Clave_Provedor();
                    while(r1.next()){
                        B.addItem(String.valueOf(r1.getInt(1)));
                    }
                }
                catch(SQLException e){}
                Op.Close();
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
                        fila = new Object[11]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                 for (int i=0;i<11;i++)
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
}
