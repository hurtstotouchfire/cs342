import java.util.Stack;

public class Solver {

    private final int N = 8; // in case we want to solve N-queens
    private boolean success;
    private Stack<Node> qp;
    private int column;
    //private String[] board; // use constructor to initialize with N

    public Solver() {
	qp = new Stack<Node>();
	column = 2;// figure out what this should be initialized to
	success = false;
    }

    public static void main (String[] args){ // making this runnable for now
	Solver me = new Solver();
	me.doit();
    }

    private void doit() {
	System.out.println("Empty: " + qp);
	Node xy = coords(1,1);
	System.out.println("Node: " + xy.getX() + ", " + xy.getY());
	qp.push(xy);
	System.out.println("1 node: " + qp);

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

    private Node coords(int x, int y) {
	Node coordinates = new Node();
	coordinates.setX(x);
	coordinates.setY(y);
	return coordinates;
    }

    private boolean conflict() {
	return false;
    }
}
