package Default;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Fichero {
	private String File_Name = "";
	private FileReader input;
	public String txt = "";
	
	public Fichero(String File_Name){
		this.File_Name = File_Name;
	}
	
	public void escribir(String txt){
		try{
			FileWriter output = new FileWriter(this.File_Name);
			for(int i=0;i<txt.length();i++){
				output.write(txt.charAt(i));
			}
			output.close();
			JOptionPane.showMessageDialog(null,"El texto ha sido cifrado!");
		}catch(IOException e){
			//System.out.println("Ocurrio un error!");
		}
	}

	
	public String leer(){		
		try{
			this.input = new FileReader(this.File_Name);
			int c = this.input.read();
			while(c != -1){
				txt +=(char)c;				
				c = this.input.read();
			}									
			this.input.close();
			return txt;
		}catch(Exception e){	
			JOptionPane.showMessageDialog(null,"Ocurrio un error!");
			return txt;
		}		
	}
	
	public String[][] convertir(String txt){
		int i=0,j=0,k=0;
		String [][] matriz = new String[4][4];
		String subs = "";
		for(i=0;i<txt.length();i++){
			subs += txt.charAt(i);
			if((i+1)%2==0){
				matriz[j][k] = subs;				
				if(k==3){
					k=0;
					j++;					
				}else{
					k++;	
				}						
				subs = "";
			}
		}	
		return matriz;
	}
	
	public int[][] hex2dec(String[][] s, int x, int y){
		int i,j;
		int [][]res = new int[x][y];
		Hexadecimal h = new Hexadecimal();
		for(i=0;i<x;i++){
			for(j=0;j<y;j++){
				res[i][j] = h.hex2int(s[i][j]);
				//System.out.println(res[i][j]);
			}
		}
		
		
		return res;
	}
}
