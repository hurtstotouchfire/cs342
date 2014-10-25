package lab1021;


public class LinkedStackRPN implements MyStackRPN {

	private LSNodeDouble top;
	private int count;
	
	public LinkedStackRPN() {
		top = null;
		count = 0;
	}
	
	public void push(double d) throws StackOverFlowException {
		// TODO Auto-generated method stub
		LSNodeDouble n = new LSNodeDouble();
		n.setData(d);
		
		n.setNext(top);
		count++;
		top = n;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public double pop() {
		double rtn = top.getData();
		LSNodeDouble n = top;
		
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
			LSNodeDouble n = top;
			for (int i = count-1; i >= 0; i--) {
				if (i == count-1) {
					rtn += "Top -> ";
				} else {
					rtn += "       ";
				}
				rtn += "<" + n.getData() + ">\n";
				n = n.getNext();
			}
		}
		return rtn;
	}

}
