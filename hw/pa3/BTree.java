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

	// if tree is empty
	if (nodeCount == 0) {
	    root = n;
	    nodeCount++;
	    return true;
	}
		
	// Insert node in alphabetical order by word
	BTNode currentNode = root;
		
	while (currentNode != null) {
	    // Compare the new word to the word we're on
	    int comp = treeDir(word, currentNode.getWord());
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
		throw new RuntimeException("Invalid add case.");
	    }
	    
	}		
	return false; 
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
	    // Print inorder
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
	switch(comp) {
	case stay: // if it's the same, return true
	    return currentNode;
	case left: // if we're too late in the alphabet, go left
	    return bsearch(currentNode.getLchild(), word);
	case right: // if we're too early in the alphabet, go right
	    return bsearch(currentNode.getRchild(), word);
	default:
	    throw new RuntimeException("Invalid search case."); 
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

    // get count for a given word
    public int wordCount(String word) {
	BTNode target = search(word);
	return target.getCount();
    }

    // Methods for deepest node
    
    // get deepest word by finding max depth and then getting the first word at that depth
    public String getDeepestWord() {
	// determine tree depth
    	int maxDepth = getMaxDepth();
    	//search for node with max depth
	BTNode deepestNode = searchForDepth(root, 0, maxDepth);
	if (deepestNode == null) {
	    throw new RuntimeException("No Node at maxDepth");
	} else {
	    return deepestNode.getWord();
	}
    }

    // Find max node depth
    public int getMaxDepth() {
	setMaxDepth(root, 0);
	return maxDepth + 1; // I'm counting the root as level 0
    } 

    // traverse tree to determine max depth
    private void setMaxDepth(BTNode curr, int depth) {
	maxDepth = Math.max(depth, maxDepth);
	depth++;
	if (!(curr.getLchild() == null)) {
	    setMaxDepth(curr.getLchild(), depth);
	} 
	if (!(curr.getRchild() == null)) {
	    setMaxDepth(curr.getRchild(), depth);
	}
    }

    // returns the first node it finds at a given depth
    private BTNode searchForDepth(BTNode curr, int d, int depth) {
	// base cases
	if (curr == null) { // if we've reached the end, return null
	    return null;
	} else if (d == depth) { // if we're at the depth we want, return this node
	    return curr;
	} else { //recurse
	    d++; // go down a level
	    
	    // if it's in the left branch, return that
	    BTNode lNode = searchForDepth(curr.getLchild(), d, depth);
	    if (lNode != null) {
		return lNode;
	     }
	    
	    // if it's in the right branch, return that
	    BTNode rNode = searchForDepth(curr.getRchild(), d, depth);
	    if (rNode != null) {
		 return rNode;
	    }

	    // Otherwise not found
	    return null;
	} 
    }
    
    // Methods for most frequent word

    // get most frequent word by finding max word count and then returning the first word with that count
    public String getMostFrequentWord() {
	// determine max word count
    	setMaxCount(root);
    	//search for node with max word count
	BTNode frequentWord = searchWordByCount(root, maxCount);
	if (frequentWord == null) {
	    return "word with count " + maxCount + "not found";
	} else {
	    return frequentWord.getWord();
	}
    }

    public int getMaxWordCount() {
	setMaxCount(root);
	return maxCount;
    }

    // traverse tree to determine max word count
    private void setMaxCount(BTNode curr) {
	maxCount = Math.max(curr.getCount(), maxCount);
	if (!(curr.getLchild() == null)) {
	    setMaxCount(curr.getLchild());
	} 
	if (!(curr.getRchild() == null)) {
	    setMaxCount(curr.getRchild());
	} 
    }

    // returns the first node it finds with a given count
    private BTNode searchWordByCount(BTNode curr, int count) {
	// base cases
	if (curr == null) { // if we've reached the end, return null
	    return null;
	} else if (curr.getCount() == count) { // if we're at a word with the count we want, return this node
	    return curr;
	} else { // recursion
	    // if it's in the left branch, return that
	    BTNode lNode = searchWordByCount(curr.getLchild(), count);
	    if (lNode != null) {
		return lNode;
	    }

	    // if it's in the right branch, return that
	    BTNode rNode = searchWordByCount(curr.getRchild(), count);
	    if (rNode != null) {
		return rNode;
	    }

	    // otherwise not found
	    return null;
	}
    }

}
