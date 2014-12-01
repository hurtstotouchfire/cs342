import java.lang.Math;
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
	// if this already exists we should increment instead TODO
	if (search(word)) {
	    // increment somehow, probably need a different method.
	    System.out.println("Word already in tree"); // debugging
	    return false;
	}
		
	// Insert node in alphabetical order by word
	BTNode currentNode = root;
	System.out.println("Current Node: " + currentNode); //debugging
		
	while (currentNode != null) {
	    // Compare the new word to the word we're on
	    int comp = word.compareTo(currentNode.getWord());
	    comp = comp / Math.abs(comp);
	    System.out.println(comp); // debugging
	    switch(comp) {
	    case 0: // if it's the same, increment instead of adding
		currentNode.incrCount();
		return true;
	    case -1: // if we're too late in the alphabet, go left
		// if there's nothing there, insert
		if (currentNode.getLchild() == null) {
		    currentNode.setLchild(n);
		    nodeCount++;
		    return true;
		} // otherwise, traverse
		currentNode = currentNode.getLchild();
	    case 1: // if we're too early in the alphabet, go right
		// if there's nothing there, insert
		if (currentNode.getRchild() == null) {
		    currentNode.setRchild(n);
		    nodeCount++;
		    return true;
		} // otherwise, traverse
		currentNode = currentNode.getRchild();
	    default:
		throw new RuntimeException("Invalid add case."); // TODO throw runtime exception
	    }
	    
	}		
	return false; // TODO what's this case?		
    }
	
    public String toString() {
	String rtn = "Nodecount: " + nodeCount + "\n";
	return printTree(root, rtn);
    }
    
    private String printTree(BTNode node, String rtn) {
	if (node == null) {
	    rtn = rtn + ".";
	    return rtn;
	} else {
	    // TODO check what this order is, looks like inorder
	    rtn += printTree(node.getLchild(), rtn);
	    rtn += node;
	    rtn += printTree(node.getRchild(), rtn);
	    return rtn;
	}
    }
    
    public boolean search(String word) {
	return bsearch(root, word);
    }

    private boolean bsearch(BTNode currentNode, String word) {
	// base case: if we reach a dead end, the word's not in the tree
	if (currentNode == null) {
	    return false;
	}
	
	// Compare the word we're searching for to the word we're on
	int comp = word.compareTo(currentNode.getWord());
	comp = comp / Math.abs(comp);
	System.out.println(comp); // debugging
	switch(comp) {
	case 0: // if it's the same, return true
	    return true;
	case -1: // if we're too late in the alphabet, go left
	    return bsearch(currentNode.getLchild(), word);
	case 1: // if we're too early in the alphabet, go right
	    return bsearch(currentNode.getRchild(), word);
	default:
	    throw new RuntimeException("Invalid search case."); // TODO throw runtime exception
	}
    }
}
