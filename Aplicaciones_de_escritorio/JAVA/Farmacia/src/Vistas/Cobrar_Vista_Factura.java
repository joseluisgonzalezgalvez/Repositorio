/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

//import com.birosoft.liquid.LiquidLookAndFeel;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Administrador
 */
public class Cobrar_Vista_Factura extends JPanel{
    public JPanel JP[]= new JPanel[5];
    public JButton JB[]= new JButton[20];
    public JTextField JT[]= new JTextField[20];
    JLabel JL[]= new JLabel[20];
    public JCheckBox JCK[]= new JCheckBox[4];
    public JComboBox C;
    public JTable Valuacion2,Valuacion;
    public Cobrar_Vista_Factura(){
        Disenio();
    }
    public void Disenio() {
        setLayout(null);
        setSize(1020,580);
        for(int i=0;i<5;i++){
            JP[i] = new JPanel();
            JP[i].setLayout(null);
        }
        for(int i=0;i<20;i++){
            JT[i] = new JTextField();
        }
        //++++++++++++++++ Titulo ++++++++++++++++++++++++++++++++++++++++++++++
        JL[0]= new JLabel("FARMACIAS DEL ISTMO");
        JL[1]= new JLabel("       Sucursal Ixtepec");
        JL[2]= new JLabel("Calle Vicente Guerrero, Avenida Hidalgo Nº 90");
        JL[0].setBounds(435,5,150,30);
        JL[1].setBounds(435,25,150,30);
        JL[2].setBounds(370,45,300,30);
        
        //++++++++++++++++ Panel Tarjeta++++++++++++++++++++++++++++++++++++++++++++++
        
        JL[3]= new JLabel("Numero de Venta ");
        JL[3].setBounds(10,30, 120,30);
        JT[0].setBounds(140,35, 120,25);
        JB[0] = new JButton("Buscar");
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
        JL[9] = new JLabel("Numero Telefonico: ");
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
        C.addItem("Id");
        C.addItem("Nombre");
        C.addItem("Tipo");
        C.addItem("Caducidad");
        C.addItem("Precio");
        C.addItem("Cantidad");
        C.addItem("Cantidad Minima");
        C.addItem("Cantidad Maxima");
        C.setBounds(10,20 ,140, 20);
        JT[13].setBounds(160,20,250, 20);
        JB[4] = new JButton("Buscar");
        JB[4].setBounds(430, 20,100,25);
        JP[3].add(C);
        JP[3].add(JT[13]);
        JP[3].add(JB[4]);
        String encabezados2[] ={"Id","Nombre","Nombre Generico","Tipo","Cantidad (ml)(grms)","Precio","Cantidad nº"};
        Object[][] datos2={
            {1,"Aspirina","Acido Acetalisilico","Tabletas","1500 ml",190,40},
            {1,"Aspirina","Acido Acetalisilico","Tabletas","1500 ml",190,40},
            {1,"Aspirina","Acido Acetalisilico","Tabletas","1500 ml",190,40},
            {1,"Aspirina","Acido Acetalisilico","Tabletas","1500 ml",190,40},
            {1,"Aspirina","Acido Acetalisilico","Tabletas","1500 ml",190,40},
            {1,"Aspirina","Acido Acetalisilico","Tabletas","1500 ml",190,40},
            {1,"Aspirina","Acido Acetalisilico","Tabletas","1500 ml",190,40},
            {1,"Aspirina","Acido Acetalisilico","Tabletas","1500 ml",190,40},
        };
        //Construir la Tabla con el constructor (cadena,matriz de objetos)
        Valuacion2=new JTable(datos2,encabezados2);
        //agragar la tabla a un panel de desplazamiento
        JScrollPane scr2=new JScrollPane(Valuacion2);
        //establece el tamaño del puerto de vista desplazable
        Valuacion2.setPreferredScrollableViewportSize(new Dimension(800,150));
        scr2.setBounds(10, 60, 540,110);
        JP[3].add(scr2);
        
        JCK[2]= new JCheckBox("Seleccionar Producto");
        JCK[2].setBounds(180,210,150,30);
        JP[3].add(JCK[2]);
        
        JB[4]= new JButton("Agregar a Compra");
        JB[4].setBounds(350,210,150,25);
        JP[3].add(JB[4]);
        //+++++++++++++++++++++++++ Panel Compras +++++++++++++++++++++++++++++++
        String encabezados[] ={"Nombre","Tipo","Cantidad (ml)(grms)","Precio","Cantidad","SubTotal"};
        Object[][] datos={
            {"Aspirina","Tabletas","1500 ml",190,1,190},
            {"Alcohol","Tabletas","1500 ml",190,2,380},
            {"Mertiolate","Tabletas","1500 ml",190,1,190},
            {"Vendas","Tabletas","1500 ml",190,2,380},
            {"Medicina","Tabletas","1500 ml",190,1,190},
            {"Capsulas","Tabletas","1500 ml",190,5,950},
        };
        //Construir la Tabla con el constructor (cadena,matriz de objetos)
        Valuacion=new JTable(datos,encabezados);
        //agragar la tabla a un panel de desplazamiento
        JScrollPane scr=new JScrollPane(Valuacion);
        //establece el tamaño del puerto de vista desplazable
        Valuacion.setPreferredScrollableViewportSize(new Dimension(800,150));
        Valuacion.setEnabled(false);
        scr.setBounds(10, 15, 540,400);
        JP[4].add(scr);
        
        JCK[3]= new JCheckBox("Seleccionar Producto");
        JCK[3].setBounds(200,145,150,20);
        //JP[4].add(JCK[3]);
        
        JB[5]= new JButton("Quitar Producto");
        JB[5].setBounds(360,470,150,25);
        //JP[4].add(JB[5]);
        
        JB[6]= new JButton("Limpiar");
        JB[6].setBounds(100,470,100,25);
        JP[4].add(JB[6]);
        
        JB[7]= new JButton("Cobrar");
        JB[7].setBounds(190,470,100,25);
        //JP[4].add(JB[7]);
        
        JB[5]= new JButton("Cobrar");
        JB[5].setBounds(350,470,150,25);
        JP[4].add(JB[5]);
        
        JL[14] = new JLabel("Precio Total: ");
        JL[14].setBounds(10,440,100,20);
        JT[14].setBounds(90,440,100,20);

        JL[15] = new JLabel("Efectivo: ");
        JL[15].setBounds(210,440,100,20);
        JT[15].setBounds(260,440,100,20);

        JL[16] = new JLabel("Cambio: ");
        JL[16].setBounds(380,440,100,20);
        JT[16].setBounds(430,440,100,20);
        
        JT[14].setEnabled(false);
        JP[4].add(JL[14]);
        JP[4].add(JT[14]);
        JP[4].add(JL[15]);
        JP[4].add(JT[15]);
        JP[4].add(JL[16]);
        JP[4].add(JT[16]);
        //++++++++++++++++ Panel Tarjeta++++++++++++++++++++++++++++++++++++++++++++++
        JCK[0] = new JCheckBox("Tarjeta Farmaceutica");
//        JCK[0].setBounds(10,130, 150, 25);
        JCK[1] = new JCheckBox("Registrar Cliente");
//        JCK[1].setBounds(10,250,150, 25);
        JP[0].setBorder(BorderFactory.createTitledBorder("Buscar Venta"));
        JP[0].setBounds(10,80,400,80);
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos Del Cliente"));
        JP[1].setBounds(10,180,400,270);
        JP[2].setBorder(BorderFactory.createTitledBorder("Datos Del Empleado"));
        JP[2].setBounds(10,480,400,90);
        JP[3].setBorder(BorderFactory.createTitledBorder("Consultas"));
        JP[3].setBounds(430,160,560,250);
        
        JP[4].setBorder(BorderFactory.createTitledBorder("Lista de Compras"));
        JP[4].setBounds(430,80,570,500);
        
        add(JCK[0]);
        add(JCK[1]);
        add(JL[0]);
        add(JL[1]);
        add(JL[2]);
        add(JP[0]);
        add(JP[1]);
        add(JP[2]);
      //  add(JP[3]);
        add(JP[4]);
    } 
    /*
    public static void main (String Args[]){
            try{


                UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                LiquidLookAndFeel.setLiquidDecorations(true, "panther");
            }
            catch(Exception e){}        
        Cobrar_Vista_Factura Vf = new Cobrar_Vista_Factura();
        Vf.Disenio();
        Vf.setVisible(true);
        Vf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }*/
}
        