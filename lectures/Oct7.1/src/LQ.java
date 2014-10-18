
public class LQ implements MyQ {
	private Node front;
	private Node rear;
	private int count;

	public LQ() {
		front = rear = null;
		count = 0;
	}

	/* (non-Javadoc)
	 * @see MyQ#add(java.lang.Integer)
	 */
	@Override
	public void add(Integer data) {
		// create and set the data in a Node
		Node n = new Node();
		n.setData(data);

		if (count == 0) {
			// Queue is empty
			rear = front = n;
		} else {
			// General case
			rear.setNext(n);
			rear = n;
		}
		// Finally increment the count
		count++;

	}
	
	/* (non-Javadoc)
	 * @see MyQ#remove()
	 */
	@Override
	public Integer remove() {
		Integer x;
		
		if (count <= 0) {
			// Don't remove from an empty queue
			System.out.println("Removed from a queue of " + count + " elements");
			count = 0;
			return null;
		} else {
			x = front.getData();
			front = front.getNext();
			count--;
			
			// If there was only one element in the queue, now there are none.
			if (count == 0) {
				front = rear = null;
			}
		}
		
		return x;
	}
	
	/* (non-Javadoc)
	 * @see MyQ#size()
	 */
	@Override
	public int size() {
		return count;
	}
	
	/* (non-Javadoc)
	 * @see MyQ#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (count == 0);
	}
	
	/* (non-Javadoc)
	 * @see MyQ#isFull()
	 */
	@Override
	public boolean isFull() {
		return false;
	}

	public String toString() {
		String rtn = "";

		if (count == 0) {
			rtn += "<Empty>";
		} else {
			Node n = front;
			for (int i = 0; i < count; i++) {
				rtn += "<" + n + "> ";
				n = n.getNext();
			}
		}

		return rtn;
	}
}
