import java.util.Stack;

public class Solver {

    private final int N = 8; // in case we want to solve N-queens
    private boolean success;
    private Stack<Node> qp;
    private int column;
    //private String[] board; // use constructor to initialize with N

    public Solver() {
	qp = new Stack<Node>();
	column = 1;// figure out what this should be initialized to
	success = false;
    }

    public static void main (String[] args){ // making this runnable for now
	Solver me = new Solver();
	me.doit();
    }

    private void doit() {
// 	System.out.println("Empty: " + qp);
// 	Node xy = coords(1,1);
// 	System.out.println("Node: " + xy.getX() + ", " + xy.getY());
// 	qp.push(xy);
// 	System.out.println("1 node: " + qp);
	
	// push first coordinate set
	qp.push(coords(1, 1));
	System.out.println(qp);
	
	// loop through until we find  solution
	while (!qp.empty() && !success) {
	    if (conflict()) {
		// pop items off until the top is not in the 8th column
		//System.out.println("peek x: " + qp.peek().getX());
		while (!qp.empty() && (qp.peek().getX() == 8)) {
		    qp.pop();
		}
		if (!qp.empty()) {// increment the column of the top item
		    System.out.println("before increment: " + qp);
		    incrementCol(qp.peek());
		}
	    } else if (qp.size() == N) {
		success = true;
		//display the result
		System.out.println("Solution: " + qp);
	    } else {
		int x = column;
		int y = qp.size() + 1;
		qp.push(coords(x,y));
		System.out.println("push new: " + qp);
	    }
	}
	
    }
    
    private Node coords(int x, int y) {
	Node coordinates = new Node();
	coordinates.setX(x);
	coordinates.setY(y);
	return coordinates;
    }

    private void incrementCol(Node coords) {
	int x = coords.getX();
	x++;
	coords.setX(x);
    }

    private boolean conflict() {
	Node latest = qp.peek();
	System.out.println("checking for conflicts in " + qp.size() + " items: " + qp);
	int i = 0;
	do { // compare latest item to each other item
	    Node coords = qp.get(i);
	    System.out.println("Iteration: " + i);
	    System.out.println("Latest: " + latest);
	    System.out.println("Coords: " + coords);
	    i++;
	} while (i < qp.size() - 1); // stop when we get to the latest
	return getRandomBoolean();
    }

    public boolean getRandomBoolean() {
	if (qp.size() == 0 || qp.size() == 1) {
	    return false;
	} else {
	    return Math.random() < 0.5;
	}
    }

    private boolean rowConflict() {
	return false;
    }
    private boolean diagConflict() {
	return false;
    }
}
