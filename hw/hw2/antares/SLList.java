public class SLList {
  public Node head;

  public Node appendNode(Node nextNode) {
    if (head == null) {
      head = nextNode;
    } else {
      findTail(null).setNext(nextNode);
    }

    return(nextNode);
  }

  public Node findTail(Node currentNode) {
    if (currentNode == null) {
      currentNode = head;
    }

    if (currentNode.isTail()) {
      return(currentNode);
    } else {
      return(findTail(currentNode.nextNode));
    }
  }

  public void cutTail() {
    if (head != null) {
      if (findTailAndCut(head)) {
        head = null;
      }
    }
  }
  
  private boolean findTailAndCut(Node currentNode) {
    if (currentNode.isTail()) {
      return(true);
    } else {
      if (findTailAndCut(currentNode.nextNode)) {
        currentNode.nextNode = null;
      }
      return(false);
    }
  }

  public void prettyPrint() {
    if (head == null) {
      System.out.print("List is empty.");
    } else {
      printFollowing(head);
    }
    System.out.print("\n");
  }

  private void printFollowing(Node currentNode) {
    System.out.print(currentNode.datum + " ");
    if (currentNode.nextNode != null) {
      printFollowing(currentNode.nextNode);
    }
  }
}
