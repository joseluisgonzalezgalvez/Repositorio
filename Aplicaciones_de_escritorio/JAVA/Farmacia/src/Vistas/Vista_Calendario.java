/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Vista_Calendario extends JFrame implements ActionListener{
    VistaProducto p;
    public JCalendar Calendario;
    public JButton Aceptar;
    public JPanel JP[]= new JPanel[2];
    public Vista_Calendario(VistaProducto P){
        this.p=P;
    }
    
    public void init(){
        setLayout(null);
        setSize(310,310);
        JP[0]= new JPanel();
        JP[1]= new JPanel();
        
        Aceptar = new JButton("Aceptar");
        JP[0].setLayout(null);
        JP[1].setLayout(new GridLayout());
        
        final JCalendar Calendario = new JCalendar();
        Calendario.setBounds(20, 20, 237,175);
        
        JP[0].add(Calendario);
        
        JP[0].setBorder(BorderFactory.createTitledBorder("Seleccione Una Fecha"));
        JP[0].setBounds(10, 10,277, 200);
        JP[1].setBorder(BorderFactory.createTitledBorder("Validar La Fecha"));
        JP[1].setBounds(10, 220,277, 50);
        JP[1].add(Aceptar);
        //Aceptar.addActionListener(new VistaValidarBoton(this));
        add(JP[0]);
        add(JP[1]);
        
        
        
        Aceptar.addActionListener(new ActionListener(){

        
            @Override
        public void actionPerformed(ActionEvent e) {
                String dia="";
                String mes="";
                String año="";
                if(Calendario.getCalendar().get(java.util.Calendar.DATE)<10){
                    dia="0"+ Integer.toString(Calendario.getCalendar().get(java.util.Calendar.DATE));
                }
                else{
                    dia = Integer.toString(Calendario.getCalendar().get(java.util.Calendar.DATE));
                }
                if(Calendario.getCalendar().get(java.util.Calendar.MONTH)+1<10){
                    mes = "0"+ Integer.toString(Calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);          
                }
                else{
                    mes = Integer.toString(Calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);          
                }
                año = Integer.toString(Calendario.getCalendar().get(java.util.Calendar.YEAR));
                
                String Fecha="";
                Fecha= Fecha+dia+"/"+mes+"/"+año;
                p.Jt[3].setText(Fecha);
                setVisible(false);
          
            }  
        });
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        init();
    }
}
