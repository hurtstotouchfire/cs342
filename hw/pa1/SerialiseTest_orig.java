import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialiseTest_orig {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	TestObject o1 = new TestObject(1);
	TestObject o2 = new TestObject(2);
	TestObject o3 = new TestObject(3);
     
	try {
	    ObjectOutputStream oout = new ObjectOutputStream(
							     new FileOutputStream("output.bin"));

	    System.out.println("here's what goes in:");
	    System.out.println(o1);
	    System.out.println(o2);
	    System.out.println(o3);

               
	    oout.writeObject(o1);
	    oout.writeObject(o2);
	    oout.writeObject(o3);
	    oout.flush();
	    oout.close();
               
	    ObjectInputStream oin = new ObjectInputStream(
							  new FileInputStream("output.bin"));
               
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

class TestObject implements Serializable {
    private int foo;
     
    public TestObject(int i) {
	foo = i;
    }
     
    public String toString() {
	return "TestObject::"+foo;
    }
     
    public static final long serialVersionUID = 1l;
}
