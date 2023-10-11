package mousechaser;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;
import support.cse131.Timing;

public class ChaseTheMouse {
	private static final int X = 0;
	private static final int Y = 1;

	/**
	 * @return the current x and y coordinates of the mouse
	 */
	public static double[] getMousePosition() {
		
		double [] mouse = {StdDraw.mouseX() , StdDraw.mouseY()};
		return mouse;
		
	}
	
	
// --------------------------------------------------------------------------------------------------------------------------

	/**
	 * Draw a ball of radius r at the specified location
	 * 
	 * @param location the x and y coordinate for the ball
	 * @param radius   the radius of the ball
	 */
	public static void drawBall(double[] location, double radius) {
		
		
		StdDraw.filledCircle(location[0], location[1], radius);
		
	}
	
// --------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @param v value
	 * @return v^2
	 */
	public static double square(double v) {
		
			return (v * v);
	}

	
// --------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @param xy vector in 2D space
	 * @return magnitude of xy
	 */
	public static double calculateMagnitude(double[] xy) {
		
	double magnitude =	Math.sqrt(square(xy[X]) + square(xy[Y]));
	return magnitude;
		
	}

	
// --------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @param a vector in 2D space
	 * @param b vector in 2D space
	 * @return a + b
	 */
	public static double[] add(double[] a, double[] b) {
		
		double xDim = a[X] + b[X];
		double yDim	= a[Y] + b[Y];
		double[] addedVector = {xDim , yDim};
		
		return addedVector;
		
	}

// -------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @param a vector in 2D space
	 * @param b vector in 2D space
	 * @return a - b
	 */
	public static double[] subtract(double[] a, double[] b) {
		
		double xDim = (a[X] - b[X]);
		double yDim	= (a[Y] - b[Y]);
		double[] subVector = {xDim , yDim};
		return subVector;
		
	}

	/**
	 * @param xy     vector in 2D space
	 * @param scalar
	 * @return xy * scalar
	 */
	public static double[] scalarMultiply(double[] xy, double scalar) {
		
		double xDim = xy[X] * scalar;
		double yDim	= xy[Y] * scalar;
		double[] scaledVector = {xDim , yDim};
		return scaledVector;
		
	}

// --------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param currentBallPosition the location of the ball currently
	 * @param mousePosition       the location of the mouse currently
	 * @param speed               the speed with which the ball should move toward
	 *                            the mouse
	 * @param deltaTime           the elapsed time
	 * @return the next location of the ball given its current position, the mouse's
	 *         position, the speed, and the time change
	 */
	public static double[] calculateNextPosition(double[] currentBallPosition, double[] mousePosition, double speed,
			double deltaTime) {
		
		double magnitude = calculateMagnitude(subtract(mousePosition, currentBallPosition));
		
		if (magnitude > (speed * deltaTime)) {
			
	//	double[] difference = subtract(mousePosition, currentBallPosition);
			double xValue = currentBallPosition[X] + (speed * deltaTime)*(mousePosition[X] - currentBallPosition[X])/magnitude;
			double yValue = currentBallPosition[Y] + (speed * deltaTime)*(mousePosition[Y]- currentBallPosition[Y])/magnitude;
			double[] change = {xValue, yValue};
			
			return change;
		
		}
			//double deltaPosition = deltaTime * speed;
		else {
			
			return mousePosition;
		
		}
			
			
			// Return the next ball position as specified in the write up
		
	}

// --------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Simulate a ball chasing the mouse.
	 */
	public static void chaseTheMouse() {
		
			StdDraw.enableDoubleBuffering();
			
			double[] newPosition = {Math.random() , Math.random()}; // New Random Positon
			
			drawBall(newPosition , .02); 
			StdDraw.setPenColor(Color.BLUE);// Drawing Ball
			
			double Speed = 98;
			double Time = .3;
			
			
			while(true) {
				
				StdDraw.clear();
				double[] newMouse = getMousePosition();
				double[] newBall = calculateNextPosition(newPosition, newMouse, Speed,
						Time);
				newPosition = newBall;
				
				drawBall(newBall,.02);
				
				StdDraw.show();
			}
			
			
			
	}

	public static void main(String[] args) {
		chaseTheMouse();
	}
}
