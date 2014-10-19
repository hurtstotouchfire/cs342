// TODO fix indentation in master and rebase
public class Driver {

    public static void main(String[] args) {
	Driver me = new Driver();
	me.doIt();
    }
	
    /* Test Cases:
       
       Print: 
       x - empty condition
       1 contact
       multiple contacts

       Add:
       add first contact
       add additional contacts
       add dupe contact

       Search:
       successful search by name for contact
       successful search by email for contact
       failing search

       Delete:
       failing delete (contact doesn't exist)
       successful delete
       delete last contact

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
	addy.printAllContacts();

    }

}
