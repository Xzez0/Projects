package assignment01;

import support.cse131.ArgsProcessor;

public class GradeCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		
// ------------------------------------------------Name-------------------------------------------------------
	
	String name = ap.nextString("Enter the student's name");
	System.out.println("CSE 131 Grade for " + name);
	
// -------------------------------------Average Assignment Grade----------------------------------------------
	
	 double averageAssignmentGrade = ap.nextDouble("Average assignment grade");
	 
	 double averageOutput = (double) (averageAssignmentGrade * .40);
	 
	 System.out.println("Average assignment grade: " + averageAssignmentGrade + "%");
	 System.out.println("Weighted assignment grade (out of 40): " + Math.round(averageOutput * 100.00)/100.00 + "%");
	 
// ---------------------------------------------Extension-----------------------------------------------------
		
	 int extensionPoints = ap.nextInt("Number of extension points");
	 
	 double extensionOutput = (double) ((extensionPoints/.40)*.12);
	 
	 System.out.println("Number of extension points: " + extensionPoints);
	 System.out.println("Weighted extension grade (out of 12): " + Math.round(extensionOutput * 100.00)/100.00 + "%");

// -------------------------------------------- Studios Attended ---------------------------------------------
		
	 double studiosAttended = ap.nextInt("Number of studios attended");
	 
	 double studiosAoutput = (double) ((studiosAttended/8) * 13);
	 
	 System.out.println("Number of studios attended: " + Math.round(studiosAttended * 100)/100);
	 System.out.println("Weighted studio grade (out of 13): " + Math.round(studiosAoutput * 100.00)/100.00 + "%");

//  ------------------------------------------Average quiz grade ---------------------------------------------
		
	 double averageQuizGrade = ap.nextDouble("Average quiz grade");
	 
	 double quizOutput = (double) (averageQuizGrade * .02);
	 
	 System.out.println("Average quiz grade: " + averageQuizGrade + "%");
	 System.out.println("Weighted quiz grade (out of 2): " + Math.round(quizOutput * 100.00)/100.00 + "%");

//  -------------------------------------------Studio Preps --------------------------------------------------
		
	 int studioPrepsCompleted = ap.nextInt("Studio preps completed");
	 
	 double studioOutput = (double) ((studioPrepsCompleted * .02)*10);
	 
	 
	 System.out.println("Studio preps completed " + studioPrepsCompleted);
	 System.out.println("Weighted studio prep grade (out of 2): " + Math.round(studioOutput *100.00)/100.00 + "%");

//  ------------------------------------------Average Exam Grade ---------------------------------------------
		
	 double averageExamGrade = ap.nextDouble("Average exam grade");
	 
	 double examOutput = (double) (averageExamGrade * .30);
	 
	 System.out.println("Average exam grade: " + averageExamGrade + "%");
	 System.out.println("Weighted exam grade (out of 30): " + Math.round(examOutput *100.00)/100.00 + "%");
	 
// ---------------------------------------------Course Review-------------------------------------------------
	 
	 // total grade + 1% from course evaluation 
	 
	 double gradeTotal = (double)(averageOutput + extensionOutput + studiosAoutput + quizOutput + studioOutput + examOutput + 1);
	 boolean courseReview = Math.random() > 0.5;
	
	 System.out.println("Completed course review: " + courseReview);
	 System.out.println("Total Grade: " + Math.round(gradeTotal * 100.0)/100.0 + "%");
	 
	 
	}
}

	