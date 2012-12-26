
public class MergeSort1 {

	private static Student[] sorted;
	
	public static void sort(Student[] array){
		
		sorted = new Student[array.length];
		
		if(array.length > 1){
			
			Student[] first = new Student[array.length/2];
			System.arraycopy(array, 0, first, 0, array.length/2);
			sort(first);
			
			int secondlength = array.length - (array.length/2);
			Student[] second = new Student[secondlength];
			System.arraycopy(array, array.length/2, second, 0, secondlength);
			sort(second);
			
			Student[] merge = merge(first, second);
			System.arraycopy(merge, 0, array, 0, merge.length);
			
		}

	}
	
	private static Student[] merge(Student[] arr1, Student[] arr2){
		Student[] temp = new Student[arr1.length + arr2.length];
		int arr1dex = 0;
		int arr2dex = 0;
		int tempdex = 0;
		
		
		while(arr1dex < arr1.length && arr2dex < arr2.length){
			if(arr1[arr1dex].getSerial() < arr2[arr2dex].getSerial()){
				temp[tempdex] = arr1[arr1dex];
				tempdex++;
				arr1dex++;
			}
			else{
				temp[tempdex] = arr2[arr2dex];
				tempdex++;
				arr2dex++;
			}
		}
		            
		while(arr1dex < arr1.length){
			temp[tempdex] = arr1[arr1dex];
			tempdex++;
			arr1dex++;
		}
		
		while(arr2dex < arr2.length){
			temp[tempdex] = arr2[arr2dex];
			tempdex++;
			arr2dex++;
		}
		
		return temp;
	}
	
	
	public static void display(){
		
		for(int i = 0; i < sorted.length; i++){
			if(sorted[i] == null){
				System.out.println("NULL");
			}
			else{
				System.out.println(String.format("%d \t %s",sorted[i].getSerial(), sorted[i].getName()));
			}
		}
		
	}
}
