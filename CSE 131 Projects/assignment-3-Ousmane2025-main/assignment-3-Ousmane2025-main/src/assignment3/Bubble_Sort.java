package assignment3;

import java.util.Arrays;

import support.cse131.ArgsProcessor;

public class Bubble_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);

//-----------------------------------------------------------------User Input-------------------------------------------------------------------------
		
		int  length = ap.nextInt("Please input the length of your array: ");
		
		int  set[] = new int[length];
				
//-----------------------------------------Assigning the integers provided by user into specific indexes----------------------------------------------
		
		for (int index = 0; index <= (length - 1); index = index + 1) {

			
				int value = ap.nextInt("Choose your integers: ");
				set[index] = value;
				
				
		}
						
		System.out.println("Given values " +Arrays.toString(set));
	
//-------------------------------------------------------Swapping the order of the arrays-------------------------------------------------------------
				
		int n = set.length;
		
		for (int i = 0; i <= (length - 1); i = i + 1) {  // Goes through each index to see if it's greater than the ones before
			
			for (int index = 1; index <= (n-i-1); index = index + 1) {
			
				if (set[index - 1] > set[index]){ // Checking previous index
				
					
				int switch_over = set[index-1]; // Swapping places
				int s2 = set[index];

				set[index-1] = s2;
				set[index]= switch_over;
				
		
				}	
			}
			
		}
		
		System.out.println("New arrangement: " +Arrays.toString(set));
		
	}	 
}

		
		
		
		
		
		
		
		
