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
		System.out.println("Another pass: " + qp);
	    if (conflict()) {
		// pop items off until the top is not in the nth column
		//System.out.println("peek x: " + qp.peek().getX());
		while (!qp.empty() && (qp.peek().getX() == N)) {
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
	switch (qp.size()) {
	case 0: return false;
	case 1: return false;
	default:
	    Node latest = qp.peek();
	    System.out.println("checking for conflicts in " + qp.size() + " items: " + qp);
	    int i = 0;
	    do { // compare latest item to each other item
		Node coords = qp.get(i);
		// check rows and columns
		if (coords.getX() == latest.getX()) {return true;}
		if (coords.getY() == latest.getY()) {return true;}
		//check diagonals
		if (diagConflict(coords, latest)) {return true;}
		
		// debugging output
		System.out.println("Iteration: " + i);
		System.out.println("Latest: " + latest);
		System.out.println("Coords: " + coords);
		
		i++; // should we be starting at the top or bottom of the stack?
	    } while (i < qp.size() - 1); // stop when we get to the latest

	    // otherwise there are no conflicts
	    System.out.println("no conflicts in " + qp);
	    return false;
	}
    }

    public boolean getRandomBoolean() {
	if (qp.size() == 0 || qp.size() == 1) {
	    return false;
	} else {
	    return Math.random() < 0.5;
	}
    }

    private boolean diagConflict(Node coords, Node latest) {
	int x = coords.getX();
	int y = coords.getY();
	
	// check x++ y++
	do {
	    x++;
	    y++;
	    if (x == latest.getX() && y == latest.getY()) {return true;}
	} while (x < N && y < N);
	
	// check x-- y++
	do {
	    x--;
	    y++;
	    if (x == latest.getX() && y == latest.getY()) {return true;}
	} while (x > 1 && y < N);
	
	// check x-- y--
	do {
	    x--;
	    y--;
	    if (x == latest.getX() && y == latest.getY()) {return true;}
	} while (x > 1 && y > 1);
	
	// check x++ y--
	do {
	    x++;
	    y--;
	    if (x == latest.getX() && y == latest.getY()) {return true;}
	} while (x < N && y > 1);
	
	return false;
    }
}
