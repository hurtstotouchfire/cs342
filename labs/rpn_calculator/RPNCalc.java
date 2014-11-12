
public class RPNCalc extends LinkedStack {

    public void evalOperator(String op) {

	if (op == "m") {
	    //then handle unary minus
	} else if (op == "d") {
	    //then handle duplication
	} else {
	    // everything else is binary
	    if (this.count < 2) {
		//some error
	    } else {
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
		case "%":
		    this.push(operand1 / operand2);
		    break;
		case "s":
		    this.push(operand1 / operand2);
		    break;
		default:
		    // push back on
		}
	    }
	}
	
    }
}
