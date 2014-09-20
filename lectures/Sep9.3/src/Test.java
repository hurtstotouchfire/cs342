
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test me = new Test();
		me.doIt();
	}
	
	public void doIt() {
		int a, b;
		
		a = 33;
		b = 44;
		
		if ((a > 30) | (b++ < 50)) {
			System.out.println("Expression is true");
			
		} else {
			System.out.println("Expression is false");
		}
		
		System.out.println("a is " + a + ", b is " + b);
	}

}
