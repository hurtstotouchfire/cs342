
public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		SLList list = new SLList();
		// check out our empty list
		list.displayList();

		// put 10 integers in it
		list.append(3);
		list.append(1);
		list.append(4);
		list.append(1);
		list.append(5);
		list.append(9);
		list.append(2);
		list.append(6);
		list.append(5);
		list.append(3);
		list.displayList();		

		// delete the last node
		list.deleteLastNode();
		list.displayList();		
	}

}
