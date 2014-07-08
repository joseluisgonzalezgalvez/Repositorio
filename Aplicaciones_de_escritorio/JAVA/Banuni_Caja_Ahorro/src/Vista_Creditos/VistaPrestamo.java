/*
                                          * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista_Creditos;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Base_Datos.Sentencias;
import Vista_Creditos.ManejadorFechas;

/**
 *
 * @author Tiago
 */
@SuppressWarnings("serial")
public class VistaPrestamo extends JPanel implements Runnable{
  public JPanel JP[]= new JPanel[7];
  public   JButton JB[]= new JButton[10];
  public JTextField JT[]= new JTextField[20];
  public JLabel JL[]= new JLabel[20];
  public JTable Valuacion2;
  public DefaultTableModel modelo;
  public JTable Valuacion3;
  public DefaultTableModel modelo2;  
  public JLabel etiquetitas[] = new JLabel[10];
  public JTextField cajitas[] = new JTextField[20];
  public JPanel panelito = new JPanel();
  public static int Codigo_Empleado;
  Color xx = new Color(102,205,0);
  @SuppressWarnings("rawtypes")
  public JComboBox Interes;
  @SuppressWarnings("rawtypes")
  public JComboBox Plazos;
  public Base_Datos.Sentencias Op = new Sentencias();
  ResultSet r1;
  public void Borrar(){
	                int i = modelo.getRowCount();
	                for(int m=i-1;m>=0;m--){
	                        modelo.removeRow(m);
	                }
  }
  public VistaPrestamo(){
        Disenio();
        h1 = new Thread(this);
        h1.start();     
    }
  
  public void Llenar_Tabla_Base_Datos(ResultSet R){
      Object [] fila;
  try{
         Op.Open();
         r1=R;
          while (r1.next()){
               fila = new Object[8];
               for (int i=0;i<8;i++)
                      fila[i] = r1.getObject(i+1);
           modelo2.addRow(fila);
          }
         Op.Close();
  }catch(SQLException e){}
} 
  public void Borrar_Creditos(){
          int i = modelo2.getRowCount();
          for(int m=i-1;m>=0;m--){
                
        	  modelo2.removeRow(m);
          }
  }
  
  
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public void Disenio() {
        setLayout(null);
        setSize(1025,570);
        //***************** creamos los paneles  *******************************
        for(int i=0; i<6;i++){
                JP[i]= new JPanel();
                JP[i].setLayout(null);
        }
        for(int i=0; i<20; i++){
            JT[i]= new JTextField();
            cajitas[i]= new JTextField();
            cajitas[i].setEnabled(false);
        }
        //***************** componentes del panel 1 ****************************
        JL[0] = new JLabel("Cliente:");
        JB[1] = new JButton("Verificar");
        JB[0] = new JButton("Buscar");
        JL[0].setBounds(10, 25, 100, 20);
        
        JB[0].addActionListener(new Control.Control_Vista_Prestamos(this));
        JT[0].setBounds(70,23,210,25);
        JB[0].setBounds(350,23,80,25);
       //JB[1].setBounds(390,23,80,25);
        
        etiquetitas[0] = new JLabel("Id Cliente: ");
        etiquetitas[1] = new JLabel("Nombre: ");
        etiquetitas[2] = new JLabel("Direccion: ");
        etiquetitas[3] = new JLabel("Estado Crediticio: ");
        etiquetitas[4] = new JLabel("Ciudad Actual: ");
        etiquetitas[0].setBounds(10, 50, 100, 30);
        cajitas[0].setBounds(70, 50, 50, 25);
        etiquetitas[1].setBounds(10, 80, 100, 30);
        cajitas[1].setBounds(70, 80, 180, 25);
        etiquetitas[2].setBounds(10, 110, 100, 30);
        cajitas[2].setBounds(70, 110, 180, 25);
        etiquetitas[3].setBounds(255, 80, 110, 30);
        cajitas[3].setBounds(355, 80, 125, 25);
        etiquetitas[4].setBounds(255, 110, 100, 30);
        cajitas[4].setBounds(355, 110, 125, 25);
        JP[0].add(etiquetitas[0]);
        JP[0].add(cajitas[0]);
        JP[0].add(etiquetitas[1]);
        JP[0].add(cajitas[1]);
        JP[0].add(etiquetitas[2]);
        JP[0].add(cajitas[2]);
        JP[0].add(etiquetitas[3]);
        JP[0].add(cajitas[3]);
        JP[0].add(etiquetitas[4]);
        JP[0].add(cajitas[4]);
        JP[0].add(JL[0]);
        JP[0].add(JT[0]);
        JP[0].add(JB[0]);
        JP[0].add(JB[1]);
        //**************** componentes del panel 2 *****************************
        JL[1] = new JLabel("Id:");
        JL[2] = new JLabel("Fecha del Crédito:");
        JL[3] = new JLabel("Interes:");
        JL[4] = new JLabel("%");
        JL[5] = new JLabel("Importe	:");
        JL[6] = new JLabel("Pago Acordado:");
        JL[7] = new JLabel("Periodo:");
        JL[8] = new JLabel("Vencimiento de la primera cuota");
        JL[2].setBounds(10, 28, 140, 20);
        JL[1].setBounds(410, 28, 80, 25);
        //JL[2].setBounds(140, 28, 140, 20);
        JL[3].setBounds(285, 28, 90, 20);
        JL[4].setBounds(395, 28, 50,20);
        JT[1].setBounds(330, 23, 50, 25);
        JT[6].setBounds(430, 23, 50, 25);
        JT[2].setEnabled(false);
        JT[2].setBounds(125, 23, 130, 25); // caja de texto de fechas
        
        
        
        Interes= new JComboBox();
        Interes.addItem("");
        Interes.addItem("2.5");
        Interes.addItem("3");
        Interes.addItem("3.5");
        Interes.addItem("4");
        Interes.addItem("4.5");
        Interes.addItem("5");
        //Interes.setBounds(400, 23, 60, 25);
        Plazos= new JComboBox();
        Plazos.addItem("");
        Plazos.addItem("Semanal");
        Plazos.addItem("Quincenal");
        Plazos.addItem("Mensual");
        ///Plazos.setBounds(400, 23, 60, 25);
        JT[4].setBounds(70,55,100,25);
        JT[5].setBounds(275,55,70,25);
        Plazos.setBounds(400,55, 80,25);
        JT[7].setBounds(360,55, 250,25);
        JL[5].setBounds(10,58, 200,20);
        JL[6].setBounds(180,58, 200,20);
        JL[7].setBounds(345,58, 200,20);
        JL[8].setBounds(650,58, 300,20);
        JL[8].setVisible(false);
        JT[7].setVisible(false);
        //JP[1].add(Interes);
        JP[1].add(Plazos);
        for(int i=1;i<9;i++){
                JP[1].add(JL[i]);
                JP[1].add(JT[i]);
        }
        //***************** tabla de valores  **********************************
        modelo=new DefaultTableModel();
        modelo.addColumn("Período");
        modelo.addColumn("Fecha");
        modelo.addColumn("Interes Mensual");
        modelo.addColumn("Abono a capital");
        modelo.addColumn("Pagó Realizado");
        modelo.addColumn("Deuda Actual");
        Valuacion2= new JTable(modelo);
        JScrollPane scr=new JScrollPane(Valuacion2);
        Valuacion2.setPreferredScrollableViewportSize(new Dimension(700,400));
        scr.setBounds(15, 30, 730,400);
        Valuacion2.enable(false);
        JP[2].add(scr);
        //***************** tabla de valores  **********************************
        modelo2=new DefaultTableModel();
        modelo2.addColumn("Crédito");
        modelo2.addColumn("Fecha");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Apellido");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("Interes");
        modelo2.addColumn("Estado");
        modelo2.addColumn("Plazos");
        Valuacion3= new JTable(modelo2);
        JScrollPane scr2=new JScrollPane(Valuacion3);
        Valuacion3.setPreferredScrollableViewportSize(new Dimension(450,480));
        scr.setBounds(5, 30, 470,150);
        Valuacion3.enable(false);
        panelito.add(scr2);
        //***************** Componentes del Panel 3 como entregar el money *****
        JL[14] = new JLabel("Tipo de Pago: ");
        JL[15] = new JLabel("Cantidad en Letras:");
        JL[14].setBounds(20, 25, 100, 20);
        JL[15].setBounds(10, 50, 150, 20);
        JT[13].setBounds(120, 25, 150, 25);
        JT[14].setBounds(120, 50, 150, 25);
        JP[3].add(JL[14]);
        JP[3].add(JL[15]);
        JP[3].add(JT[13]);
        JP[3].add(JT[14]);
        //**************** componentes del panel 4 *****************************
        JB[2] = new JButton("Guardar");
        JB[3] = new JButton("Imprimir");
        JB[4] = new JButton("Imprimir Credito");
        JB[5] = new JButton("Limpiar");
        JB[6] = new JButton("Calcular");
        JB[2].setBounds(20,24, 120,25);
        JB[5].setBounds(167,24, 120,25);
        JB[6].setBounds(320,24, 120,25);
        JB[3].setBounds(320,55, 120,25);
        JB[4].setBounds(20,55, 120,25);
        JP[4].add(JB[2]);
        JP[4].add(JB[5]);
        JP[4].add(JB[6]);
        JP[4].add(JB[3]);
        JP[4].add(JB[4]);
        JB[2].addActionListener(new Control.Control_Vista_Prestamos(this));
        JB[3].addActionListener(new Control.Control_Vista_Prestamos(this));
        //***************** Establecemos los tamaños y puestos *****************
        JB[6].addActionListener(new Control.Control_Vista_Prestamos(this));

        JP[0].setBounds(20, 10, 490, 160);
        JP[1].setBounds(20, 170, 490, 90);
        JP[2].setBounds(20, 260, 490, 200);
        panelito.setBounds(518, 10, 490, 540);
        JP[4].setBounds(20,460, 490, 90);
        JP[0].setBorder(BorderFactory.createTitledBorder("Seleccionar Cliente Para Credito"));
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos Del Credito"));
        JP[2].setBorder(BorderFactory.createTitledBorder("Lista de Cuotas"));
        panelito.setBorder(BorderFactory.createTitledBorder("Base de datos"));
        JP[3].setBorder(BorderFactory.createTitledBorder("Forma de Entregar el Credito"));
        JP[4].setBorder(BorderFactory.createTitledBorder("Acciones"));
        for(int i=0; i<6;i++){
                add(JP[i]);
        }
        add(panelito);
    }
    String fechaActual,hora,minutos,segundos,ampm;
    Calendar calendario;    
    Thread h1;
    public void run(){
        Thread ct = Thread.currentThread();
        while(ct == h1) {   
            calcula();
            JT[2].setText(ManejadorFechas.DameFechaActual()+" "+hora + ":" + minutos + ":" + segundos + " "+ampm);
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {}
        }
    }
    public void calcula () {        
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
        if(ampm.equals("PM")){
            int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
            hora = h>9?""+h:"0"+h;
        }else{
            hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);            
        }
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND); 
    }
}
