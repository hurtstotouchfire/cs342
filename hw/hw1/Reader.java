public class Reader {
    private String prompt;

    public Reader (String a_prompt) {
	prompt = a_prompt;
    }

    public static void main (String[] args) {
	Reader r = new Reader("promptastic!");
	int input = r.readln();
	System.out.print (input);
    }

    public int readln () {
	System.out.println (prompt);
	int num = 0;
	int ch;
	while ((ch = System.in.read ()) != '\n')
	    if (ch >= '0' && ch <= '9')
		{
		    num *= 10;
		    num += ch - '0';
		}
	    else
		break;
	return num;
    }
}
