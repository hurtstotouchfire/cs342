package lab1021;

public class RPNCalculator extends LinkedStackRPN {

    public void evalBasicOperator(String op) {
	// only supports 2 inputs, 1 output, all doubles
   if (this.getCount() > 0) {
	double operand = this.pop();
    switch (op) {
	case "m":
	    this.push(-operand);
	    break;
	case "d":
	    this.push(operand);
	    this.push(operand);
	    break;
	case "p":
		this.push(operand);
		System.out.println("the top number is " + operand);
		break;
	case "n":
		System.out.println("the top number is " + operand);
		break;
	case "f":
		System.out.println("the content of the stack is " + this.toString());
		break;
	case "c":
		for (int i=0; i< this.getCount(); i++)
			this.pop();
		break;
	default: this.push(operand);
			}
    
    if (this.getCount()>1) {
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
			    if (operand2 ==0) {
			    	System.out.println("Divided by zero, try again.");
			    	this.push (operand1);
			    	this.push (operand2); }
			    else {
				this.push(operand1/ operand2);}
			    break;
			case "%":
			   this.push(operand1 % operand2);
			   break;
			case "s":
			    this.push(operand2);
			    this.push(operand1);
			    break;
			default: 
				this.push (operand1);
		    	this.push (operand2);
		}
	
	} 
	
   	} 
   }

    
 }

	

