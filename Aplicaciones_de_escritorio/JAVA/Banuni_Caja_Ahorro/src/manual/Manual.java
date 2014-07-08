/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manual;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
/**
 *
 * @author lab8
 */
public class Manual extends JDialog{
    JMenuBar barraMenu;
    JMenuItem Item[]=new JMenuItem[2],Item2;
    JMenu menu1[] = new JMenu[2];
    JToolBar barra;
    JButton botones[]=new JButton[2];
    JPanel panelx,panely,panel_in;
    JPanel p_pestaña;
    JTextArea area2;
   Icon ima[]=new ImageIcon[2];
  JScrollPane sp;
   String h[]={"Inicio.jpg","Manual.jpg"};
  String slv[]={"Menu principal","altas","Bajas","Prestamo"};
  JLabel b=new JLabel("* Pulse el boton");
  JLabel k=new JLabel("para obtener informaciÃ³n");
  JButton boton[]=new JButton[3];
  JTabbedPane pestaña;


  /*Manual(){
      diseÃ±oManual();
  }*/
 public void diseñoManual(){
        setSize(800,600);
        setLayout(null);
     
       setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       setLocationRelativeTo(null);
        ////////////////////////////////////////
        //barra de menus
        barraMenu= new JMenuBar();
        barraMenu.setBounds(0,0,800,30);
        ////menus de la barra de menus
        menu1[0]=new JMenu("Archivo");
        menu1[1]=new JMenu("Ayuda");
       
        
        //////////////////////////////////////////
        
        Item[0]=new JMenuItem("Imprimir manual");
        Item[1]=new JMenuItem("Salir");
        Item2= new JMenuItem("Desarrolladores");
        Item[0].addActionListener(new ControlPestañas(this));
        Item[1].addActionListener(new ControlPestañas(this));
        Item2.addActionListener(new ControlPestañas(this));
        /////////////////////////////////////////
        

        
        for(int i=0;i<2;i++){
            menu1[0].add(Item[i]);

        }
        menu1[1].add(Item2);
       barraMenu.add(menu1[0]);
       barraMenu.add(menu1[1]);
            

        
        for(int i=0; i<2;i++){

            ima[i]=new ImageIcon(h[i]);

        }
        
      
        //barra de herramientas

        barra=new JToolBar();
        barra.setLayout(null);
        barra.setBounds(0,31, 800, 61);
        ////BOtones

        for(int i=0;i<2;i++){
        
        botones[i]=new JButton(ima[i]);
        botones[i].setBackground(Color.WHITE);
        botones[i].setBounds(0+(i*61),0,60, 60);
        botones[i].addActionListener(new ControlPestañas(this));
    //    botones[i].setIcon(ima[i]);
        }
       
       boton[0]=new JButton("Panel Consulta");
       boton[1]=new JButton("Panel Datos Cliente");
       boton[2]=new JButton("Panel Datos Acciones");
    
        /////Paneles

      
         
        
        panelx=new JPanel();
        panelx.setLayout(null);
        panelx.setBounds(301,91,484,470);
        panelx.setBorder(BorderFactory.createTitledBorder("Descripcion"));
        //pestaÃ±as en panel[0]
        p_pestaña=new JPanel();

        p_pestaña.setLayout(null);
        
        for(int i=0;i<3;i++){
        boton[i].setBounds(30,70+(i*50),200,30);
        boton[i].addActionListener(new ControlPestañas(this));
        }
        for(int i=0;i<3;i++){
        p_pestaña.add(boton[i]);
        }


        panely= new JPanel();
        panely.setLayout(null);
        panely.setBounds(15,95,260,460);
        panely.setBorder(BorderFactory.createTitledBorder("                                      Informacion"));
        pestaña=new JTabbedPane();
        //pestaÃ±a.setLayout(null);
        
        pestaña.addTab("Contenido",p_pestaña);
        
        pestaña.setBounds(0, 0, 260, 460);
        panely.add(pestaña);
        //areaen panel[1]
        area2=new JTextArea();
        area2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        area2.setBackground(Color.WHITE);
        area2.setFont(new Font(("Times New Roman"),Font.PLAIN,13));
        area2.setEditable(false);
       // area2.setBounds(30,35, 424, 410);
        sp= new JScrollPane(area2);
        sp.setBounds(30,35, 424, 410);
        panelx.add(sp);
        for(int i=0;i<2;i++){
            barra.add(botones[i]);
        }
        
       
        add(panelx);
        add(panely);
        add(barraMenu);
        add(barra);
        setVisible(true);
   }

 public void llenado_Consulta(){
area2.setText("");
     try{



    	    FileReader fr = new FileReader("Consultas.txt");
    	    BufferedReader br = new BufferedReader(fr);

    	    String texto = "", linea = "";

    	    //al ser null es porque ya llego al final del archivo
    	    while ((linea = br.readLine()) != null)
    		    texto+= linea + "\n";



    	    br.close();
    	    fr.close();
    	    //es muy importante cerrar el archivo ya que si
    	    //no lo cerramos el programa se puede trabar.

            area2.append(texto);
    	    //System.out.println(texto);

    	}catch(Exception e){
        e.printStackTrace();}


    }




 
 public void llenado_Acciones(){
  area2.setText("");
     try{



    	    FileReader fr = new FileReader("Acciones.txt");
    	    BufferedReader br = new BufferedReader(fr);

    	    String texto = "", linea = "";

    	    //al ser null es porque ya llego al final del archivo
    	    while ((linea = br.readLine()) != null)
    		    texto+= linea + "\n";



    	    br.close();
    	    fr.close();

            area2.append(texto);
    	    //System.out.println(texto);

    	}catch(Exception e){
        e.printStackTrace();}


    }



 

 public void llenado_DatosC(){
 area2.setText("");
     try{



    	    FileReader fr = new FileReader("DatosC.txt");
    	    BufferedReader br = new BufferedReader(fr);

    	    String texto = "", linea = "";

    	    //al ser null es porque ya llego al final del archivo
    	    while ((linea = br.readLine()) != null)
    		    texto+= linea + "\n";



    	    br.close();
    	    fr.close();

            area2.append(texto);
    	    //System.out.println(texto);

    	}catch(Exception e){
        e.printStackTrace();}


    }



 public void llenado_principal(){

     area2.setText("");
     try{
         FileReader fr= new FileReader("Menu Principal.txt");
         BufferedReader br= new BufferedReader(fr);

         String texto ="", linea ="";

         while((linea=br.readLine())!=null){
             texto+=linea +"\n";
         }
         br.close();
         fr.close();
         area2.append(texto);
     }catch(Exception e){
         e.printStackTrace();
     }


 }
 public void Designer_Programers(){
     area2.setText("");
     try{
         FileReader fr= new FileReader("Designers&Programers.txt");
         BufferedReader br= new BufferedReader(fr);

         String texto ="", linea ="";

         while((linea=br.readLine())!=null){
             texto+=linea +"\n";
         }
         br.close();
         fr.close();
         area2.append(texto);
     }catch(Exception e){
         e.printStackTrace();
     }
 }


}
