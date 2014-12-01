public class BTree {
	
    private BTNode root;
    private int nodeCount;
	
    public BTree() {
	root = null;
	nodeCount = 0;
    }
	
    public boolean add(String word) {
		
	BTNode n = new BTNode(word);

	// What if tree is empty?
	if (nodeCount == 0) {
	    root = n;
	    nodeCount++;
	    return true;
	}
		
	// See if data already in tree
	if (search(data)) return false;
		
	// iteratively locate place for this data
	BTNode currentNode = root;
		
	while (currentNode != null) {
	    if (data > currentNode.getWord()) {
		if (currentNode.getRchild() == null) {
		    currentNode.setRchild(n);
		    nodeCount++;
		    return true;
		} else {
		    currentNode = currentNode.getRchild();
		}
	    } else {
		if (currentNode.getLchild() == null) {
		    currentNode.setLchild(n);
		    nodeCount++;
		    return true;
		} else {
		    currentNode = currentNode.getLchild();
		}
				
	    }
	}
		
	return false;
		
    }
	
    public void print() {
	printTree(root);
    }
	
    private void printTree(BTNode root) {
	if (root == null) {
	    System.out.print(".");
	    return;
	}
		
	printTree(root.getLchild());
	System.out.print(root.getWord());
	printTree(root.getRchild());
		
    }

    /*
    public void preOrder() {
	preOrderTraversal(root);
	System.out.println();
    }
	
    private void preOrderTraversal(BTNode root) {
	if (root == null) {
	    return;
	}
	System.out.print(root.getWord() + " ");
	preOrderTraversal(root.getLchild());
	preOrderTraversal(root.getRchild());
    }
    
    public void inOrder() {
	inOrderTraversal(root);
	System.out.println();
    }
	
    private void inOrderTraversal(BTNode root) {
	if (root == null) {
	    return;
	}
	preOrderTraversal(root.getLchild());
	System.out.print(root.getWord() + " ");
	preOrderTraversal(root.getRchild());
    }
	
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
	System.out.print(root.getWord() + " ");
    }
    */
	
    public boolean search(String word) {
	return bsearch(root, word);
    }
	
    private boolean bsearch(BTNode currentNode, String word) {
	if (currentNode == null) {
	    return false;
	}
		
	if (currentNode.getWord() == word) {
	    return true;
	} else {
	    if (word < currentNode.getWord()) {
		return bsearch(currentNode.getLchild(), word);
	    } else {
		return bsearch(currentNode.getRchild(), word);
	    }
	}
    }
}
