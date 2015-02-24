
public class InsertionSort {

	public static int[] sort(int[] array) {
		
		for(int i = 1; i < array.length; i++) {
			int key = array[i];
			
			int j;
			for(j = i - 1; (j >= 0) && (key < array[j]); j--) {
				array[j + 1] = array[j];
			}
			
			array[j + 1] = key;
			
			System.out.println(SortTester.arrayToString("myArray", array));
		}
		
		return array;
	}
}
