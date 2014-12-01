public class Driver {

    public static void main(String[] args) {
	Driver me = new Driver();
	me.doIt();
    }

    public void doIt() {
	// read in text file
	// remove punctuation and map to lowercase, keep only letters and numbers
	// either save it out or somehow put it into another object that we can Scan
	
	// make a BTree object
	BTree bt = new BTree();
	bt.add("cat");
	System.out.println("First pass: " + bt);
	bt.add("and");
	System.out.println("Second pass: " + bt);
    }
}
