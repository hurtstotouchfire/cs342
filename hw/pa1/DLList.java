// TODO: add all the methods here we actually need
public class DLList {
    protected Node head;
    protected int nodeCount;
    protected Node tail; // need this for exporting from end
    protected Node currentNode; // TODO make other AddressBook methods use this.

    public DLList() {
	head = null;
	tail = null;
	nodeCount = 0;
	currentNode = null;
    }
  
    // TODO: possible methods
    // createNode - make a new node and put data in it
    // insert - take a node, somehow insert it alphabetically, while handling the abstraction of Contact. Maybe need to extend DLList with an abstraction class?
    // avoid: Node.getData.getName and order by that

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
