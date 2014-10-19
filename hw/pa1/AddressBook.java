// what's the right segregation of abstractions? 
// AddressBook knows it extends DLList and uses DLList methods presumably
// But maybe all public methods on AddressBook are named as if DLList does not exist

// TODO: consider taking a string array of args so you can set all three. 
// store in array as well?
// Would need getters and setters for those fields.

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

    public void execArgs(String command, String input) {// TODO: move to another class somehow
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

    public void addContact(String newName, String email, String phoneNumber) { //add contacts in alpha order by Name field.
	/* first, make sure searchContact returns false. (note that this is less efficient but better encapsulation)
	 * make a new Contact and populate data
	 * 
	 * start with first contact, get it's name
	 * if firstcontact.name is alphabetically after newName
	 *     insertContactAtHead(newName)
	 * otherwise, make a loop (remember prev node so we can step back one)
	 * if currentContact.name is alpha before newName
	 *     getNext contact
	 * else 
	 *     insert newName contact after prev node and before currentContact node.
	 */
    }
    public void printAllContacts() { // TODO: Make sure Contact toString makes a nice print output for concatenating
	// if nodeCount == 0 (is this the right check)
	// print that we're empty. 
	// else:
	// make a return string with some initial glue in it
	// start at head
	// while we have Contacts
	//     add currentContact.toString() to return string
    }

    public boolean searchContacts(String query, String field) {
	// TODO: if I use a class variable for currentNode I could have searchContacts set that to the contact when I find it, and then I could call this from add and delete and I could just pick that up from the class... Way more efficient.
	/* start at head
	 * while we have contacts
	 *    if currentContact field matches query
	 *        println(currentContact.toString())
	 *        return true
	 * if the loop finishes or we reach nextContact is null, 
	 *    return false
	 */
    }
    public void deleteContact(String contactName) {
	/* first make sure searchContact returns true (note that this is less efficient but better encapsulation)
	 * start at first contact
	 * while currentContact.name != contactName
	 * 
	 */
    }
    public void exportContacts() {}
    public void importContacts() {}

    // More methods I need:
    private void insertContactAtHead(String newName) {
	// make a new node with name newName
	// make it the new head

	// So this would be a private method that knows about Contacts (which DLList doesn't know about)
	// but which also knows about DLList Nodes, which public methods of AddressBook will not reference.
    }
}
