package lab1021;

public interface MyStackRPN {

	public abstract void push(double data) throws StackOverFlowException;

	public abstract double pop();

	public abstract boolean isEmpty();

	public abstract double stackTop();

	public abstract boolean isFull();

	public abstract void clear();
	
	public String toString();
	
}