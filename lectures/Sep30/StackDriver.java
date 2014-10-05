public class StackDriver {
    public static void main (String[] args) {
	ArrayStack stack = new ArrayStack();
	System.out.println(stack);
	stack.push(10);
	stack.push(20);
	stack.push(30);
	System.out.println(stack);
    }

}
