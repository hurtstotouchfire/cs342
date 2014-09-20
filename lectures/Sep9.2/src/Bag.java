
public class Bag {
	
	static final int BAG_SIZE = 100;
	int [] bag;
	private int numElements = 0;

	
	public Bag() {
		bag = new int[BAG_SIZE];
	}
	
	public Bag(int initialCapacity) {
		bag = new int[initialCapacity];
	}
	
	public void add( int element) {
		if (bag.length == numElements) {
			// Bag is full
			ensureCapacity(bag.length+BAG_SIZE);
		}
		bag[numElements++] = element;
		
	}
	
	public void addAll(Bag addend) {
		ensureCapacity(bag.length + addend.size());
		System.arraycopy(addend.bag, 0, bag, numElements, addend.numElements);
		numElements += addend.numElements;
	}
	
	public void addMany(int... elements) {
		
	}
	
	public Bag clone() {
		Bag rtn;
		
		try {
			rtn = (Bag) super.clone();
		} 
		catch (CloneNotSupportedException e){
			throw new RuntimeException("Ouch not cloneable");
		}
		
		rtn.bag = bag.clone();
		
		return rtn;
	}
	
	public int countOccurrances(int target) {
		
		int num = 0;
		for (int i = 0; i < numElements; i++) {
			if (bag[i] == target) {
				num++;
			}
		}
		return num;
	}
	
	public void ensureCapacity(int minimumCapacity) {
		int [] newBag;
		
		if (bag.length < minimumCapacity) {
			newBag = new int[minimumCapacity];
			System.arraycopy(bag, 0, newBag, 0, numElements);
			bag = newBag;
		}
	}
	
	public int getCapacity() {
		return bag.length;
	}
	
	public boolean vicsRemove(int target) {
		
		for (int i = 0; i < numElements; i++) {
			if (bag[i] == target) {
				//bag[i] = bag[--numElements];
				bag[i] = bag[numElements-1];
				numElements--;
				return true;
			}
		}
		return false;
	}
	
	public boolean remove(int target) {
		int index;
		
		index = 0; 
		while((index < numElements) && (target != bag[index]))
			index++;
		
		if (index == numElements)
			return false;
		else {
			numElements--;
			bag[index] = bag[numElements];
			return true;
		}

	}
	
	public int size() {
		return numElements;
	}
	
	public void trimToSize() {
		// allocate an array of numElements size
		// copy the elements from the current bag to the new array
		// rename the new array to bag
		// return
		
		int [] newBag = new int [numElements];
		for (int i = 0; i < numElements; i++) {
			newBag[i] = bag[i];
		}
		bag = newBag;
		
	}
	
	public static Bag union(Bag b1, Bag b2) {
		return null;
	}
}
