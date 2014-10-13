// TODO: 
// sort out how searching and printing by private data should be methodized
public class Contact extends Node {

    // Private data for each field
    private String Name;
    private String Email;
    private String Number;
    
    // need a constructor to make my new blank contact
    // initialize fields to null so that contacts don't need 
    // to have all 3

    public void setName(String[] args) {
	this.Name = args;
    }
    public String getName() {
	return Name;
    }

    public void setEmail(String[] args) {
	this.Email = args;
    }
    public String getEmail() {
	return Email;
    }


    public void setNumber(String[] args) {
	this.Number = args;
    }
    public String getNumber() {
	return Number;
    }
    
    public String[] toString() {
	// output all fields in a nice string format
    }

}
