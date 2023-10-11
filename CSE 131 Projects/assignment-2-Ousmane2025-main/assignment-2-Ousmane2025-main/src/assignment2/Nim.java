package assignment2;

import support.cse131.ArgsProcessor;

public class Nim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArgsProcessor ap = new ArgsProcessor(args);

		int Start = ap.nextInt("Please input the number of sticks being played: ");
		int Current = Start;
		int RoundCount = 0;

		while (Current > 1) {

			int Remove = ap.nextInt("How many sticks do you want to remove?: ");

			while ((Remove <= 0) || (Remove > 2)) {

				Remove = ap.nextInt("Please choose only 1 or 2 sticks: ");
			}

			if (Current == 1) {
				while (Remove != 1) {

					Remove = ap.nextInt("Please choose only 1 or 2 sticks: ");
				}
			}
// --------------------------------------------------------Human's Turn-------------------------------------------------------------------

			if (Remove == 2) {

				Current -= 2;

				System.out.println("Round " + RoundCount + ":" + (Current + 2) + " at the start human takes 2, so "
						+ Current + " remain");

				RoundCount += 1;

				if (Current <= 0) {

					System.out.println("You Win! - Computer Loses!");
					// break;

				}
			}

			else {

				Current -= 1;
				System.out.println("Round " + RoundCount + ":" + (Current + 1) + " at the start human takes 1, so "
						+ Current + " remain");

				RoundCount += 1;

				if (Current <= 0) {

					System.out.println("You Win! - Computer Loses!");
					// break;

				}
			}

// ---------------------------------------------------Computer's Turn----------------------------------------------------------------------	

			if (Current > 0) {

				boolean Computer = Math.random() > 0.5;

				if ((Computer) || (Current == 1)) {

					int computerStart = Current - 1;

					System.out.println("Round " + RoundCount + ":" + Current + " at the start computer takes 1, so "
							+ computerStart + " remain");
					Current = computerStart;

					RoundCount = RoundCount + 1;

					if (computerStart <= 0) {

						System.out.println("Computer Wins! You Lose!");
						// break;
					}

					else {
					}
				}

				else {

					int comStart = Current - 2;
					System.out.println("Round " + RoundCount + ":" + Current + " at the start computer takes 2, so "
							+ comStart + " remain");

					Current = comStart;

					if (comStart <= 0) {

						System.out.println("Computer Wins! You Lose");
						// break;

					}

					else {
					}
				}

			}
		}

	}
}
