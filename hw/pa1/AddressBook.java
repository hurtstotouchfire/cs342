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
	printAllContacts();
	// print contents of address book using list's toString method
	System.out.println(list);	

	// make a loop which takes commands and parses them with parseArgs
	/*
	  while (not breaking condition) {
	  parseArgs();
	  }
	*/
	
    }
    
    public void parseArgs() {	
	// take CL input
	// validate input, ask additional questions where needed
	// break up as command and input
	// execArgs(command, input);

    }

    public void execArgs(String command, String[] input) {// TODO: move to another class somehow
	// make input arg optional

   	// if command is "a"
	addContact(input);

   	// if command is "p"
	printAllContacts();

   	// if command is "s"
	searchContacts(input[0], "name");

   	// if command is "e"
	searchContacts(input[1], "email");

   	// if command is "d"
        deleteContact(input[0]);

	// String array arg option breaks down once you need a filename. Need to break this up and move it.

   	// if command is "w"
	String fileName = ""; //get this from UI / validation
	exportContacts(fileName);

   	// if command is "r"
	String fileName = ""; //get this from UI / validation
	importContacts(fileName);
    }

    /* TODO:
     * decide which of the following UI methods need to exist and which we can 
     * implement by directly accessing DLList methods.
     */

    public void addContact(String[] contactInfo) { //add contacts in alpha order by Name field.
	String newName = contactInfo[0];
	String email = contactInfo[1]; 
	String phoneNumber = contactInfo[2];
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
	 */
	// if the loop finishes or we reach nextContact is null, 
	return false;
    }
    public void deleteContact(String contactName) {
	/* first make sure searchContact returns true (note that this is less efficient but better encapsulation)
	 * start at first contact
	 * while currentContact.name != contactName
	 * 
	 */
    }
    public void exportContacts(String fleName) {//https://community.oracle.com/message/9051394
	/*
	 * initialize a new File from fileName
	 * initialize a new FileOutputStream, giving it the new File
	 * initialize a new ObjectOutputStream, giving it the new FileOutputStream
	 * 
	 * start at the tail node
	 * while we have nodes,
	 *     writeObject(currentContact)
	 *     currentContact.getPrev();
	 * make sure to include the head
	 * close out the streams
	 */
    }
    public void importContacts(String fleName) { // TODO: currently currentNode vs currentContact is all mixed up
	/*
	 * initialize a new File from fileName
	 * initialize a new FileInputStream, giving it the new File
	 * initialize a new ObjectInputStream, giving it the new FileInputStream
	 * 
	 * No contacts in file:
	 * check for empty file (EOFE probably) and throw error
	 *
	 * One contact in file:
	 * make newContact object from readObject()
	 * point head to newContact
	 * point tail to newContact
	 * set currentNode to newContact
	 * if there's only one contact, the following while loop will immediately get EOFE
	 *
	 * Multiple contacts:
	 * while we're not getting an end of file exception
	 *     make newContact object from readObject()
	 *     set newContact prev to currentNode
	 *     set currentNode next to newContact
	 *     set tail to newContact
	 *     set currentContact to newContact
	 */
    }

    // More methods I need:
    private void insertContactAtHead(String newName) {
	// make a new node with name newName
	// make it the new head

	// So this would be a private method that knows about Contacts (which DLList doesn't know about)
	// but which also knows about DLList Nodes, which public methods of AddressBook will not reference.
    }
}
