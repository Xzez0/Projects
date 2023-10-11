package assignment7;

public class Course {

	private String Name;
	private int Credits;
	private int Capacity;
	private int Counter = 0;
	private Student[] Students;

	public Course(String Name, int Credits, int Capacity) {

		this.Name = Name;
		this.Credits = Credits;
		this.Capacity = Capacity;
		Students = new Student[Capacity];
	}

	public String getName() {
		return Name;

	}

	public int getCredits() {
		return Credits;

	}

	public int getCapacity() {

		return Capacity;

	}

	public int getSeatsRemaining() {

		return (this.Capacity - this.Counter);

	}

// -----------------------------------------------------------------------------------------------------------------------------
	
	public boolean addStudent(Student s) {
		for (int i = 0; i < Students.length; i++) {

			if (Students[i] == s) {
				return false;
			}
		}

		if (getSeatsRemaining() <= 0) {

			return false;
		}

		Students[this.Capacity - getSeatsRemaining()] = s;
		Counter++;

		return true;
	}
	
// -----------------------------------------------------------------------------------------------------------------------------

	public Student getStudentAt(int index) {
		return Students[index];
	}

// -----------------------------------------------------------------------------------------------------------------------------

	public String generateRoster() {

		String roster = " ";
		for (int i = 0; i < Students.length; i++) {
			if (Students[i] != null) {
				roster = roster + Students[i].getFullName() + " ";

			}
		}

		return roster;
	}

// -----------------------------------------------------------------------------------------------------------------------------

	public double calculateAverageGPA() {
		double Sum = 0;
		for (int i = 0; i < Students.length; i++) {
			if (Students[i] != null) {
				Sum = Sum + Students[i].calculateGradePointAverage();

			}
		}

		return (Sum / Counter);

	}

// -----------------------------------------------------------------------------------------------------------------------------
	public String toString() {
		return Name + String.valueOf(Credits);

	}

}
