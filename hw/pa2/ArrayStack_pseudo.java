
public class ArrayStack {

    private static final int ARRAY_SIZE = 10; // since this is customized for the N-queens solver, this can be pretty low. 
    private int[] stack; // use something that will let us store [1,1], like an integer array or a Node
    private int count;
	
    public ArrayStack() {
        // initialize a stack with ARRAY_SIZE
	count = 0;
    }

    public void push(int[] data) { // implement StackOverFlowException?
    	// if full
	    // throw StackOverFlowException
	// else
	    // add data on top of the stack
	    // increment stack
    }
	
    public Node pop() {
	// return the top item 
	// decrement count
    }
	
    public boolean empty() {
	// return true if count is 0, false otherwise
    }
	
    public Node peek() {
	// return top item from stack
	// don't decrement count
    }
	
    public boolean full() {
	// return true if the stack length is the same as count, false otherwise
    }

    public int size() {
	return count;
    }
	
    public void clear() {
	// pop until empty
    }
	
    public Node get(int i) {
	// return any entry by array index
    }

}
