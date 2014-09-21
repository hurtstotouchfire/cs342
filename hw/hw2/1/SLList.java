
public class SLList {
	
    private Node head;
    private int nodeCount;
	
    public SLList() {
	head = null;
	nodeCount = 0;
    }

    public boolean append(int data) {
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

}
