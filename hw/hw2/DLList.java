
public class DLList {
	
    private Node head;
    private int nodeCount;
	
    public DLList() {
	head = null;
	nodeCount = 0;
    }
	
    public int size() {
	return nodeCount;
    }
	
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
	
    public boolean search(int data) {
	if (size() == 0) {
	    return false;
	}
		
	Node tmp = head;
		
	while (tmp != null) {
	    if (tmp.getData() == data) {  // Got it
		return true;
	    }
	    tmp = tmp.getNext();
	}
	// Getting here means the data is not there
	return false;
    }
	
    public void insertInOrder(int data) {
	// Head insert
	// Step 1 (Head is null)
	if (head == null) {
	    headAdd(data);
	    return;
	}
		
	// General insert
		
	Node prev = null;
	Node cur = head;
		
	while (cur != null) {
	    if (cur.getData() >= data) {
		// Insert data before current and after prev
		if (prev == null) {
		    // Insert data at head of the list
		    // Because it is the smallest piece of data
		    headAdd(data);
		    return;
		} else {
		    // Insert in the middle of the list
		    Node n = new Node();
		    n.setData(data);
		    n.setNext(cur);
					
		    prev.setNext(n);
		    nodeCount++;
		    return;
		}
	    }
	    // Update our references
	    prev = cur;
	    cur = cur.getNext();
	}
		
	// Tail Insert
	if (cur == null) {
	    Node n = new Node();
	    n.setData(data);
	    n.setNext(null);
	    prev.setNext(n);
	    nodeCount++;
	    return;
	}
    }
	
    public boolean deleteNodeContaining(int data) {
	// Empty List
	if (head == null) {
	    return false;
	}
		
	// General Delete
		
	Node prev = null;
	Node cur = head;
		
	while (cur != null) {
	    if (cur.getData() == data) {
		// Delete node after prev
		if (prev == null) {
		    // Delete head because it contains data
		    headRemove();
		    return true;
		} else {
		    // Remove from the middle of the list
		    // prev and cur are valid
					
		    prev.setNext(cur.getNext());
		    cur.setNext(null);
		    nodeCount--;
		    return true;
		}
	    }
	    // Update our references
	    prev = cur;
	    cur = cur.getNext();
	}
	return false;
    }
	
    public String toString() {
	String rtn = "";
	rtn += "[Node Count = " + nodeCount + "]\n";
		
	if (nodeCount == 0) {
	    rtn += "<Empty>";
	} else {
	    Node t = head;
	    while (t != null) {
		rtn += "<" + t.getData() + ", " + t.getNext() + "> ";
		t = t.getNext();
	    }
	}
		
	return rtn;
    }

}
