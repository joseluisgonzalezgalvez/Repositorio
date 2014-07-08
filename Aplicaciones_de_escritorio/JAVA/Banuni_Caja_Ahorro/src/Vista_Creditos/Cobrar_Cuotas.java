package Vista_Creditos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Operaciones.Operaciones;

/**
 *
 * @author Administrador
 */
@SuppressWarnings({ "serial", "unused" })
public class Cobrar_Cuotas extends JPanel{
    public JPanel JP[]= new JPanel[10];
    public JTextField JT[]= new JTextField[20];
    public JLabel JL[]= new JLabel[20];
    public JButton JB[]= new JButton[7];
    @SuppressWarnings("rawtypes")
	public JComboBox fecha;
    public JTable Valuacion;
    public JTable Valuacion2;
    public DefaultTableModel modelo;
    public JTable Valuacion3;
    public DefaultTableModel modelo2;  
    ResultSet r1;
    Operaciones op=new Operaciones();
    
    public void Llenar_Tabla_Base_Datos(ResultSet R){
        Object [] fila;
    try{
           op.conectar();
           	r1=R;
            while (r1.next()){
                 fila = new Object[6];
                 for (int i=0;i<6;i++)
                        fila[i] = r1.getObject(i+1);
             modelo.addRow(fila);
            }
           op.desconectar();
    }catch(SQLException e){}
  } 
    public void Borrar_Cuotas(){
            int i = modelo2.getRowCount();
            for(int m=i-1;m>=0;m--){
                  
          	  modelo2.removeRow(m);
            }
    }
    public void Llenar_Tabla_Cuotas(ResultSet R){
        Object [] fila;
    try{
           op.conectar();
           	r1=R;
            while (r1.next()){
                 fila = new Object[9];
                 for (int i=0;i<9;i++)
                        fila[i] = r1.getObject(i+1);
             modelo2.addRow(fila);
            }
           op.desconectar();
    }catch(SQLException e){}
  } 
    public void Borrar_Creditos(){
            int i = modelo.getRowCount();
            for(int m=i-1;m>=0;m--){
                  
          	  modelo.removeRow(m);
            }
    }
    
    public Cobrar_Cuotas(){
        Disenio();
    }
    @SuppressWarnings("deprecation")
	public void Disenio() {
        setLayout(null);
        setSize(850,540);
        for(int i=0; i<10;i++){
            JP[i]= new JPanel();
            JP[i].setLayout(null);
        }
        for(int i=0; i<20;i++){
            JT[i]= new JTextField();
            //JL[i]= new JLabel();
        }
        //******************* Panel 0 ******************************************
        JL[0] = new JLabel("Cliente");
        JB[0] = new JButton("Buscar");
        JL[0].setBounds(10, 20, 100, 20);
        JT[0].setBounds(60,23,100,20);
        JB[0].setBounds(680,23,100,25);
        JB[0].addActionListener(new Control.control_cobrar_cuotas(this));
        JP[0].add(JL[0]);
        JP[0].add(JT[0]);
        JP[0].add(JB[0]);
        //******************* Panel 1 ******************************************
        JL[1]= new JLabel("Cuotas a cobrar");
        JL[2]= new JLabel("Finalizadas");
        JL[3]= new JLabel("Pendientes");
        JL[4]= new JLabel("Morosos");
        JL[5]= new JLabel("Saldo $");

        
        modelo=new DefaultTableModel();
        modelo.addColumn("Id Prestamo");
        modelo.addColumn("Interes");
        modelo.addColumn("Monto Prestado");
        modelo.addColumn("Fecha Prestamo");
        modelo.addColumn("Periodo Pago");
        modelo.addColumn("Estado");
        
        Valuacion2= new JTable(modelo);
        
        JScrollPane scr=new JScrollPane(Valuacion2);
        Valuacion2.setPreferredScrollableViewportSize(new Dimension(800,150));
        scr.setBounds(10, 30,780,60);
        //Valuacion2.enable(false);
        Valuacion2.addMouseListener(new Control.control_cobrar_cuotas(this));
        JP[1].add(scr);
        JP[4].setLayout(new GridLayout());
        modelo2=new DefaultTableModel();
        modelo2.addColumn("Numero");
        modelo2.addColumn("Id prestamo");
        modelo2.addColumn("Fecha de registro");
        modelo2.addColumn("Fecha de pago");
        modelo2.addColumn("Interés");
        modelo2.addColumn("Abono");
        modelo2.addColumn("Pago");
        modelo2.addColumn("Deuda");
        modelo2.addColumn("Estado");
        Valuacion3= new JTable(modelo2);
        JScrollPane scr2=new JScrollPane(Valuacion3);
        Valuacion3.setPreferredScrollableViewportSize(new Dimension(800,150));
        //scr.setBounds(10, 30,780,60);
        Valuacion3.addMouseListener(new Control.control_cobrar_cuotas(this));
        //Valuacion3.enable(false);
        JP[4].add(scr2);
      /*  JL[1].setBounds(10,160,100,30);
        JL[2].setBounds(210,160,100,30);
        JL[3].setBounds(319,160,100,30);
        JL[4].setBounds(438,160,100,30);
        JL[5].setBounds(640,160,100,30);
        JT[1].setBounds(115,167,50,20);
        JT[2].setBounds(180,167,20,20);
        JT[3].setBounds(290,167,20,20);
        JT[4].setBounds(408,167,20,20);
        JT[5].setBounds(690,167,100,20);
        JT[2].setBackground(Color.BLACK);
        JT[3].setBackground(Color.BLUE);
        JT[4].setBackground(Color.red);*/
        JP[1].add(scr);
        JP[1].add(JL[1]);
        JP[1].add(JL[2]);
        JP[1].add(JL[3]);
        JP[1].add(JL[4]);
        JP[1].add(JL[5]);
        JP[1].add(JT[2]);
        JP[1].add(JT[1]);
        JP[1].add(JT[3]);
        JP[1].add(JT[4]);
        JP[1].add(JT[5]);
        //******************* Panel 2 ******************************************
        JL[6] = new JLabel("Abono $");
        JL[7] = new JLabel("Interés $");
        JL[8] = new JLabel("Clave del pago:");
        JL[9] = new JLabel("Fecha de pago:");
        JL[6].setBounds(10, 25, 135, 30);
        JL[7].setBounds(10, 60, 135, 30);
        JL[8].setBounds(10, 95, 135, 30);
        JL[9].setBounds(10, 130, 135, 30);
        JT[6].setBounds(160,30, 150, 20);
        JT[7].setBounds(160,65, 150, 20);
        JT[8].setBounds(160,100, 150, 20);
        JT[9].setBounds(160,135, 150, 20);
        JT[6].setEditable(false);
        JT[7].setEditable(false);
        JT[8].setEditable(false);
        JT[9].setEditable(false);
        
        for(int i=6; i<10;i++){
            JP[2].add(JL[i]);
            JP[2].add(JT[i]);    
        }
        
        //******************* Panel 3 ******************************************
        JB[1]= new JButton("Guardar Cobro");
        JB[2]= new JButton("Limpiar");
        JB[3]= new JButton("Cerrar");
        JB[1].setBounds(30, 30,130, 25);
        JB[2].setBounds(43, 60,100, 25);
        JB[3].setBounds(43, 90,100, 25);
        JB[1].addActionListener(new Control.control_cobrar_cuotas(this));
        JP[3].add(JB[1]);
        //**********************************************************************
        JP[0].setBorder(BorderFactory.createTitledBorder("Seleccionar cliente para cobrar las cuotas"));
        JP[1].setBorder(BorderFactory.createTitledBorder("Prestamos Totales"));
        JP[4].setBorder(BorderFactory.createTitledBorder("Lista de Cuotas"));
        JP[2].setBorder(BorderFactory.createTitledBorder("Valores"));
        JP[3].setBorder(BorderFactory.createTitledBorder("Acciones"));
        JP[0].setBounds(20, 10, 800, 60);
        JP[1].setBounds(20, 70, 800, 100);
        JP[4].setBounds(20, 170, 800, 170);
        JP[2].setBounds(20, 340, 400, 170);
        JP[3].setBounds(430,340,200,170);
        for(int i=0; i<10;i++){
            add(JP[i]);
        }
        setVisible(true);
        
    }
    /*
    public static void main(String Args[]){
            try{
                
                
                UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                LiquidLookAndFeel.setLiquidDecorations(true, "panther");
            }
            catch(Exception e){}
            SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Cobrar_Cuotas().setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );;
            }
        });
    }*/
}
