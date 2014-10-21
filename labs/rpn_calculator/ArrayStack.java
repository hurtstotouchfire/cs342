
public class ArrayStack implements MyStack {

	private static final int ARRAY_SIZE = 32;
	private int[] stack;
	private int count;
	
	public ArrayStack() {
		stack = new int[ARRAY_SIZE];
		count = 0;
	}
	
	/* (non-Javadoc)
	 * @see MyStack#push(int)
	 */
	@Override
	public void push(int data) throws StackOverFlowException {
		if (isFull()) {
			throw new StackOverFlowException("Stack Overflow");
		} else {
			stack[count++] = data;
		}
	}
	
	/* (non-Javadoc)
	 * @see MyStack#pop()
	 */
	@Override
	public int pop() {
		return stack[--count];
	}
	
	/* (non-Javadoc)
	 * @see MyStack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (count == 0);
	}
	
	/* (non-Javadoc)
	 * @see MyStack#stackTop()
	 */
	@Override
	public int stackTop() {
		return stack[count-1];
	}
	
	/* (non-Javadoc)
	 * @see MyStack#isFull()
	 */
	@Override
	public boolean isFull() {
		return (count == stack.length);
	}
	
	/* (non-Javadoc)
	 * @see MyStack#clear()
	 */
	@Override
	public void clear() {
		while (!isEmpty()) {
			pop();
		}
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
