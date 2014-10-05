
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		SLList list = new SLList();
		System.out.println(list.size());
		list.insertInOrder(33);  // empty list
		list.insertInOrder(43);	// Tail of list
		list.insertInOrder(23);	// Front of populated list
		list.insertInOrder(35);	// Middle of populated list
		System.out.println(list);

		System.out.println(list.deleteNodeContaining(88));

		System.out.println(list.deleteNodeContaining(33));
		System.out.println(list.deleteNodeContaining(43));
		System.out.println(list.deleteNodeContaining(23));
		
		//System.out.println(list.search(34));
		System.out.println(list);
		
	}

}
