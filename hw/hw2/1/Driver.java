
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
		list.insertAtTail(3);
		list.insertAtTail(1);
		list.insertAtTail(4);
		list.insertAtTail(1);
		list.insertAtTail(5);
		list.insertAtTail(9);
		list.insertAtTail(2);
		list.insertAtTail(6);
		list.insertAtTail(5);
		list.insertAtTail(3);
		list.displayList();		

		// delete the last node
		list.deleteLastNode();
		list.displayList();		
	}

}
