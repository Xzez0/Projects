package assignment4;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;
import zombies.ZombieSimulationFiles;

public class ZombieData {

	public static void main(String[] args) throws Exception {
		// NOTE: The line below will prompt the user with a file open dialog box.
		// The contents of the selected file will be made available via the
		// ArgsProcessor ap.
		ArgsProcessor ap = ZombieSimulationFiles.createArgsProcessorFromFile(args);

		// TODO: 1. Read in the number of entities from the ArgsProcessor

		int N = ap.nextInt();
		boolean areZombies[] = new boolean[N];
		double xs[] = new double[N];
		double ys[] = new double[N];
		int nonzombieCounter = 0;

		for (int i = 0; i < N; i++) {

			String zombie = ap.nextString();
			xs[i] = ap.nextDouble();
			ys[i] = ap.nextDouble();

			if (zombie.equals("Zombie")) {

				areZombies[i] = true;
			}

			else if (zombie.equals("Nonzombie")) {

				areZombies[i] = false;
				nonzombieCounter = nonzombieCounter + 1;
			}
		}

		for (int z = 0; z < N; z++) {

			if (areZombies[z] == true) {
				StdDraw.setPenColor(StdDraw.RED);
			}

			else {

				StdDraw.setPenColor(StdDraw.BLACK);
			}

			StdDraw.filledCircle(xs[z], ys[z], 0.008);
			StdDraw.text(0.9, 0.008, (nonzombieCounter + "/" + N));
		}

	}

}

// TODO: 2. Create the arrays that will hold entity data

// TODO: 3. Read in all the Entity data

// TODO: 4. Iterate through all the data and display it using StdDraw
