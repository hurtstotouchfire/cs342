package lab1021;

import java.util.Scanner;

public class RPNMenu {

	public RPNMenu() {
		
	}
	
	public void doIt() {
		RPNCalculator calc = new RPNCalculator (); 
		Scanner keyboard = new Scanner (System.in);
		int loop = 1;
		do {
			System.out.println("==========Menu============= \n"
					+ "xx.xx: place a number on the stack \n"
					+ "+: Add the top two items \n"
					+ "*: Mutiply the top two items \n"
					+ "-: Substract the top item from the next item \n"
					+ "/: Divide the second item by the top item \n"
					+ "%: Integer remainder when the dividing the second item by the top item\n"
					+ "m: Negate the top item \n"
					+ "s: Swap the top two items \n"
					+ "d: Duplicate top item on stack \n"
					+ "p: Print (to the screen) the top item\n"
					+ "n: Print and remove the top item \n"
					+ "f: Print all the contents of the stack (leaving it intact) \n"
					+ "q: Quite \n"
					+ "h (or ?): Print a help message"
					+ "Please setect your choice:");
		if (keyboard.hasNextDouble()){
		double n = 	keyboard.nextDouble();
		calc.push(n);
		}
		else { String op = keyboard.nextLine();
		calc.evalBasicOperator(op);
		if (op == "x") loop =0;}
		} while (loop ==1);
		
	}

	public static void main(String[] args) {
		RPNMenu me = new RPNMenu ();
		me.doIt();

	}

}
