
public class RPNDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RPNDriver me = new RPNDriver();
		me.doIt();
		
			
	}

	
	public void doIt() {
		
		RPNCalculator stack = new RPNCalculator();
		stack.push(3);
		stack.push(4);
		
		String operator = "*";
		
		stack.evalBasicOperator(operator);
		System.out.println(stack);
		
			
	}
}
