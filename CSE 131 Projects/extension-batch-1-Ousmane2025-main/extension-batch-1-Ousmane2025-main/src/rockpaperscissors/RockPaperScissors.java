package rockpaperscissors;

import support.cse131.ArgsProcessor;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int iterations = ap.nextInt("How many simulations do you want? ");
		int player = 0;
		int wins = 0;
		int lost = 0;
		
		for(int i = 0; i <= iterations; i++) {
			
			String playersmove = " "; 
			
			if (player == 0) {
				
				playersmove = "Rock";
				
			}
			
			else if (player == 1) {
				playersmove = "Paper";
				
			}
			
			else {
				playersmove = "Scissors";
				
				
			}
			
			player++;
			
			if(player >= 3) {
				player = 0;
			}
			
			System.out.println("Player: " +playersmove);
				
			
		int Computer = (int) (Math.random() * 3);
			
		String computersmove = " "; 
		
		if (Computer == 0) {
			
			computersmove = "Rock";
			
		}
		
		else if (Computer == 1) {
			computersmove = "Paper";
			
		}
		
		else {
			computersmove = "Scissors";
			
			
		}
		
		System.out.println("Computer's Move: " +computersmove);
		
		if (playersmove == computersmove) {
			
			
		}
		
		else if (computersmove == "Rock" && playersmove == "Scissors" ||
				computersmove == "Paper" && playersmove == "Rock") {
			
			lost++;
		}

		else { wins++;
		
		}
		
		System.out.println("Player wins " +wins +" games out of " +iterations +" rounds");
		System.out.println("Computer wins " +lost +" games out of " +iterations +" rounds");
		
		
		if(wins > lost) {
			System.out.println("Player Wins!");
			
			
		}
		
		else {
			
			System.out.println("Computer Wins!");
		}
	}

}}
