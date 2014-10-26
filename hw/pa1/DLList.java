// TODO: add all the methods here we actually need
public class DLList {
    protected Node head;
    protected int nodeCount;
    protected Node tail; // need this for exporting from end

    public DLList() {
	head = null;
	tail = null;
	nodeCount = 0;
    }
  
    public void insertAtHead(String[] data) {
	Node newNode = new Node();
	newNode.setData(data);

	newNode.setNext(head);
	head.setPrev(newNode);
	head = newNode;
	nodeCount++;
    }
  
    public void insertBeforeNode(String[] data, Node currentNode) {
	// get node previous to current
	Node prevNode = currentNode.getPrev();

	// create new node to insert between prev and current
	Node newNode = new Node();
	newNode.setData(data);
	newNode.setNext(currentNode);
	newNode.setPrev(prevNode);

	// point existing list nodes to include new node and increment node count
	prevNode.setNext(newNode);
	currentNode.setPrev(newNode);
	nodeCount++;
    }
  
    public void insertAtTail(String[] data) {
	Node newNode = new Node();
	newNode.setData(data);

	newNode.setPrev(tail);
	tail.setNext(newNode);
	tail = newNode;
	nodeCount++;
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
