
public class QuickSort {
	
	public static void sort(int[] array, int start, int end) {
		int index = partition(array, start, end);
		
		if(start < (index - 1)) sort(array, start, (index - 1));
		if(index < end) sort(array, index, end);
	}
	
	private static int partition(int[] array, int start, int end) {
		
		int pivot = array[start + (end - start) / 2]; // middle value
		
		int i = start;
		int j = end;
		
		while (i <= j) {
			for(; array[i] < pivot; i++);
			for(; array[j] > pivot; j--);
			
			if (i <= j) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		
		// System.out.println(SortTester.arrayToString("QSort", array));
		return i;
	}
	
	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		
		array[a] = array[b];
		array[b] = temp;
	}

}
