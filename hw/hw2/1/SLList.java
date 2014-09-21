
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
	    Node lastNode = findLastNode();
	}
	
	// make a new node with our data in it
	Node newNode = new Node();
	newNode.setData(data);
	nodeCount++;

	// stick it after the tail
	newNode.setNext(lastNode.getNext());
	lastNode.setNext(newNode);
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
	    // do things differently
	    return false;
	}
	else {
	    lastNode = findLastNode(self);
	    // delete it
	    return true;
	}
    }

    private Node findLastNode() {

	// what if I am passed an empty, null head? I cannot call getNext on that.

	// start at the head
	Node curr = head;

	// loop through until a node has nothing after it
	while (curr.getNext() != null) {
	    curr = curr.getNext();
	}
	return curr;
    }

    public String displayList() {
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
