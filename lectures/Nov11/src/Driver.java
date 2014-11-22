
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		MyBTree tree = new BTree();
		
		tree.add(55);
		tree.add(30);
		tree.add(60);
		tree.add(35);
		tree.add(44);
		//tree.add(44);
		tree.add(78);
		//tree.print();
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
		
		System.out.println(tree.search(55));
	}

}
