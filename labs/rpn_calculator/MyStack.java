public interface MyStack {

	public abstract void push(double data) throws StackOverFlowException;

	public abstract double pop();

	public abstract boolean isEmpty();

	public abstract double stackTop();

	public abstract boolean isFull();

	public abstract void clear();
	
	public String toString();
	
}
