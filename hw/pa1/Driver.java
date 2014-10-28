// TODO fix indentation in master and rebase
public class Driver {

    public static void main(String[] args) {
	Driver me = new Driver();
	me.doIt();
    }
	
    /* Test Cases:
       
       Print: 
       x - empty condition
       x - 1 contact
       multiple contacts

       Add:
       x - add first contact
       add additional contacts
       add dupe contact

       Search:
       successful search by name for contact
       successful search by email for contact
       failing search

       Delete:
       failing delete (contact doesn't exist)
       successful delete
       x - delete last contact

       Export:
       export empty contact list
       export multiple contacts

       Import:
       import multiple contacts

    */

    public void doIt() {// Exercising public methods
	System.out.println("Make an empty AddressBook");
	AddressBook addy = new AddressBook();

	// Print: empty condition
	System.out.println("Print the empty AddressBook");
	System.out.println(addy);
	System.out.println("");

	// add first contact
	System.out.println("Add first contact");
	String[] contactInfo = new String[3];
	contactInfo[0] = "Kelly";
	contactInfo[1] = "kb@stuff.com"; 
	contactInfo[2] = "123-4567";
	addy.addContact(contactInfo);
	System.out.println("");


	// Print: 1 contact
	System.out.println("Print the contact");
	System.out.println(addy);
	System.out.println("");


	// Delete: last contact
	System.out.println("Delete the contact");
	addy.deleteContact(0);
	System.out.println(addy);
	System.out.println("");


	System.out.println("Add the contact back");
	addy.addContact(contactInfo);
	System.out.println(addy);
	System.out.println("");


	//make some contacts
	String[] contactInfo2 = new String[3];
	contactInfo2[0] = "Bob";
	contactInfo2[1] = "kb2@stuff.com"; 
	contactInfo2[2] = "123-4567";
	String[] contactInfo3 = new String[3];
	contactInfo3[0] = "Charlie";
	contactInfo3[1] = "kb3@stuff.com"; 
	contactInfo3[2] = "123-4567";
	String[] contactInfo4 = new String[3];
	contactInfo4[0] = "Bret";
	contactInfo4[1] = "kb4@stuff.com"; 
	contactInfo4[2] = "123-4567";
	String[] contactInfo5 = new String[3];
	contactInfo5[0] = "Zedd";
	contactInfo5[1] = "kb5@stuff.com"; 
	contactInfo5[2] = "123-4567";

	System.out.println("Add a contact");
	addy.addContact(contactInfo2);
	System.out.println(addy);
	System.out.println("");

	System.out.println("Add a contact");
	addy.addContact(contactInfo3);
	System.out.println(addy);
	System.out.println("");

	System.out.println("Add a contact");
	addy.addContact(contactInfo4);
	System.out.println(addy);
	System.out.println("");

	System.out.println("Add a contact");
	addy.addContact(contactInfo5);
	System.out.println(addy);
	System.out.println("");


	// Searching
	System.out.println("Search for contact by name");
	System.out.println(addy.searchContacts("Kelly", "name"));
	System.out.println("");

	System.out.println("Search for contact by email");
	System.out.println(addy.searchContacts("kb3@stuff.com", "email"));
	System.out.println("");

	System.out.println("Failing search by name");
	System.out.println(addy.searchContacts("nope", "name"));
	System.out.println("");

	System.out.println("Failing search by email");
	System.out.println(addy.searchContacts("waa@stuff.com", "email"));
	System.out.println("");


	// delete contacts
	System.out.println("Delete a contact");
	addy.deleteContact(3);
	System.out.println(addy);
	System.out.println("");

	System.out.println("Delete a contact");
	addy.deleteContact(4);
	System.out.println(addy);
	System.out.println("");

	System.out.println("Delete a contact");
	addy.deleteContact(2);
	System.out.println(addy);
	System.out.println("");

	System.out.println("Delete a contact");
	addy.deleteContact(1);
	System.out.println(addy);
	System.out.println("");

    }

}
