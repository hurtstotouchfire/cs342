
public class SLList {
	
    private Node head;
    private int nodeCount;
	
    public SLList() {
	head = null;
	nodeCount = 0;
    }

    public void insertAtTail(int data) {
	// if there are no nodes yet, insert at head
	if (head == null){
	    insertAtHead(data);
	} else {
	    Node lastNode = getNodeByIndex(nodeCount - 1);
	    // make a new node with our data in it
	    Node newNode = new Node();
	    newNode.setData(data);
	    nodeCount++;
	    
	    // stick it after the tail
	    newNode.setNext(lastNode.getNext());
	    lastNode.setNext(newNode);
	}
    }
    
    public void insertAtHead(int data) {
	// make a new node with our data in it
	Node newNode = new Node();
	newNode.setData(data);
	nodeCount++;

	// stick it in front of the head
	newNode.setNext(head);
	head = newNode;
    }
    
    public boolean deleteLastNode() {
	if (head == null){
	    // Could throw an error here
	    System.out.println("That's all the nodes!");
	    return false;
	} else if (nodeCount == 1) {
	    // last is also first
	    head = null;
	    nodeCount--;
	    return true;
	} else {
	    Node secondToLast = getNodeByIndex(nodeCount - 2);
	    // point it at null
	    secondToLast.setNext(null);
	    nodeCount--;
	    return true;
	}
    }

    public void deleteAllNodes() {
	head = null;
	nodeCount = 0;
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
	    Node currNode = head;
	    
	    // loop through, incrementing current until we reach the node we want
	    int c = 0;
	    while (c != i) {
		currNode = currNode.getNext();
		c++;
	    }
	    return currNode;
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
