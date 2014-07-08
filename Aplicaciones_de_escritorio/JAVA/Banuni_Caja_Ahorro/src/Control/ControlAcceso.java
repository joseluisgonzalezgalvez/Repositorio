/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Vistas.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Sala3_02
 */
public class ControlAcceso implements ActionListener,ItemListener,KeyListener{
    Acceso A;
    static int bandera = 0;
    public String User;
    String Contra_bd="";
    Base_Datos.Sentecias_BD Op;
    public ControlAcceso(Acceso A){
    this.A=A;
    Op = new Base_Datos.Sentecias_BD();
    }
    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {
        String Selexion = (String) A.Usuarios.getSelectedItem();
        User = (String) A.Nombres.getSelectedItem();
        String Contra_Panel="";
        Op.Open();
        Contra_bd = Op.Obtener_Contrasenia((String) A.Nombres.getSelectedItem());
        //JOptionPane.showMessageDialog(null,"Contra de la BD : "+Contra_bd);
        Op.Close();
        
        
        if(Selexion.equals("")){
            A.Nombres.setEnabled(false);
            A.JB[0].setEnabled(false);
            A.JB[1].setEnabled(true);
            A.JB[2].setEnabled(false);
            A.campoContrasenia.setEnabled(false);
        }
        if(Selexion.equals("Usuario") || Selexion.equals("Administrador")){
            A.Nombres.setEnabled(true);
            A.Nombres.removeAllItems();
            Op.Open();
            A.Nombres=Op.Pruebita(Selexion,A.Nombres);
            Op.Close();
            A.JB[0].setEnabled(true);
            A.JB[1].setEnabled(true);
            A.campoContrasenia.setEnabled(true);
        }  
        
        if(e.getSource() == A.JB[0] ){
            Contra_Panel= A.campoContrasenia.getText();
            //JOptionPane.showMessageDialog(null,"Contrasenia del panel = "+Contra_Panel);
            if(Contra_Panel.equals(Contra_bd) ){
                JOptionPane.showMessageDialog(null,"Contraseña Correcta");
                VistaPrincipal VP = new VistaPrincipal();

                    VP.diseno(User,Selexion);
                    VP.setLocationRelativeTo(null);
                    VP.setTitle("SISTEMA DE PRESTAMOS BANUNI");
                    VP.setVisible(true);
                    VP.setResizable(false);
                    VP.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    VP.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Imagenes/vender.jpg"));
                    A.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null,"Contraseña Erronea");
            }
        }
        if(e.getSource() == A.JB[1]){
            A.Usuarios.setSelectedIndex(0);
            A.Usuarios.setEnabled(true);
            A.JB[1].setEnabled(true);
            A.JB[2].setEnabled(true);
            A.Nombres.removeAllItems();
            A.campoContrasenia.setText("");
        }
        if(e.getSource() == A.JB[2]){
            System.exit(0);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void keyTyped(KeyEvent cx) {
		
        String Selexion = (String) A.Usuarios.getSelectedItem();
        User = (String) A.Nombres.getSelectedItem();
        String Contra_Panel="";
        Op.Open();
        Contra_bd = Op.Obtener_Contrasenia((String) A.Nombres.getSelectedItem());
        //JOptionPane.showMessageDialog(null,"Contra de la BD : "+Contra_bd);
        Op.Close();
		
       if(cx.getKeyChar()==10){
           Contra_Panel= A.campoContrasenia.getText();
           //JOptionPane.showMessageDialog(null,"Contrasenia del panel = "+Contra_Panel);
           if(Contra_Panel.equals(Contra_bd) ){
               JOptionPane.showMessageDialog(null,"Contraseña Correcta");
               VistaPrincipal VP = new VistaPrincipal();

                   VP.diseno(User,Selexion);
                   VP.setLocationRelativeTo(null);
                   VP.setTitle("SISTEMA DE PRESTAMOS BANUNI");
                   VP.setVisible(true);
                   VP.setResizable(false);
                   VP.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                   VP.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Imagenes/vender.jpg"));
                   A.setVisible(false);
           }
           else{
               JOptionPane.showMessageDialog(null,"Contraseña Erronea");
           }
    	}
	}
}
