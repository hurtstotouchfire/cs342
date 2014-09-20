
public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestDriver me = new TestDriver();
		me.doIt();
	}
	
	private void doIt() {
		Car c = new Car();
		
		System.out.println(c);
		Dealership dealer = new Dealership();
		System.out.println(dealer);
		
		c.setAutomatic(false);
		c.setDoors(2);
		c.setEngineSize(5.7);
		
		dealer.addCar(c);
		
		System.out.println(dealer);
		
		Car x = dealer.getCar(1);
		
		x.setDoors(57);
		
		Car y = dealer.getCar(1);
		System.out.println(y);
	}

}
