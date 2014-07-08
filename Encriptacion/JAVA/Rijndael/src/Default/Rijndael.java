package Default;

public class Rijndael {
	public String State;
	public String CipherKey;
	public String [][] state, cipherKey,xor,subBytes,shrows,Mcolumns;
	public String [][] keyschedule = new String[4][20];
	public int [][] RCon;	
	public int [][] stateInt, cipherKeyInt;
	public Fichero f1,f2;
	public SBox sbox = new SBox();	
	
	public Rijndael(){
		generaRCon();
		this.sbox.generaSBox();
	}
	
	public void generaRCon(){
		RCon = new int[4][4];
		System.out.println("------------------------ RCon");
		for(int i=0,j=0;i<4;i++){
			for(j=0;j<4;j++){
				if(i==0 && j==0){
					RCon[i][j]=j+1;
				}else if(i==0){
					RCon[i][j]=j*2;
				}else{
					RCon[i][j]=0;
				}
				System.out.println("RCon["+i+"]["+j+"] = "+RCon[i][j]);
			}
		}
	}
	
	public void input(String info, String key){
		this.f1 = new Fichero(info+".txt");
		this.f2 = new Fichero(key+".txt");
		this.State = f1.leer();		
		this.CipherKey = f2.leer();		
		this.state = f1.convertir(this.State);
		this.cipherKey = f1.convertir(this.CipherKey);
		this.stateInt = f1.hex2dec(this.state, 4, 4);	
		
		System.out.println("------------------------");
		for(int i=0,j=0;i<4;i++){
			for(j=0;j<4;j++){
				System.out.println("State["+i+"]["+j+"] = "+state[i][j]);
			}
		}
		System.out.println("------------------------");
		for(int i=0,j=0;i<4;i++){
			for(j=0;j<4;j++){
				System.out.println("CipherKey["+i+"]["+j+"] = "+cipherKey[i][j]);
			}
		}
		//this.cipherKeyInt = f1.hex2dec(this.cipherKey, 4, 4);
	}
	
	public void AddRoundKey(String [][] info, String [][] key, int x, int y,int index){			
		int [][]res1 = new int[x][y];
		int [][]res2 = new int[x][y];
		this.xor = new String[x][y];
		int i,j;
		Hexadecimal d = new Hexadecimal();		
		res1 = d.hex2dec(info, x, y,0);
		res2 = d.hex2dec(key, x, y,index);
		System.out.println("------------------------");
		for(i=0;i<x;i++){
			for(j=0;j<y;j++){
				this.xor[i][j]=Integer.toHexString(res1[i][j]^res2[i][j]);
				if(this.xor[i][j].length()<2)
					this.xor[i][j]="0"+xor[i][j];
				System.out.println("AddRoundKey["+i+"]["+j+"] = "+this.xor[i][j]);
				/*System.out.println("Valor en decimal!");
				System.out.println("res1["+i+"]["+j+"]: "+res1[i][j]);
				System.out.println("res2["+i+"]["+j+"]: "+res2[i][j]);
				System.out.println("Valor en hexadecimal!");
				System.out.println("xor["+i+"]["+j+"]: "+xor[i][j]);*/
			}			
		}
		
	}
	
	public String[] AddRoundKey(String []keyschedule, String[]v, String[]RCon, int x){
		int []res1 = new int[4];
		int []res2 = new int[4];
		int []res3 = new int[4];
		String []v_xor = new String[4];
		Hexadecimal d = new Hexadecimal();		
		res1 = d.hex2dec(keyschedule, x);
		res2 = d.hex2dec(v, x);
		res3 = d.hex2dec(RCon, x);
		for(int i=0;i<x;i++){			
			v_xor[i]=Integer.toHexString(res1[i]^res2[i]^res3[i]);
			if(v_xor[i].length()<2)
				v_xor[i]="0"+v_xor[i];
			/*System.out.println("Valor en decimal!");
			System.out.println("keyschedule["+i+"]: "+res1[i]);
			System.out.println("vector["+i+"]: "+res2[i]);
			System.out.println("RCon["+i+"]: "+res3[i]);
			System.out.println("Valor en hexadecimal!");
			System.out.println("v_xor["+i+"]: "+v_xor[i]);*/			
		}
		return v_xor;
	}
	
	public void SubBytes(String[][] xor, int x, int y){
		this.subBytes = new String[x][y];						
		this.subBytes = this.sbox.trans(xor, x, y);
		System.out.println("------------------------");
		for(int i=0,j=0;i<x;i++){
			for(j=0;j<y;j++){
				System.out.println("SubBytes["+i+"]["+j+"] = "+this.subBytes[i][j]);
			}
		}
	}
	
	public void ShiftRows(String[][]subBytes,int x, int y){
		this.shrows = new String[x][y];
		int i,j;
		for(i=0;i<x;i++){
			for(j=0;j<y;j++){
				if(i==0)
					this.shrows[i][j] = subBytes[i][j];
				if(i==1){
					if(j>2)
						this.shrows[i][j] = subBytes[i][j-3];
					else
						this.shrows[i][j] = subBytes[i][j+1];
				}
				if(i==2){
					if(j>1)
						this.shrows[i][j] = subBytes[i][j-2];
					else
						this.shrows[i][j] = subBytes[i][j+2];
				}
				if(i==3){
					if(j>0)
						this.shrows[i][j] = subBytes[i][j-1];
					else
						this.shrows[i][j] = subBytes[i][j+3];
				}
			}
		}
		System.out.println("------------------------");		
		for(i=0;i<x;i++){
			for(j=0;j<y;j++){
				System.out.println("ShiftRows["+i+"]["+j+"] = "+this.shrows[i][j]);
			}
		}
	}
	
	public void MixColumns(String [][] shrows,int x,int y){
		Columns col = new Columns();
		this.Mcolumns = new String[x][y];
		col.crear_columns();				
		this.Mcolumns = col.mix(shrows);
		System.out.println("------------------------ MixColumns");
		for(int i=0,j=0;i<x;i++){
			for(j=0;j<y;j++){
				System.out.println("MixColumns["+i+"]["+j+"] = "+this.Mcolumns[i][j]);
			}
		}
	}	
	
	public void key_schedule(String [][]cipher){		
		String []vector = new String[4];		
		String []v_RCon = new String[4];
		String []v_keysch = new String[4];
		Hexadecimal d = new Hexadecimal();
		int i,j;
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				this.keyschedule[i][j]=cipher[i][j];
				if(j==3){
					vector[i]=cipher[i][j];
					//System.out.println("vector["+i+"]="+vector[i]);
				}
			}
		}	
		
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){				
				if(j==3){
					vector[i]=this.keyschedule[i][j];
					//System.out.println("vector["+i+"]="+vector[i]);
				}
			}
		}
		
		vector = recorre_vector(vector);
		vector = vector_subBytes(vector);
		
		for(int k=0;k<4;k++){
			v_RCon[k]=Integer.toHexString(this.RCon[k][0]);
			v_keysch[k]=this.keyschedule[k][0];
			//System.out.println("v_RCon["+k+"]="+v_RCon[k]);
			//System.out.println("v_keysch["+k+"]="+v_keysch[k]);
		}
		
		vector = AddRoundKey(v_keysch, vector, v_RCon, 4);
		
		for(i=0;i<4;i++){
			this.keyschedule[i][4] = vector[i];
			//System.out.println("keyschedule["+i+"][4]: "+keyschedule[i][4]);
		}
		
		j=5;
		int k=0;
		for(k=0;k<3;k++){
			for(i=0;i<4;i++){
				this.keyschedule[i][j] = Integer.toHexString(d.hex2int(keyschedule[i][j-4])^d.hex2int(keyschedule[i][j-1]));
				//System.out.println("keyschedule["+i+"]["+j+"]: "+keyschedule[i][j]);
			}
			j++;
		}
		
		for(i=0;i<4;i++){
			for(j=4;j<8;j++){				
				if(j==7){
					vector[i]=this.keyschedule[i][j];
					//System.out.println("vector["+i+"]="+vector[i]);
				}
			}
		}
		
		vector = recorre_vector(vector);
		vector = vector_subBytes(vector);			
		
		for(k=0;k<4;k++){
			v_RCon[k]=Integer.toHexString(this.RCon[k][1]);
			v_keysch[k]=this.keyschedule[k][4];
			//System.out.println("v_RCon["+k+"]="+v_RCon[k]);
			//System.out.println("v_keysch["+k+"]="+v_keysch[k]);
		}
		
		vector = AddRoundKey(v_keysch, vector, v_RCon, 4);
		
		for(i=0;i<4;i++){
			this.keyschedule[i][8] = vector[i];
			//System.out.println("keyschedule["+i+"][8]: "+keyschedule[i][8]);
		}
		
		j=9;		
		for(k=0;k<3;k++){
			for(i=0;i<4;i++){
				this.keyschedule[i][j] = Integer.toHexString(d.hex2int(keyschedule[i][j-4])^d.hex2int(keyschedule[i][j-1]));
				//System.out.println("keyschedule["+i+"]["+j+"]: "+keyschedule[i][j]);
			}
			j++;
		}
		
		for(i=0;i<4;i++){
			for(j=8;j<12;j++){				
				if(j==11){
					vector[i]=this.keyschedule[i][j];
					//System.out.println("vector["+i+"]="+vector[i]);
				}
			}
		}
		
		vector = recorre_vector(vector);
		vector = vector_subBytes(vector);			
		
		for(k=0;k<4;k++){
			v_RCon[k]=Integer.toHexString(this.RCon[k][2]);
			v_keysch[k]=this.keyschedule[k][8];
			//System.out.println("v_RCon["+k+"]="+v_RCon[k]);
			//System.out.println("v_keysch["+k+"]="+v_keysch[k]);
		}
		
		vector = AddRoundKey(v_keysch, vector, v_RCon, 4);
		
		for(i=0;i<4;i++){
			this.keyschedule[i][12] = vector[i];
			//System.out.println("keyschedule["+i+"][12]: "+keyschedule[i][12]);
		}
		
		j=13;		
		for(k=0;k<3;k++){
			for(i=0;i<4;i++){
				this.keyschedule[i][j] = Integer.toHexString(d.hex2int(keyschedule[i][j-4])^d.hex2int(keyschedule[i][j-1]));
				//System.out.println("keyschedule["+i+"]["+j+"]: "+keyschedule[i][j]);
			}
			j++;
		}
		
		for(i=0;i<4;i++){
			for(j=12;j<16;j++){				
				if(j==15){
					vector[i]=this.keyschedule[i][j];
					//System.out.println("vector["+i+"]="+vector[i]);
				}
			}
		}
		
		vector = recorre_vector(vector);
		vector = vector_subBytes(vector);			
		
		for(k=0;k<4;k++){
			v_RCon[k]=Integer.toHexString(this.RCon[k][3]);
			v_keysch[k]=this.keyschedule[k][12];
			//System.out.println("v_RCon["+k+"]="+v_RCon[k]);
			//System.out.println("v_keysch["+k+"]="+v_keysch[k]);
		}
		
		vector = AddRoundKey(v_keysch, vector, v_RCon, 4);
		
		for(i=0;i<4;i++){
			this.keyschedule[i][16] = vector[i];
			//System.out.println("keyschedule["+i+"][16]: "+keyschedule[i][16]);
		}
		
		j=17;		
		for(k=0;k<3;k++){
			for(i=0;i<4;i++){
				this.keyschedule[i][j] = Integer.toHexString(d.hex2int(keyschedule[i][j-4])^d.hex2int(keyschedule[i][j-1]));
				//System.out.println("keyschedule["+i+"]["+j+"]: "+keyschedule[i][j]);
			}
			j++;
		}
		
		System.out.println("------------------------ Key Schedule");
		for(i=0;i<4;i++){
			for(j=0;j<20;j++){
				System.out.println("KeySchedule["+i+"]["+j+"] = "+this.keyschedule[i][j]);
			}
		}
	}
	
	public String[] recorre_vector(String []v){
		String []new_vector = new String[4];
		for(int i=0;i<4;i++){
			if(i==3)
				new_vector[i]=v[i-3];
			else
				new_vector[i]=v[i+1];
			//System.out.println("new_vector["+i+"]="+new_vector[i]);
		}
		return new_vector;
	}
	
	public String[] vector_subBytes(String []v){
		String []new_vector = new String[4];		
		new_vector = this.sbox.trans(v, 4);		
		return new_vector;
	}
	
	public String print(String[][] m){
		String s="";
		for(int i=0,j=0;i<4;i++){
			for(j=0;j<4;j++){
				//System.out.println("CipherKey["+i+"]["+j+"]: "+m[i][j]);
				s+=m[i][j];
			}
		}
		return s;
	}

	public static void main(String args[]){	
		Rijndael rijndael = new Rijndael();		
		rijndael.input("State","CipherKey");
		rijndael.key_schedule(rijndael.cipherKey);
		//Ronda Inicial
		rijndael.AddRoundKey(rijndael.state, rijndael.cipherKey, 4, 4,0);
		//Ronda 1, 2 y 3
		for(int i=0;i<3;i++){
			rijndael.SubBytes(rijndael.xor, 4, 4);
			rijndael.ShiftRows(rijndael.subBytes, 4, 4);
			rijndael.MixColumns(rijndael.shrows,4,4);		
			rijndael.AddRoundKey(rijndael.state, rijndael.keyschedule, 4, 4,(i+1)*4);		
		}
		//Ronda Final
		rijndael.SubBytes(rijndael.xor, 4, 4);
		rijndael.ShiftRows(rijndael.subBytes, 4, 4);
		rijndael.AddRoundKey(rijndael.state, rijndael.keyschedule, 4, 4,16);		
		
		//Generación de la clave
		Fichero f = new Fichero("CipherText.txt");
		f.escribir(rijndael.print(rijndael.xor));
	}
}