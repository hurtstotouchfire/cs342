import java.io.Serializable;
public class Node implements Serializable  {
    protected Node next;
    protected Node prev;
    protected String[] data;
    
    public Node(String[] data) {
	this.data = data;
    }
    public Node getNext() {
    return next;
    }
    public void setNext(Node next) {
    this.next = next;
    }

    public Node getPrev() {
    return prev;
    }
    public void setPrev(Node prev) {
    this.prev = prev;
    }

    public String[] getData() {
    return data;
    }
    public void setData(String[] data) {
    this.data = data;
    }


    public String toString() {
	return data[0];
    }

}
