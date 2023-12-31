package assignment5;

import java.awt.Color;
import java.util.Objects;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;
import zombies.ZombieSimulationFiles;

/**
 * A Zombie Simulator!
 */
public class ZombieSimulator {
	public static final int X = 0;
	public static final int Y = 1;
	private static final String ZOMBIE_TOKEN_VALUE = "Zombie";

	private static final Color ZOMBIE_COLOR = new Color(146, 0, 0);
	private static final Color NONZOMBIE_COLOR = new Color(0, 0, 0);
	private static final Color TEXT_COLOR = new Color(73, 0, 146);
	public static final double ENTITY_RADIUS = 0.008;

	public static final double RANDOM_DELTA_HALF_RANGE = 0.006;

	/**
	 * Read entities from a file.
	 */
	public static void readEntities(ArgsProcessor ap, boolean[] areZombies, double[][] positions) {

		// TODO: Implement this function
		// (you can probably adjust code from Assignment 4)

		int N = areZombies.length;

		int nonzombieCounter = 0;

		for (int i = 0; i < N; i++) {

			String zombie = ap.nextString();
			positions[i][X] = ap.nextDouble();
			positions[i][Y] = ap.nextDouble();

			if (zombie.equals(ZOMBIE_TOKEN_VALUE)) {

				areZombies[i] = true;
			}

			else {

				areZombies[i] = false;
				nonzombieCounter = nonzombieCounter + 1;
			}

		}
	}

	/**
	 * Draw all the entities. Zombies are drawn as ZOMBIE_COLOR filled circles of
	 * radius ENTITY_RADIUS and non-zombies with filled NONZOMBIE_COLOR filled
	 * circles of radius ENTITY_RADIUS). Further, add feedback for nonzombie count
	 * (when ready to do so), and any additional desired drawing features.
	 * 
	 * @param areZombies the zombie state of each entity
	 * @param positions  the (x,y) position of each entity
	 */
	public static void drawEntities(boolean[] areZombies, double[][] positions) {
		// DONE: Clear the frame
		StdDraw.clear();

		int nonzombieCounter = 0;
		int N = 0;
		for (int i = 0; i < positions.length; i++) {

			if (areZombies[i] == true) {

				StdDraw.setPenColor(ZOMBIE_COLOR);
				N++;
			}

			else {

				StdDraw.setPenColor(NONZOMBIE_COLOR);
				N++;
				nonzombieCounter++;
			}

			StdDraw.filledCircle(positions[i][X], positions[i][Y], ENTITY_RADIUS);
		}

		StdDraw.setPenColor(TEXT_COLOR);
		StdDraw.text(0.9, 0.008, (nonzombieCounter + "/" + N));

		// TODO: Write the loop that displays all the entities
		// (you can probably adjust code from Assignment 4)

		// DONE: Show everything that was drawn (show the updated frame). This should be
		// the only "show()" command!
		StdDraw.show();
	}

	/**
	 * Check if the entity at the given index is touching a zombie. (HINT: You know
	 * the location of the center of each entity and that they all have a radius of
	 * ENTITY_RADIUS. If the circles representing two entities overlap they are
	 * considered to be touching. Consider using the distance formula.)
	 *
	 * @param index      the index of the entity to check
	 * @param areZombies the zombie state of each entity
	 * @param positions  the (x,y) position of each entity
	 * @return true if the entity at index is touching a zombie, false otherwise
	 */
	public static boolean touchingZombie(int index, boolean[] areZombies, double[][] positions) {
		// TODO: Complete this method
		for (int i = 0; i < areZombies.length; i++) {
			double distance = Math.sqrt(Math.pow(positions[i][X] - positions[index][X], 2)
					+ (Math.pow(positions[i][Y] - positions[index][Y], 2)));

			if (areZombies[i] || areZombies[index]) {

				if (distance <= (2 * ENTITY_RADIUS)) {
					areZombies[i] = true;
					areZombies[index] = true;
					return true;
				}
			}
		}

		return false; // FIXME: Replace this so it returns the value of interest
	}

	/**
	 * Update the areZombies states and positions of all entities (assume Brownian
	 * motion).
	 *
	 * The rules for an update are:
	 * 
	 * Each entity should move by a random value between -RANDOM_DELTA_HALF_RANGE
	 * and +RANDOM_DELTA_HALF_RANGE in both the x and the y coordinates.
	 * 
	 * Entities should not be able to leave the screen. x and y coordinates should
	 * be kept between [0-1.0]
	 *
	 * If a non-zombie is touching a zombie it should change to a zombie. (HINT: you
	 * need to check all entities. On each one that is NOT a zombie, you can re-use
	 * code you've already written to see if it's "touching" a Zombie and, if so,
	 * change it to a zombie.)
	 *
	 * @param areZombies the zombie state of each entity
	 * @param positions  the (x,y) position of each entity
	 */
	public static void updateEntities(boolean[] areZombies, double[][] positions) {
		// TODO: Complete this method: It should update the positions of items in the
		// entities array

		for (int i = 0; i < areZombies.length; i++) {
			touchingZombie(i, areZombies, positions);
			double Xnew = Math.random() * (RANDOM_DELTA_HALF_RANGE - (-RANDOM_DELTA_HALF_RANGE))
					+ (-RANDOM_DELTA_HALF_RANGE);
			double Ynew = Math.random() * (RANDOM_DELTA_HALF_RANGE - (-RANDOM_DELTA_HALF_RANGE))
					+ (-RANDOM_DELTA_HALF_RANGE);
			positions[i][X] = positions[i][X] + Xnew;
			positions[i][Y] = positions[i][Y] + Ynew;

			if (positions[i][X] < 0 || positions[i][X] > 1) {
				while (positions[i][X] < 0 || positions[i][X] > 1) {
					Xnew = Math.random() * (RANDOM_DELTA_HALF_RANGE - (-RANDOM_DELTA_HALF_RANGE))
							+ (-RANDOM_DELTA_HALF_RANGE);
					positions[i][X] = positions[i][X] + Xnew;
				}
			} 

			if (positions[i][Y] < 0 || positions[i][Y] > 1) {
				while (positions[i][Y] < 0 || positions[i][Y] > 1) {
					Ynew = Math.random() * (RANDOM_DELTA_HALF_RANGE - (-RANDOM_DELTA_HALF_RANGE))
							+ (-RANDOM_DELTA_HALF_RANGE);
					positions[i][Y] = positions[i][Y] + Ynew;
				}
			}
		}

	}

	public static int nonzombieCount(boolean[] areZombies) {
		int count = 0;
		for (int i = 0; i < areZombies.length; i++) {

			if (areZombies[i] == false) {
				count++;

			}

		}
		return count;

	}
	/**
	 * Return the number of nonzombies remaining
	 */
	// TODO: Change TodoReplaceWithCorrectReturnType to appropriate return type.
	// TODO: Change TodoReplaceWithCorrectParameterType to appropriate parameter
	// type.
	// TODO: Rename todoRenameMe.
	// public static TodoReplaceWithCorrectReturnType
	// nonzombieCount(TodoReplaceWithCorrectParameterType todoRenameMe) {
	// TODO: complete this method
	// }

	/**
	 * Run the zombie simulation.
	 */
	private static void runSimulation(ArgsProcessor ap) {
		StdDraw.enableDoubleBuffering(); // reduce unpleasant drawing artifacts, speed things up

		int N = ap.nextInt();
		int nonzombieCounter = 0;
		boolean[] areZombies = new boolean[N];
		double[][] positions = new double[N][2];
		readEntities(ap, areZombies, positions);
		drawEntities(areZombies, positions);

		StdDraw.pause(500);

		while (nonzombieCount(areZombies) != 0) {
			updateEntities(areZombies, positions);
			drawEntities(areZombies, positions);
		}

		// TODO: Write the loop that will run the simulation.
		// Continue if nonzombies remain
		// Update zombie state and positions
		// Redraw

	}

	public static void main(String[] args) {
		ArgsProcessor ap = ZombieSimulationFiles.createArgsProcessorFromFile(args);
		runSimulation(ap);
	}

}
