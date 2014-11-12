// import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static java.lang.System.out;

public class VendorRPG {
	
	private static Product[] productList = {
		new Product("Chips"),
		new Product("Candy"),
		new Product("Pretzel"),
		new Product("Popcorn"),
		new Product("Tyler Besselman", (1 << 40))
	};
	
	// default input reader
	private BufferedReader userInput;
	
	// name of the user
	private String name;
	
	// user choise
	private int choice;
	
	// the vending machine! :D
	private VendingMachine vendor;
	
	// randumb number generator
	private static Random rand = new Random();
	
	public VendorRPG() throws IOException {
		this.userInput = new BufferedReader(new InputStreamReader(System.in));
		
		this.vendor = new VendingMachine(productList);

		this.name = promptUserName();
		
		mainMenu();
		this.choice = 0;
	}
	
	private String promptUserName() throws IOException {
		out.print("What is your name? ");
		String str = this.userInput.readLine();
		out.println();
		return str;
	}
	
	public void mainMenu() {
		out.print("\n\n\n\n\n\n\n\n\n\n");
		out.println("=========================================");
		out.println("Welcome, " + this.name + ", to VendorRPG!");
		out.println("=========================================\n\n");
		
		
	}
	
	public void play() throws IOException {
		this.choice = mainChoicesScreen();
		this.doChoiceAction();
	}
	
	private int mainChoicesScreen() throws IOException {
		out.println("1 - Choose a vending machine product");
		out.println("2 - Kick the vending machine");
		out.println("3 - You didn't want anything anyway");
		out.println("4 - Why am I here again?");
		return this.getChoice();
	}
	
	private int getChoice() throws IOException {
		out.println();
		out.print("What will you do? ");
		return this.userInput.read() - '0';
	}
	
	private void doChoiceAction() throws IOException {
		switch(this.choice) {
			case 1:
				action1();
				break;
			case 2:
				action2();
				break;
			case 3:
				action3();
				break;
			case 4:
				action4();
				break;
			default:
				// this.play();
				return;
		}
	}
	
	private void action1() throws IOException {
		out.println("You press a bunch of random buttons on the vending machine.");
		vendorBuy(rand.nextInt(this.vendor.getNumItems()));
	}
	
	private void action2() {
		out.println("You kick the vending machine. (10)");
		out.println("The vending machine falls over onto you! (-100)");
		this.gameOver();
	}
	
	private void action3() {
		out.println("You leave the vending machine alone.");
		out.println("You didn't really want anything, anyway...");
		this.gameOver();
	}
	
	private void action4() {
		out.println("Has anyone really been far even as decided to use even go want to do look more like?");
		this.gameOver();
	}
	
	private void gameOver() {
		out.println();
		out.println("=========================================");
		out.println("              GAME OVER");
		out.println("=========================================");
		System.exit(0);
	}
	
	private void vendorBuy(int which) throws IOException {
		this.vendor.buy(this.vendor.getItemList()[which]);
		out.println("The vending machine shakes.");
		
		while(this.vendor.toPay() > 0) {
			vendorPay();
			
			if(this.vendor.toPay() > 0) {
				out.println("The vending machine beeps softly.");
			}
		}
		
		out.println("Success!");
	}
	
	private void vendorPay() throws IOException {

		this.userInput.skip(1);
		out.println("The vending machine asks for $" + this.vendor.toPay());
		out.print("How much money do you give the machine? ");
		
		String input = this.userInput.readLine();
		double payIn = 0;
		
		if(input.equals("")) {
			return;
		}
		
		else {
			payIn = Double.valueOf(input);
		}
			
		
		this.vendor.pay(payIn);
	}
	
	public static void main(String[] args) throws IOException {
		VendorRPG game = new VendorRPG();
		game.play();
	}
}
