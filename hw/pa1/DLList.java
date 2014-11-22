import java.io.Serializable;

public class DLList implements Serializable {
    protected Node head;
    protected int nodeCount;
    protected Node tail; 

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

    public void insertAtIndex(Node newNode, int index) {
        // defer to head and tail methods for special cases
	if (index < 0) {
	    throw new RuntimeException("Negative indices are not supported.");
	} else if (nodeCount == 0) {// don't care what index they provide, if the list is empty, insert at head
	    addHead(newNode);
	} else if (index == 0) {
	    insertAtHead(newNode);
	} else if (index == (nodeCount)) {
	    insertAtTail(newNode);
	} else {
	    Node currentNode = getNodeByIndex(index);
	    insertBeforeNode(newNode, currentNode);
	}
    }

    public void removeAtIndex(int index) {
	
	if (index < 0) {
	    throw new RuntimeException("Negative indices are not supported.");
	} else if (index == 0 && nodeCount == 0) {
	    throw new IndexOutOfBoundsException();
	} else if (index == 0) {
	    removeHead();
	} else if (index >= nodeCount) {
	    throw new IndexOutOfBoundsException();
	} else if (index == (nodeCount - 1)) {
	    removeTail();
	} else {
	    Node currentNode = getNodeByIndex(index);
	    removeNode(currentNode);
	}
    }

    private Node getNodeByIndex(int index) {
	// this is only called by insertAtIndex and removeAtIndex currently, which will do their own index checking
	// but we will safeguard for indexing errors just in case someone else uses this someday
	if (index >= nodeCount) {
	    return null;
	} else if (index < 0) {
	    System.out.println("We don't support negative indexing.");
	    return null;
	} else {
	    // start at the head
	    Node currentNode = head;
	    
	    // loop through, incrementing current until we reach the node we want
	    int c = 0;
	    while (c != index) {
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

    private void addHead(Node newNode) {// add first node
	newNode.setNext(null);
	newNode.setPrev(null);
	head = newNode;
	tail = newNode;
	nodeCount++;
    }

    private void insertAtHead(Node newNode) {// insert before existing head
	newNode.setNext(head);
	head.setPrev(newNode);
	head = newNode;
	nodeCount++;
    }
  
    private void insertBeforeNode(Node newNode, Node currentNode) {
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

    private void insertAtTail(Node newNode) {//insert after last node
	// can handle a 1 node list but not an empty one
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
     * For empty lists, they throw runtime errors. 
     */

    private void clearList() {// make the list like new again
	nodeCount = 0;
	head = null;
	tail = null;
    }

    private void removeHead() {//can handle 2+ node lists. for 1 node, use clear

	switch (nodeCount) {
	case 0: // this should be handled by the parent method, but just in case
	    throw new RuntimeException("Head is already removed.");
	case 1:
	    clearList();
	    break;
	default:
	    // get node after head
	    Node nextNode = head.getNext();
	    
	    // make it the new head and decrement node count
	    nextNode.setPrev(null);
	    head = nextNode;
	    nodeCount--;
	}
    }
  
    private void removeNode(Node currentNode) {

	// get nodes surrounding current
	Node prevNode = currentNode.getPrev();
	Node nextNode = currentNode.getNext();

	// point them at each other and decrement node count
	prevNode.setNext(nextNode);
	nextNode.setPrev(prevNode);
	nodeCount--;
    }
  
    private void removeTail() {// can handle 2 node list but not 1
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
