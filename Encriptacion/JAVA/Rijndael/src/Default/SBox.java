package Default;

import java.util.Random;

public class SBox {

	public String[][] SBox;
	
	public SBox(){
				
	}
	
	public void generaSBox(){
		SBox = new String[16][16];
		int i,j;		
		System.out.println("------------------------ S-Box");
		for(i=0;i<16;i++){
			for(j=0;j<16;j++){
				SBox[i][j] = dec2hex();
				System.out.println("SBox["+i+"]["+j+"] = "+SBox[i][j]);
			}	
		}
	}
	
	public String dec2hex(){
		Random r=new Random();
		String s = Integer.toHexString(r.nextInt(255));
		if(s.length()<2)
			s="0"+s;
		return s;
	}
	
	public String[][] trans(String [][]state,int x, int y){
		int i,j;
		String num;
		String [][]trans = new String[x][y];
		for(i=0;i<x;i++){
			for(j=0;j<y;j++){
				num = state[i][j];				
				trans[i][j] = this.SBox[Integer.decode("0x"+num.charAt(0))][Integer.decode("0x"+num.charAt(1))];
				//System.out.println("trans["+i+"]["+j+"] = "+trans[i][j]);
			}	
		}	
		return trans;
	}
	
	public String[] trans(String []vector,int x){
		int i;
		String num;		
		String []trans = new String[x];
		for(i=0;i<x;i++){			
			num = vector[i];
			if(num.length()>1)
				trans[i] = this.SBox[Integer.decode("0x"+num.charAt(0))][Integer.decode("0x"+num.charAt(1))];
			else
				trans[i] = this.SBox[Integer.decode("0x0")][Integer.decode("0x"+num.charAt(0))];
			//System.out.println("trans["+i+"] = "+trans[i]);			
		}	
		return trans;
	}
}
	