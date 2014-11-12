import static java.lang.System.out;

public class Store {

	public static void main(String[] args) {
		Cashier cashman = new Cashier();
		Goods groceries = new Goods("Groceries", 3.45);
		
		cashman.purchase(groceries);
		cashman.pay(3.50);
		out.println(cashman.getChange());
		
		int gotback[] = cashman.calcChange();
		
		
		for(int i = 0; i < gotback.length; i++) {
			switch(i) {
				case 0:
					out.print("Dollars: ");
					break;
				case 1:
					out.print("Quarters: ");
					break;
				case 2:
					out.print("Dimes: ");
					break;
				case 3:
					out.print("Nickels: ");
					break;
				case 4:
					out.print("Pennies: ");
					break;
				default:
					out.print("Unknown Denom.: ");
					break;
			}
			
			out.println(gotback[i]);
		}
		
		out.println();
		
	}

}
