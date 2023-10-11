package fibonacci;

public class Fibonacci {

	/**
	 * Below copy your solution to recursive Fibonacci from studio
	 * 
	 * @param n
	 * @return the nth Fibonacci number, computed recursively
	 */
	public static int recursive(int n) {
		
			if(n<=1) {
				return n;
			}
		
			return recursive(n-1) + recursive(n-2);
	}

	/**
	 * Below write your solution to Fibonacci, using iteration
	 * 
	 * @param n
	 * @return the nth Fibonacci number, computed iteratively
	 */
	public static int iterative(int n) {
		
		int z = 1;
		int c = 1;
			
			if (n < 1|| n== 1) {
				
				return n;
			}
		
			
			for (int i = 2; i < n; i++) {
				int FibCurrent = c;
				c+= z;
				z = FibCurrent;
				
			}
			
			return c;
	}

}
