
public class LinkedStack implements MyStack {

	private LSNode top;
	protected int count;
	
	public LinkedStack() {
		top = null;
		count = 0;
	}
	
	@Override
	public void push(double data) throws StackOverFlowException {
		// TODO Auto-generated method stub
		LSNode n = new LSNode();
		n.setData(data);
		
		n.setNext(top);
		count++;
		top = n;
	}

	@Override
	public double pop() {
		double rtn = top.getData();
		LSNode n = top;
		
		top = top.getNext();
		count--;
		n.setNext(null);
		
		return rtn;
	}

	@Override
	public boolean isEmpty() {

		return (top == null);
		//return (count == 0);
	}

	@Override
	public double stackTop() {
		return top.getData();
	}

	@Override
	public boolean isFull() {
		return false;
	}

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
			LSNode n = top;
			for (int i = count-1; i >= 0; i--) {
				if (i == count-1) {
					rtn += "Top -> ";
				} else {
					rtn += "       ";
				}
				rtn += "<" + (char)n.getData() + ">\n";
				n = n.getNext();
			}
		}
		return rtn;
	}

}
