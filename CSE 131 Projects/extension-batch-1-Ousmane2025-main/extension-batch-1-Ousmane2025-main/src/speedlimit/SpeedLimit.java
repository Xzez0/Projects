package speedlimit;

import support.cse131.ArgsProcessor;

public class SpeedLimit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int reportedSpeed = ap.nextInt("How fast was the person going?: ");
		int speedLimit = ap.nextInt("What is the speed limit: ");
		int speedFine = 100;
		int speedDifference  = (reportedSpeed - speedLimit);
		
		if (speedDifference >= 10) {
			
			int overFine = (speedDifference * 10);
			 
			System.out.println("You reported a speed of " + reportedSpeed +" MPH for a speed limit of " +speedLimit +" MPH.");
			System.out.println("You went " + speedDifference + " MPH over the speed limit.");
			System.out.println("Your fine is $" +overFine +".");
		}
		
	
		if ((speedDifference < 10 ) && (reportedSpeed > speedLimit)) {
			
			System.out.println("You reported a speed of " + reportedSpeed +" MPH for a speed limit of " +speedLimit +" MPH.");
			System.out.println("You went " + speedDifference + " MPH over the speed limit.");
			System.out.println("Your fine is $" + speedFine +".");
		
		}
		
		else if (speedDifference <= 0) {
			
			System.out.println("Have a nice day.");
			
		}
		

	}

}
