package chapter10;

public class General {

	//10.4, reference
	/* Flip a positive sign to negative, or a negative sign to pos*/
	public static int FnNegate(int a){
		int neg = 0;
		int d = a < 0? 1: -1;
		while (a != 0){
			neg += d;
			a += d;
		}
		return neg;
	}
	
	/* substract two numbers by negating b and adding them*/
	public static int FnMinus(int a, int b){
		return a + FnNegate(b);
	}
	
	/* check if a and b are different signs */
	public static boolean DifferentSigns(int a, int b){
		return ((a < 0 && b > 0) || (a>0 && b < 0))? true : false;
	}
	
	/* Return absolute value */
	public static int abs(int a){
		if (a < 0) return FnNegate(a);
		else return a;
	}
	
	/* Multiply a by b by adding a to itself b times */
	public static int FnTimes(int a, int b){
		if (a < b) return FnTimes(b, a);
		int sum = 0;
		for(int iter = abs(b); iter > 0; --iter) sum += a;
		if (b < 0) sum = FnNegate(sum);
		return sum;
	}
	
	public static int FnDivide(int a, int b) throws
		java.lang.ArithmeticException {
		if (b == 0){
			throw new java.lang.ArithmeticException("Divide by 0.");
		}
		int quotient = 0;
		int divisor = FnNegate(abs(b));
		int divend;
		for (divend = abs(a); divend >= abs(divisor); divend += divisor){
			++quotient;
		}
		if (DifferentSign(a, b)) quotient = FnNegate(quotient);
		return quotient;
	}
	
	public static int getKthMagicNumber(int k){
		if (k <= 0) return 0;
		int val = 1;
		Queue<integer> Q3 = new LinkedList<Integer>();
		Queue<integer> Q5 = new LinkedList<Integer>();
		Queue<integer> Q7 = new LinkedList<Integer>();
		Q3.add(3);
		Q3.add(5);
		Q3.add(7);
		for (--k; k > 0; --k){
			val = Math.min(Q3.peek().intValue(), 
				  Math.min(Q5.peek().intValue(), Q7.peek().intValue()));
			if (val == Q7.peek()){
				Q7.remove();
			} else {
				if (val == Q5.peek()){
					Q5.remove();
				} else {
					Q3.remove();
					Q3.add(val * 3);
				}
				Q5.add(val * 5);
			}
			Q7.add(val * 7);
		}
		return val;
	}
}
