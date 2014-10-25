
public class RPNCalc extends LinkedStack {

    public void evalBasicOperator(String op) {
	// only supports 2 inputs, 1 output, all doubles

	double operand2 = this.pop();
	double operand1 = this.pop();

	switch (op) {
	case "+":
	    this.push(operand1 + operand2);
	    break;
	case "-":
	    this.push(operand1 - operand2);
	    break;
	case "*":
	    this.push(operand1 * operand2);
	    break;
	case "/":
	    this.push(operand1 / operand2);
	    break;

	}
    }


}
