
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		OpenHash t = new OpenHash();
		//t.getLoc(57);
		t.add(23);
		t.add(23+31);
		t.add(23+31+31);
		t.add(23+31+31+31);
		t.delete(23+31+31);
		System.out.println(t);
	}

}
