public class Driver {
  public static void main(String[] args) {
    SLList list = new SLList();
    for(int i = 0; i < 10; i++) {
      list.appendNode(new Node(i));
    }

    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
    list.cutTail();
    list.prettyPrint();
  }
}
