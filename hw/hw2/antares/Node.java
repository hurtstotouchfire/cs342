public class Node {
  public int datum;
  public Node nextNode;

  public Node(int datumVal) {
    this.datum = datumVal;
    this.nextNode = null;
  }

  public void setNext(Node next) {
    this.nextNode = next;
  }

  public boolean isTail() {
    return(this.nextNode == null);
  }
}
