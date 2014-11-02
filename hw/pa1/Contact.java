import java.io.Serializable;
// TODO: 
// sort out how searching and printing by private data should be methodized
public class Contact extends Node implements Serializable {

    public Contact(String[] data) {
	super(data);
    }

    // Some helper methods to minimize casting in AddressBook
    public Contact nextContact() {
	return (Contact)next;
    };

    public Contact prevContact() {
	return (Contact)prev;
    };


    // Data handling methods
    // Array: [name, email, phoneNumber]
    
    public void setName(String args) {
	this.data[0] = args;
    }
    public String getName() {
	return this.data[0];
    }

    public void setEmail(String args) {
	this.data[1] = args;
    }
    public String getEmail() {
	return this.data[1];
    }


    public void setNumber(String args) {
	this.data[2] = args;
    }
    public String getNumber() {
	return this.data[2];
    }

    
    public String toString() {
	String rtn = "";
	// output all fields in a nice string format
	rtn +=  getName() + ": " + getNumber() + ", " + getEmail();
	return rtn;
	}

    // this doesn't fix the import error.
    //public static final long serialVersionUID = 1l;
}
