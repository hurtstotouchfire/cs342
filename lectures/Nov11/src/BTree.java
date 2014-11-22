
public class BTree implements MyBTree {
	
	private BTNode root;
	private int nodeCount;
	
	public BTree() {
		root = null;
		nodeCount = 0;
	}
	
	/* (non-Javadoc)
	 * @see MyBTree#add(java.lang.Integer)
	 */
	@Override
	public boolean add(Integer data) {
		
		BTNode n = new BTNode();
		n.setData(data);

		// What if tree is empty?
		if (nodeCount == 0) {
			root = n;
			nodeCount++;
			return true;
		}
		
		// See if data already in tree
		if (search(data)) return false;
		
		// iteratively locate place for this data
		BTNode tmp = root;
		
		while (tmp != null) {
			if (data > tmp.getData()) {
				if (tmp.getRchild() == null) {
					tmp.setRchild(n);
					nodeCount++;
					return true;
				} else {
					tmp = tmp.getRchild();
				}
			} else {
				if (tmp.getLchild() == null) {
					tmp.setLchild(n);
					nodeCount++;
					return true;
				} else {
					tmp = tmp.getLchild();
				}
				
			}
		}
		
		return false;
		
	}
	
	/* (non-Javadoc)
	 * @see MyBTree#print()
	 */
	@Override
	public void print() {
		printTree(root);
	}
	
	private void printTree(BTNode root) {
		if (root == null) {
			System.out.print(".");
			return;
		}
		
		printTree(root.getLchild());
		System.out.print(root.getData());
		printTree(root.getRchild());
		
	}
	
	/* (non-Javadoc)
	 * @see MyBTree#preOrder()
	 */
	@Override
	public void preOrder() {
		preOrderTraversal(root);
		System.out.println();
	}
	
	private void preOrderTraversal(BTNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getData() + " ");
		preOrderTraversal(root.getLchild());
		preOrderTraversal(root.getRchild());
	}
	
	/* (non-Javadoc)
	 * @see MyBTree#inOrder()
	 */
	@Override
	public void inOrder() {
		inOrderTraversal(root);
		System.out.println();
	}
	
	private void inOrderTraversal(BTNode root) {
		if (root == null) {
			return;
		}
		preOrderTraversal(root.getLchild());
		System.out.print(root.getData() + " ");
		preOrderTraversal(root.getRchild());
	}
	
	/* (non-Javadoc)
	 * @see MyBTree#postOrder()
	 */
	@Override
	public void postOrder() {
		postOrderTraversal(root);
		System.out.println();
	}
	
	private void postOrderTraversal(BTNode root) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.getLchild());
		postOrderTraversal(root.getRchild());
		System.out.print(root.getData() + " ");
	}
	

	/* (non-Javadoc)
	 * @see MyBTree#search(java.lang.Integer)
	 */
	@Override
	public boolean search(Integer num) {
		return bsearch(root, num);
	}
	
	private boolean bsearch(BTNode root, Integer num) {
		if (root == null) {
			return false;
		}
		
		if (root.getData() == num) {
			return true;
		} else {
			if (num < root.getData()) {
				return bsearch(root.getLchild(), num);
			} else {
				return bsearch(root.getRchild(), num);
			}
		}
	}
 }
