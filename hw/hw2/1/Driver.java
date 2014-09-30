
public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		System.out.println("Make an empty list");
		SLList list = new SLList();

		System.out.println("See what happens if we try to delete nothing");
		list.deleteLastNode();
		list.displayList();		

		System.out.println("Put something in and immediately delete it");
		list.insertAtTail(3);
		list.displayList();		
		list.deleteLastNode();
		list.displayList();		


		System.out.println("Inserting the first item at head or tail should look the same");
		list.insertAtTail(3);
		list.displayList();		
		list.deleteLastNode();
		list.insertAtHead(3);
		list.displayList();		

		System.out.println("Clear out our list and put 10 fresh integers in it");
		list.deleteAllNodes();
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

		System.out.println("Delete the last node");
		list.deleteLastNode();
		list.displayList();		

	}

}
