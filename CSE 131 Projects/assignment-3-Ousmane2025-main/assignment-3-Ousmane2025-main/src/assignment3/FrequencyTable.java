package assignment3;


import support.cse131.ArgsProcessor;

public class FrequencyTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArgsProcessor ap = new ArgsProcessor(args);



//----------------------------------Creating an array of random integers between (1 and n)-----------------------------------------------

		int min = 1;
		int max_n = ap.nextInt("Provide a maximum value: ");

		int x = ap.nextInt("Provide the desired amount of generate values between 1 and " + max_n +" : ");

		System.out.println("Frequencies for " + x +" randomly generated values between " +min +" and " + max_n);

		int Range[] = new int[x];
		int set[] = new int [max_n];

//------------------------------------------------Generating Frequencies-----------------------------------------------------------------

		for (int i = 0; i <= x-1 ; i++) {

			int a = (int) (Math.random()* max_n); // Setting the max
			Range[i] = a;


			set[a]= set[a] + 1; // Setting frequency counter
		}

		for (int i = 0; i <= max_n - 1; i++) {

			System.out.println((i+1) +":" +set[i]);
		}


	}		

}

