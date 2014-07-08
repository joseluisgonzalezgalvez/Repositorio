/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validaciones;
import java.util.regex.*;

public class Validar_Datos{

    //****** Validar La hora
    public boolean Validar_Hora(String cod) {
        Pattern pat;
        Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[0-2][0-4][:][0-5][0-9][:][0-5][0-9]");
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return true;
            else
                return false;
    }
    //****** Validar Numeros
    public boolean Validar_Numeros(String cod) {
        Pattern pat;
        Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[0-9][0-9]*" );
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return true;
            else
                return false;
    }
    //****** Validar Letras
    public boolean Validar_Letras(String cod) {
        Pattern pat;
        Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[A-Za-z, ][A-Za-z, ]*" );
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return true;
            else
                return false;
    }
    //****** Validar Letras_Numeros
    public boolean Validar_Letras_Numeros(String cod) {
        Pattern pat;
        Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[A-Za-z0-9][A-Za-z 0-9']*" );
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return true;
            else
                return false;
    }
    //****** Validar Precios
    public boolean Validar_Precios(String cod) {
        Pattern pat;
        Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[0-9]*[.][0-9][0-9]" );
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return true;
            else
                return false;
    }
    //****** Validar Direccion
    public boolean Validar_Direccion(String cod) {
        Pattern pat;
	    Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[a-zA-Z][a-zA-Z #0-9.]*");
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return true;
            else
                return false;
    }
    //****** Validar Telefono
    public boolean Validar_Telefonos(String cod) {
        Pattern pat;
        Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return true;
            else
                return false;
    }
    //****** Validar Correos
    public boolean Validar_Correos(String cod) {
        Pattern pat;
        Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[0-9a-zA-Z_]*[@][a-z]*[.][a-zA-Z]*");
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return  true;
            else
                return false;
    }
    //****** Validar Fechas
    public boolean Validar_Fechas(String cod) {
        Pattern pat;
        Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[0-3][0-9][/][0-1][1-9][/][1-2][0-9][0-9][0-9]");
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return true;
            else
                return false;
    }
   //validar cedula profesional
    public boolean Validar_cedula(String cod) {
        Pattern pat;
        Matcher mat;
        boolean val=false,val1=false;
        pat = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
		mat = pat.matcher(cod);
		val1= mat.matches();
            if(val1==false)
                return true;
            else
                return false;
    }
}