public class StackDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackDriver me = new StackDriver();
		// me.doIt();
		// me.useStack();
		me.useStack2();
	}

	public void doIt() {
		MyStack stack = new LinkedStack();

		// System.out.println(stack);

		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack);

		for (int i = 0; i < 50; i++) {
			if (!stack.isFull()) {
				stack.push(i);
			}
			/*
			 * try { stack.push(i); } catch (StackOverFlowException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}
		System.out.println("Stack after 50 pushes \n" + stack);

		for (int i = 0; i < 50; i++) {
			if (!stack.isEmpty()) {
				stack.pop();
			}
		}

		System.out.println(stack);
		// System.out.println(stack.foo());
	}

	public void useStack() {
		String data2 = "This is a String";
		String data = "A man a plan a canal Panama";

		MyStack stack = new LinkedStack();

		for (int i = 0; i < data.length(); i++) {
			stack.push(data.charAt(i));
		}

		System.out.println(stack);

		String output = "";

		while (!stack.isEmpty()) {
			output += (char) stack.pop();
		}

		System.out.println(output);
	}

	public void useStack2() {

		String data2 = "((()))()()((()))";
		String data = "((34 + 55))( * )(12 + 2)";

		MyStack stack = new LinkedStack();

		System.out.println(data);
		int i;
		for (i = 0; i < data.length(); i++) {
			char d;
			d = (char) data.charAt(i);
			if (d == '(') {
				stack.push(d);
			}
			if (d == ')') {
				if (stack.isEmpty()) {
					break;
					// System.out.println("Invalid String");
					// return;
				}
				stack.pop();
			}
		}

		if (i != data.length()) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println("^ Invalid character");
		} else {
			if (stack.isEmpty())
				System.out.println("Looks good");
			else {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				System.out.println("^ Expecting ) character");
			}
		}

	}

}
