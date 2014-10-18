import java.io.Serializable;


public class MyClass implements Serializable{
	
	String [] stuff = null;
	
	private int count = 0;
	
	public MyClass() {
		stuff = new String[32];
	}
	
	public void add(String s) {
		stuff[count++] = s;
	}
	
	public String toString() {
		String rtn = "";
		
		for (int i = 0; i < count; i++) {
			rtn += stuff[i] + "\n";
		}
		
		return rtn;
	}

}
