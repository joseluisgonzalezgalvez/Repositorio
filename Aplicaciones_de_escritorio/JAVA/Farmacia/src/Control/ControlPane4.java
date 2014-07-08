/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ControlPane4 implements ActionListener
{
	Vistas.Vista_Consulta_Medica p4;
        static int respaldo=0,respaldo2=0;
	public ControlPane4(Vistas.Vista_Consulta_Medica p)
	{
		this.p4=p;
	}
	public void actionPerformed(ActionEvent e){
                Font Actual= p4.textarea.getFont();
                
		Object o =e.getSource();
		//Estilo solo sera con JChekBoxMenuItem
                //Fuente y los demas solo seran con JRadioButtonMenuItem
                //acer que el predeterminado sea por defecto
                //fRedeterminado.setSelected(true);
		//botones del toolbar
		if(o==p4.copiar || o==p4.botones[2] || o==p4.copiar2){
                    p4.textarea.copy();
		}
                if(o==p4.guardar){
                    System.exit(0);
                }
		if(o==p4.pegar || o==p4.botones[4] ||o==p4.pegar2){
                    p4.textarea.paste();
		}
		if(o==p4.borrar || o== p4.botones[1] || o==p4.borrar2){
                    p4.textarea.cut();
		}
                if(o== p4.botones[3]){
                    if(p4.textarea.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"NO HAY TEXTO!!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,p4.textarea.getText());
                    }

		}
		if(o==p4.nuevo || o== p4.botones[0]  || o==p4.nuevo2){
                    p4.textarea.setText("");
                    p4.textarea.setFont(p4.fRedeterminada);
                    p4.textarea.setForeground(Color.black);
		}
		if(o==p4.tiposfuente[1]){
			p4.textarea.setFont(new Font("Arial",Actual.getStyle(),Actual.getSize()));
		}
		if(o==p4.tiposfuente[0]){
			p4.textarea.setFont(new Font("Times New Roman",Actual.getStyle(),Actual.getSize()));
		}
		if(o==p4.tiposfuente[2]){
			p4.textarea.setFont(new Font("Calibri",Actual.getStyle(),Actual.getSize()));
		}
                if(o==p4.tiposfuente[3]){
			p4.textarea.setFont(p4.fRedeterminada);
		}
                if(o==p4.tamañofuente[0]){
			p4.textarea.setFont(new Font(Actual.getFontName(),Actual.getStyle(),12));
		}
                if(o==p4.tamañofuente[1]){
			p4.textarea.setFont(new Font(Actual.getFontName(),Actual.getStyle(),13));
		}
                if(o==p4.tamañofuente[2]){
			p4.textarea.setFont(new Font(Actual.getFontName(),Actual.getStyle(),14));
		}
                if(o==p4.tamañofuente[3]){
			p4.textarea.setFont(new Font(Actual.getFontName(),Actual.getStyle(),16));
		}
                if(o==p4.tamañofuente[4]){
			p4.textarea.setFont(new Font(p4.fRedeterminada.getFontName(),p4.fRedeterminada.getStyle(),p4.fRedeterminada.getSize()));
		}
                if(o==p4.negritas){
                    if(p4.negritas.isSelected()==true){
                        if(p4.cursiba.isSelected()==true){
                            p4.textarea.setFont(new Font(Actual.getName(),Font.BOLD+Font.ITALIC,Actual.getSize()));
                            //JOptionPane.showMessageDialog(null,"Entro a BOLD +ITALIC");
                        }
                        else{
                            //JOptionPane.showMessageDialog(null,"Entro a BOLD");
                            p4.textarea.setFont(new Font(Actual.getName(),Font.BOLD,Actual.getSize()));
                        }
                    }
                    else{
                        //JOptionPane.showMessageDialog(null,"Entro a PLAIN 1");
                        p4.textarea.setFont(new Font(Actual.getName(),Font.PLAIN+Font.ITALIC,Actual.getSize()));
                    }
                    if(p4.negritas.isSelected()==false && p4.cursiba.isSelected()==false){
                        //JOptionPane.showMessageDialog(null,"Restablece");
                        p4.textarea.setFont(new Font(Actual.getName(),Font.PLAIN,Actual.getSize()));
                    }
                    /*if(p4.cursiba.isSelected()== true){
                        JOptionPane.showMessageDialog(null,"NEGRITAS+CURSIVA");
                        p4.textarea.setFont(new Font(Actual.getName(),Font.BOLD+Font.ITALIC,Actual.getSize()));
                    }
                   /* else{
                        JOptionPane.showMessageDialog(null,"NEGRITAS");
                        p4.textarea.setFont(new Font(Actual.getName(),Font.BOLD,Actual.getSize()));
                        p4.cursiba.setSelected(false);
                    }¡*/
                    
                    /*if(p4.cursiba.isSelected()== true){
                                p4.textarea.setFont(new Font(Actual.getName(),Font.BOLD+Font.ITALIC,Actual.getSize()));
                        }^*/
              /*      if(respaldo2==0){
                        p4.textarea.setFont(new Font(Actual.getName(),Font.BOLD,Actual.getSize()));
                        respaldo2=1;
                        JOptionPane.showMessageDialog(null,"Cambio a negrytas");
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Cambio a PLAIN");
                        p4.textarea.setFont(new Font(Actual.getName(),Font.PLAIN,Actual.getSize()));
                        respaldo2=0;
                    }*/
                }
                if(o==p4.cursiba){
                    if(p4.cursiba.isSelected()==true){
                        if(p4.negritas.isSelected()==true){
                            p4.textarea.setFont(new Font(Actual.getName(),Font.BOLD+Font.ITALIC,Actual.getSize()));
                           // JOptionPane.showMessageDialog(null,"Entro a ITALIC+  BOLD");
                        }
                        else{
                           // JOptionPane.showMessageDialog(null,"Entro a ITALIC ");
                            p4.textarea.setFont(new Font(Actual.getName(),Font.ITALIC,Actual.getSize()));
                        }
                    }
                    else{
                        //JOptionPane.showMessageDialog(null,"Entro a PLAIN 2");
                        p4.textarea.setFont(new Font(Actual.getName(),Font.PLAIN+Font.BOLD,Actual.getSize()));
                    }
                    if(p4.negritas.isSelected()==false && p4.cursiba.isSelected()==false){
                       // JOptionPane.showMessageDialog(null,"Restablece");
                        p4.textarea.setFont(new Font(Actual.getName(),Font.PLAIN,Actual.getSize()));
                    }
            /*        if(p4.negritas.isSelected()==true){
                        JOptionPane.showMessageDialog(null,"CURSIVA+NEGRITA");
                            p4.textarea.setFont(new Font(Actual.getName(),Font.BOLD+Font.ITALIC,Actual.getSize()));
                    }
                    /*else{
                        JOptionPane.showMessageDialog(null,"CURSIVA");
                         p4.textarea.setFont(new Font(Actual.getName(),Font.ITALIC,Actual.getSize()));
                         p4.negritas.setSelected(false);
                    }*/
                    //JOptionPane.showMessageDialog(null,respaldo);
              /*      if(respaldo==0){
                        p4.textarea.setFont(new Font(Actual.getName(),Font.ITALIC,Actual.getSize()));
                        respaldo=1;
                        JOptionPane.showMessageDialog(null,"Cambio a ITALIC");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Cambio a PLAIN");
                        p4.textarea.setFont(new Font(Actual.getName(),Font.PLAIN,Actual.getSize()));
                        respaldo=0;
                    }*/
                }
                if(o==p4.normal){
                   respaldo=0;
                   p4.textarea.setFont(new Font(Actual.getName(),p4.fRedeterminada.getStyle(),Actual.getSize()));
                   p4.negritas.setSelected(false);
                   p4.cursiba.setSelected(false);
                   p4.normal.setSelected(false);
                }
                if(o==p4.colorfuente[0]){
                        p4.textarea.setForeground(Color.red);
                }
                if(o==p4.colorfuente[2]){
                        p4.textarea.setForeground(Color.black);
                }
                if(o==p4.colorfuente[1]){
                        p4.textarea.setForeground(Color.blue);
                }

                // utiliza la funcion tooltiptex!!!
	}
}
