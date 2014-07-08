package Control;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import Base_Datos.*;
//import TestBase.*;
import Vistas.*;
public class Control_Cliente implements ActionListener,ItemListener
{
    Vistas.Cliente cliente;
    Base_Datos.Sentecias_BD operacion;

    public Control_Cliente(Cliente cliente)
    {
        this.cliente=cliente;
        operacion = new Base_Datos.Sentecias_BD();
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==cliente.matrizboton[5])
        {
            System.exit(0);
        }
        if(cliente.matrizboton[3]==e.getSource())
        {
            //imprimir los datos en consola
            operacion.Open();
            //operacion.ImprimirDatos();
            operacion.Close();
        }
        if(cliente.matrizboton[0]==e.getSource())
        {
            //nuevo limpar las cajas de texto
            for(int i=0;i<8;i++)
            {
                cliente.matriztext[i].setEnabled(true);
                cliente.matriztext[i].setText("");
                cliente.domicilioprofesor.setText("");
            }
            cliente.matriztext[0].setEnabled(false);

        }
        if(cliente.matrizboton[1]==e.getSource())
        {
            operacion.Open();
            String aux=cliente.matriztext[0].getText();
            int clave=Integer.parseInt(aux);
            String nombre=cliente.matriztext[1].getText();
            String direccion=cliente.matriztext[2].getText();
            String ciudad=cliente.matriztext[3].getText();
            String telefono=cliente.matriztext[4].getText();
            String codigo=cliente.matriztext[5].getText();
            String estado=cliente.matriztext[6].getText();
            String aux2=cliente.matriztext[7].getText();
            int numero=Integer.parseInt(aux2);
            try
            {
                //System.out.println("Entro a altas");
                operacion.altacliente(nombre,direccion,ciudad,telefono,codigo,estado,numero);
                //System.out.println("Despues de realizar las altas");
                cliente.llenar();
               // actualizar();
            } catch(SQLException ex) {
                Logger.getLogger(Control_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            //opepro.ImprimirDatos();
            actualizar();
            operacion.Close();
        }
        if(cliente.matrizboton[4]==e.getSource())
        {
            operacion.Open();
            String aux=(String)cliente.clavecliente.getSelectedItem();
            int clave=Integer.parseInt(aux);
            String nombre=cliente.matriztext[1].getText();
            String direccion=cliente.matriztext[2].getText();
            String ciudad=cliente.matriztext[3].getText();
            String telefono=cliente.matriztext[4].getText();
            String codigo=cliente.matriztext[5].getText();
            String estado=cliente.matriztext[6].getText();
            String aux2=cliente.matriztext[7].getText();
            int numero=Integer.parseInt(aux2);

            //String domicilio=cliente.domicilioprofesor.getText();
            System.out.println("Entro a modificar");
           // operacion.modificar(clave,nombre,direccion,ciudad,telefono,codigo,estado,numero);
            //operacion.ImprimirDatos();
            operacion.Close();
        }
        if(cliente.matrizboton[2]==e.getSource())
        {
            String auxclave=(String)cliente.clavecliente.getSelectedItem();
            operacion.Open();
            //operacion.eliminar(auxclave);
            actualizar();
            operacion.Close();
        }
    }
    public void itemStateChanged(ItemEvent e)
    {
        if(cliente.clavecliente==e.getItemSelectable())
        {
            String aux="",aux1="";
            System.out.println("itemStateChanged");
            String auxclave=(String)cliente.clavecliente.getSelectedItem();
            operacion.Open();
            cliente.matriztext[0].setText(auxclave);
            cliente.matriztext[1].setText(operacion.nombre(auxclave));
            cliente.matriztext[2].setText(operacion.direccion(auxclave));
            cliente.matriztext[3].setText(operacion.ciudad(auxclave));
            cliente.matriztext[4].setText(operacion.telefono(auxclave));
            cliente.matriztext[5].setText(operacion.codigo(auxclave));
            cliente.matriztext[6].setText(operacion.estado(auxclave));
            cliente.matriztext[7].setText(operacion.numero(auxclave));
            
            operacion.Close();
        }
    }
    public void actualizar()
    {
        cliente.clavecliente.removeAllItems();
        cliente.clavecliente.remove(cliente);
        //cliente.llenar();
    }
}

