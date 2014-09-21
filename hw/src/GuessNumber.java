public class GuessNumber {
    private int target_num;
    private int range_min = 1;
    private int range_max = 1000;
    private int guess = range_min - 1; //initialize guess outside range
    private int num_guesses = 0;

    public static void main (String[] args) {
	GuessNumber gn = new GuessNumber();
	gn.welcome();
	gn.pick_random_number();
	gn.give_up();
    }
    private void welcome() {
	System.out.print ("I'm thinking of a number between " + range_min + " and " + range_max + "...\n");
    }
    private void pick_random_number() {
	// TODO: make this pick a random number between range_min and range_max
	target_num = 50;
    }
    private void take_a_guess() {
	/* TODO: 
	   receive a guess and provide feedback
	   increment num_guesses
	 */
	if (guess == target_num)
	    gn.you_win();
	else {
	    gn.take_a_guess();
	}


    }
    private void give_up() {
	System.out.print ("Ok, it's " + target_num + ".\n");
    }
}
