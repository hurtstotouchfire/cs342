
public class ArrayStack {

    private static final int ARRAY_SIZE = 32;
    private int[] stack;
    private int count;
	
    public ArrayStack() {
	stack = new int[ARRAY_SIZE];
	count = 0;
    }

    public static void main(String[] args) {
	ArrayStack me = new ArrayStack();
	me.testCases();
    }

    private void testCases() {
	int int1 = 1;
	int int2 = 2;
	int int3 = 3;
	push(int1);
	push(int2);
	push(int3);

	System.out.println(this);
	System.out.println("Item at index 1: " + get(1));
	System.out.println(this);
    }

    public void push(int data) throws StackOverFlowException {
	if (isFull()) {
	    throw new StackOverFlowException("Stack Overflow");
	} else {
	    stack[count++] = data;
	}
    }
	
    public int pop() {
	return stack[--count];
    }
	
    public boolean isEmpty() {
	return (count == 0);
    }
	
    public int stackTop() {
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
	
    public int get(int i) {
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
