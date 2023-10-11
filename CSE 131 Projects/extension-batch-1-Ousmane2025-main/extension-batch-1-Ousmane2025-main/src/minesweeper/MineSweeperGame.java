package minesweeper;

import java.io.IOException;

import support.cse131.ArgsProcessor;
import support.cse131.minesweeper.MineSweeperUtils;
import support.cse131.minesweeper.game.Model;
import support.cse131.minesweeper.game.viz.Controller;
import support.cse131.minesweeper.game.viz.StreamToBoardAdapter;

public class MineSweeperGame {

	public static void main(String[] args) throws IOException {

		ArgsProcessor ap = new ArgsProcessor(args);

		int cols = ap.nextInt("How many columns?");
		int rows = ap.nextInt("How many rows?");
		double probability = ap.nextDouble("What is the probability of a bomb?");

		//
		// Run the student's game, capturing the output to create the game board
		//
		String output = MineSweeperUtils.runMain(cols, rows, probability);

		//
		// Here is what the student's code printed
		//
		System.out.println("Output from student's code:");
		System.out.println("---------------------------------------");
		System.out.println(output);
		System.out.println("---------------------------------------");

		StreamToBoardAdapter myStream = new StreamToBoardAdapter(new String(output), cols, rows);
		Model model = new Model(myStream.getBoard());
		System.out.println("\nGame will be played based on this board:");
		model.print(true);
		Controller game = new Controller(model);
		game.run();
	}

}
