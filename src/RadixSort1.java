/*RadixSort1.java - Contains all of the methods necessary for radix sort.
 * Dan Myers
 * CSC 364 - 001
 */
import java.util.Arrays;


public class RadixSort1 {

	private static final int numBuckets = 10; //number of buckets - always 10 for 0-9
	private static Queue1[] buckets = new Queue1[numBuckets]; //creates and arary of queues
	private static Student[] array;	//array of students


	public static void sort(Student[] stuArr, int div){

		array = stuArr;
		int ans;
		Student[] newArray = new Student[array.length];
		if(div == 10000){ //Base condition
			return;
		}

		/*Iterates through the array placing the numbers 
		 * in buckets based on the appropriate digits
		 * 
		 */
		for(int i = 0; i < array.length; i++){
			int number = 0;
			number = array[i].getSerial() / div;
			ans = number % 10;

			if(buckets[ans] == null){
				buckets[ans] = new Queue1(array.length);
				buckets[ans].insert(array[i]);
			}
			else{
				buckets[ans].insert(array[i]);
			}

		}

		int j = 0;

		/*Iterates through the buckets placing the numbers into an array
		 * in the order they are in the queues.
		 */
		for(int i = 0; i < buckets.length; i++){
			if(buckets[i] != null){
				Student temp = buckets[i].remove();
				while(temp != null){
					newArray[j] = temp;
					j++;
					temp = buckets[i].remove();
				}

			}
		}
		array = newArray; //Sets the sorted array to the static variable.
		Arrays.fill(buckets, null); //clears out the buckets
		sort(array, div*10);	//recursive call.  Multiplies divisor by 10 to get the next digit.

	}

	public static void display(){

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
