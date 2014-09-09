import java.util.Scanner;
public class GuessNumber {
    private int target_num;
    private int range_min = 1;
    private int range_max = 1000;
    private int guess = range_min - 1;
    private int num_guesses = 0;

    public static void main (String[] args) {
	GuessNumber gn = new GuessNumber();
	gn.welcome();
	gn.random_number();
	if (gn.take_a_guess())
	    gn.you_win();
    }

    private void welcome() {
	System.out.print ("I'm thinking of a number between " + range_min + " and " + range_max + "...\n");
    }

    private void random_number() {
    // TODO: make this pick a random number between range_min and range_max
	target_num = 50;
    }

    private boolean take_a_guess() {

	Scanner scant = new Scanner(System.in);
	System.out.println("Take a guess: ");
	if (scant.hasNextInt()) {
	    guess = scant.nextInt();
	    //System.out.println ("You guessed: " + guess);
	    //System.out.println ("That makes " + num_guesses + " guesses.");
	    give_feedback();
	} else {
	    System.out.println ("That's not an integer...");
	}
	
	num_guesses++;
	
	// if base case, return true and win. otherwise recurse.
	if (guess == target_num)
	    return true;
	else {
	    return take_a_guess();
	}
	
    }
    
    private void give_feedback() {
	if (guess < target_num) {
	    System.out.println ("That's too low.");
	} else if (guess > target_num) {
	    System.out.println ("That's too high.");
	} else { 
	    return;
	}
    }
    
    private void you_win() {
	System.out.println ("Ok, it's " + target_num + ".");
	System.out.println ("You got it in " + num_guesses + " guesses!");
    }   
}


