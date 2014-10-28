import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialiseTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
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

	Contact o1 = new Contact(contactInfo2);
	Contact o2 = new Contact(contactInfo3);
	Contact o3 = new Contact(contactInfo4);


	System.out.println("here's what goes in:");
	System.out.println(o1);
	System.out.println(o2);
	System.out.println(o3);
	

	try {
	    ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("output.bin"));
	    
	    oout.writeObject(o1);
	    oout.writeObject(o2);
	    oout.writeObject(o3);
	    oout.flush();
	    oout.close();
               
	    ObjectInputStream oin = new ObjectInputStream(new FileInputStream("output.bin"));
               
	    Object ob1 = oin.readObject();
	    Object ob2 = oin.readObject();
	    Object ob3 = oin.readObject();
               
	    System.out.println("here's what comes out:");
	    System.out.println(ob1);
	    System.out.println(ob2);
	    System.out.println(ob3);
               
	} catch (Exception exc){ 
	    exc.printStackTrace();
	}
    }
}
/*
class Contact implements Serializable {
    private int foo;
     
    public Contact(int i) {
	foo = i;
    }
     
    public String toString() {
	return "Contact::"+foo;
    }
     
    public static final long serialVersionUID = 1l;
}
*/
