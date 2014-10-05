public class ArrayStack {

    private int count;

    public ArrayStack() {
	int[] stack = new int[0];
	count = 0;
    }

    public void push (int data) {
	stack[count] = data;
	count++;
    }

    public boolean isFull() {
	return (count == stack.length);
    }

    public boolean isEmpty() {
	return (count == 0);
    }

    public String toString() {
	String rtn = "";
	if (count == 0) {
	    rtn = "[Empty]";
	} else {
	    rtn = "Stack contains: \n";
	    for (int i=1; i == count; i++) {
		rtn = rtn + ", [" + stack[i] + "]";
	    }
	}
    }
}
