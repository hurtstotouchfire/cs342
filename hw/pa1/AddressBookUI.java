import java.util.Scanner;
// TODO fix indentation in master and rebase
public class AddressBookUI {

    public static void main(String[] args) {
	AddressBookUI me = new AddressBookUI();
	// me.testMethods();

	me.printMenu();
	me.takeInput();

    }

    public void takeInput() {
	AddressBook addy = new AddressBook();
	Scanner scant = new Scanner(System.in);

	// Print the menu
	
	char input = scant.next().charAt(0);
	if (validInput(input)) {
	    parseInput(input);
	} else {
	    System.out.println("That is not a valid command.");
	    printMenu();
	}
    }

    private void printMenu() {
	String output = "Address Book Commands: \n";
	output += "a - Add a contact\n";
	output += "p - Print all contacts\n";
	output += "s - Search for a contact by name\n";
	output += "e - Search for a contact by email\n";
	output += "d - Delete a contact\n";
	output += "w - Write all contacts to a file\n";
	output += "r - Restore contacts from file\n";

	System.out.println(output);
    }

    private boolean validInput(char input) {// Exercising public methods
	switch (input) {
	case 'a': return true;
	case 'p': return true;
	case 's': return true;
	case 'e': return true;
	case 'd': return true;
	case 'w': return true;
	case 'r': return true;
	default: return false;
	}
    }

    private boolean parseInput(char input) {// Exercising public methods
	switch (input) {
	case 'a': return true;
	case 'p': return true;
	case 's': return true;
	case 'e': return true;
	case 'd': return true;
	case 'w': return true;
	case 'r': return true;
	default: return false;
	}
    }

    private void testMethods() {// Exercising public methods
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

	// export
	System.out.println("export contacts");
	addy.exportContacts("Contacts.bin");

	// import
	System.out.println("import contacts");
	addy.importContacts("Contacts.bin");

    }

}
