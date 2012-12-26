/*SelectionSort.java - Contains all the methods necessary to perform selection sort
 * Dan Myers
 * CSC 364 - 001
 */
public class SelectionSort {

	public static void sort(Student[] unsortedArray){

		Student[] sortedArray = null;	//Holds the sorted array
		Student tmp;	//Temporary holder
		int count, posmin;
		sortedArray = unsortedArray;	//Sets sorted array to the array that was passed in.
		for(count = 0; count < unsortedArray.length; count++){

			posmin = findMin(sortedArray, count); //Returns the minimum vanue in the array

			/*Swaps the lowest value with the current count which is
			 * the leftmost spot in the array that hasn't been sorted.
			 */
			tmp = sortedArray[posmin];
			sortedArray[posmin] = sortedArray[count]; // 
			sortedArray[count] = tmp;

		}




	}

	/*Returns the minimum value in the array based on the starting position*/
	private static int findMin(Student[] array, int start){

		int minIndex = start;
		int index;
		for(index = start; index < array.length; index++){

			if(array[index].getSerial()<array[minIndex].getSerial()){
				minIndex = index;
			}
		}
		return minIndex;

	}

}
