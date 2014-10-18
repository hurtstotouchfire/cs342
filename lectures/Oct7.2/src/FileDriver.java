import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;


public class FileDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileDriver me = new FileDriver();
		me.doIt();
	}

	public void doIt() {
		//textFile();
		objFile();
	}

	public void textFile() {
		File f = new File("MyFile.txt");
		PrintWriter p = null;

		System.out.println(f.exists());

		try {
			p = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		p.println("Hello");
		p.println("Goodbye");
		p.close();

		FileReader myF = null;

		try {
			myF = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader b = new BufferedReader(myF);

		String s = "";
		while(s != null) {
			try {
				s = b.readLine();
				if (s != null) {
					System.out.println(s);
				}
			} catch (IOException e) {
				System.out.println("DONE!");
				try {
					b.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public void objFile() {
		
		File f = new File("myClass.foo");

		MyClass m = new MyClass();
		m.add("This is a test");
		m.add("This is only a test");
		m.add("If this had been a real emergency...");

		System.out.println(m);

		try{

			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(m);
			oos.close();
			System.out.println("Done");

		}catch(Exception ex){
			ex.printStackTrace();
		}

		// Ok read it back in
		
		try {
		FileInputStream fin = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fin);
		MyClass mi = (MyClass) ois.readObject();
		System.out.println(mi);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
