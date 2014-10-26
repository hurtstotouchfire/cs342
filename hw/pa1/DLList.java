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

    public void removeHead() {
	// get node after head
	Node nextNode = head.getNext();

	// make it the new head and decrement node count
	nextNode.setPrev(null);
	head = nextNode;
	nodeCount--;
    }
  
    public void removeNode(Node currentNode) {
	// get nodes surrounding current
	Node prevNode = currentNode.getPrev();
	Node nextNode = currentNode.getNext();

	// point them at each other and decrement node count
	prevNode.setNext(nextNode);
	nextNode.setPrev(prevNode);
	nodeCount--;
    }
  
    public void removeTail() {
	// get node before tail
	Node prevNode = tail.getPrev();

	// make it the new tail and decrement node count
	prevNode.setNext(null);
	tail = prevNode;
	nodeCount--;

    }
  
}
