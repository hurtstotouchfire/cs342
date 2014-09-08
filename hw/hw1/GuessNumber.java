import java.io.IOException;
public class GuessNumber {
    private int target_num;
    private int range_min = 0;
    private int range_max = 1000;
    private int guess;
    private int num_guesses = 1;

    public static void main (String[] args) {
	GuessNumber gn = new GuessNumber();
	gn.welcome();
	gn.random_number();
	gn.take_a_guess();
	gn.give_up();
    }
    private void welcome() {
	System.out.print ("I'm thinking of a number between " + range_min + " and " + range_max + "...\n");
    }
    private void random_number() {
    // TODO: make this pick a random number between range_min and range_max
	target_num = 50;
    }
    private void take_a_guess() {

	//TODO: validate inputs
	// take input and spit it right back out
	Reader r = new Reader("Take a guess:");
	guess = r.readln();
	System.out.println (guess);
	
	num_guesses++;
	// TODO: compare to num_guesses
	System.out.println ("You guessed: " + guess);
	System.out.println ("That makes " + num_guesses + " guesses.");
    }
    private void give_up() {
	System.out.print ("Ok, it's " + target_num + ".\n");
    }

    // put some of this type of stuff in a buffer reader class
    //	int ch;
    //	while ((ch = System.in.read()) != '\n') {
    //	    guess = ((char) ch);
    //	}


}


