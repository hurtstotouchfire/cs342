import java.util.Scanner;
// TODO fix indentation in master and rebase
public class AddressBookUI {

    private Scanner scant;
    private AddressBook addy;
    private String filename;

    public AddressBookUI() {
	// initialize scanner
	scant = new Scanner(System.in);
	scant.useDelimiter("\\n");

	// initialize default filename
	filename = "output.bin";

	// initialize addressbook
	addy = new AddressBook();
    }

    public static void main(String[] args) {
	AddressBookUI me = new AddressBookUI();

	// print command menu and await commands
	me.printMenu();
	me.takeInput();
	// TODO: make this quittable
    }

    public void takeInput() {
	// TODO: currently breaks if you enter multiple newlines
	while(scant.hasNext()) {
	    char input = scant.next().charAt(0);
	    if (validInput(input)) {
		parseInput(input);
	        System.out.println("\nEnter a command:");
	    } else {
		System.out.println("That is not a valid command.");
		printMenu();
	        System.out.println("\nEnter a command:");
	    }
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

    private void parseInput(char input) {
	switch (input) {
	case 'a': 
	    addContact();
	    break;
	case 'p': 
	    printContacts();
	    break;
	case 's': 
	    searchByName();
	    break;
	case 'e': 
	    searchByEmail();
	    break;
	case 'd': 
	    deleteContact();
	    break;
	case 'w': 
	    writeContacts();
	    break;
	case 'r': 
	    readContacts();
	    break;
	default: 
	    break;
	}
    }

    private void addContact() {
	String[] contactInfo = new String[3];

	// get name
	System.out.println("Enter contact name");
	contactInfo[0] = scant.next();

	// get email
	System.out.println("Enter contact email address");
	contactInfo[1] = scant.next();

	// get phone number as string
	System.out.println("Enter contact phone number");
	contactInfo[2] = scant.next();

	boolean success = addy.addContact(contactInfo);
	if (success) {
	    System.out.println("Contact added.");
	}
    }

    private void printContacts() {
	System.out.println(addy);
    }

    private void searchByName() {
	System.out.println("Enter a name to search by");
	String name = scant.next();
	System.out.println("");
	System.out.println(addy.searchContacts(name, "name"));
    }

    private void searchByEmail() {
	System.out.println("Enter an email address to search by");
	String email = scant.next();
	System.out.println("");
	System.out.println(addy.searchContacts(email, "email"));
    }

    private void deleteContact() {
	System.out.println("Enter the index of the contact to delete");
	if (scant.hasNextInt()) {
	    int index = scant.nextInt();
	    addy.deleteContact(index);
	} else {
	    System.out.println("Please enter an integer index or ENTER to cancel deletion.");
	    scant.next(); // consume incorrect input and try again
	    deleteContact();
	    // TODO: break if enter
	}
    }

    private void writeContacts() {
	System.out.println("Enter base filename:");
	filename = scant.next() + ".bin";
	boolean success = addy.exportContacts(filename);
	if (success) {
	    System.out.println("Contacts exported.");
	} 
    }

    private void readContacts() {
	//TODO
    }

}
