// TODO: 
// sort out how searching and printing by private data should be methodized
// make Contact extend Node so that I can get next and previous
public class Contact {
    // an array containing 3 strings for my fields
    private String[] contact; 

    // associate name, email, number vars with indices in array
    // that might need to happen in setter methods
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
