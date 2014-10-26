// TODO: add all the methods here we actually need
public class DLList {
    protected int nodeCount;
    protected Node head;
    protected Node tail;
    protected Node current;

    public DLList() {//not actually sure this would get called with the subclass, may need a constructor there to initialize nodecount in particular. TODO: investigate default constructor for integer variables.
	nodeCount = 0;
	head = null;
	tail = null;
	current = null;
    }
  
    // TODO: possible methods
    // createNode - make a new node and put data in it
    // insert - take a node, somehow insert it alphabetically, while handling the abstraction of Contact. Maybe need to extend DLList with an abstraction class?
    // avoid: Node.getData.getName and order by that

    //insert before head
    //insert after tail
    //insert before node

    public void insert(String[] data) {
	// Create new node with data
	// insert it in front of the head by updating:
	// head should point to the new node
	// Next on the new node should point to the former head
	// Prev on the former head should point to the new node
	// increment nodeCount
    }
  
    public void insertAtTail(String[] data) {
	// If there is only one node, insertAtHead
	// Else:
	// Create new node with data
	// insert it after the tail bu updating:
	// Next on former tail should point to the new node
	// Prev on the new node should point to the former tail
	// Next on the new node should point to null
	// increment nodeCount
	// if keeping track of tail, update reference to new node
    }
  
    public String displayList () {
	// initialize empty string to return
	String rtn = "";
	// Traverse length of list, starting at head
	// for each node:
	// append reference to Prev to string
	// append data to string
	// append reference to Next to string
	return rtn;
    }
  
}
