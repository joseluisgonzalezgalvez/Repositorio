/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Administrador
 */
public class ContolPane4_Mouse implements MouseListener{
    	Vistas.Vista_Consulta_Medica p4;
        static int respaldo=0,respaldo2=0;
    public ContolPane4_Mouse(Vistas.Vista_Consulta_Medica p){
		this.p4=p;
	}

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON3){
            p4.Jx.show(p4.textarea,e.getX(),e.getY());
            }
    }

    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
  //      throw new UnsupportedOperationException("Not supported yet.");
    }

}
