public class Solver {

    private int N = 8; // in case we want to solve N-queens
    private boolean success = false;
    private Stack queenPositions;
    private int column = 2; // figure out what this should be initialized to

    //private String[] board; // use constructor to initialize with N

    public static void main (String[] args){ // making this runnable for now
	// queenPositions.push([1,1])
	while (!queenPositions.empty() && !success) {
	    if (conflict()) {
		// pop the last choice off
		column++;
	    } else if (queenPositions.size == N) {
		success = true;
		//display the result
	    } else {
		queenPositions.push([queenPositions.size() + 1, column]);
	    }
	}

    }

    private void conflict() {

    }
}
