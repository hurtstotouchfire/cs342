
public class AQ implements MyQ {
	
	private int front;
	private int rear;
	private int count;
	private static final int QUEUE_SIZE = 32;
	
	private Integer[] q;

	public AQ() {
		front = rear = count = 0;
		q = new Integer[QUEUE_SIZE];
	}
	
	@Override
	public void add(Integer data) {
		if (isFull()) 
			return;
		
		q[rear++] = data;

		rear = rear % q.length;
		count++;
		
	}

	@Override
	public Integer remove() {
		if (isEmpty()) {
			return null;
		}
		
		Integer rtn = q[front];
		front++;
		front = front % q.length;
		count--;
		
		return rtn;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return (count == q.length);
	}

	public String toString() {
		String rtn = "";

		if (count == 0) {
			rtn += "<Empty>";
		} else {
			int n = front;
			for (int i = 0; i < count; i++) {
				rtn += "<" + q[n] + "> ";
				
				n++;  // next entry, please
				// Cure wrap
				if (n == q.length) {
					n = 0;
				}
			}
		}

		return rtn;
	}

}
