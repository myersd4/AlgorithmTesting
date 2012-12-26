/*QuickSort.java - All the methods necessary for the quicksort algorithm.
 * Dan Myers
 * CSC 364 - 001
 */
public class QuickSort {

		/*This method allows quicksort to be called without having to pass
		 * the starting and ending positions
		 */
		public static void sort(Student[] array){
			
			quickSort(array, 0, array.length-1);
		}
		
		/*Recursive quicksort method, finds the pivot and splits the array into 
		 * two smaller arrays based on that value.
		 */
		public static void quickSort(Student[] array, int start, int end){
			if(end > start){
				int pivot = partition(array, start, end);
				quickSort(array, start, pivot);
				quickSort(array, pivot+1, end);
			}
		}
		
		/*
		 * Partition method takes the array and the bounds of the array as input.
		 * Organizes the array so all values lower than the pivot are to the left,
		 * and all values higher than the pivot are to the right.
		 */
		private static int partition(Student[] array, int left, int right){
			
			Student tmp;	//Holder for a student object.
			int leftPtr = left + 1;    //Sets the left pointer one to the right of the lower bound of the array.
	        int rightPtr = right;	//Right pointer is set to the upper bound.
			int pivot = array[left].getSerial();	//Uses the first element of the array as the pivot value.
			
			while(rightPtr > leftPtr){
				
				//Finds a value higher than pivot.
				while(leftPtr <= rightPtr && array[leftPtr].getSerial() <= pivot){
					leftPtr++;
				}
				
				//Finds a value lower than pivot.
				while(leftPtr <= rightPtr && array[rightPtr].getSerial() > pivot){
					rightPtr--;
				}
				
				//swaps the two values
				if(rightPtr > leftPtr){
					tmp = array[rightPtr];
					array[rightPtr] = array[leftPtr];
					array[leftPtr] = tmp;
				}
			}
			
			//finds the highest remaining value in the array
			while(rightPtr > left && array[rightPtr].getSerial() >= pivot){
				rightPtr--;
			}
			
			
			if(pivot>array[rightPtr].getSerial()){
				tmp = array[left];
				array[left] = array[rightPtr];
				array[rightPtr] = tmp;
				return rightPtr;
			}
			else{
				return left;
			}

		}
	}
