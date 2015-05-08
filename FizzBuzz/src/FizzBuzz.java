public class FizzBuzz {

	public static final int NUMS = 100;
	
	public static void main(String[] args) {
		for(int i = 0; i < NUMS; i++) {
			if(i % 3 == 0) System.out.print("fizz");
			if(i % 5 == 0) System.out.print("buzz");
			if(((i % 3) * (i % 5)) != 0) System.out.print(i);
			System.out.println();
		}
	}
}