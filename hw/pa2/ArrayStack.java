
public class ArrayStack {

    private static final int ARRAY_SIZE = 32;
    private Node[] stack;
    private int count;
	
    public ArrayStack() {
	stack = new Node[ARRAY_SIZE];
	count = 0;
    }

    public static void main(String[] args) {
	ArrayStack me = new ArrayStack();
	me.testCases();
    }

    private void testCases() {
	Node node1 = new Node(1, 1);
	Node node2 = new Node(2, 2);
	Node node3 = new Node(3, 3);
	push(node1);
	push(node2);
	push(node3);

	System.out.println(this);
	System.out.println("Item at index 1: " + get(1));
	System.out.println(this);
    }

    public void push(Node data) throws StackOverFlowException {
	if (isFull()) {
	    throw new StackOverFlowException("Stack Overflow");
	} else {
	    stack[count++] = data;
	}
    }
	
    public Node pop() {
	return stack[--count];
    }
	
    public boolean isEmpty() {
	return (count == 0);
    }
	
    public Node stackTop() {
	return stack[count-1];
    }
	
    public boolean isFull() {
	return (count == stack.length);
    }
	
    public void clear() {
	while (!isEmpty()) {
	    pop();
	}
    }
	
    public Node get(int i) {
	return stack[i];
    }

    public String toString() {
	String rtn = "";
	if (count == 0) {
	    rtn = "<Empty>";
	} else {
	    rtn += "Stack Contains " + (count) + " Elements\n";
	    for (int i = count-1; i >= 0; i--) {
		if (i == count-1) {
		    rtn += "Top -> ";
		} else {
		    rtn += "       ";
		}
		rtn += "<" + stack[i] + ">\n";
	    }
	}
	return rtn;
    }
	
    public String foo() {
	return "foo";
    }
}
