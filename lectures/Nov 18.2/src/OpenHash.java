
public class OpenHash {

	private int []table;
	private static final int NEVER_USED = -1;
	private static final int PREV_USED = -2;
	
	public OpenHash() {
		table = new int[31];
		for (int i = 0; i < table.length; i++) {
			table[i] = NEVER_USED;
		}
	}
	
	
	public int getLoc(int data) {
		int loc = hashFunction(data);
		if (table[loc] != NEVER_USED) {
			for (int i = 0; i < table.length; i++) {
				System.out.println((loc+probe(i))% table.length);
				if (table[(loc+probe(i)) % table.length] == NEVER_USED || 
						table[(loc+probe(i)) % table.length] == PREV_USED) {
					return (loc+probe(i))% table.length;
				}
			}
		} else {
			return loc;
		}
		return -1;
	}
	
	private int hashFunction(int data) {
		return data % table.length;
	}
	
	private int probe(int attempt) {
		int rtn = (int) (Math.pow((double) attempt, 2.0));
		//System.out.println("Probe = " + rtn);
		return rtn;
	}
	
	public boolean add(int data) {
		int loc = getLoc(data);
		System.out.println("loc = " + loc);
		if (loc < 0) return false;
		table[loc] = data;
		return true;
	}
	
	public boolean delete(int data) {
		int loc = search(data);
		if (loc != -1) {
			table[loc] = PREV_USED;
			return true;
		}
		return false;
	}
	
	public int search(int data) {
		int loc = hashFunction(data);
		int prb;
		for (int i = 0; i < table.length; i++) {
			prb = probe(i);
			System.out.println("Search prb = " + prb);
			if (table[(loc+prb) % table.length] == data) {
				return (loc+prb) % table.length;
			}
			
			if (table[(loc+prb) % table.length] == NEVER_USED) {
				return -1;
			}
		}
		
		return -1;
	}
	
	public String toString() {
		String rtn = "";
		
		for (int i = 0; i < table.length; i++) {
			rtn += "table[" + i + "] = ";
			if (table[i] == NEVER_USED) {
				rtn += "NEVER_USED\n";
			} else if (table[i] == PREV_USED) {
				rtn += "PREV_USED\n";
			} else {
				rtn += table[i] + "\n";
			}
		}
		
		return rtn;
	} 
}
