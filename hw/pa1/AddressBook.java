
public class AddressBook extends DLList {

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

	// make a loop which takes commands and parses them with parseArgs
	while (not breaking condition) {
	    addy.parseArgs();
	}
	
    }
    
    public void parseArgs() {	
	// take CL input
	// validate input, ask additional questions where needed
	// break up as command and input
	// execArgs(command, input);

    }

    // TODO: make Driver class which exercises all of these
    public void execArgs(String command, String input) {
	// make input arg optional

   	// if command is "a"
	addy.addContact(input);

   	// if command is "p"
	addy.printList(list);

   	// if command is "s"
	addy.search(input);

   	// if command is "e"
	addy.search(input, "email");

   	// if command is "d"
	addy.deleteContact(input);

   	// if command is "w"
	addy.export(input);

   	// if command is "r"
	addy.import(input);
    }

    /* TODO:
     * decide which of the following UI methods need to exist and which we can 
     * implement by directly accessing DLList methods.
     */

    private void addContact() {}
    private void printList() {}
    private void search() {}
    private void deleteContact() {}
    private void export() {}
    private void import() {}

}
