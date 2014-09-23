
public class Node {
    private String[] data; // data is an array containing 3 strings
    private Node next;
    private Node prev;
    
    public int getData() {
    return data;
    }
    public void setData(int data) {
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
    
}
