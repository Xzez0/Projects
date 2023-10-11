package assignment3;

import support.cse131.ArgsProcessor;

public class Symmetrical_Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		
	
		int n = ap.nextInt("Enter you nth dimension: ");
		int m = ap.nextInt("Enter you mth dimension: ");
		int mm = m/2;
		String set[][] = new String[n][mm]; // Fill up half the columns of the desired 
		String mirror[][] = new String[n][mm];
		
		
		for (int z = 0;  z < (n); z++) {
			for (int e = 0;  e < mm; e++) { 
			
			set[z][e] = " "; 
			mirror[z][e] = " ";
			}}
			
			for (int i = 0; i < (n*mm)/4 ; i++ ) {
		
				
							
				int h = (int)(Math.random() * n);
				int k = (int)(Math.random() * mm);
				
				
						set[h][k] = "*";
						mirror[h][(mm-k)-1] = "*"; // Tell the mirrored array to be place in in it's mirrored spot.
						// if the array is a 10x10 in position 2,3 , then the mirrored position is 2,7
					
			}
		
			
		
		for (int f = 0; f < n ;f++) { 
			for (int d = 0; d < mm ;d++) { 
				
			
			System.out.print(set[f][d] + mirror[f][d]);
			}
			
			System.out.println();
			
		}
	
		
	}
}

