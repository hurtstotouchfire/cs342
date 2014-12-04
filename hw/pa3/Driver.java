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
	bt.add("delta");
	System.out.println("First pass: " + bt);
	bt.add("gamma");
	System.out.println("Second pass: " + bt);
	bt.add("beta");
	System.out.println("Third pass: " + bt);
	bt.add("alpha");
	System.out.println("Fourth pass: " + bt);
	bt.add("gamma");
	System.out.println("Fifth pass: " + bt);
	bt.add("delt");
	System.out.println("First pass: " + bt);
	bt.add("gamm");
	System.out.println("Second pass: " + bt);
	bt.add("bet");
	System.out.println("Third pass: " + bt);
	bt.add("alph");
	System.out.println("Fourth pass: " + bt);
	bt.add("gamm");
	System.out.println("Fifth pass: " + bt);
    }
}
