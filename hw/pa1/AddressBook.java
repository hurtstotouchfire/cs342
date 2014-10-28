// what's the right segregation of abstractions? 
// AddressBook knows it extends DLList and uses DLList methods presumably
// But maybe all public methods on AddressBook are named as if DLList does not exist

// TODO: consider taking a string array of args so you can set all three. 
// store in array as well?
// Would need getters and setters for those fields.
import java.io.*;

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
	Contact newContact = new Contact(contactInfo);
	return newContact;
    }

   /*
     *   Methods for supported commands
     */

    public boolean addContact(String[] contactInfo) { 
	// Add contacts in alpha order by Name field.
	// Prevent adding dupes for the fields we allow searching on:
	// - name
	// - email
	
	// unpack contact fields that we will validate against
	String newName = contactInfo[0];
	String newEmail = contactInfo[1]; 
	// dupe phone numbers are allowed
	
	// make a new contact with this info, and then we'll figure out where it goes.
	Contact newContact = createContact(contactInfo);

	// If there are no contacts yet, add this one in the first slot
	if (firstContact() == null) {
	    insertAtIndex(newContact, 0);
	    return true;
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
		i++; // increments even on the last time through the loop
	    }
	}
	
	// if loop completes, then insert contact at end 
	// (index is currently 1 past the valid indices that have Contacts)
	insertAtIndex(newContact, i);
	return true;
    }
    
    public String searchContacts(String query, String field) {
	// traverse list of Contacts, searching for a particular field
	// Prints contact if found and returns index 
	// TODO: sort out what this method should return

	Contact currentContact = firstContact();
	int i = 0; // keep track of index, we will include this in our return.
	while (currentContact != null) {
	    if (field == "email") {
		if (currentContact.getEmail() == query) {
		    String rtn = "";
		    rtn += "[" + i + "][";
		    rtn += currentContact;
		    rtn += "]";
		    return rtn;
		}
	    } else if (field == "name") {
		if (currentContact.getName() == query) {
		    String rtn = "";
		    rtn += "[" + i + "][";
		    rtn += currentContact;
		    rtn += "]";
		    return rtn;
		} 
	    } else {
		throw new RuntimeException("That Contact field is not queryable!");
	    }
		currentContact = currentContact.nextContact();
		i++;
	}
	return "Contact not found.";
    }

    public void deleteContact(int index) {
	// TODO: add some messaging for what was removed
	try {
	    removeAtIndex(index);
	} catch (IndexOutOfBoundsException e) {
	    System.err.println("There is no Contact at that index.");
	}
    }

    public boolean exportContacts(String fileName) {
	// if we have no contacts, don't export.
	if (nodeCount == 0) {//TODO make this addressbooky
	    throw new RuntimeException("You have no contacts to export.");
	}

	try {
	    ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(fileName));
	    
	    Contact currentContact = firstContact();
	    while (currentContact != null) {
		System.out.println("Exporting contact: " + currentContact);
		oout.writeObject(currentContact);
		currentContact = currentContact.nextContact();
	    }

	    // close up the file when we're done.
	    oout.flush();
	    oout.close();
	    return true;

	} catch (IOException ioe){ 
	    ioe.printStackTrace();
	    return false;
	} 
    }
    
    public void importContacts(String fileName) { // TODO: currently currentNode vs currentContact is all mixed up
	// if file doesn't exist, throw an error.
	/*	if (nodeCount == 0) {
	    throw new RuntimeException("File does not exist.");
	    }*/

	try {
	    ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fileName));
	    
	    // need to loop through till we reach end of file. For now just testing 2.
	    Contact c1 = (Contact)oin.readObject();
	    Contact c2 = (Contact)oin.readObject();

	    // all debugging. fails when I try to access String data. Ok until there.
	    //	    Contact c1_node = (Contact)c1;
	    String[] info = c1.getData();
	    System.out.println(info[0]);// NullPointerException here
	    System.out.println(c1);// also here which does the same thing
	    System.out.println(c2);
	} catch (IOException ioe) { 
	    ioe.printStackTrace();
	} catch (ClassNotFoundException cnfe) {
	    cnfe.printStackTrace();
	}
    }
    
}
