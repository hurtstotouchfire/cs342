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
  
    public void insertAtIndex(int index, String[] data) {
	switch (index) {
	case 0:
	    insertAtHead(data);
	case nodeCount - 1:
	    insertAtTail(data);
	default:
	    Node currentNode = getNodeByIndex(index);
	    insertBeforeNode(data, currentNode);
	}
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

    private Node getNodeByIndex(int i) {
	// safeguard for indexing errors
	if (i >= nodeCount) {
	    return null;
	} else if (i < 0) {
	    System.out.println("We don't support negative indexing.");
	    return null;
	} else {
	    // start at the head
	    Node currentNode = head;
	    
	    // loop through, incrementing current until we reach the node we want
	    int c = 0;
	    while (c != i) {
		currentNode = currentNode.getNext();
		c++;
	    }
	    return currentNode;
	}
    }

    public void displayList() {
	String output = "";
	output += "Node Count = " + nodeCount + "\n";
		
	if (nodeCount == 0) {
	    output += "[Empty]";
	} else {
	    Node temp = head;
	    while (temp != null) {
		output += "[" + temp.getData() + ", " + temp.getNext() + "] ";
		temp = temp.getNext();
	    }
	}
		
	System.out.println(output);
    }

  
}
