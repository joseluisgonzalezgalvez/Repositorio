package Vista_Creditos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Vista_Prestamo_Nuevo extends JPanel implements Runnable{
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
  public static int Codigo_Empleado;
  Color xx = new Color(102,205,0);
  @SuppressWarnings("rawtypes")
  public JComboBox Interes;
  @SuppressWarnings("rawtypes")
  public JComboBox Plazos;
  ResultSet r1;
  String fechaActual,hora,minutos,segundos,ampm;
  Calendar calendario;    
  Thread h1;
  public void Borrar(){
	                int i = modelo.getRowCount();
	                for(int m=i-1;m>=0;m--){
	                        modelo.removeRow(m);
	                }
  }
  public Vista_Prestamo_Nuevo(){
        Disenio();
        h1 = new Thread(this);
        h1.start();     
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
        //**************** componentes del panel 2 *****************************
        JL[1] = new JLabel("Importe: "); 
        JL[2] = new JLabel("Fecha del Crédito:");
        JL[3] = new JLabel("Interes:");
        JL[4] = new JLabel("%");
        JL[5] = new JLabel("Pago Acordado:");
        JL[6] = new JLabel("N° de Cuotas:");
        JL[7] = new JLabel("Periodo:");
        JL[8] = new JLabel("Vencimiento de la primera cuota");
        JL[1].setBounds(10, 28, 100, 20);
        JL[2].setBounds(290, 28, 150, 20);
        JL[3].setBounds(170, 28, 100, 20);
        JL[4].setBounds(265, 28, 60,20);
        JT[1].setBounds(70, 28, 80, 20);
        JT[2].setBounds(405, 28, 130, 20);
        JT[2].setEnabled(false);
        JT[6].setBounds(220, 28, 40, 20);

        Plazos= new JComboBox();
        Plazos.addItem("");
        Plazos.addItem("Semanal");
        Plazos.addItem("Quincenal");
        Plazos.addItem("Mensual");
        //Plazos.setBounds(500, 23, 60, 25);
        JT[4].setBounds(110,58,100,20);
      //  JT[5].setBounds(300,58,50,20);
        Plazos.setBounds(320,58, 100,20);
        JT[7].setBounds(220,58, 250,20);
        JL[5].setBounds(10,58, 200,20);
       // JL[6].setBounds(220,58, 200,20);
        JL[7].setBounds(260,58, 200,20);
        JL[8].setBounds(650,58, 300,20);
        JL[8].setVisible(false);
        JT[7].setVisible(false);
        JP[1].add(JT[5]);
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
        //**************** componentes del panel 4 *****************************
        JB[2] = new JButton("Calcular");
        JB[3] = new JButton("Imprimir Préstamo");
        JB[4] = new JButton("Limpiar");
        JP[4].setLayout(new FlowLayout());
        JP[4].add(JB[2]);
        JP[4].add(JB[4]);
        JP[4].add(JB[3]);
        //***************** Establecemos los tamaños y puestos *****************
        JP[1].setBounds(20, 20, 550, 90);
        JP[2].setBounds(20, 110, 760, 450);
        JP[4].setBounds(580,20, 200, 90);
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos Del Credito"));
        JP[2].setBorder(BorderFactory.createTitledBorder("Lista de Cuotas"));
        JP[4].setBorder(BorderFactory.createTitledBorder("Acciones"));
        for(int i=1; i<6;i++){
                add(JP[i]);
        }
    }
    
    //************ Hilo del Reloj ************************************************

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