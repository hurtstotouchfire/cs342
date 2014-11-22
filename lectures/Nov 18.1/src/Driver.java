
public class Driver {

	int []array = {2, 4, 5, 6, 7, 8, 9, 10, 12, 23, 34, 45, 56, 99}; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		System.out.println(linSearch(99));
		System.out.println(linBinSearch(99));
		System.out.println(recBinSearch(88, 0, array.length-1));
	}
	
	public int linSearch(int data) {
		int i;
		for (i = 0; i < array.length; i++) {
			if (array[i] == data) {
				break;
			}
		}
		
		if (i == array.length) {
			return -1;
		}
		
		return i;
	}

	public boolean linBinSearch(int data) {
		
		boolean done = false;
		int lo = 0;
		int hi = array.length-1;
		int mid;
		
		while (!done) {
			if (lo > hi) {
				return false;
			}
			
			mid = (hi + lo) / 2;
			System.out.println("mid = " + mid);
			if (array[mid] == data) {
				return true;
			}
			
			if (array[mid] > data) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
			
		}
		return false;
	}
	
	public boolean recBinSearch(int data, int lo, int hi) {
		if (lo > hi) {
			return false;
		}
		
		int mid = (hi + lo) / 2;
		if (array[mid] == data) {
			return true;
		}
		
		if (array[mid] > data) {
			return recBinSearch(data, lo, mid - 1);
		} else {
			return recBinSearch(data, mid + 1, hi);
		}
	}
}
