public class Solver {

    private final int N = 8; // in case we want to solve N-queens
    private boolean success;
    private ArrayStack qp; // queen positions
    private int column;
    private int iteration = 0; // debugging

    public Solver() {
	qp = new ArrayStack();
	column = 1;
	success = false;
    }

    public static void main (String[] args){ 
	Solver me = new Solver();
	me.solve();
    }

    private void solve() {
	// push first coordinate set
	qp.push(coords(1, 1));

	// program runs faster without output, but it looks cooler with it
	System.out.println("[0]: " + qp); // debugging

	// loop through until we find  solution
	while (!qp.empty() && !success) {

	    iteration++; // for debugging
	    System.out.println("[" + iteration + "]: " + qp); // debugging
	    if (conflict()) {

		// pop items off until the top is not in the nth column
		while (!qp.empty() && (qp.peek().getX() == N)) {
		    qp.pop();
		}
		if (!qp.empty()) {// increment the column of the top item
		    incrementCol(qp.peek());
		} else {
		    throw new RuntimeException("Empty stack! " + qp);
		}
	    } else if (qp.size() == N) { // if we've found a solution
		success = true;
		System.out.println("Solution: " + qp);
		printBoard();
	    } else { // push the next guess onto the stack
		int x = column;
		int y = qp.size() + 1;
		qp.push(coords(x,y));
	    }
	}
	
    }
    
    private Node coords(int x, int y) { // any changes to the syntax for creating new nodes should go here
	Node coordinates = new Node(x, y);
	return coordinates;
    }

    private void incrementCol(Node coords) { // possible refactor: put this on Node as an incrementing method
	int x = coords.getX();
	x++;
	coords.setX(x);
    }

    private boolean conflict() { // check for conflicts in our solutions as they progress
	switch (qp.size()) {
	case 0: return false; // these cases cannot have conflicts by definition
	case 1: return false;
	default:

	    Node latest = qp.peek();
	    int i = 0;
	    do { // compare latest item to each other item
		Node coords = qp.get(i);

		// check rows and columns
		if (coords.getX() == latest.getX()) {return true;}
		if (coords.getY() == latest.getY()) {return true;}

		//check diagonals
		if (diagConflict(coords, latest)) {return true;}
		
		i++;
	    } while (i < qp.size() - 1); // stop when we get to the latest

	    // otherwise there are no conflicts
	    return false;
	}
    }

    private boolean diagConflict(Node coords, Node latest) { //check for diagonal conflicts
        // initialize coords
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

    public void printBoard() { // Print out the board in a prettier format
        // Make a 2d array so that we can put our coords back in 2d space
	String[][] board = new String[N][N];
	for (int i = 0; i < N; i++) {
	    Node coords = qp.get(i);
	    int x = coords.getX() - 1;
	    int y = coords.getY() - 1;
	    board[x][y] = "Q";
	}
	System.out.println(arrayToString(board)); // print out the 2d array
    }

    private String arrayToString(String[][] a) {
	String rtn;     
	rtn = "";
	int column;
	int row;

	for (row = 0; row < a.length; row++) {
	    for (column = 0; column < a[0].length; column++ ) {
		if (a[row][column] == null) { // put a spacer into any empty cells
		    rtn = rtn + " - ";
		} else { // otherwise pad out the cell contents
		    rtn = rtn + " " + a[row][column] + " ";
		}
	    }
	    rtn = rtn + "\n";
	}
	return rtn;
    }

}
