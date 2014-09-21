
public class SLList {
	
    private Node head;
    private int nodeCount;
	
    public SLList() {
	head = null;
	nodeCount = 0;
    }

    public boolean append(int data) {
	if (head == null){
	    // do things differently
	}
	
	return false;
    }
    
    public boolean deleteLastNode() {
	return false;
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

    private Node findLastNode(SLList list){

	// what if I am passed an empty, null head? I cannot call getNext on that.

	// start at the head
	curr = list.head;

	// loop through until a node has nothing after it
	while (curr.getNext() != null) {
	    curr = curr.getNext();
	}
    return curr;
    }
}
