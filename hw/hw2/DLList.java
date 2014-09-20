
public class DLList {
	
    private Node head;
    private int nodeCount;
    /*	
    public DLList() {
	head = null;
	nodeCount = 0;
    }
    */	
    public int size() {
	return nodeCount;
    }
    /*	
    public void headAdd(int data) {
	Node newNode = new Node();
	newNode.setData(data);
		
	newNode.setNext(head);
	head = newNode;
	nodeCount++;
    }
	
    public int headRemove() throws RuntimeException{
	int d = head.getData();
	Node tmp = head;
		
	head = head.getNext();
	tmp.setNext(null);
		
	nodeCount--;
	return d;
    }
    */ 	
    public boolean search(int data) {

    }
	
    public void appendNodeWith(int data) {

    }
	
    public boolean deleteNodeWith(int data) {

    }
	
    public String toString() {
	String rtn = "";
	rtn += "Node Count = " + nodeCount + "\n";
		
	if (nodeCount == 0) {
	    rtn += "<Empty>";
	} else {
	    Node temp = head;
	    while (t != null) {
		rtn += "[";
		rtn += temp.getData(); // get the data from current node assigned to temp
		rtn += ", ";
		rtn += temp.getNext(); // get the pointer for the next node
		rtn += "] ";
		
		temp = temp.getNext();// get next until null
	    }
	}
		
	return rtn;
    }

}
