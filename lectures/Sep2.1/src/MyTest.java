
public class MyTest {
	private int var1 = 43;
	private static int var3 = 27;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTest me = new MyTest();
		me.myMethod();
	}
	
	public void myMethod() {
		int var2;
		var1 = 34;
		var2 = 35;
		var3 = 44;
		testTheater();
	}

	public void testTheater() {
		Theater theater1 = new Theater();
		Theater theater2 = new Theater();
		
		theater1.sellTicket();
		System.out.println(theater1.printTicketCount());
		theater1.sellTicket();
		System.out.println(theater1.printTicketCount());
		
		theater2.sellTicket();
		System.out.println(theater2.printTicketCount());
		
	}
}
