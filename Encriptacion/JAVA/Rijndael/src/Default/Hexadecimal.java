package Default;

public class Hexadecimal {
	public int hex2int(String hex){		
		String prefix = "0x";
		hex = prefix + hex;
		return Integer.decode(hex);		
	}
	
	public int[][] hex2dec(String[][] s, int x, int y, int index){
		int i,j;
		int [][]res = new int[x][y];
		Hexadecimal h = new Hexadecimal();
		for(i=0;i<x;i++){
			for(j=0;j<y;j++){				
				res[i][j] = h.hex2int(s[i][index]);
				if(index<(y-1))
					index++;
				//System.out.println(res[i][j]);
			}
			index=0;
		}
		return res;
	}
	
	public int[] hex2dec(String[] s, int x){
		int i;
		int []res = new int[x];
		Hexadecimal h = new Hexadecimal();
		for(i=0;i<x;i++){			
			res[i] = h.hex2int(s[i]);
			//System.out.println(res[i][j]);
		}
		return res;
	}
}