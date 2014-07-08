/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author Administrador
 */
@SuppressWarnings("serial")
public class Acceso extends JFrame{
    @SuppressWarnings("rawtypes")
	public JComboBox Usuarios;
    @SuppressWarnings("rawtypes")
	public JComboBox Nombres;
    public JLabel JL[]= new JLabel[5];
    public JTextField JT[]= new JTextField[5];
    public JPanel JP[]= new JPanel[5];
    public JButton JB[]= new JButton[5];
    public Icon quake1 = new ImageIcon( "src/Imagenes/logito.png" );
    public JPasswordField campoContrasenia;
    
    ResultSet r1;
    Base_Datos.Sentecias_BD Op = new Base_Datos.Sentecias_BD();
    
    public Acceso(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void Disenio(){
        setSize(500,420);
        setLayout(null);
        for(int i=0; i<5;i++){
            JT[i]= new JTextField();
            JP[i]= new JPanel();
            JP[i].setLayout(null);
        }
        JL[0]= new JLabel("Usuario");
        JL[1]= new JLabel("Nombre");
        JL[2]= new JLabel("Contraseña");
        JB[0] = new JButton("Ingresar");
        JB[1] = new JButton("Limpiar");
        JB[2] = new JButton("Salir");
        Usuarios = new JComboBox();
        Nombres = new JComboBox();

        Usuarios.addItem("");
        //Usuarios.addItem("Usuario");
        Usuarios.addItem("Administrador");
        
        campoContrasenia = new JPasswordField();
        JL[0].setBounds(20,0, 80,30);
        //Accion.setBounds(20,60, 80,30);
        JP[1].add(JL[1]);
        JL[1].setBounds(20,25, 80,30);
        JP[1].add(JL[2]);
        Nombres.setBounds(130,25,300,25);
        JP[1].add(Nombres);
        //Nombres.addActionListener(new Control.ControlAcceso(this));
        JP[1].add(campoContrasenia);
        
        JL[2].setBounds(20,65, 80,30);
        JL[4] = new JLabel(quake1);
        JL[4].setBounds(60,10,135,135);
        JP[2].add(JL[4]);
        campoContrasenia.setBounds(130,65,300,25);
        Usuarios.setBounds(40,70,110,20);
        JP[0].add(Usuarios);
        JP[0].setBorder(BorderFactory.createTitledBorder("Seccion De Usuarios"));
        JP[1].setBorder(BorderFactory.createTitledBorder("Datos del Usuario"));
        JP[2].setBorder(BorderFactory.createTitledBorder("Cajita Feliz"));
        JP[3].setBorder(BorderFactory.createTitledBorder("Acciones"));
        JP[0].setBounds(10, 5, 200,150);
        JP[1].setBounds(10, 170, 470,120);
        JP[2].setBounds(220, 5, 260,150);
        JP[3].setBounds(10, 300, 470,80);
        
        JB[0].setBounds(50, 30, 100, 30);
        JB[1].setBounds(180, 30, 100, 30);
        JB[2].setBounds(310, 30, 100, 30);
        
        JP[3].add(JB[0]);
        JP[3].add(JB[1]);
        JP[3].add(JB[2]);
        
            Nombres.setEnabled(false);
            JB[0].setEnabled(false);
            JB[1].setEnabled(true);
            JB[2].setEnabled(true);
            campoContrasenia.setEnabled(false);
        add(JP[0]);
        add(JP[1]);
        add(JP[2]);
        add(JP[3]);
        Usuarios.addActionListener(new Control.ControlAcceso(this));
        campoContrasenia.addKeyListener(new Control.ControlAcceso(this));
        JB[0].addActionListener(new Control.ControlAcceso(this));
        JB[1].addActionListener(new Control.ControlAcceso(this));
        JB[2].addActionListener(new Control.ControlAcceso(this));
        //Llenar_Combo();
    }
    /*
    public void Llenar_Combo(){
                try{
                    Op.Open();
                    r1= Op.Consulta_Nombre_Empleado();
                    while(r1.next()){
                        Nombres.addItem(String.valueOf(r1.getInt(1)));
                    }
                }
                catch(SQLException e){}
                Op.Close();
    }*/
}
