/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manual;
import java.awt.Desktop;
import java.awt.event.*;
import java.io.File;
/**
 *
 * @author lab8
 */
public class ControlPesta�as implements ActionListener{

    Manual m;

    ControlPesta�as(Manual m){
        this.m=m;
    }


    public void actionPerformed(ActionEvent e){
        


      if(m.boton[0]==e.getSource()){

          m.llenado_Consulta();
      }

      if(m.boton[1]==e.getSource()){

       m.llenado_DatosC();
      }
      if(m.boton[2]==e.getSource()){
 m.llenado_Acciones();

      }

      



      if(m.botones[0]==e.getSource()){
        m.llenado_principal();
         }
        if(m.botones[1]==e.getSource()){

        }

      if(m.Item[0]==e.getSource()){

      }
      if(m.Item[1]==e.getSource()){
          System.exit(0);
      }
      if(m.Item2==e.getSource()){
          m.Designer_Programers();
      }


    }
    
        
        
        

    

}
