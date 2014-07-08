package Default;

public class Columns {
	public int[][] columns;
	
	public Columns(){
		//crear_columns();
	}
	
	public void crear_columns(){
		this.columns = new int[4][4];
		System.out.println("------------------------ Transformación Lineal");
		for(int i=0,j=0;i<4;i++){
			for(j=0;j<4;j++){
				if(i==j){
					this.columns[i][j] = 2;
				}else 
					if(i==(j-1) || (i==3 && j==0))
						this.columns[i][j] = 3;
					else
						this.columns[i][j] = 1;
				System.out.println("Matriz["+i+"]["+j+"] = "+this.columns[i][j]);
			}
		}
	}
	
	public void print(){
		for(int i=0,j=0;i<4;i++){
			for(j=0;j<4;j++){
				//System.out.println("this.columns["+i+"]["+j+"]: "+this.columns[i][j]);
				}
		}
	}
	
	public String[][] mix(String[][] matrix){
		String [][] result = new String[4][4];
		int i;
		for(i=0;i<4;i++){
			result[i]=ret_vector(matrix[i]);
		}
		return result;
	}
	
	public String[] ret_vector(String[] v){		
		String [] result = new String[4];
		int [] intresult = new int[4];
		int [] m1 = new int[4];
		m1 = vhex2vint(v);
		int aux = 0, doble = 0, pivote = 0;
		for(int i=0,j=0;i<4;i++){			
			for(j=0;j<4;j++){
				if(this.columns[i][j]==1){
					aux ^= m1[pivote]; 					
				}
				if(this.columns[i][j]==2){
					doble = m1[pivote]<<1;
					if(doble>256)
						doble -= 256;
					aux ^= doble ^ 27;					
				}
				if(this.columns[i][j]==3){
					doble = (m1[pivote]*2)^m1[pivote];
					if(doble>256)
						doble -= 256;
					aux ^= doble ^ 27;	
				}
				if(pivote<3)
					pivote++;
			}
			intresult[i] = aux;			
			//System.out.println("intresult["+i+"]: "+intresult[i]);
			pivote = 0;
			aux = 0;
		}		
		result = vint2vhex(intresult);
		return result;
	}
	
	public int[] vhex2vint(String[] v){
		Hexadecimal h = new Hexadecimal();
		int[] vint = new int[4];
		for(int i=0;i<4;i++){
			vint[i] = h.hex2int(v[i]);
			//System.out.println("vint["+i+"]: "+vint[i]);
		}
		return vint;
	}
	
	public String[] vint2vhex(int[] v){
		String[] vstr = new String[4];
		for(int i=0;i<4;i++){
			vstr[i] = Integer.toHexString(v[i]);
		}
		return vstr;
	}
}
