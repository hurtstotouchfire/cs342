public class DLList {
  private Node head;
  private int nodeCount;
  // Optional: 
  // private Node tail;

  public DLList() {
  head = null;
  nodeCount = 0;
  }
  
  public void insertAtHead {
    // Create new node with data
    // insert it in front of the head by updating:
      // head should point to the new node
      // Next on the new node should point to the former head
      // Prev on the former head should point to the new node
      // increment nodeCount
  }
  
  public void insertAtTail {
    // If there is only one node, insertAtHead
    // Else:
    // Create new node with data
    // insert it after the tail bu updating:
      // Next on former tail should point to the new node
      // Prev on the new node should point to the former tail
      // Next on the new node should point to null
      // increment nodeCount
      // if keeping track of tail, update reference to new node
  }
  
    public Node getNodeByIndex(int i) {
    // Safeguard for indexing errors:
      // index cannot be larger than nodecount - 1 (assuming 0 indexing)
      // if index can be negative, interpret it as indexing backwards from the tail
    // Traverse the length of the list by following Next links until you reach the Node for that index
      // if index can be negative, can optimize for indexes that are > 0.5 * nodeCount by starting from tail and following Prev
  }
  
  public String displayList () {
    // initialize empty string to return
    // Traverse length of list, starting at head
    // for each node:
      // append reference to Prev to string
      // append data to string
      // append reference to Next to string
    // return string
  }
  
}
