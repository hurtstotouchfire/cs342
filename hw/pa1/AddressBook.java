// what's the right segregation of abstractions? 
// AddressBook knows it extends DLList and uses DLList methods presumably
// But maybe all public methods on AddressBook are named as if DLList does not exist

// TODO: consider taking a string array of args so you can set all three. 
// store in array as well?
// Would need getters and setters for those fields.

public class AddressBook extends DLList {

    // Some helper methods to keep all our casting in one place
    //    public Contact currentContact(){
    //return (Contact)currentNode;
    //}

    private Contact firstContact(){
	return (Contact)head;
    }

    private Contact lastContact(){
	return (Contact)tail;
    }

    private Contact createContact(String[] contactInfo) {
	Contact newContact = new Contact();
	newContact.setData(contactInfo);
	return newContact;
    }

    // Methods for supported commands

    public boolean addContact(String[] contactInfo) { 
	/* Add contacts in alpha order by Name field.
	 * Prevent adding dupes for the fields we allow searching on:
	 * - name
	 * - email
	 */
	
	// unpack contact fields that we will validate against
	String newName = contactInfo[0];
	String newEmail = contactInfo[1]; 
	// dupe phone numbers are allowed
	
	// make a new contact with this info, and then we'll figure out where it goes.
	Contact newContact = createContact(contactInfo);

	// If there are no contacts yet, add this one in the first slot
	if (firstContact() == null) {
	    insertAtIndex(newContact, 0);
	}

	// Otherwise, add it in order
	Contact currentContact = firstContact();
	int i = 0; // keep track of index, we will use this to insert
	while (currentContact != null) {
	    if (currentContact.getName() == newName) {
		// prevent adding dupe names
		System.out.println("That name is already associated with a Contact.");
		return false;
	    } else if (currentContact.getEmail() == newEmail) {
		// prevent adding dupe emails
		System.out.println("That email address is already associated with a Contact.");
		return false;
	    } else if (currentContact.getName().compareTo(newName) > 0) {
		// once current > new, insert new in current slot
		insertAtIndex(newContact, i);
		return true;
	    } else {
		currentContact = currentContact.nextContact();
		i++;
	    }
	}
	
	// if loop completes, then insert contact at end
	i++; // TODO: figure out how to do this in the argument
	insertAtIndex(newContact, i);
	return true;
    }
    
    public int searchContacts(String query, String field) {
	// traverse list of Contacts, searching for a particular field
	// Prints contact if found and returns index 
	// TODO: sort out what this method should return

	Contact currentContact = firstContact();
	int i = 0; // keep track of index, we will return this
	while (currentContact != null) {
	    if (field == "email") {
		if (currentContact.getEmail() == query) {
		    System.out.println(currentContact);
		    return i;
		}
	    } else if (field == "name") {
		if (currentContact.getName() == query) {
		    System.out.println(currentContact);
		    return i;
		} 
	    } else {
		throw new RuntimeException("That Contact field is not queryable!");
	    }
		currentContact = currentContact.nextContact();
		i++;
	}
	return -1;
    }

    public void deleteContact(int index) {
	// add some messaging for what was removed
	removeAtIndex(index);
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

}
