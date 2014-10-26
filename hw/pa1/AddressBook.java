// what's the right segregation of abstractions? 
// AddressBook knows it extends DLList and uses DLList methods presumably
// But maybe all public methods on AddressBook are named as if DLList does not exist

// TODO: consider taking a string array of args so you can set all three. 
// store in array as well?
// Would need getters and setters for those fields.

public class AddressBook extends DLList {

    private Contact currentContact = null;

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
    

    public void addContact(String[] contactInfo) { //add contacts in alpha order by Name field.
	String newName = contactInfo[0];
	String email = contactInfo[1]; 
	String phoneNumber = contactInfo[2];
	
	if (searchContacts(newName, "name")) {
	    System.out.println("That name is already associated with a Contact.");
	} else if (searchContacts(email, "email")) {
	    System.out.println("That email address is already associated with a Contact.");
	} else {
	    // make a new Contact and populate data
	    Contact newContact = new Contact();
	    newContact.setName(newName);
	    newContact.setEmail(email);
	    newContact.setNumber(phoneNumber);
	    
	    // case 1: insert before head
	    if (currentContact.getName().compareTo(newName) < 0) {
		insertAtHead(contactInfo);
	    }
	    
	    // case 2: insert somewhere in between
	    currentContact = (Contact)head.getNext();
	    while (currentContact != null) {
		// search until we overshoot, handle tail case separately
		if (currentContact.getName().compareTo(newName) > 0) {
		    // once current > new, insert new before current and break
		    insertBeforeNode(contactInfo, (Node)currentContact);
		    break;
		} else {
		    currentContact = (Contact)currentContact.getNext();
		}
	    }
	    
	    // case 3: insert as new tail
	    insertAtTail(contactInfo);
	}
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
	currentContact = (Contact)head;
	while (currentContact != null) {
	    if (field == "email") {
		if (currentContact.getEmail() == query) {
		    System.out.println(currentContact);
		    return true;
		}
	    } else if (field == "name") {
		if (currentContact.getName() == query) {
		    System.out.println(currentContact);
		    return true;
		} 
	    } else {
		throw new RuntimeException("That Contact field is not queryable!");
	    }
	}
	return false;
    }

    public void deleteContact(String contactName) {
	if (searchContacts(contactName, "name")) {
	    Contact prev = (Contact)currentContact.getPrev();
	    Contact next = (Contact)currentContact.getNext();
	    prev.setNext(next);
	    next.setPrev(prev);
	    System.out.println("Contact removed.");
	} else {
	    System.out.println("Contact not found.");
	}
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
