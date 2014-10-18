
public class QueueDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueDriver me = new QueueDriver();
		me.doIt();
	}
	
	public void doIt() {
		
		MyQ q = new LQ();
		
		q.add(23);
		q.add(32);
		q.add(43);
		System.out.println(q);
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
		System.out.println(q);
	}

}
