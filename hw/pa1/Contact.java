import java.io.Serializable;
// TODO: 
// sort out how searching and printing by private data should be methodized
public class Contact extends Node implements Serializable {

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
	return rtn;
    }

}
