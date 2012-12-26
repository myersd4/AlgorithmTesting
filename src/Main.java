/*Main.java - main class that calls the sorting classes
 * Dan Myers
 * CSC 364 - 001
 * Program 2
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int choice;	// choice of algorithm
		int size;	// Size of the array
		long startTime = 0, endTime = 0, totalTime = 0; // Variables used to time algorithm
		Scanner input = new Scanner(System.in);	//Input for decisions

		/*Loop iterates through the enitre program until the user opts to quit.  
		 * This allows efficient testing of each algorithm.
		 */
		do{
			System.out.print("Please enter size of list to be sorted (zero to exit):");
			size = input.nextInt();	//Array size input
			System.out.println();

			if(size == 0){
				System.exit(0);
			}
			System.out.println("1. Selection Sort");
			System.out.println("2. Merge Sort");
			System.out.println("3. Quick Sort");
			System.out.println("4. Radix Sort");
			System.out.println("9. Exit");
			System.out.println("Please select an algorithm:");
			choice = input.nextInt();	//algorithm choice input.


			Student [] studentArray;	//Array of students to be sorted.
			studentArray = initalizeStudents(size);	//calls the method to initialize array of students.
			
			/*
			 * Each if statement calls the function of the algorithm to be used.  Records the time it takes to run.
			 * Then outputs the time and result of the sorting.
			 */
			if(choice == 1){	//Selection sort
				startTime = System.currentTimeMillis();
				SelectionSort.sort(studentArray);
				endTime = System.currentTimeMillis();
				display(studentArray);
				totalTime = endTime - startTime;
				System.out.println(String.format("Total execution time: %d milliseconds", totalTime));
			}
			else if(choice == 2){	//Merge sort
				startTime = System.currentTimeMillis();
				MergeSort1.sort(studentArray);
				endTime = System.currentTimeMillis();
				display(studentArray);
				totalTime = endTime - startTime;
				System.out.println(String.format("Total execution time: %d milliseconds", totalTime));
			}
			else if(choice == 3){	//Quick Sort
				startTime = System.currentTimeMillis();
				QuickSort.sort(studentArray);
				endTime = System.currentTimeMillis();
				display(studentArray);
				totalTime = endTime - startTime;
				System.out.println(String.format("Total execution time: %d milliseconds", totalTime));
			}
			else if(choice == 4){	//Radix sort
				startTime = System.currentTimeMillis();
				RadixSort1.sort(studentArray,1);
				endTime = System.currentTimeMillis();
				RadixSort1.display();
				totalTime = endTime - startTime;
				System.out.println(String.format("Total execution time: %d milliseconds", totalTime));
			}
			else{
				if(choice != 9){
					System.out.println("Please enter a valid selection!!");
				}
			}





		}while(choice != 9);
	}

	/*
	 * Method initialized the array of students by giving each student a random
	 * serial number between 0 - 9999 and a random 5 character string as a name.
	 * Takes the number of objects to be created as the input.
	 */
	public static Student[] initalizeStudents(int numStudents){

		Student[] studentArray = new Student[numStudents];
		StringBuffer name = new StringBuffer();	
		String name1;	//name

		for(int i = 0; i < numStudents; i++){

			int serial = (int)(Math.random()*9999);	//random serial number
			name1 = generateName();

			studentArray[i] = new Student(serial, name1);
		}
		return studentArray;
	}
	
	/*Method to generate a random string for the name*/
	public static String generateName(){

		final String namespace = "abcdefghijklmnopqrstuvwxyz";
		final int length = 5;
		StringBuffer nameBuffer = new StringBuffer();
		String finalName = null;
		int charLocation;
		char[] name = new char[length];
		for(int i = 0; i < length; i++){
			charLocation = (int) (Math.random()*26);
			name[i] = namespace.charAt(charLocation);
			nameBuffer = nameBuffer.append(name[i]);
		}
		finalName = nameBuffer.toString();
		return finalName;
	}

	/*Method to display whatever array it receives as input*/
	public static void display(Student[] array){

		for(int i = 0; i < array.length; i++){
			if(array[i] == null){
				System.out.println("NULL");
			}
			else{
				System.out.println(String.format("%d \t %s",array[i].getSerial(), array[i].getName()));
			}
		}

	}
}
