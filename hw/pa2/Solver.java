import java.util.Stack;

public class Solver {

    private final int N = 8; // in case we want to solve N-queens
    private boolean success;
    private Stack<int[]> qp;
    private int column;
    //private String[] board; // use constructor to initialize with N

    public Solver() {

	column = 2;// figure out what this should be initialized to
	success = false;
    }

    public static void main (String[] args){ // making this runnable for now
	Stack<int[]> qp = new Stack<int[]>();
	Solver me = new Solver();
	me.doit();
    }

    private void doit() {
	System.out.println(qp);
	int[] xy = coords(1,1);
	System.out.println(xy[0] + ", " + xy[1]);
	System.out.println(qp);

	qp.push(xy);
	while (!qp.empty() && !success) {
	    if (conflict()) {
		// pop the last choice off
		column++;
	    } else if (qp.size() == N) {
		success = true;
		//display the result
	    } else {
		int x = qp.size() + 1;
		int y = column;
		qp.push(coords(x,y));
	    }
	}

    }

    private int[] coords(int x, int y) {
	int[] coordinates = new int[2];
	coordinates[0] = x;
	coordinates[1] = y;
	return coordinates;
    }

    private boolean conflict() {
	return false;
    }
}
