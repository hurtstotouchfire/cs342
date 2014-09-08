public class GuessNumber {
    private int target_num;
    private int range_min = 0;
    private int range_max = 1000;

    public static void main (String[] args) {
	GuessNumber gn = new GuessNumber();
	gn.welcome();
	gn.random_number();
	gn.give_up();
    }
    private void welcome() {
    	    System.out.print ("I'm thinking of a number between " + range_min + " and " + range_max + "...\n");
    }
    private void random_number() {
    // TODO: make this pick a random number between range_min and range_max
    	    target_num = 50;
    }
    private void give_up() {
    	    System.out.print ("Ok, it's " + target_num + ".\n");
    }
}
