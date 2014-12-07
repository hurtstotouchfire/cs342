import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Driver {

    private String filename = "sample.txt";
    private String text;
    private int strPos = 0;

    public static void main(String[] args) {
	Driver me = new Driver();
	//me.btreeTest();
	me.fileTest();
    }

    public void fileTest() {
	// read in text file
	text = readFile("sample.txt");
	
	// make a tree to put stuff in
	BTree bt = new BTree();
	
	while (strPos != text.length() - 1) {
	    // remove punctuation and map to lowercase, keep only letters and numbers
	    // append to tree
	    bt.add(getNextWord());
	}

	// Print tree
	System.out.println("sample text: " + bt);

    }

    public String readFile(String filename)
    {
	String content = null;
	File file = new File(filename);
	try {
	    FileReader reader = new FileReader(file);
	    char[] chars = new char[(int) file.length()];
	    reader.read(chars);
	    content = new String(chars);
	    reader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return content;
    }

    public String getNextWord() {
	// start with empty rtn, and first char in text
	String rtn = "";
	char n = text.charAt(strPos);
	
	// First skip past any leading non-alphanumeric chars
	while (!Character.isLetterOrDigit(n)) {
	    strPos++;
	    n = text.charAt(strPos);
	}

	// Now pull only letters or numbers until we hit a space
	while(!Character.isWhitespace(n)) {
	    if (Character.isLetterOrDigit(n)) {//if it's a letter or number
		n = Character.toLowerCase(n); //convert to lowercase (doesn't alter numbers)
		rtn += n; //and append to rtn
	    }//otherwise move to the next char
	    strPos++; 
	    n = text.charAt(strPos);
	}

	return rtn;
    }

    public void btreeTest() {
	
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
