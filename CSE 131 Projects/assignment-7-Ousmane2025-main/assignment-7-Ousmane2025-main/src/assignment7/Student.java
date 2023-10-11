package assignment7;

public class Student {

	private String firstName;
	private String lastName;
	private int Id;
	private double attemptedCredits;
	private double passingCredits;
	private double TotalGradeQualityPoints;
	private double BearBucksBalance;
	private double calculatedGradePointAverage;

// ---------------------------------------------------------Student Name ----------------------------------------------------------------------------------------------

	public Student(String firstName, String lastName, int Id) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.Id = Id;

	}

	public String getFullName() {

		String FullName = firstName + " " + lastName;
		return FullName;

	}

// ------------------------------------------------------------------- ID -----------------------------------------------------------------------------------------------

	public void setID(int ID) {

		this.Id = ID;

	}

	public int getId() {

		int StudentID = Id;
		return StudentID;

	}

// ------------------------------------------------------------------- Attempted Credits -----------------------------------------------------------------------------------------------

	public double getTotalAttemptedCredits() {
		return this.attemptedCredits;

	}

// ------------------------------------------------------------------- Passing Credits -----------------------------------------------------------------------------------------------

	public double getTotalPassingCredits() {

		return passingCredits;

	}

// -----------------------------------------------------------------Submit Grade-----------------------------------------------------------------------------------------------

	public void submitGrade(double grade, int credits) {

		this.TotalGradeQualityPoints += grade * credits;
		this.attemptedCredits += credits;

		if (grade >= 1.7) {
			passingCredits += credits;
		}

	}
// ------------------------------------------------------------------- GPA -----------------------------------------------------------------------------

	public double calculateGradePointAverage() {

		this.calculatedGradePointAverage = (double) (this.TotalGradeQualityPoints / this.attemptedCredits);
		return this.calculatedGradePointAverage;

	}

// ---------------------------------------------------- Class Standing---------------------------------------------------------------------------------------------

	public String getClassStanding() {

		if (passingCredits < 30) {

			return "First Year";

		}

		else if ((passingCredits >= 30) && (passingCredits < 60)) {

			return "Sophomore";
		}

		else if ((passingCredits >= 60) && (passingCredits < 90)) {

			return "Junior";

		}

		else if (passingCredits >= 90) {

			return "Senior";
		}

		return getClassStanding();

	}

// ---------------------------------------------------- Phi Beta Kappa ---------------------------------------------------------------------------------------------

	public boolean isEligibleForPhiBetaKappa() {

		if (((this.passingCredits >= 98) && (calculateGradePointAverage() >= 3.6))
				|| ((this.passingCredits >= 75) && (calculateGradePointAverage() >= 3.8))) {

			return true;

		}

		else {

			return false;
		}

	}

// ---------------------------------------------------- Add Bear Bucks  ---------------------------------------------------------------------------------------------

	public Student(double BearBucksBalance) {

		this.BearBucksBalance = BearBucksBalance;

	}

	public void depositBearBucks(double amount) {

		this.BearBucksBalance = this.BearBucksBalance + amount;

	}

// ---------------------------------------------------- Subtract Bear Bucks  ---------------------------------------------------------------------------------------------

	public void deductBearBucks(double amount) {

		this.BearBucksBalance = this.BearBucksBalance - amount;

	}

// ---------------------------------------------------- Get Bear Bucks Balance  ---------------------------------------------------------------------------------------------

	public double getBearBucksBalance() {
		return BearBucksBalance;

	}

	public double cashOutBearBucks() {

		double BearBucks = 0;

		if (this.BearBucksBalance > 10) {

			BearBucks = this.BearBucksBalance - 10;
			this.BearBucksBalance = 0;
			return BearBucks;
		}

		else {

			this.BearBucksBalance = 0;
			return BearBucks;
		}
	}

	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {

		String lastName = " ";

		if (isHyphenated == true) {
			lastName = this.lastName + "-" + other.lastName;

		}

		else {

			lastName = this.lastName;
		}

	Student Child = new Student(firstName, lastName, id);
		Child.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
		return Child;

	}

	public String toString() {

		String FullName = firstName + " " + lastName + " ";
		return FullName + Id;
	}

}
