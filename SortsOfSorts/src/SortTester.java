import java.util.Random;


public class SortTester {
	public static String arrayToString(String name, int[] array) {
		String ret = name + ": {";
		
		for(int i = 0; i < array.length; i++) {
			if(i == array.length - 1) ret += array[i];
			else ret += array[i] + ", ";
		}
		
		ret += "}";
		return ret;
	}
	
	public static long sortQuickAndTime(int[] array) {
		long start = System.nanoTime();
		
		QuickSort.sort(array, 0, array.length - 1);
		
		return (long)(System.nanoTime() - start);
	}

	public static void a()
	{
		try {
			throw new RuntimeException();
		} catch (Throwable t) {
			try {
				b();
			} catch (StackOverflowError e) {
				b();
			}
			
		}
	}

	public static void b()
	{
		try {
			throw new RuntimeException();
		} catch (Throwable t) {
			a();
		}
	}

	public static void main(String[] args) {
		a();
		
		Random rand = new Random();
		
		int myArray[] = new int[1000];
		for(int i = 0; i < myArray.length; i++) {
			myArray[i] = rand.nextInt(101);
		}
		
		System.out.println(arrayToString("QSort", myArray));
		System.out.println("===");
		System.out.println(sortQuickAndTime(myArray));
		System.out.println(arrayToString("QSort", myArray));
		
	}
}
