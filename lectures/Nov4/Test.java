import java.util.Random;


public class Test {
	Random gen = new Random();
	public int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test me = new Test();
		me.doIt();
	}

	
	public void doIt() {
		//print(5);
		//blowStack(1, 0);
		palindromeChecker("a man a plan a canal panama");
		palindromeChecker("mama");
		palindromeChecker("123456789");
		System.out.println(factorial(5));
		//System.out.println(fib(68));
		System.out.println(itFib(68));
	}
	
	public void print(int x) {
		
		int r = gen.nextInt(100);
		System.out.print(x + " " + r + " ");
		if (x < 1) 
			return;
		print(x-1);
		System.out.print(x + " " + r + " ");

	}
	
	
	
	public void blowStack(int x, int y) {
		System.out.println(x);
		blowStack((x+1), y+1);
	}
	
	
	public void palindromeChecker(String s) {
		String newString = "";
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i)) || 
					Character.isDigit(s.charAt(i)))  {
				newString = (newString + s.charAt(i)).toLowerCase();
			}
		}
		String s2 = newString;
		String g = stringRecurse(s2, "", 0);
		//System.out.println(g);
		int len = s2.length()/2;
		if (s2.length() % 2 == 1) {
			len++;
		}
		if (g.equals(s2.substring(len))) {
			System.out.println("'" + s + "'" + " is a palindrome");
		} else {
			System.out.println("'" + s + "'" + " is not a palindrome");
			
		}
		//System.out.println(g);
	}
	
	public String stringRecurse(String s, String r, int index) {
		//System.out.print(s.charAt(index));
		if (index == s.length()/ 2)
			return r;
		return stringRecurse(s, s.charAt(index) + r, index+1);
		//System.out.print(s.charAt(index));
		//return r;
	}
	
	public int factorial(int x) {
		if ((x == 0) || (x == 1))
			return 1;
		
		return x * factorial(x-1);
	}
	
	public int fib(int o) {
		if ((o == 1) || (o == 2))
			return 1;
		
		return fib(o-1) + fib(o-2);
	}
	
	public int itFib(int o) {
		if ((o == 1) || (o == 2))
			return 1;

		int result1 = 1;
		int result2 = 1;
		int result3 = 0;
		for (int i = 0; i < o-2; i++) {
			result3 = result1 + result2;
			result1 = result2;
			result2 = result3;
		}
		
		return result3;
	}
}
