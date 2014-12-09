import java.lang.Integer;
public class BTree {
	
    private BTNode root;
    private BTNode nullNode;
    private int nodeCount;
    private int maxDepth;
    private int maxCount;


    // utility function for string comparison will return these values
    private final int left = -1;
    private final int right = 1;
    private final int stay = 0;
	
    public BTree() {
	root = null;
	nullNode = null;
	nodeCount = 0;
	maxDepth = 0;
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
    
    public BTNode search(String word) {
	return bsearch(root, word);
    }

    private BTNode bsearch(BTNode currentNode, String word) {
	// base case: if we reach a dead end, the word's not in the tree
	if (currentNode == null) {
	    return nullNode;
	}
	
	// Compare the word we're searching for to the word we're on
	int comp = treeDir(word, currentNode.getWord());
	System.out.println(comp); // debugging
	switch(comp) {
	case stay: // if it's the same, return true
	    return currentNode;
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

    public int wordCount(String word) {
	BTNode target = search(word);
	return target.getCount();
    }

    // definitely want to avoid returning nodes publicly if we can
    public String getDeepestWord() {
    	return getDeepestNode().getWord();
    } 

    // Methods for deepest node
    private BTNode getDeepestNode() {
	// determine tree depth
    	int maxDepth = findMaxDepth();
    	//search for node with max depth
	BTNode deepestNode = searchForDepth(root, 0, maxDepth);
	return deepestNode;
    }

    private BTNode searchForDepth(BTNode curr, int d, int depth) {
	// 
	if (d == depth) { // if we're at the max depth, return this node
	    return curr;
	} else if (!(curr.getLchild() == null)) { //otherwise go left
	    d++;
	    return searchForDepth(curr.getLchild(), d, depth);
	} else if (!(curr.getRchild() == null)) { // then go right
	    d++;
	    return searchForDepth(curr.getRchild(), d, depth);
	} else {// if there's no node of the depth we're searching for
	    return nullNode;
	}
    }
    
    // Find max node depth
    public int findMaxDepth() {
	depthTraverse(root, 0);
	return maxDepth;
    } 

    private void depthTraverse(BTNode curr, int depth) {
	if (!(curr.getLchild() == null)) {
	    depth++;
	    depthTraverse(curr.getLchild(), depth);
	} else if (!(curr.getRchild() == null)) {
	    depth++;
	    depthTraverse(curr.getRchild(), depth);
	} else {
	    maxDepth = Math.max(depth, maxDepth);
	    depth--;
	    return;
	}
		    
    }

    // Methods for most frequent word
    public String getMostFrequentWord() {
	// determine max word count
    	setMaxCount(root);
    	//search for node with max word count
	BTNode frequentWord = searchWordByCount(root, maxCount);
	return frequentWord.getWord();
    }

    public int getMaxWordCount() {
	setMaxCount(root);
	return maxCount;
    }

    private BTNode searchWordByCount(BTNode curr, int count) {
	// 
	if (curr.getCount() == count) { // if we're at a word with the count we want, return this node
	    return curr;
	} else if (!(curr.getLchild() == null)) { //otherwise go left
	    return searchWordByCount(curr.getLchild(), count);
	} else if (!(curr.getRchild() == null)) { // then go right
	    return searchWordByCount(curr.getRchild(), count);
	} else {// if there's no node of the depth we're searching for
	    return nullNode;
	}
    }
    
    private void setMaxCount(BTNode curr) {
	maxCount = Math.max(curr.getCount(), maxCount);
	if (!(curr.getLchild() == null)) {
	    setMaxCount(curr.getLchild());
	} else if (!(curr.getRchild() == null)) {
	    setMaxCount(curr.getRchild());
	} 
		    
    }


}
