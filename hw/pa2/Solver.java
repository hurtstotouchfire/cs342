import java.util.Stack;

public class Solver {

    private final int N = 8; // in case we want to solve N-queens
    private boolean success;
    private Stack<Node> qp; // queen positions
    private int column;
    //private int iteration = 0; // debugging
    // TODO add visualization method
    //private String[] board; // use constructor to initialize with N

    public Solver() {
	qp = new Stack<Node>();
	column = 1;
	success = false;
    }

    public static void main (String[] args){ // making this runnable for now TODO
	Solver me = new Solver();
	me.doit();
    }

    private void doit() {
	// push first coordinate set
	qp.push(coords(1, 1));
	System.out.println(qp);

	// loop through until we find  solution
	while (!qp.empty() && !success) {
	    //System.out.println("Iteration: " + iteration);
	    //iteration++; // for debugging
	    if (conflict()) {
		System.out.println("Conflict in: " + qp);
		// pop items off until the top is not in the nth column
		while (!qp.empty() && (qp.peek().getX() == N)) {
		    qp.pop();
		}
		if (!qp.empty()) {// increment the column of the top item
		    incrementCol(qp.peek());
		    System.out.println("Adjusting latest: " + qp);
		} else {
		    throw new RuntimeException("Empty stack! " + qp);
		}
	    } else if (qp.size() == N) {
		success = true;
		//display the result TODO
		System.out.println("Solution: " + qp);
	    } else {
		int x = column;
		int y = qp.size() + 1;
		qp.push(coords(x,y));
	    }
	}
	
    }
    
    private Node coords(int x, int y) {
	Node coordinates = new Node(x, y);
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
	    int i = 0;
	    do { // compare latest item to each other item
		Node coords = qp.get(i);

		// debugging output
		//if (iteration == 2833) {
		//    System.out.println("Iteration: " + i);
		//    System.out.println("Latest: " + latest);
		//    System.out.println("Coords: " + coords);
		//}

		// check rows and columns
		if (coords.getX() == latest.getX()) {return true;}
		if (coords.getY() == latest.getY()) {return true;}
		//check diagonals
		if (diagConflict(coords, latest)) {return true;}
		
		i++; // TODO: should we be starting at the top or bottom of the stack? optimization-wise
	    } while (i < qp.size() - 1); // stop when we get to the latest

	    // otherwise there are no conflicts
	    System.out.println("no conflicts in " + qp);
	    return false;
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
		
	// re-initialize coords
	x = coords.getX();
	y = coords.getY();

	// check x-- y++
	do {	    
	    x--;
	    y++;
	    if (x == latest.getX() && y == latest.getY()) {return true;}
	} while (x > 1 && y < N);
		
	// re-initialize coords
	x = coords.getX();
	y = coords.getY();

	// check x-- y--
	do {
	    x--;
	    y--;
	    if (x == latest.getX() && y == latest.getY()) {return true;}
	} while (x > 1 && y > 1);
		
	// re-initialize coords
	x = coords.getX();
	y = coords.getY();

	// check x++ y--
	do {
	    x++;
	    y--;
	    if (x == latest.getX() && y == latest.getY()) {return true;}
	} while (x < N && y > 1);
	
	return false;
    }
}
