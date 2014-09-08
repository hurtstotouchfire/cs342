import java.io.IOException;
public class GuessNumber {
    private int target_num;
    private int range_min = 0;
    private int range_max = 1000;
    private int guess = range_min - 1; //initialize guess outside range
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

	//TODO: validate inputs
	Reader r = new Reader("Take a guess:");
	try {
	    guess = r.readln();
	} catch (IOException e) {
	    //care about it
	}

	num_guesses++;
	System.out.println ("You guessed: " + guess);
	System.out.println ("That makes " + num_guesses + " guesses.");

	// if base case, return true and win. otherwise recurse.
	if (guess == target_num)
	    return true;
	else {
	    return take_a_guess();
	}

    }
    private void you_win() {
	System.out.println ("Ok, it's " + target_num + ".");
	//	System.out.println ("It only took you " + num_guesses + "!");
    }

}


