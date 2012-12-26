/*Student.java - This class defines the student object to be sorted
 * Dan Myers
 * CSC 364 - 001
 */
public class Student {
	
	private int serial;	//Serial number of student.
	private String name;	//Name of Student.
	
	
	//Constructor
	public Student(int serial, String name){
		
		this.serial = serial;
		this.name = name;
		
	}
	//Getter for serial
	public int getSerial(){
		return serial;
	}
	
	//Getter for name
	public String getName(){
		return name;
	}
	
}
