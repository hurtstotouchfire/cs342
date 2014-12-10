import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class DraculaIO {

    private String filename = "pg345.txt";
    private String text;
    private int strPos = 0;
    private BTree bt;

    public DraculaIO() {
	bt = new BTree();
    }

    public static void main(String[] args) {
	DraculaIO dio = new DraculaIO();
	dio.readDracula();
	dio.queryBTree();
    }

    public void readDracula() {
	// read in text file
	text = readFile(filename);
	
	while (strPos != text.length() - 1) {
	    // remove punctuation and map to lowercase, keep only letters and numbers
	    // append to tree
	    bt.add(getNextWord());
	}

	// Print tree TODO remove then when we switch to real file
	System.out.println("sample text: " + bt);

    }

    public String readFile(String filename) {
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
	// gets next contiguous alphanumeric, non-whitespace string
	// returns only lowercase letters

	// start with empty rtn, and first char in text
	String rtn = "";
	char n = text.charAt(strPos);
	
	// First skip past any leading non-alphanumeric chars
	while (!Character.isLetterOrDigit(n)) {
	    strPos++;
	    n = text.charAt(strPos);
	    System.out.print(n);
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

    public void queryBTree() {
	System.out.println("transylvania occurs : " + bt.wordCount("transylvania") + " times"); //16
	System.out.println("harker occurs       : " + bt.wordCount("harker") + " times"); //113
	System.out.println("renfield occurs     : " + bt.wordCount("renfield") + " times"); //39
	System.out.println("vampire occurs      : " + bt.wordCount("vampire") + " times"); //24
	System.out.println("expostulate occurs  : " + bt.wordCount("expostulate") + " times"); //1
	System.out.println("Tree is             : " + bt.getMaxDepth() + " nodes deep"); //34
	System.out.println("Tree contains       : " + bt.getNodeCount() + " distinct words"); //10857
	System.out.println("Word at root is     : " + bt.getRootWord()); //the
	System.out.println("Deepest word is     : " + bt.getDeepestWord()); //accessible
	System.out.println("Most Frequent is    : '" + bt.getMostFrequentWord() + "' occuring " + bt.getMaxWordCount() + " times"); //8037
    }

}
