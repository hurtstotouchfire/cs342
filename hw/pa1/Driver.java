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

	// add first contact
	System.out.println("Add a contact");
	String[] contactInfo = new String[3];
	contactInfo[0] = "Kelly";
	contactInfo[1] = "kb@stuff.com"; 
	contactInfo[2] = "123-4567";
	addy.addContact(contactInfo);

	// Print: 1 contact
	System.out.println("Print the contact");
	System.out.println(addy);

	// Delete: last contact
	System.out.println("Delete the contact");
	addy.deleteContact(0);

	System.out.println("Add a contact");
	addy.addContact(contactInfo);

	//make some contacts
	String[] contactInfo2 = new String[3];
	contactInfo2[0] = "Bob";
	contactInfo2[1] = "kb@stuff.com"; 
	contactInfo2[2] = "123-4567";
	String[] contactInfo3 = new String[3];
	contactInfo3[0] = "Charlie";
	contactInfo3[1] = "kb@stuff.com"; 
	contactInfo3[2] = "123-4567";
	String[] contactInfo4 = new String[3];
	contactInfo4[0] = "Bret";
	contactInfo4[1] = "kb@stuff.com"; 
	contactInfo4[2] = "123-4567";

	System.out.println("exercising index methods directly");
	addy.insertAtIndex(0, contactInfo2);
	System.out.println(addy);
	addy.insertAtIndex(2, contactInfo3);
	System.out.println(addy);
	addy.insertAtIndex(1, contactInfo4);
	System.out.println(addy);

	System.out.println("searching");
	System.out.println(addy.searchContacts("Kelly", "name"));
    }

}
