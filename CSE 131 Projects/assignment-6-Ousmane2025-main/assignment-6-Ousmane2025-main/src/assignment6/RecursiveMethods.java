package assignment6;

public class RecursiveMethods {

	/**
	 * Recursively computes base ^ exponent
	 * 
	 * @param base the base - can be positive or negative
	 * @param exp  the exponent - can be positive or negative
	 * @return base ^ exponent
	 */
	public static double exponent(int base, int exp) {

		if (exp == 1) {

			return base;

		}

		if (exp > 0) {
			return (base * exponent(base, exp - 1) / base);

		}

		else if (exp < 0) {
			return (exponent(base, exp + 1) / base);

		}

		else {

			return 1; // Anything to the power of 0 is 1.
		}

	}
	// FIXME Recursively compute base^exp

	/**
	 * Recursively compute the sum of elements in an array
	 * 
	 * @param array an array of integers
	 * @return the sum of the elements in values
	 */
	public static int arraySum(int[] array) {

		return arrayHelper(array, array.length);
	}

	public static int arrayHelper(int[] array, int n) {

		if (n == 0) {

			return 0;

		}

		int total = arrayHelper(array, n - 1) + array[n - 1];
		return total;

		// sum = array[n] + arraySum(int[] array , n-1);

		// FIXME: Recursively compute the sum of the values in an array

	}

	/**
	 * Return a new String which is the original source String with all occurrences
	 * of the target character substituted by the replacement String.
	 * 
	 * @param source      the source String
	 * @param target      the target character to be replaced
	 * @param replacement the replacement String
	 * 
	 * @return the String which results from substituting all of the target
	 *         characters in the source String with the replacement String
	 */
	public static String substituteAll(String source, char target, String replacement) {
		String result = "";
		for (int i = 0; i < source.length(); ++i) {
			char ch = source.charAt(i);
			if (ch == target) {
				result = result + replacement;
			} else {
				result = result + ch;
			}
		}
		return result;
	}

	/**
	 * Recursively computes string representations of dragon curves
	 * 
	 * @param n the desired degree of the dragon curve
	 * @return the nth dragon curve
	 */

	private static String F(int n) {
		if (n == 0) {

			return "F";
		}

		else {

			return F(n - 1) + "-" + H(n - 1);
		}
	}

	private static String H(int n) {
		if (n == 0) {
			return "H";

		}

		else {
			return F(n - 1) + "+" + H(n - 1);
		}
	}

	public static String dragon(int n) {

		// FIXME Recursively compute dragon curves
		return F(n + 1);

	}

	/**
	 * Finds the length of the longest path in the given 2D array from the specified
	 * start position.
	 * 
	 * @param chart 2D array of stones
	 * @param r     start position row
	 * @param c     start position column
	 * @return the length of the longest path that was found
	 */
	public static int maxPathLength(boolean[][] chart, int r, int c) {

		if (r < 0 || c < 0 || r > chart.length - 1 || c > chart[0].length - 1 || chart[r][c] == false) {
			return 0;

		}

		else {
			chart[r][c] = false;
			int up = maxPathLength(chart, r - 1, c);
			int down = maxPathLength(chart, r + 1, c);
			int left = maxPathLength(chart, r, c - 1);
			int right = maxPathLength(chart, r, c + 1);

			chart[r][c] = true;
			return (1 + Math.max(Math.max(up, right), Math.max(down, left)));

		}
		// FIXME Find and return the length of the longest path in the array

	}
}
