public interface MyStack {

	public abstract void push(int data) throws StackOverFlowException;

	public abstract int pop();

	public abstract boolean isEmpty();

	public abstract int stackTop();

	public abstract boolean isFull();

	public abstract void clear();
	
	public String toString();
	
}