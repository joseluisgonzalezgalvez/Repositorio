/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.CheckboxGroup;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Administrador
 */
public class Cobrar_Receta_Medica extends JPanel{
    
   
    public JPanel JP[]= new JPanel[5];
    public JButton JB[]= new JButton[20];
    public JTextField JT[]= new JTextField[20];
    JLabel JL[]= new JLabel[20];
    public JCheckBox JCK[]= new JCheckBox[4];
    public JComboBox C;
    public JTable Valuacion2,Valuacion;
    public Cobrar_Receta_Medica(){
        Disenio();
    }

    public void Disenio() {
        setLayout(null);
        setSize(340,590);
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
        JL[0].setBounds(100,5,150,30);
        JL[1].setBounds(100,25,150,30);
        JL[2].setBounds(40,45,300,30);
        add(JL[0]);
        add(JL[1]);
        add(JL[2]);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        
        JL[4] = new JLabel("Numero Receta :");
        JL[5] = new JLabel("Nombre: ");
        JL[6] = new JLabel("Direccion: ");
        JL[7] = new JLabel("");
        
        
        JL[8] = new JLabel("");
        JL[9] = new JLabel("Precio Total: ");
        JL[10] = new JLabel("Efectivo: ");
        JL[11] = new JLabel("Cambio: ");
        
        JL[4].setBounds(10,20,120,30);
        JL[5].setBounds(10,50,120,30);
        JL[6].setBounds(10,80,120,30);
        JL[7].setBounds(10,110,120,30);

        JL[8].setBounds(10,140,120,30);
        JL[9].setBounds(10,170,120,30);
        JL[10].setBounds(10,200,120,30);
        JL[11].setBounds(10,230,120,30);

        
/*        
        JL[8].setBounds(570,20,120,30);
        JL[9].setBounds(570,50,120,30);
        JL[10].setBounds(570,80,120,30);
        JL[11].setBounds(570,110,120,30);
*/      

        
        JT[4].setBounds(100,20,80,25);
        JT[5].setBounds(100,50,170,25);
        JT[6].setBounds(100,80,170,25);
        //JT[7].setBounds(100,110,170,25);
/*
        
        JT[8].setBounds(700,20,220,25);
        JT[9].setBounds(700,50,220,25);
        JT[10].setBounds(700,80,220,25);
        JT[11].setBounds(700,110,220,25);*/

       // JT[8].setBounds(100,140,170,25);
        JT[9].setBounds(100,170,170,25);
        JT[5].setEnabled(false);
        JT[6].setEnabled(false);
        JT[9].setEnabled(false);
        JT[11].setEnabled(false);
        JT[10].setBounds(100,200,170,25);
        JT[11].setBounds(100,230,170,25);
        
        
        
        
/*        
        JB[1]= new JButton("Guardar");
        JB[1].setBounds(10,230, 100,25);
        JP[1].add(JB[1]);
        JB[2]= new JButton("Modificar");
        JB[2].setBounds(140,230, 100,25);
        JP[1].add(JB[2]);
        JB[3]= new JButton("Guardar");
        JB[3].setBounds(270,230, 100,25);
        JP[1].add(JB[3]);
        
        
        JB[1].setEnabled(false);
        JB[2].setEnabled(false);
        JB[3].setEnabled(false);
        */
        JP[1].add(JL[4]);
        JP[1].add(JL[5]);
        JP[1].add(JL[6]);
        JP[1].add(JL[7]);
        JP[1].add(JL[8]);
        JP[1].add(JL[9]);
        JP[1].add(JL[10]);
        JP[1].add(JL[11]);
        
        JP[1].add(JT[4]);
        JP[1].add(JT[5]);
        JP[1].add(JT[6]);
        JP[1].add(JT[7]);
        JP[1].add(JT[8]);
        JP[1].add(JT[9]);
        JP[1].add(JT[10]);
        JP[1].add(JT[11]);
               
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos Del Cliente"));
        JP[1].setBounds(10,80,310,270);
        add(JP[1]);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        JL[12] = new JLabel("Identificador :");
        JL[13] = new JLabel("Nombre: ");
        JL[14] = new JLabel("Especialidad: ");
        JL[15] = new JLabel("Cedula: ");
        
        JL[12].setBounds(10,20,120,30);
        JL[13].setBounds(10,50,120,30);
        JL[14].setBounds(10,80,120,30);
        JL[15].setBounds(10,110,120,30);
        JT[12].setEnabled(false);
        JT[13].setEnabled(false);
        JT[14].setEnabled(false);
        JT[15].setEnabled(false);
        JT[12].setBounds(100,20,170,25);
        JT[13].setBounds(100,50,170,25);
        JT[14].setBounds(100,80,170,25);
        JT[15].setBounds(100,110,170,25);      
        
        JP[2].add(JL[12]);
        JP[2].add(JL[13]);
        JP[2].add(JL[14]);
        JP[2].add(JL[15]);
        
        JP[2].add(JT[12]);
        JP[2].add(JT[13]);
        JP[2].add(JT[14]);
        JP[2].add(JT[15]);
        
        JP[2].setBorder(BorderFactory.createTitledBorder("Datos Del Empleado"));
        JP[2].setBounds(10,350,310,150);
        add(JP[2]);
        
        JB[0]=new JButton("Cobrar");
        JB[1]=new JButton("Limpiar");
        JB[2]=new JButton("Buscar");
        
        JB[2].setBounds(200,20,100,25);
        JP[1].add(JB[2]);
        JB[0].setBounds(50,20, 100, 25);
        JB[1].setBounds(170,20, 100, 25);
        
        JP[3].add(JB[0]);
        JP[3].add(JB[1]);
        
        
        JP[3].setBorder(BorderFactory.createTitledBorder("Acciones"));
        JP[3].setBounds(10,500,310,60);
        add(JP[3]);
        
    }
    /*
   public static void main(String Args[]){
        Cobrar_Receta_Medica Cm = new Cobrar_Receta_Medica();
        Cm.Disenio();
        Cm.setVisible(true);
        Cm.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
    */
}
