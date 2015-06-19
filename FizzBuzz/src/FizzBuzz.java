public class FizzBuzz {

	public static final int NUMS = 100;
	
	public static void main(String[] args) {
		methodOne();
		// methodTwo();
	}
	
	public static void methodOne() {
		for(int i = 0; i < NUMS; i++) {
			if(i % 3 == 0) System.out.print("fizz");
			if(i % 5 == 0) System.out.print("buzz");
			if(((i % 3) * (i % 5)) != 0) System.out.print(i);
			System.out.println();
		}
	}
	
	public static void methodTwo() {
		for(int i = 0; i < NUMS; i++) {
			boolean f = (i % 3) == 0, b = (i % 5) == 0;
			System.out.println(f ? b ? "fizzbuzz" : "fizz" : b ? "buzz" : i);
		}
	}
}