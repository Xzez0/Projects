package mario;

import support.cse131.ArgsProcessor;

public class Mario {

	public static void main(String[] args) {

		//
		// Surprise! This part is done for you.
		// Don't change this and don't ask for any other inputs
		// or testing will fail
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int size = ap.nextInt("What size mountain do you want?");
		int pattern = ap.nextInt("What pattern (1, 2, 3, or 4)?");

		if (size < 1)
			throw new IllegalArgumentException("Size must be at least 1");
		if (pattern < 1 || pattern > 4)
			throw new IllegalArgumentException("Invalid pattern, must be 1, 2, 3, or 4.  Mario aborts");

		//
		// Create the mountain by printing to System.out
		//


		String mountain[][] = new String[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size ; j++) {

				mountain[i][j] = " ";
			}
		}

// ----------------------------------------- Pattern 1--------------------------------------------------------------------

		if (pattern == 1) {

			for (int i = 0; i < size; i++) {
				for (int j = size-1-i; j < size; j++) {

					mountain[i][j] = "#";		
				}
			}

			for (int f = 0; f < size ;f++) { 
				for (int d = 0; d < size ;d++) { 


					System.out.print(mountain[f][d]);
				}

				System.out.println();
			}


		}

// -----------------------------------------Pattern 2-------------------------------------------------------------------


		if (pattern == 2) {

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < i + 1; j++) {

					mountain[i][j] = "#";		
				}
			}

			for (int f = 0; f < size ;f++) { 
				for (int d = 0; d < size ;d++) { 


					System.out.print(mountain[f][d]);
				}

				System.out.println();
			}
		}

//-----------------------------------------------------Pattern 3--------------------------------------------------------
		
		if (pattern == 3) {
			
			

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {

					mountain[i][j] = "#";				
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < i ; j++) {

					mountain[i][j] = " ";		
				}
			}
		
			for (int f = 0; f < size ;f++) { 
				for (int d = 0; d < size ;d++) { 


					System.out.print(mountain[f][d]);
				}

				System.out.println();
			}


		}
		
//-----------------------------------------------------Pattern 4--------------------------------------------------------
		
				if (pattern == 4) {

					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size - i; j++) {

							mountain[i][j] = "#";				
						}
					}

					for (int f = 0; f < size ;f++) { 
						for (int d = 0; d < size ;d++) { 


							System.out.print(mountain[f][d]);
						}

						System.out.println();
					}


				}

	}
}