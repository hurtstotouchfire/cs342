import java.io.IOException;
public class Reader {
    private String prompt;

    public Reader (String a_prompt) {
	prompt = a_prompt;
    }
    /*
    public static void main (String[] args) {
	Reader r = new Reader("promptastic!");
	try {
	    int input = r.readln();
	    System.out.print (input);
	} catch (IOException e) {
	    //care about it
	}
    }
    */
    public int readln () throws java.io.IOException {
	System.out.println(prompt);
	int num = 0;
	int ch;
	while ((ch = System.in.read ()) != '\n')

	    if (! valid_input(Integer.toString(ch)))
		throw new IOException("Not a valid input.");

	    // assemble a multi-digit integer
	    if (ch >= '0' && ch <= '9')
		{
		    num *= 10;
		    num += ch - '0';
		}
	    else
		break;
	return num;
    }
    private boolean valid_input (String input) {
	int[] valid_inputs = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
	for (int i=0; i<valid_inputs.length; i++) {
	    if (input == Integer.toString(valid_inputs[i])) {
		System.out.println("checking " + valid_inputs[i]);
		return true;
	    } else {
		return false;
	    }
	}
    }
}
