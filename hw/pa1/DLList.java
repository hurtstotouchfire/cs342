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
  
    /*
     * Insertion and deletion should all route through the ByIndex methods.
     * These methods will check the nodeCount and call the appropriate methods
     * for bookkeeping the head / tail / various pointers.
     */

    public void insertAtIndex(int index, String[] data) {
	
	if (index == 0) {
	    insertAtHead(data);
	} else if (index == (nodeCount)) {//TODO: how to indicate with index to insert after tail
	    insertAtTail(data);
	} else {
	    Node currentNode = getNodeByIndex(index);
	    insertBeforeNode(data, currentNode);
	}
    }

    public void removeAtIndex(int index) {
	
	if (index == 0) {
	    // throw a runtime error maybe?
	} else if (index == 1) {
	    removeHead();
	} else if (index == (nodeCount - 1)) {
	    removeTail();
	} else {
	    Node currentNode = getNodeByIndex(index);
	    removeNode(currentNode);
	}
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

    /*
     * The following insert* methods handle cases where nodeCount = 1+
     * for empty lists, they defer to addHead
     */
    //TODO: make private so only the byindex methods can call them
    public void addHead(Node newNode) {// add first node
	newNode.setNext(null);
	newNode.setPrev(null);
	head = newNode;
	tail = newNode;
	nodeCount++;
	
    }

    public void insertAtHead(String[] data) {// insert before existing head
	Node newNode = new Node();
	newNode.setData(data);

	newNode.setNext(head);
	head.setPrev(newNode);
	head = newNode;
	nodeCount++;
    }
  
    public void insertBeforeNode(String[] data, Node currentNode) {//TODO check cases here
	    Node newNode = new Node();
	    newNode.setData(data);
	switch (nodeCount) {
	case 0:
	    addHead(newNode);
	default: 
	    // get node previous to current
	    Node prevNode = currentNode.getPrev();
	    
	    // create new node to insert between prev and current
	    newNode.setNext(currentNode);
	    newNode.setPrev(prevNode);
	    
	    // point existing list nodes to include new node and increment node count
	    prevNode.setNext(newNode);
	    currentNode.setPrev(newNode);
	    nodeCount++;
	}
    }

    public void insertAtTail(String[] data) {
	// can handle a 1 node list but not an empty one
	    Node newNode = new Node();
	    newNode.setData(data);

	switch (nodeCount) {
	case 0:
	    addHead(newNode);
	default: 	    
	    newNode.setPrev(tail);
	    tail.setNext(newNode);
	    tail = newNode;
	    nodeCount++;
	}
    }

    /*
     * Remove methods handle cases where nodeCount = 2+
     * For 1 node, they defer to clear
     * For empty lists, they throw runtime errors. TODO add those
     */

    public void removeHead() {//can handle 2+ node lists. for 1 node, use clear
	// get node after head
	Node nextNode = head.getNext();

	// make it the new head and decrement node count
	nextNode.setPrev(null);
	head = nextNode;
	nodeCount--;
    }
  
    public void removeNode(Node currentNode) {//TODO safeguard for 0,1,2 cases
	// get nodes surrounding current
	Node prevNode = currentNode.getPrev();
	Node nextNode = currentNode.getNext();

	// point them at each other and decrement node count
	prevNode.setNext(nextNode);
	nextNode.setPrev(prevNode);
	nodeCount--;
    }
  
    public void removeTail() {// can handle 2 node list but not 1
	// get node before tail
	Node prevNode = tail.getPrev();

	// make it the new tail and decrement node count
	prevNode.setNext(null);
	tail = prevNode;
	nodeCount--;

    }

    /*
     * Print list
     */

    public String toString() {
	String output = "";
	output += "Node Count = " + nodeCount + "\n";
		
	if (nodeCount == 0) {
	    output += "[0][Empty]";
	} else {
	    Node currentNode = head;
	    int i = 0;
	    while (currentNode != null) {
		output += "[" + i + "][" + currentNode + "] ";
		currentNode = currentNode.getNext();
		i++;
	    }
	}
		
	return output;
    }

  
}
