import java.io.*;

public class AddressBook extends DLList implements Serializable {

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
	// Returns all matching contacts, with indices

	Contact currentContact = firstContact();
	int i = 0; // keep track of index, we will include this in our return.
	String rtn = "";
	while (currentContact != null) {
	    if (field == "email") {
		if (currentContact.getEmail().equals(query)) {
		    rtn += "[" + i + "][";
		    rtn += currentContact;
		    rtn += "]";
		}
	    } else if (field == "name") {
		if (currentContact.getName().equals(query)) {
		    rtn += "[" + i + "][";
		    rtn += currentContact;
		    rtn += "]";
		} 
	    } else {
		throw new RuntimeException("That Contact field is not queryable!");
	    }
		currentContact = currentContact.nextContact();
		i++;
	}

	if (rtn == "") {
	    return "Contact not found.";
	} else {
	    return rtn;
	}
    }

    public void deleteContact(int index) {

	try {
	    removeAtIndex(index);
	    System.out.println("Contact was delete.");
	} catch (IndexOutOfBoundsException e) {
	    System.err.println("There is no Contact at that index.");
	}
    }
    
}
