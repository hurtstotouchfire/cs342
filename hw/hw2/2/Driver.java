
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		DLList list = new DLList();
		System.out.println(list.size());
		list.appendNodeWith(33);  // empty list
		list.appendNodeWith(43);	// Tail of list
		list.appendNodeWith(23);	// Front of populated list
		list.appendNodeWith(35);	// Middle of populated list
		System.out.println(list);

		System.out.println(list.deleteNodeWith(88));

		System.out.println(list.deleteNodeWith(33));
		System.out.println(list.deleteNodeWith(43));
		System.out.println(list.deleteNodeWith(23));
		
		//System.out.println(list.search(34));
		System.out.println(list);
		
	}

}
