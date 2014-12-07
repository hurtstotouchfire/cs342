import java.lang.Integer;
public class BTree {
	
    private BTNode root;
    private int nodeCount;

    // utility function for string comparison will return these values
    private final int left = -1;
    private final int right = 1;
    private final int stay = 0;
	
    public BTree() {
	root = null;
	nodeCount = 0;
    }
	
    /*
     * Getters for private vars
     */

    public int getNodeCount() {
	return nodeCount;
    }

    // never provide the actual root object to an outside class
    public String getRootWord() { 
	return root.getWord();
    }

    /*
     * Heavy lifter methods that make the tree
     */

    public boolean add(String word) {
		
	BTNode n = new BTNode(word);

	// What if tree is empty?
	if (nodeCount == 0) {
	    root = n;
	    nodeCount++;
	    return true;
	}
		
	// Insert node in alphabetical order by word
	BTNode currentNode = root;
	System.out.println("Current Node: " + currentNode); //debugging
		
	while (currentNode != null) {
	    // Compare the new word to the word we're on
	    int comp = treeDir(word, currentNode.getWord());
	    System.out.println(comp); // debugging
	    switch(comp) {
	    case stay: // if it's the same, increment instead of adding
		currentNode.incrCount();
		return true;
	    case left: // if we're too late in the alphabet, go left
		// if there's nothing there, insert
		if (currentNode.getLchild() == null) {
		    currentNode.setLchild(n);
		    nodeCount++;
		    return true;
		} // otherwise, traverse
		currentNode = currentNode.getLchild();
		break;
	    case right: // if we're too early in the alphabet, go right
		// if there's nothing there, insert
		if (currentNode.getRchild() == null) {
		    currentNode.setRchild(n);
		    nodeCount++;
		    return true;
		} // otherwise, traverse
		currentNode = currentNode.getRchild();
		break;
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
	    rtn += printTree(node.getLchild(), "");
	    rtn += node;
	    rtn += printTree(node.getRchild(), "");
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
	int comp = treeDir(word, currentNode.getWord());
	System.out.println(comp); // debugging
	switch(comp) {
	case stay: // if it's the same, return true
	    return true;
	case left: // if we're too late in the alphabet, go left
	    return bsearch(currentNode.getLchild(), word);
	case right: // if we're too early in the alphabet, go right
	    return bsearch(currentNode.getRchild(), word);
	default:
	    throw new RuntimeException("Invalid search case."); // TODO throw runtime exception
	}
    }

    // Utility function that compares two strings and tells you which way to go
    private int treeDir(String query, String current) {
	int comp = query.compareTo(current);
	return Integer.signum(comp);
    }

    /*
     * Methods for getting information about the tree's contents
     */

    public int wordCount(String word) {}
    public int getMaxWordCount() {} 

    // not sure how this will be implemented yet
    private int getNodeDepth(BTNode node) {} 
    public int getWordDepth(String word) {} // could use search then getNodeDepth
    public int getMaxDepth() {}

    // definitely want to avoid returning nodes publicly if we can
    public String getDeepestWord() {
	return getDeepestNode().getWord();
    } 
    private BTNode getDeepestNode(BTNode node) {} 

}
