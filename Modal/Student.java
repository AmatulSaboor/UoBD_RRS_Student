package Modal;

/**
 * It's a modal class for STUDENT and has getters and setters and a constructor
 * for it
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class Student {

	// instance variables
	private int stdID;
	private String stdName;
	private String stdEmail;
	private String stdPassword;
	private int stdAge;
	private char stdGender;
	private String stdProgramme;
	public String USER_TYPE = "Student";

	// constructor
	public Student(int sID, String stdName, String stdEmail, String stdPassword, int stdAge, char stdGender,
			String stdProgramme) {
		super();
		this.stdID = sID;
		this.stdName = stdName;
		this.stdEmail = stdEmail;
		this.stdPassword = stdPassword;
		this.stdAge = stdAge;
		this.stdGender = stdGender;
		this.stdProgramme = stdProgramme;
	}

	// getter and setter methods
	public int getStdID() {
		return stdID;
	}

	public void setStdID(int stdID) {
		this.stdID = stdID;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdEmail() {
		return stdEmail;
	}

	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	public String getStdPassword() {
		return stdPassword;
	}

	public void setStdPassword(String stdPassword) {
		this.stdPassword = stdPassword;
	}

	public int getStdAge() {
		return stdAge;
	}

	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	public char getStdGender() {
		return stdGender;
	}

	public void setStdGender(char stdGender) {
		this.stdGender = stdGender;
	}

	public String getStdProgramme() {
		return stdProgramme;
	}

	public void setStdProgramme(String stdProgramme) {
		this.stdProgramme = stdProgramme;
	}
}