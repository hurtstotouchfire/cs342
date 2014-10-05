
public class AddressBook {

    public static void main(String[] args) {
	AddressBook addy = new AddressBook();
	addy.start();
    }
    
    public void start() {
	
	// make an empty list
	DLList list = new DLList();
	addy.print();
	// print contents of address book using list's toString method
	System.out.println(list);
	
    }
    
}
